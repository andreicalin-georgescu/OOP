package entities;

import utilities.InvestigationResult;
import utilities.State;

public class Patient {

    private int id;
    private String name;
    private int age;
    private int time;
    private PatientState state;
    private State currentState;
    private InvestigationResult investigationResult;
    private boolean diagnosed = false;
    private IllnessType illnessType;
    private int hospitalRounds;

    public int getHospitalRounds() {
        return hospitalRounds;
    }

    public void setHospitalRounds(int hospitalRounds) {
        this.hospitalRounds = hospitalRounds;
    }

    public InvestigationResult getInvestigationResult() {
        return investigationResult;
    }

    public void setInvestigationResult(InvestigationResult investigationResult) {
       this.investigationResult = investigationResult;
    }

    public boolean isDiagnosed() {
        return diagnosed;
    }

    public void setDiagnosed(boolean diagnosed) {
        this.diagnosed = diagnosed;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public IllnessType getIllnessType() {
        return illnessType;
    }

    public void setIllnessType() {
        this.illnessType = IllnessType.valueOf(this.getState().getIllnessName().toUpperCase());
    }

    //an int from 3 to 0 representing most urgent to less urgent | used for triageQueue
    private int urgency;

    public int getUrgency() {
        return urgency;
    }

    public void setUrgency(int urgency) {
        this.urgency = urgency;
    }

    public PatientState getState() {
        return state;
    }

    public void setState(PatientState state) {
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void treat(int T) {
        this.getState().setSeverity(this.getState().getSeverity() - 22);
    }
}
