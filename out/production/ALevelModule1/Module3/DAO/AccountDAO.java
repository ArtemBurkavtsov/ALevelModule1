package src.module3.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import src.Module3.Service.Account;
import src.Module3.Service.ConnectorManager;
import src.Module3.DAO.DAO;
import src.Module3.Service.User;

import java.util.List;
import java.util.Optional;

public class AccountDAO implements Dao<Account> {
    private final static AccountDAO INSTANCE = new AccountDAO();

    public AccountDAO() {
    }

    public static AccountDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public Account create(Account account) {
        try (Session session = ConnectorManager.openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.merge(account);
            transaction.commit();
        }
        return account;
    }

    @Override
    public Optional<Account> getById(Long id) {
        try (Session session = ConnectorManager.openSession()) {
            Account account = session.find(Account.class, id);
            if (account == null) {
                System.out.println("The account under  ID" + id + " does not exist.");
            }
            return Optional.ofNullable(account);
        }
    }

    @Override
    public Optional<Account> update(Account account) {
        try (Session session = ConnectorManager.openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            Account updateAccount = session.get(Account.class, account.getId());
            Long userId = account.getUser().getId();
            session.get(User.class, userId);
            if (updateAccount != null) {
                updateAccount.setAccountName(account.getAccountName());
                updateAccount.setUser(account.getUser());
                session.merge(updateAccount);
                transaction.commit();
                return Optional.of(updateAccount);
            }
            System.out.println("The account under such ID doesn`t exist.");
            return Optional.empty();
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = ConnectorManager.openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            Account account = session.find(Account.class, id);
            if (account != null) {
                System.out.println("Account's details before delete: ");
                System.out.println(account);
                session.remove(account);
                System.out.println("Account id " + id + " was delete.");
            } else {
                System.out.println("Account id " + id + " doesn`t exist.");
            }
            transaction.commit();
        }
    }

    @Override
    public List<Account> getAll() {
        try (Session session = ConnectorManager.openSession()) {
            return session.createQuery("SELECT account FROM Account account JOIN FETCH account.user", Account.class).list();
        }
    }
}