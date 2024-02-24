package src.Module3.Service;

import jdk.dynalink.Operation;
import java.util.List;

public interface Account1 {
    void createAccount(Long userId, String accountName, BigDecimal initialBalance);
    void updateAccount(Account1 account);
    void deleteAccount(Long accountId);
    List<Operation> getOperationsByAccountId(Long accountId);
    void generateReport(Long accountId, LocalDate fromDate, LocalDate toDate);
    void createOperation(Long accountId, Category category, double amount, String operationName) throws ValidationException;
    BigDecimal getAccountBalance(Long accountId);
}