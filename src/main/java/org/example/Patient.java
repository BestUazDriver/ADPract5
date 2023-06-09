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
    private int id;
    private LocalDate date;
    private String name;
    private String organisation;
    private int organisationTreatment;
    private LocalDate treatmentStartDate;
    private int riskScoreCVRM;
    private int mdrd;
    private LocalDate lastMDRDLastDate;
    private double glucoseFasting;
    private LocalDate glucoseFastingLastDate;
    private double cholesterol;
    private LocalDate cholesterolLastDate;
    private int systolicBloodPressure;
    private int diastolicBloodPressure;
    private LocalDate systolicBloodPressureLastDate;
    private int bmi;
    private LocalDate bmiLastDate;
    private String cvrm;
    private String smokingStatus;
    private LocalDate dateLastContactCVRM;
    private String patientGender;
    private int age;
    private boolean hypertension;
    private LocalDate annualCheckupCVRMDate;
    private LocalDate interimCheckupCVRMDate;
}
