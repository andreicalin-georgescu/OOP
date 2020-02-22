package hospital;

import entities.Doctor;
import entities.ERTehnician;
import entities.Nurse;
import entities.Patient;
import utilities.Specialities;
import utilities.State;

import java.util.ArrayList;
import java.util.Observable;

public class HospitalState extends Observable {

    private int simulationLength;
    private int nurses;
    private int investigators;
    private ArrayList<Doctor> doctors = new ArrayList<>();
    private ArrayList<Patient> incomingPatients = new ArrayList<>();

    private ArrayList<Patient> triageQueue = new ArrayList<>();
    private ArrayList<Patient> investigationsQueue = new ArrayList<>();
    private ArrayList<Patient> examinationsQueue = new ArrayList<>();
    private ArrayList<Patient> sentHome = new ArrayList<>();

    public ArrayList<Patient> getSentHome() {
        return sentHome;
    }

    private Specialities specialities = new Specialities();

    public ArrayList<Patient> getTriageQueue() {
        return triageQueue;
    }

    public ArrayList<Patient> getExaminationsQueue() {
        return examinationsQueue;
    }

    public ArrayList<Patient> getInvestigationsQueue() {
        return investigationsQueue;
    }

    public int getSimulationLength() {
        return simulationLength;
    }

    public void setSimulationLength(int simulationLength) {
        this.simulationLength = simulationLength;
    }

    public int getNurses() {
        return nurses;
    }

    public void setNurses(int nurses) {
        this.nurses = nurses;
    }

    public int getInvestigators() {
        return investigators;
    }

    public void setInvestigators(int investigators) {
        this.investigators = investigators;
    }

    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(ArrayList<Doctor> doctors) {
        this.doctors = doctors;
    }

    public ArrayList<Patient> getIncomingPatients() {
        return incomingPatients;
    }

    public void setIncomingPatients(ArrayList<Patient> incomingPatients) {
        this.incomingPatients = incomingPatients;
    }

    private static HospitalState hs = null;

    private HospitalState() {
    }

    public static HospitalState getInstance() {
        if (hs == null) {
            hs = new HospitalState();
        }
        return hs;
    }

    void setFactors(ArrayList<Doctor> doctors){
        for (Doctor doctor : doctors) {
            doctor.setConstants();
        }
    }

    void setIllnessTypes(ArrayList<Patient> patients) {
        for (Patient patient : patients) {
            patient.setIllnessType();
        }
    }

    void addToQueue(Patient patient){
        if (this.getTriageQueue().isEmpty()) {
            this.getTriageQueue().add(patient);
        } else {
            int index = 0;
            for (int i = 0; i < this.getTriageQueue().size(); i++) {
                if (patient.getUrgency() >= this.getTriageQueue().get(i).getUrgency()) {
                    index = i;
                    break;
                }
            }
            this.getTriageQueue().add(index, patient);
        }
    }

    void nursesAssess() {
        Nurse nurse = new Nurse();
        nurse.assessUrgency(this.getIncomingPatients().get(0));
        this.addToQueue(this.getIncomingPatients().get(0));
        this.getIncomingPatients().get(0).setCurrentState(State.TRIAGEQUEUE);

    }

    public Specialities getSpecialities() {
        return specialities;
    }

    void setDoctorsWhoTreat() {
        for (int i = 0; i < this.getDoctors().size(); i++) {
            Doctor doctor = this.getDoctors().get(i);
            for (int j = 0; j < this.getDoctors().get(i).getDiseasesTreated().size(); j++) {
                String disease = this.getDoctors().get(i).getDiseasesTreated().get(j);
                switch (disease.toLowerCase()) {
                    case "heart_attack":
                        this.getSpecialities().getHeart_attack().add(doctor);
                        break;
                    case "heart_disease":
                        this.getSpecialities().getHeart_disease().add(doctor);
                        break;
                    case "allergic_reaction":
                        this.getSpecialities().getAllergic_reaction().add(doctor);
                        break;
                    case "broken_bones":
                        this.getSpecialities().getBroken_bones().add(doctor);
                        break;
                    case "burns":
                        this.getSpecialities().getBurns().add(doctor);
                        break;
                    case "car_accident":
                        this.getSpecialities().getCar_accident().add(doctor);
                        break;
                    case "cuts":
                        this.getSpecialities().getCuts().add(doctor);
                        break;
                    case "high_fever":
                        this.getSpecialities().getHigh_fever().add(doctor);
                        break;
                    case "sport_injuries":
                        this.getSpecialities().getSport_injuries().add(doctor);
                        break;
                    case "abdominal_pain":
                        this.getSpecialities().getAbdominal_pain().add(doctor);
                        break;
                    case "food_poisoning":
                        this.getSpecialities().getFood_poisoning().add(doctor);
                        break;
                    case "pneumonia":
                        this.getSpecialities().getPneumonia().add(doctor);
                        break;
                    case "stroke":
                        this.getSpecialities().getStroke().add(doctor);
                        break;
                }
            }
        }
    }

