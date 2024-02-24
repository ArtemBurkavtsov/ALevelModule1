package src.Module3.Service;
@Service
public class AccountImpl implements Account1 {
    @Autowired
    private Account account;

    @Autowired
    private Operation operationO;

    @Override
    public void createAccount(Long userId, String accountName, BigDecimal initialBalance) {
    }

    @Override
    public BigDecimal getAccountBalance(Long accountId) {
        List<Operation> operations = operationDAO.getByAccountId(accountId);
        return operations.stream().map(Operation::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
