package src.Module3.Service;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import src.Module3.NegativeException;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "account")
@Table(schema = "user_accounts", name = "operations")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "amount")
    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
    @Column(name = "operation_type", columnDefinition = "text")
    private OperationType type;
    @Column(name = "category")
    private String category;
    @Column(name = "transactionTime")
    private LocalDateTime transactionTime;
    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setAmount(BigDecimal amount) throws NegativeException {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new NegativeException("The amount cannot negative or equals zero.");
        }
        this.amount = amount;
    }
}