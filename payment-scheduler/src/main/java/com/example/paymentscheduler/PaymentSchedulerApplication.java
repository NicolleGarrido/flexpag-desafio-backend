@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentSchedule {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private LocalDateTime date;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private PaymentStatus status;
}
