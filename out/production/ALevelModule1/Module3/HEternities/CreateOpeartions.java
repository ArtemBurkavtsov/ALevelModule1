package src.Module3.HEternities;
@Entity
@Table(name = "operations")
public class CreateOpeartions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @Enumerated(EnumType.STRING)
    private Category category;

    private double amount;

    private LocalDateTime createdAt;
}