    //TODO: use investigationresult.notdiagnosed instead of is diagnosed field;
    void sendPatientsToDoctors() {
        int size = this.getTriageQueue().size();
        for (int i = 0; i < size; i++) {
            Patient patient = this.getTriageQueue().get(i);
            Doctor doctor;
            switch (patient.getState().getIllnessName().toLowerCase()) {
                case "heart_attack":
                    doctor = this.getSpecialities().getHeart_attack().get(0);
                    this.getSpecialities().getHeart_attack().
                            add(this.getSpecialities().getHeart_attack().size() - 1, doctor);
                    this.getSpecialities().getHeart_attack().remove(0);

                    if (!patient.isDiagnosed()) {
                        if (patient.getState().getSeverity() <= doctor.getMaxForTreatment()) {
                            patient.getState().setSeverity(patient.getState().getSeverity() - 22);
                            patient.setCurrentState(State.HOME_CARDIO);
                            patient.setDiagnosed(true);
                            this.getSentHome().add(patient);
                        } else {
                            patient.setCurrentState(State.INVESTIGATIONSQUEUE);
                            patient.setDiagnosed(true);
                            this.getInvestigationsQueue().add(patient);

                        }
                    }
                    break;
                case "heart_disease":
                    doctor = this.getSpecialities().getHeart_disease().get(0);
                    this.getSpecialities().getHeart_disease().
                            add(this.getSpecialities().getHeart_disease().size() - 1, doctor);
                    this.getSpecialities().getHeart_disease().remove(0);

                    if (!patient.isDiagnosed()) {
                        if (patient.getState().getSeverity() <= doctor.getMaxForTreatment()) {
                            patient.getState().setSeverity(patient.getState().getSeverity() - 22);
                            if (doctor.getType().toUpperCase().equals("CARDIOLOGIST")) {
                                patient.setCurrentState(State.HOME_CARDIO);
                            }
                            if (doctor.getType().toUpperCase().equals("INTERNIST")) {
                                patient.setCurrentState(State.HOME_INTERNIST);
                            }
                            patient.setDiagnosed(true);
                            this.getSentHome().add(patient);
                        } else {
                            patient.setCurrentState(State.INVESTIGATIONSQUEUE);
                            patient.setDiagnosed(true);
                            this.getInvestigationsQueue().add(patient);
                        }
                    }
                    break;
                case "allergic_reaction":
                    doctor = this.getSpecialities().getAllergic_reaction().get(0);
                    this.getSpecialities().getAllergic_reaction().
                            add(this.getSpecialities().getAllergic_reaction().size() - 1, doctor);
                    this.getSpecialities().getAllergic_reaction().remove(0);

                    if (!patient.isDiagnosed()) {
                        if (patient.getState().getSeverity() <= doctor.getMaxForTreatment()) {
                            patient.getState().setSeverity(patient.getState().getSeverity() - 22);

                            if (doctor.getType().toUpperCase().equals("ER_PHYSICIAN")) {
                                patient.setCurrentState(State.HOME_ERPHYSICIAN);
                            }

                            if (doctor.getType().toUpperCase().equals("GASTROENTEROLOGIST")) {
                                patient.setCurrentState(State.HOME_GASTRO);
                            }

                            if (doctor.getType().toUpperCase().equals("INTERNIST")) {
                                patient.setCurrentState(State.HOME_INTERNIST);
                            }
                            patient.setDiagnosed(true);
                            this.getSentHome().add(patient);
                        } else {
                            patient.setCurrentState(State.INVESTIGATIONSQUEUE);
                            patient.setDiagnosed(true);
                            this.getInvestigationsQueue().add(patient);
                        }
                    }
                    break;
                case "broken_bones":
                    doctor = this.getSpecialities().getBroken_bones().get(0);
                    this.getSpecialities().getBroken_bones().
                            add(this.getSpecialities().getBroken_bones().size() - 1, doctor);
                    this.getSpecialities().getBroken_bones().remove(0);

                    if (!patient.isDiagnosed()) {
                        if (patient.getState().getSeverity() <= doctor.getMaxForTreatment()) {
                            patient.getState().setSeverity(patient.getState().getSeverity() - 22);

                            patient.setCurrentState(State.HOME_ERPHYSICIAN);
                            patient.setDiagnosed(true);
                            this.getSentHome().add(patient);
                        } else {
                            patient.setCurrentState(State.INVESTIGATIONSQUEUE);
                            patient.setDiagnosed(true);
                            this.getInvestigationsQueue().add(patient);
                        }
                    }
                    break;
                case "burns":
                    doctor = this.getSpecialities().getBurns().get(0);
                    this.getSpecialities().getBurns().
                            add(this.getSpecialities().getBurns().size() - 1, doctor);
                    this.getSpecialities().getBurns().remove(0);

                    if (!patient.isDiagnosed()) {
                        if (patient.getState().getSeverity() <= doctor.getMaxForTreatment()) {
                            patient.getState().setSeverity(patient.getState().getSeverity() - 22);

                            if (doctor.getType().toUpperCase().equals("ER_PHYSICIAN")) {
                                patient.setCurrentState(State.HOME_ERPHYSICIAN);
                            }

                            if (doctor.getType().toUpperCase().equals("GENERAL_SURGEON")) {
                                patient.setCurrentState(State.HOME_SURGEON);
                            }
                            patient.setDiagnosed(true);
                            this.getSentHome().add(patient);
                        } else {
                            patient.setCurrentState(State.INVESTIGATIONSQUEUE);
                            patient.setDiagnosed(true);
                            this.getInvestigationsQueue().add(patient);
                        }
                    }
                    break;
                case "car_accident":
                    doctor = this.getSpecialities().getCar_accident().get(0);
                    this.getSpecialities().getCar_accident().
                            add(this.getSpecialities().getCar_accident().size() - 1, doctor);
                    this.getSpecialities().getCar_accident().remove(0);

                    if (!patient.isDiagnosed()) {
                        if (patient.getState().getSeverity() <= doctor.getMaxForTreatment()) {
                            patient.getState().setSeverity(patient.getState().getSeverity() - 22);

                            if (doctor.getType().toUpperCase().equals("ER_PHYSICIAN")) {
                                patient.setCurrentState(State.HOME_ERPHYSICIAN);
                            }

                            if (doctor.getType().toUpperCase().equals("GENERAL_SURGEON")) {
                                patient.setCurrentState(State.HOME_SURGEON);
                            }
                            patient.setDiagnosed(true);
                            this.getSentHome().add(patient);
                        } else {
                            patient.setCurrentState(State.INVESTIGATIONSQUEUE);
                            patient.setDiagnosed(true);
                            this.getInvestigationsQueue().add(patient);
                        }
                    }
                    break;
                case "cuts":
                    doctor = this.getSpecialities().getCuts().get(0);
                    this.getSpecialities().getCuts().
                            add(this.getSpecialities().getCuts().size() - 1, doctor);
                    this.getSpecialities().getCuts().remove(0);

                    if (!patient.isDiagnosed()) {
                        if (patient.getState().getSeverity() <= doctor.getMaxForTreatment()) {
                            patient.getState().setSeverity(patient.getState().getSeverity() - 22);

                            if (doctor.getType().toUpperCase().equals("ER_PHYSICIAN")) {
                                patient.setCurrentState(State.HOME_ERPHYSICIAN);
                            }

                            if (doctor.getType().toUpperCase().equals("GENERAL_SURGEON")) {
                                patient.setCurrentState(State.HOME_SURGEON);
                            }
                            patient.setDiagnosed(true);
                            this.getSentHome().add(patient);
                        } else {
                            patient.setCurrentState(State.INVESTIGATIONSQUEUE);
                            patient.setDiagnosed(true);
                            this.getInvestigationsQueue().add(patient);
                        }
                    }
                    break;
                case "high_fever":
                    doctor = this.getSpecialities().getHigh_fever().get(0);
                    this.getSpecialities().getHigh_fever().
                            add(this.getSpecialities().getHigh_fever().size() - 1, doctor);
                    this.getSpecialities().getHigh_fever().remove(0);

                    if (!patient.isDiagnosed()) {
                        if (patient.getState().getSeverity() <= doctor.getMaxForTreatment()) {
                            patient.getState().setSeverity(patient.getState().getSeverity() - 22);

                            if (doctor.getType().toUpperCase().equals("INTERNIST")) {
                                patient.setCurrentState(State.HOME_INTERNIST);
                            }

                            if (doctor.getType().toUpperCase().equals("ER_PHYSICIAN")) {
                                patient.setCurrentState(State.HOME_ERPHYSICIAN);
                            }
                            patient.setDiagnosed(true);
                            this.getSentHome().add(patient);
                        } else {
                            patient.setCurrentState(State.INVESTIGATIONSQUEUE);
                            patient.setDiagnosed(true);
                            this.getInvestigationsQueue().add(patient);
                        }
                    }
                    break;
                case "sport_injuries":
                    doctor = this.getSpecialities().getSport_injuries().get(0);
                    this.getSpecialities().getSport_injuries().
                            add(this.getSpecialities().getSport_injuries().size() - 1, doctor);
                    this.getSpecialities().getSport_injuries().remove(0);

                    if (!patient.isDiagnosed()) {
                        if (patient.getState().getSeverity() <= doctor.getMaxForTreatment()) {
                            patient.getState().setSeverity(patient.getState().getSeverity() - 22);

                            if (doctor.getType().toUpperCase().equals("ER_PHYSICIAN")) {
                                patient.setCurrentState(State.HOME_ERPHYSICIAN);
                            }

                            if (doctor.getType().toUpperCase().equals("GENERAL_SURGEON")) {
                                patient.setCurrentState(State.HOME_SURGEON);
                            }
                            patient.setDiagnosed(true);
                            this.getSentHome().add(patient);
                        } else {
                            patient.setCurrentState(State.INVESTIGATIONSQUEUE);
                            patient.setDiagnosed(true);
                            this.getInvestigationsQueue().add(patient);
                        }
                    }
                    break;
                case "abdominal_pain":
                    doctor = this.getSpecialities().getAbdominal_pain().get(0);
                    this.getSpecialities().getAbdominal_pain().
                            add(this.getSpecialities().getAbdominal_pain().size() - 1, doctor);
                    this.getSpecialities().getAbdominal_pain().remove(0);

                    if (!patient.isDiagnosed()) {
                        if (patient.getState().getSeverity() <= doctor.getMaxForTreatment()) {
                            patient.getState().setSeverity(patient.getState().getSeverity() - 22);

                            if (doctor.getType().toUpperCase().equals("GASTROENTEROLOGIST")) {
                                patient.setCurrentState(State.HOME_GASTRO);
                            }

                            if (doctor.getType().toUpperCase().equals("GENRAL_SURGEON")) {
                                patient.setCurrentState(State.HOME_SURGEON);
                            }

                            if (doctor.getType().toUpperCase().equals("INTERNIST")) {
                                patient.setCurrentState(State.HOME_INTERNIST);
                            }
                            patient.setDiagnosed(true);
                            this.getSentHome().add(patient);
                        } else {
                            patient.setCurrentState(State.INVESTIGATIONSQUEUE);
                            patient.setDiagnosed(true);
                            this.getInvestigationsQueue().add(patient);
                        }
                    }
                    break;
                case "food_poisoning":
                    doctor = this.getSpecialities().getFood_poisoning().get(0);
                    this.getSpecialities().getFood_poisoning().
                            add(this.getSpecialities().getFood_poisoning().size() - 1, doctor);
                    this.getSpecialities().getFood_poisoning().remove(0);
                    if (!patient.isDiagnosed()) {

                        if (patient.getState().getSeverity() <= doctor.getMaxForTreatment()) {
                            patient.getState().setSeverity(patient.getState().getSeverity() - 22);

                            patient.setCurrentState(State.HOME_GASTRO);
                            patient.setDiagnosed(true);
                            this.getSentHome().add(patient);
                        } else {
                            patient.setCurrentState(State.INVESTIGATIONSQUEUE);
                            patient.setDiagnosed(true);
                            this.getInvestigationsQueue().add(patient);
                        }
                    }
                    break;
                case "pneumonia":
                    doctor = this.getSpecialities().getPneumonia().get(0);
                    this.getSpecialities().getPneumonia().
                            add(this.getSpecialities().getPneumonia().size() - 1, doctor);
                    this.getSpecialities().getPneumonia().remove(0);

                    if (!patient.isDiagnosed()) {
                        if (patient.getState().getSeverity() <= doctor.getMaxForTreatment()) {
                            patient.getState().setSeverity(patient.getState().getSeverity() - 22);

                            patient.setCurrentState(State.HOME_INTERNIST);
                            patient.setDiagnosed(true);
                            this.getSentHome().add(patient);
                        } else {
                            patient.setCurrentState(State.INVESTIGATIONSQUEUE);
                            patient.setDiagnosed(true);
                            this.getInvestigationsQueue().add(patient);
                        }
                    }
                    break;
                case "stroke":
                    doctor = this.getSpecialities().getStroke().get(0);
                    this.getSpecialities().getStroke().
                            add(this.getSpecialities().getStroke().size() - 1, doctor);
                    this.getSpecialities().getStroke().remove(0);

                    if (!patient.isDiagnosed()) {
                        if (patient.getState().getSeverity() <= doctor.getMaxForTreatment()) {
                            patient.getState().setSeverity(patient.getState().getSeverity() - 22);

                            patient.setCurrentState(State.HOME_NEURO);
                            this.getSentHome().add(patient);
                            patient.setDiagnosed(true);
                        } else {
                            patient.setCurrentState(State.INVESTIGATIONSQUEUE);
                            patient.setDiagnosed(true);
                            this.getInvestigationsQueue().add(patient);
                        }
                    }
                    break;
            }
        }

        ArrayList<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            if (this.getTriageQueue().get(i).isDiagnosed()) {
                indexes.add(i);
            }
        }
        this.clearTriage(indexes);
    }

    void clearTriage(ArrayList<Integer> indexes){
        int aux = 0;
        for (int i = 0; i < indexes.size(); i++) {
            int index = i - aux;
            this.getTriageQueue().remove(index);
            aux++;
        }
    }

    void investigatePatients() {
        ERTehnician erTehnician = new ERTehnician();
        for (int i = 0; i < this.getInvestigators(); i++) {
            if (!this.getInvestigationsQueue().isEmpty()) {
                Patient patient = this.getInvestigationsQueue().get(0);
                erTehnician.assess(patient);
                this.getExaminationsQueue().add(patient);
                patient.setCurrentState(State.EXAMINATIONSQUEUE);
                this.getInvestigationsQueue().remove(0);
            }
        }
    }

    void checkExaminationQueue() {
        for (int i = 0; i < this.getExaminationsQueue().size(); i++) {
            Patient patient = this.getExaminationsQueue().get(i);
            Doctor doctor;
            boolean doctorFound = false;
            switch (patient.getState().getIllnessName().toLowerCase()) {
                case "heart_attack":
                    doctor = this.getSpecialities().getHeart_attack().get(0);
                    this.getSpecialities().getHeart_attack().
                            add(this.getSpecialities().getHeart_attack().size() - 1, doctor);
                    this.getSpecialities().getHeart_attack().remove(0);
                    if (doctor.getIsSurgeon()) {
                        doctorFound = true;
                    }
                    break;
                case "heart_disease":
                    doctor = this.getSpecialities().getHeart_disease().get(0);
                    this.getSpecialities().getHeart_disease().
                            add(this.getSpecialities().getHeart_disease().size() - 1, doctor);
                    this.getSpecialities().getHeart_disease().remove(0);
                    if (doctor.getIsSurgeon()) {
                        doctorFound = true;
                    }
                    break;
                case "allergic_reaction":
                    doctor = this.getSpecialities().getAllergic_reaction().get(0);
                    this.getSpecialities().getAllergic_reaction().
                            add(this.getSpecialities().getAllergic_reaction().size() - 1, doctor);
                    this.getSpecialities().getAllergic_reaction().remove(0);
                    if (doctor.getIsSurgeon()) {
                        doctorFound = true;
                    }
                    break;
                case "broken_bones":
                    doctor = this.getSpecialities().getBroken_bones().get(0);
                    this.getSpecialities().getBroken_bones().
                            add(this.getSpecialities().getBroken_bones().size() - 1, doctor);
                    this.getSpecialities().getBroken_bones().remove(0);
                    if (doctor.getIsSurgeon()) {
                        doctorFound = true;
                    }
                    break;
                case "burns":
                    doctor = this.getSpecialities().getBurns().get(0);
                    this.getSpecialities().getBurns().
                            add(this.getSpecialities().getBurns().size() - 1, doctor);
                    this.getSpecialities().getBurns().remove(0);
                    if (doctor.getIsSurgeon()) {
                        doctorFound = true;
                    }
                    break;
                case "car_accident":
                    doctor = this.getSpecialities().getCar_accident().get(0);
                    this.getSpecialities().getCar_accident().
                            add(this.getSpecialities().getCar_accident().size() - 1, doctor);
                    this.getSpecialities().getCar_accident().remove(0);
                    System.out.println(doctor.getType());
                    if (patient.getInvestigationResult().toString().equals("HOSPITALIZE")) {
                        if( doctor.getType().toLowerCase().equals("er_physician")) {
                            patient.setCurrentState(State.HOSPITALIZED_ERPHYSICIAN);
                            patient.setHospitalRounds((int) Math.round(Math.max(patient.getState().getSeverity() * doctor.getC1(), 3)));
                        }
                        if( doctor.getType().toLowerCase().equals("general_surgeon")) {
                            patient.setCurrentState(State.HOSPITALIZED_SURGEON);
                            patient.setHospitalRounds((int) Math.round(Math.max(patient.getState().getSeverity() * doctor.getC1(), 3)));
                        }
                        patient.treat(22);
                    }
                    if (doctor.getIsSurgeon()) {
                        doctorFound = true;
                    }
                    break;
                case "cuts":
                    doctor = this.getSpecialities().getCuts().get(0);
                    this.getSpecialities().getCuts().
                            add(this.getSpecialities().getCuts().size() - 1, doctor);
                    this.getSpecialities().getCuts().remove(0);
                    if (doctor.getIsSurgeon()) {
                        doctorFound = true;
                    }
                    break;
                case "high_fever":
                    doctor = this.getSpecialities().getHigh_fever().get(0);
                    this.getSpecialities().getHigh_fever().
                            add(this.getSpecialities().getHigh_fever().size() - 1, doctor);
                    this.getSpecialities().getHigh_fever().remove(0);
                    if (doctor.getIsSurgeon()) {
                        doctorFound = true;
                    }
                    break;
                case "sport_injuries":
                    doctor = this.getSpecialities().getSport_injuries().get(0);
                    this.getSpecialities().getSport_injuries().
                            add(this.getSpecialities().getSport_injuries().size() - 1, doctor);
                    this.getSpecialities().getSport_injuries().remove(0);
                    if (doctor.getIsSurgeon()) {
                        doctorFound = true;
                    }
                    break;
                case "abdominal_pain":
                    doctor = this.getSpecialities().getAbdominal_pain().get(0);
                    this.getSpecialities().getAbdominal_pain().
                            add(this.getSpecialities().getAbdominal_pain().size() - 1, doctor);
                    this.getSpecialities().getAbdominal_pain().remove(0);
                    if (doctor.getIsSurgeon()) {
                        doctorFound = true;
                    }
                    break;
                case "food_poisoning":
                    doctor = this.getSpecialities().getFood_poisoning().get(0);
                    this.getSpecialities().getFood_poisoning().
                            add(this.getSpecialities().getFood_poisoning().size() - 1, doctor);
                    this.getSpecialities().getFood_poisoning().remove(0);
                    if (doctor.getIsSurgeon()) {
                        doctorFound = true;
                    }
                    break;
                case "pneumonia":
                    doctor = this.getSpecialities().getPneumonia().get(0);
                    this.getSpecialities().getPneumonia().
                            add(this.getSpecialities().getPneumonia().size() - 1, doctor);
                    this.getSpecialities().getPneumonia().remove(0);
                    if (doctor.getIsSurgeon()) {
                        doctorFound = true;
                    }
                    break;
                case "stroke":
                    doctor = this.getSpecialities().getStroke().get(0);
                    this.getSpecialities().getStroke().
                            add(this.getSpecialities().getStroke().size() - 1, doctor);
                    this.getSpecialities().getStroke().remove(0);
                    if (doctor.getIsSurgeon()) {
                        doctorFound = true;
                    }
                    break;
            }

            if (patient.getCurrentState().toString().toLowerCase().equals("operate")) {
                if (doctorFound) {
                    System.out.println("opereazama");
                } else {
                    patient.setCurrentState(State.OTHERHOSPITAL);
                }
            }

        }
    }

}
