package entities;
import utilities.UrgencyEstimator;

public class Nurse {
    private UrgencyEstimator ue = UrgencyEstimator.getInstance();
    public void assessUrgency(Patient patient) {
        if (ue.estimateUrgency(patient.getIllnessType(), patient.getState().getSeverity()).toString().equals("IMMEDIATE")) {
            patient.setUrgency(3);
        }

        if (ue.estimateUrgency(patient.getIllnessType(), patient.getState().getSeverity()).toString().equals("URGENT")) {
            patient.setUrgency(2);
        }

        if (ue.estimateUrgency(patient.getIllnessType(), patient.getState().getSeverity()).toString().equals("LESS_URGENT")) {
            patient.setUrgency(1);
        }

        if (ue.estimateUrgency(patient.getIllnessType(), patient.getState().getSeverity()).toString().equals("NON_URGENT")) {
            patient.setUrgency(0);
        }
    }
}
