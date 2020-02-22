package entities;

import utilities.InvestigationResult;

public class ERTehnician {

    private static final int C1 = 75;
    private static final int C2 = 40;

    public void assess(Patient patient) {
        if (patient.getState().getSeverity() > C1) {
            patient.setInvestigationResult(InvestigationResult.OPERATE);
        }
        if (patient.getState().getSeverity() <= C1 && patient.getState().getSeverity() > C2) {
            patient.setInvestigationResult(InvestigationResult.HOSPITALIZE);
        }
        if (patient.getState().getSeverity() <= C2) {
            patient.setInvestigationResult(InvestigationResult.TREATMENT);
        }
    }

}
