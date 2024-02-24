package src.Module3.DAO;
import java.util.List;
public interface Operation {
    void save(Operation operation);
    List<Operation> getByAccountId(Long accountId);
}
