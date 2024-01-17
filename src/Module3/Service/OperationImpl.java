package src.Module3.Service;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.validation.ValidationException;

@Service
public class OperationImpl implements Operation1{
    @Autowired
    private Operation1 operation;

    @Autowired
    private Account1 account1;

    @Override
    public void createOperation(Long accountId, Category category, double amount, String operationName) throws ValidationException {
        if (amount == 0) {
            throw new ValidationException("Amount cannot be zero.");
        }

        Account1 account = accountService.getAccountById(accountId);
        if (account == null) {
            throw new ValidationException("Invalid account ID.");
        }

        Operation1 operation = new Operation1();
        operation.setAccount(account);
        operation.setCategory(category);
        operation.setAmount(amount);
        operation.setOperationName(operationName);
        operation.setCreatedAt(LocalDateTime.now());

        operation.save(operation);
    }
}
