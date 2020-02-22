package utilities;

import entities.Doctor;

import java.util.ArrayList;

public class Specialities {

    private ArrayList<Doctor> heart_attack = new ArrayList<>();
    private ArrayList<Doctor> heart_disease = new ArrayList<>();
    private ArrayList<Doctor> allergic_reaction = new ArrayList<>();
    private ArrayList<Doctor> broken_bones = new ArrayList<>();
    private ArrayList<Doctor> burns = new ArrayList<>();
    private ArrayList<Doctor> car_accident = new ArrayList<>();
    private ArrayList<Doctor> cuts = new ArrayList<>();
    private ArrayList<Doctor> high_fever = new ArrayList<>();
    private ArrayList<Doctor> sport_injuries = new ArrayList<>();
    private ArrayList<Doctor> abdominal_pain = new ArrayList<>();
    private ArrayList<Doctor> food_poisoning = new ArrayList<>();
    private ArrayList<Doctor> stroke = new ArrayList<>();
    private ArrayList<Doctor> pneumonia = new ArrayList<>();

    public ArrayList<Doctor> getPneumonia() {
        return pneumonia;
    }

    public ArrayList<Doctor> getHeart_attack() {
        return heart_attack;
    }

    public ArrayList<Doctor> getHeart_disease() {
        return heart_disease;
    }

    public ArrayList<Doctor> getAllergic_reaction() {
        return allergic_reaction;
    }

    public ArrayList<Doctor> getBroken_bones() {
        return broken_bones;
    }

    public ArrayList<Doctor> getBurns() {
        return burns;
    }

    public ArrayList<Doctor> getCar_accident() {
        return car_accident;
    }

    public ArrayList<Doctor> getCuts() {
        return cuts;
    }

    public ArrayList<Doctor> getHigh_fever() {
        return high_fever;
    }

    public ArrayList<Doctor> getSport_injuries() {
        return sport_injuries;
    }

    public ArrayList<Doctor> getAbdominal_pain() {
        return abdominal_pain;
    }

    public ArrayList<Doctor> getFood_poisoning() {
        return food_poisoning;
    }

    public ArrayList<Doctor> getStroke() {
        return stroke;
    }
}
