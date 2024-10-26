import java.util.Optional;

@Service
public class PrescriptionService {

    private final DoctorRepository doctorRepository;
    private final DrugRepository drugRepository;

    @Autowired
    public PrescriptionService(DoctorRepository doctorRepository, DrugRepository drugRepository) {
        this.doctorRepository = doctorRepository;
        this.drugRepository = drugRepository;
    }

    public PrescriptionOrderForm fillOrder(Order order) {
        // 1: Retrieve the doctor by ID
        Doctor doctor = doctorRepository.findById(order.getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor not found with ID: " + order.getDoctorId()));

        // 2: Retrieve the drug by ID
        Drug drug = drugRepository.findById(order.getDrugId())
                .orElseThrow(() -> new RuntimeException("Drug not found with ID: " + order.getDrugId()));

        // 3: Calculate the correct dosage
        double dosage = order.getPatientWeight() * drug.getDosageRate();

        // 4: Create and return the PrescriptionOrderForm
        PrescriptionOrderForm prescriptionOrderForm = new PrescriptionOrderForm();
        prescriptionOrderForm.setPatientName(order.getPatientName());
        prescriptionOrderForm.setDoctorName(doctor.getName());
        prescriptionOrderForm.setDrugName(drug.getName());
        prescriptionOrderForm.setDosage(dosage);

        return prescriptionOrderForm;
    }
}
