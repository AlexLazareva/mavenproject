package ru.itparkkazan.dao;

import lombok.extern.slf4j.Slf4j;
import ru.itparkkazan.beans.Account;
import ru.itparkkazan.exeptions.DataSourceServiceException;
import ru.itparkkazan.services.DataSourceService;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@Slf4j
public class AccountDAO implements DAO<Account> {
    private DataSourceService dataSourceService = new DataSourceService();

    @Override
    public void insert(Account account) {
        try(PreparedStatement preparedStatement = dataSourceService.getPreparedStatement(AccountQuerier.INSERT_ACCOUNT_INFO)) {
            preparedStatement.setInt(1, account.getAccountNumber());
        } catch (DataSourceServiceException e) {
            log.error("Ошибка к подключения к БД при попытке вставки записи с данными счета", e);
        } catch (SQLException e) {
            log.error("Ошибка запроса к БД при попытке вставки записи с данными счета " + AccountQuerier.INSERT_ACCOUNT_INFO, e);
        } finally {
            dataSourceService.closeConnection();
        }
    }

    @Override
    public void update(Account account) {
        try (PreparedStatement preparedStatement = dataSourceService.getPreparedStatement(AccountQuerier.UPDATE_ACCOUNT_SUM)) {
            preparedStatement.setInt(1, account.getSum());
            preparedStatement.setInt(2, account.getId());
            preparedStatement.executeUpdate();
        } catch (DataSourceServiceException e) {
           log.error("Ошибка к подключения к БД при попытке обновления записи с данными счета", e);
        } catch (SQLException e) {
           log.error("Ошибка запроса к БД при попытке обновления записи с данными счета " + AccountQuerier.UPDATE_ACCOUNT_SUM, e);
        } finally {
            dataSourceService.closeConnection();
        }
    }
}
