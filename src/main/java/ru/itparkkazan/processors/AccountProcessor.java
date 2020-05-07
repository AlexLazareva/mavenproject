package ru.itparkkazan.processors;

import lombok.extern.slf4j.Slf4j;
import ru.itparkkazan.beans.Account;
import ru.itparkkazan.exeptions.ReplenishException;

@Slf4j
public class AccountProcessor {
    public static void replenishAccount(Account account, int replenishSum) throws ReplenishException {
        log.info(String.join(" ", "Пополнение счета", String.valueOf(account.getAccountNumber()), "на сумму", String.valueOf(replenishSum)));
        if (replenishSum <= 0) {
            log.error("Ошибка при пополнении счета - сумма меньше 0");
            throw new ReplenishException("Сумма пополнения меньше 0");
        }

        int currentSum = account.getSum();
        int resultSum = currentSum + replenishSum;

        account.setSum(resultSum);
    }

    public static void writeAccount(Account account, int writeOffSum) {
        /*
        Реализовать метод списания со счета.
        Во время списания выполнить проверку на достаточность средств.
        В случае, если средств недостаточно для списания (остаток должен быть не меньше 0),
        прокинуть исключение WriteOffException с соответствующим описанием.
        Написать тест.
         */
    }

    public static void transferMoney(Account fromAccount, Account toAccount, int sum) {
        /*
        Реализовать метод перевода средств с одного счета на другой.
        Во время перевода выполнить проверку на достаточность средств на счету, откуда перевод.
        Если средств недостаточно, прокинуть исключение WriteOffException с соответствующим описанием.
        Если сумма перевода отрицательная, прокинуть исключение ReplenishException с соответствующим описанием.
         */
    }
}
