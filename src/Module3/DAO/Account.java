package src.Module3.DAO;
import java.util.List;

public interface Account {
    void save(Account account);
    Account getById(Long id);
    List<Account> getByUserId(Long userId);
}
