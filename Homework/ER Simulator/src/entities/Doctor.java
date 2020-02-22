package entities;

import java.util.ArrayList;

public class Doctor {

    private String type;
    private boolean isSurgeon;
    private int maxForTreatment;
    private double C1;
    private double C2;
    private static final int T = 22;
    private ArrayList<String> diseasesTreated = new ArrayList<>();
    private boolean isBusy = false;

    public boolean isBusy() {
        return isBusy;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }

    public double getC1() {
        return C1;
    }

    public double getC2() {
        return C2;
    }

    public static int getT() {
        return T;
    }

    public ArrayList<String> getDiseasesTreated() {
        return diseasesTreated;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean getIsSurgeon() {
        return isSurgeon;
    }

    public void setSurgeon(boolean isSurgeon) {
        this.isSurgeon = isSurgeon;
    }

    public int getMaxForTreatment() {
        return maxForTreatment;
    }

    public void setMaxForTreatment(int maxForTreatment) {
        this.maxForTreatment = maxForTreatment;
    }

    public void setConstants() {
        if (this.getType().toLowerCase().equals("cardiologist")) {
                this.C1 = 0.4;
                this.C2 = 0.1;
                this.diseasesTreated.add("HEART_ATTACK");
                this.diseasesTreated.add("HEART_DISEASE");
        } else if (this.getType().toLowerCase().equals("er_physician")) {
            this.C1 = 0.1;
            this.C2 = 0.3;
            this.diseasesTreated.add("ALLERGIC_REACTION");
            this.diseasesTreated.add("BROKEN_BONES");
            this.diseasesTreated.add("BURNS");
            this.diseasesTreated.add("CAR_ACCIDENT");
            this.diseasesTreated.add("CUTS");
            this.diseasesTreated.add("HIGH_FEVER");
            this.diseasesTreated.add("SPORT_INJURIES");

        } else if (this.getType().toLowerCase().equals("gastroenterologist")) {
            this.C1 = 0.5;
            this.C2 = 1;
            this.diseasesTreated.add("ABDOMINAL_PAIN");
            this.diseasesTreated.add("ALLERGIC_REACTION");
            this.diseasesTreated.add("FOOD_POISONING");
        } else if (this.getType().toLowerCase().equals("general_surgeon")) {
            this.C1 = 0.2;
            this.C2 = 0.2;
            this.diseasesTreated.add("ABDOMINAL_PAIN");
            this.diseasesTreated.add("BURNS");
            this.diseasesTreated.add("CAR_ACCIDENT");
            this.diseasesTreated.add("CUTS");
            this.diseasesTreated.add("SPORT_INJURIES");
        } else if (this.getType().toLowerCase().equals("internist")) {
            this.C1 = 0.01;
            this.C2 = 1;
            this.diseasesTreated.add("ABDOMINAL_PAIN");
            this.diseasesTreated.add("ALLERGIC_REACTION");
            this.diseasesTreated.add("FOOD_POISONING");
            this.diseasesTreated.add("HEART_DISEASE");
            this.diseasesTreated.add("HIGH_FEVER");
            this.diseasesTreated.add("PNEUMONIA");
        } else if (this.getType().toLowerCase().equals("neurologist")) {
            this.C1 = 0.5;
            this.C2 = 0.1;
            this.diseasesTreated.add("STROKE");
        }
    }
}
