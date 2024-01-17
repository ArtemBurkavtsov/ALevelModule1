package src.Module3.HEternities;

@Entity
@Table(name = "accounts")
public class CreateAccount {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "user_id")
        private User user;

        @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
        private List<Operation> operations;
}
