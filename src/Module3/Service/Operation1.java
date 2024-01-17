package src.Module3.Service;

import jdk.jfr.Category;
import java.util.List;

public interface Operation1 {
    void createOperation(Long accountId, Category category, double amount, String operationName);
    void updateOperation(Operation1 operation);
    void deleteOperation(Long operationId);
    List<Operation1> getOperationsByAccountId(Long accountId);
}
