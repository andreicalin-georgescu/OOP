package entities;

import java.util.ArrayList;

public class PatientState{
    private String illnessName;
    private int severity;
    private ArrayList<Doctor> doctorsWhoTreat = new ArrayList<>();

    public ArrayList<Doctor> getDoctorsWhoTreat() {
        return doctorsWhoTreat;
    }

    public String getIllnessName() {
        return illnessName;
    }

    public void setIllnessName(String illnessName) {
        this.illnessName = illnessName;
    }

    public int getSeverity() {
        return severity;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }
}
