package src.Module3.HEternities;

import src.Module3.DAO.UserDAO;
import src.Module3.Service.Account;
import src.Module3.Service.User;

import java.math.BigDecimal;
import java.util.Optional;

public class CreateAccount {
        private static void createAccount(AccountDAO AccountDAO, UserDAO UserDAO) {
                Account account = new Account();
                Optional<User> getUser = userDAO.getById(6L);
                if (getUser.isEmpty()) {
                        return;
                }
                User accountUser = getUser.get();
                account.setAccountName("Salary card");
                boolean validInputBalance = false;
                while (!validInputBalance) {
                        try {
                                System.out.println("Enter balance: ");
                                BigDecimal balance = scan.nextBigDecimal();
                                account.setBalance(balance);
                                validInputBalance = true;
                        } catch (NegativeValueException e) {
                                e.printStackTrace();
                                System.out.println(e.getMessage());
                        }
                }
                account.setUser(accountUser);
                accountDAO.create(account);
                System.out.println(account);
        }

        private static void updateAccount(src.module3.dao.AccountDAO accountDao, UserDAO userDao) {
                Optional<Account> getAccount = accountDao.getById(7L);
                if (getAccount.isPresent()) {
                        Account updateAccount = getAccount.get();
                        Optional<User> newUser = userDao.getById(Long.valueOf(2L));
                        if (newUser.isPresent()) {
                                User user = newUser.get();
                                updateAccount.setAccountName("Premium card");
                                updateAccount.setUser(user);
                                accountDao.update(updateAccount);
                                System.out.println(user + " " + getAccount);
                        }
                }
        }
}
