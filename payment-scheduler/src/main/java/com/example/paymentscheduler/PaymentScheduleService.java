@Service
public class PaymentScheduleService {
  private final PaymentScheduleRepository paymentScheduleRepository;

  public PaymentScheduleService(PaymentScheduleRepository paymentScheduleRepository) {
    this.paymentScheduleRepository = paymentScheduleRepository;
  }

  public PaymentSchedule create(PaymentSchedule paymentSchedule) {
    paymentSchedule.setStatus(PaymentStatus.PENDING);
    return paymentScheduleRepository.save(paymentSchedule);
  }

  public PaymentSchedule getById(Long id) {
    return paymentScheduleRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Payment schedule not found"));
  }

  public void deleteById(Long id) {
    PaymentSchedule paymentSchedule = getById(id);
    if (paymentSchedule.getStatus() == PaymentStatus.PENDING) {
      paymentScheduleRepository.deleteById(id);
    } else {
      throw new IllegalStateException("Payment schedule cannot be deleted");
    }
  }

 
