package org.example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
    private LocalDate date;
    private String name;
    private String organisation;
    private boolean organisationTreatment;
    private LocalDate treatmentStartDate;
    private int riskScoreCVRM;
    private int mdrd;
    private LocalDate lastMDRDLastDate;
    private double glucoseFasting;
    private LocalDate glucoseFastingLastDate;
    private int cholesterol;
    private LocalDate cholesterolLastDate;
    private int systolicBloodPressure;
    private int diastolicBloodPressure;
    private LocalDate systolicBloodPressureLastDate;
    private int bmi;
    private LocalDate bmiLastDate;
    private CVRM cvrm;
    private SmokingStatus smokingStatus;
    private LocalDate dateLastContactCVRM;
    private PatientGender patientGender;
    private int age;
    private boolean hypertension;
    private LocalDate annualCheckupCVRMDate;
    private LocalDate interimCheckupCVRMDate;
}
