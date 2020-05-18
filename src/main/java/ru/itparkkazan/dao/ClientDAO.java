package ru.itparkkazan.dao;


import lombok.extern.slf4j.Slf4j;
import ru.itparkkazan.beans.Account;
import ru.itparkkazan.beans.Client;
import ru.itparkkazan.enums.ClientCredential;
import ru.itparkkazan.exeptions.DataSourceServiceException;
import ru.itparkkazan.exeptions.UnregistredAccountException;
import ru.itparkkazan.exeptions.UnregistredClientException;
import ru.itparkkazan.services.DataSourceService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Slf4j
public class ClientDAO implements DAO<Client> {
    private DataSourceService dataSourceService;

    public ClientDAO() {
        dataSourceService = new DataSourceService();
    }

    @Override
    public void insert(Client client) {
        try (PreparedStatement preparedStatement = dataSourceService.getPreparedStatement(ClientQuerier.INSERT_INTO_CLIENT_VALUES)) {
            preparedStatement.setString(1, client.getLogin());
            preparedStatement.setString(2, client.getPsswd());
            preparedStatement.setString(3, client.getFirstname());
            preparedStatement.setString(4, client.getSecondname());
            preparedStatement.setString(5, client.getSurname());
            preparedStatement.setInt(6, client.getId());
            preparedStatement.executeUpdate();
        } catch (DataSourceServiceException e) {
            log.error("Ошибка подключения к БД при попытке вставки записи с данными клиента", e);
        }
        catch (SQLException e) {
            log.error("Ошибка запроса при попытке вставки записи с данными клиента " + ClientQuerier.INSERT_INTO_CLIENT_VALUES, e);
        } finally {
            dataSourceService.closeConnection();
        }
    }

    public Client get(String login, String psswd) throws UnregistredClientException, UnregistredAccountException {
        try (PreparedStatement preparedStatement = dataSourceService.getPreparedStatement(ClientQuerier.SELECT_CLIENT_BY_LGN_AND_PSSWD)) {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, psswd);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt(ClientCredential.ID.getClientCredential());
                String firstName = resultSet.getString(ClientCredential.FIRST_NAME.getClientCredential());
                String secondName = resultSet.getString(ClientCredential.SECOND_NAME.getClientCredential());
                String surname = resultSet.getString(ClientCredential.SURNAME.getClientCredential());
                int accountId = resultSet.getInt(ClientCredential.ACCOUNT_ID.getClientCredential());
                Account account = new AccountDAO().getById(accountId);
                return new Client(id, login, firstName, secondName, surname, account);
            } else {
                throw new UnregistredClientException("Клиент с логином " + login + " отсутствует");
            }
        } catch (DataSourceServiceException e) {
            log.error("Ошибка при получении данных о клиенте с логином " + login, e);
            return null;
        } catch (SQLException e) {
            log.error("Ошибка при выполнении запроса " + ClientQuerier.SELECT_CLIENT_BY_LGN_AND_PSSWD, e);
            return null;
        } finally {
            dataSourceService.closeConnection();
        }
    }

    public List<Client> getAll() {
        try (PreparedStatement preparedStatement = dataSourceService.getPreparedStatement(ClientQuerier.SELECT_ALL_CLIENTS)) {
            List<Client> allClients = new LinkedList<>();
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(ClientCredential.ID.getClientCredential());
                String login = resultSet.getString(ClientCredential.LOGIN.getClientCredential());
                String firstname = resultSet.getString(ClientCredential.FIRST_NAME.getClientCredential());
                String secondName = resultSet.getString(ClientCredential.SECOND_NAME.getClientCredential());
                String surname = resultSet.getString(ClientCredential.SURNAME.getClientCredential());
                int accountId = resultSet.getInt(ClientCredential.ACCOUNT_ID.getClientCredential());
                AccountDAO accountDAO = new AccountDAO();
                Account account = accountDAO.getById(accountId);
                allClients.add(new Client(id, login, null, firstname, secondName, surname, account));
            }
            return allClients;
        } catch (DataSourceServiceException e) {
            log.error("Ошибка при получении списка всех клиентов", e);
            return null;
        } catch (SQLException | UnregistredAccountException e) {
            log.error("Ошибка при выполнении запроса " + ClientQuerier.SELECT_ALL_CLIENTS, e);
            return null;
        } finally {
            dataSourceService.closeConnection();
        }
    }
}
