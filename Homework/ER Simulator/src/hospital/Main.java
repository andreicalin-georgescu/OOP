package hospital;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Doctor;
import entities.Nurse;
import entities.Patient;
import utilities.State;

import java.io.File;
import java.io.IOException;

public class Main {

    public static HospitalState hs = HospitalState.getInstance();

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            hs = objectMapper.readValue(new File(args[0]), HospitalState.class);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        hs.setFactors(hs.getDoctors());
        hs.setIllnessTypes(hs.getIncomingPatients());

        int round = 0;
        //for (int i = 0; i < hs.getSimulationLength(); i++) {

        //Nurses assess urgency
        for (int i = 0; i < hs.getNurses(); i++) {
            if (!hs.getIncomingPatients().isEmpty() && hs.getIncomingPatients().get(0).getTime() == round) {
                hs.nursesAssess();
                hs.getIncomingPatients().remove(0);
            }
        }
        //Create treatment queues

        hs.setDoctorsWhoTreat();

        //Patients are sent to respective doctor to treat their illness

        hs.sendPatientsToDoctors();

        //Tehnicians investigate patients

        hs.investigatePatients();

        //Doctors check examinationQueue

        hs.checkExaminationQueue();

        round++;

        //}
    }

}

