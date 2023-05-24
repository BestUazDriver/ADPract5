package org.example;

import java.time.LocalDateTime;


public class Patient {
    private enum CVRM{
        PRIMARY, SECONDARY
    }
    private enum SmokingStatus{
        YES, NEVER
    }
    private enum PatientGender{
        MALE, FEMALE
    }
    private int id;
    private LocalDateTime date;
    private String name;
    private String organisation;
    private boolean organisationTreatment;
    private LocalDateTime treatmentStartDate;
    private int riskScoreCVRM;
    private int mdrd;
    private LocalDateTime lastMDRDLastDate;
    private double glucoseFasting;
    private LocalDateTime glucoseFastingLastDate;
    private int cholesterol;
    private LocalDateTime cholesterolLastDate;
    private int systolicBloodPressure;
    private int diastolicBloodPressure;
    private LocalDateTime systolicBloodPressureLastDate;
    private int bmi;
    private LocalDateTime bmiLastDate;
    private CVRM cvrm;
    private SmokingStatus smokingStatus;
    private LocalDateTime dateLastContactCVRM;
    private PatientGender patientGender;
    private int age;
    private boolean hypertension;
}
