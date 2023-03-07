@RestController
@RequestMapping("/payments")
public class PaymentScheduleController {
  private final PaymentScheduleService paymentScheduleService;

  public PaymentScheduleController(PaymentScheduleService paymentScheduleService) {
    this.paymentScheduleService = paymentScheduleService;
  }

  @PostMapping
  public PaymentSchedule create(@RequestBody PaymentSchedule paymentSchedule) {
    return paymentScheduleService.create(paymentSchedule);
  }

  @GetMapping("/{id}")
  public PaymentSchedule getById(@PathVariable Long id) {
    return paymentScheduleService.getById(id);
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable Long id) {
    paymentScheduleService.deleteById(id);
  }
}
