package org.example;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private final static String path = "C:\\Users\\admin\\IdeaProjects\\src\\ADPract5\\src\\main\\resources\\med.txt";

    public static void main(String[] args) {
        List<Patient> patients = readFile(path);
        System.out.println(parsePatientsByTreatment(patients));
    }

    private static List<Patient> readFile(String path) {
        BufferedReader bufferedReader;
        List<Patient> patients = new ArrayList<>();
        try {
            bufferedReader = new BufferedReader(new FileReader(path));
            String tab = String.valueOf(bufferedReader.readLine().charAt(3));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
//            for (int i = 0; i < 50; i++) {
//                line = bufferedReader.readLine();
                try {
                    boolean isValidPatient = true;
                    String[] params = line.split(tab);
                    int id = Integer.parseInt(params[0]);
                    String[] dateSplit = params[1].split("/");
                    LocalDate referenceDate = LocalDate.of(Integer.parseInt(dateSplit[2]), Integer.parseInt(dateSplit[0]), Integer.parseInt(dateSplit[1]));
                    String name = params[2];
                    String organisation = params[3];
                    int organisationTreatment = Integer.parseInt(params[4]);
                    String[] dateSplitOrganisation = params[5].split("/");
                    LocalDate treatmentStartDate = LocalDate.of(Integer.parseInt(dateSplitOrganisation[2]), Integer.parseInt(dateSplitOrganisation[0]), Integer.parseInt(dateSplitOrganisation[1]));
                    int riskScore;
                    if (params[6].equals("")) {
                        riskScore = 0;
                    } else {
                        riskScore = Integer.parseInt(params[6]);
                    }
                    if (riskScore > 50) isValidPatient = false;
                    int mdrd;
                    if (params[7].equals("")) {
                        mdrd = 0;
                    } else {
                        mdrd = Integer.parseInt(params[7]);
                    }
                    if (mdrd < 15 || mdrd > 140) isValidPatient = false;
                    LocalDate mdrdLstDate = null;
                    if (!params[8].equals("")) {
                        String[] mdrdLastParse = params[8].split("/");
                        mdrdLstDate = LocalDate.of(Integer.parseInt(mdrdLastParse[2]), Integer.parseInt(mdrdLastParse[0]), Integer.parseInt(mdrdLastParse[1]));
                    }
                    double glucoseFasting;
                    if (!params[9].isEmpty()) {
                        glucoseFasting = Double.parseDouble(params[9]);
                    } else {
                        glucoseFasting = 0.0;
                    }
                    if (glucoseFasting < 3 || glucoseFasting > 25) isValidPatient = false;
                    LocalDate glucoseFastingLastDate = null;
                    if (!params[10].equals("")) {
                        String[] glucoseFastingLastDateParse = params[10].split("/");
                        glucoseFastingLastDate = LocalDate.of(Integer.parseInt(glucoseFastingLastDateParse[2]), Integer.parseInt(glucoseFastingLastDateParse[0]), Integer.parseInt(glucoseFastingLastDateParse[1]));
                    }
                    double cholesterol;
                    if (params[11].equals("")) {
                        cholesterol = 0;
                    } else {
                        cholesterol = Double.parseDouble(params[11]);
                    }
                    if (cholesterol < 2 || cholesterol > 15) isValidPatient = false;
                    LocalDate cholesterolLastDate = null;
                    if (!params[12].equals("")) {
                        String[] cholesterolLastDateParse = params[12].split("/");
                        cholesterolLastDate = LocalDate.of(Integer.parseInt(cholesterolLastDateParse[2]), Integer.parseInt(cholesterolLastDateParse[0]), Integer.parseInt(cholesterolLastDateParse[1]));
                    }
                    int systolicBloodPressure = 0;
                    if (!params[13].equals("")) {
                        systolicBloodPressure = Integer.parseInt(params[13]);
                    }
                    if (systolicBloodPressure < 90 || systolicBloodPressure > 230) isValidPatient = false;
                    int diastolicBloodPressure = 0;
                    if (!params[14].equals("")) {
                        diastolicBloodPressure = Integer.parseInt(params[14]);
                    }
                    if (diastolicBloodPressure < 40 || diastolicBloodPressure > 120) isValidPatient = false;

                    String[] systolicBloodPressureLastDateParse = params[15].split("/");
                    LocalDate systolicBloodPressureLastDate = null;
                    if (systolicBloodPressureLastDateParse.length > 1) {
                        systolicBloodPressureLastDate = LocalDate.of(Integer.parseInt(systolicBloodPressureLastDateParse[2]), Integer.parseInt(systolicBloodPressureLastDateParse[0]), Integer.parseInt(systolicBloodPressureLastDateParse[1]));
                    }
                    int bmi = 0;
                    if (!params[16].equals("")) {
                        bmi = Integer.parseInt(params[16]);
                    }
                    if (bmi < 15 || bmi > 45) isValidPatient = false;
                    LocalDate bmiLastDate = null;
                    if (!params[17].equals("")) {
                        String[] bmiLastDateParse = params[17].split("/");
                        bmiLastDate = LocalDate.of(Integer.parseInt(bmiLastDateParse[2]), Integer.parseInt(bmiLastDateParse[0]), Integer.parseInt(bmiLastDateParse[1]));
                    }
                    String cvrm = params[18];
                    String smokingStatus = params[19];
                    LocalDate lastDateContactCVRM = null;
                    if (!params[20].equals("")) {
                        String[] lastDateContactCVRMParse = params[20].split("/");
                        lastDateContactCVRM = LocalDate.of(Integer.parseInt(lastDateContactCVRMParse[2]), Integer.parseInt(lastDateContactCVRMParse[0]), Integer.parseInt(lastDateContactCVRMParse[1]));
                    }
                    String patientGender = params[21];
                    int age = Integer.parseInt(params[22]);
                    boolean hypertension = params[23].equals("Yes");
                    LocalDate annualCheckupCVRMDate = null;
                    if (!params[24].equals("")) {
                        String[] annualCheckupCVRMDateParse = params[24].split("/");
                        annualCheckupCVRMDate = LocalDate.of(Integer.parseInt(annualCheckupCVRMDateParse[2]), Integer.parseInt(annualCheckupCVRMDateParse[0]), Integer.parseInt(annualCheckupCVRMDateParse[1]));
                    }
                    LocalDate interimCheckupCVRMDate = null;
                    if (!params[25].equals("")) {
                        String[] interimCheckupCVRMDateParse = params[25].split("/");
                        interimCheckupCVRMDate = LocalDate.of(Integer.parseInt(interimCheckupCVRMDateParse[2]), Integer.parseInt(interimCheckupCVRMDateParse[0]), Integer.parseInt(interimCheckupCVRMDateParse[1]));
                    }

                    Patient patient = Patient.builder().
                            id(id).
                            date(referenceDate).
                            name(name).
                            organisation(organisation).organisationTreatment(organisationTreatment).
                            treatmentStartDate(treatmentStartDate).
                            riskScoreCVRM(riskScore)
                            .mdrd(mdrd)
                            .lastMDRDLastDate(mdrdLstDate)
                            .glucoseFasting(glucoseFasting)
                            .glucoseFastingLastDate(glucoseFastingLastDate)
                            .cholesterol(cholesterol)
                            .cholesterolLastDate(cholesterolLastDate)
                            .systolicBloodPressure(systolicBloodPressure)
                            .diastolicBloodPressure(diastolicBloodPressure)
                            .systolicBloodPressureLastDate(systolicBloodPressureLastDate)
                            .bmi(bmi)
                            .bmiLastDate(bmiLastDate)
                            .cvrm(cvrm)
                            .smokingStatus(smokingStatus)
                            .dateLastContactCVRM(lastDateContactCVRM)
                            .patientGender(patientGender)
                            .age(age)
                            .hypertension(hypertension)
                            .annualCheckupCVRMDate(annualCheckupCVRMDate)
                            .interimCheckupCVRMDate(interimCheckupCVRMDate)
                            .build();
                    if (isValidPatient) patients.add(patient);
                } catch (ArrayIndexOutOfBoundsException e) {
                    break;
                }
            }
            return patients;
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private static Map<String, Double> parsePatientsByTreatment(List<Patient> patients) {
        Map<String, Double> totalValues = new HashMap<>();
        List<Patient> citizens = new ArrayList<>();
        List<Patient> villagers = new ArrayList<>();

        for (Patient patient : patients) {
            if (patient.getOrganisationTreatment() == 1) {
                citizens.add(patient);
            } else {
                villagers.add(patient);
            }
        }
        for (Patient patient : villagers) {
            System.out.print(patient.getDiastolicBloodPressure() + "  ");
        }
        System.out.println(" ");

        double citizenAverageDiastolicBloodPressure = 0;
        for (Patient patient : citizens) {
            citizenAverageDiastolicBloodPressure += patient.getDiastolicBloodPressure();
        }
        citizenAverageDiastolicBloodPressure = citizenAverageDiastolicBloodPressure / citizens.size();

        double citizensDiastolicBloodPressureDispersion = 0;
        for (Patient patient : citizens) {
            citizensDiastolicBloodPressureDispersion += (patient.getDiastolicBloodPressure() - citizenAverageDiastolicBloodPressure) * (patient.getDiastolicBloodPressure() - citizenAverageDiastolicBloodPressure);
        }
        citizensDiastolicBloodPressureDispersion = citizensDiastolicBloodPressureDispersion / citizens.size() - 1;
        double citizensDiastolicBloodPressureQuadraticDeviation = Math.sqrt(citizensDiastolicBloodPressureDispersion);

        double villagerAverageDiastolicBloodPressure = 0;
        for (Patient patient : villagers) {
            villagerAverageDiastolicBloodPressure += patient.getDiastolicBloodPressure();
        }
        villagerAverageDiastolicBloodPressure = villagerAverageDiastolicBloodPressure / villagers.size();

        double villagerDiastolicBloodPressureDispersion = 0;
        for (Patient patient : villagers) {
            villagerDiastolicBloodPressureDispersion += (patient.getDiastolicBloodPressure() - villagerAverageDiastolicBloodPressure) * (patient.getDiastolicBloodPressure() - villagerAverageDiastolicBloodPressure);
        }
        villagerDiastolicBloodPressureDispersion = villagerDiastolicBloodPressureDispersion / villagers.size() - 1;
        double villagerDiastolicBloodPressureQuadraticDeviation = Math.sqrt(villagerDiastolicBloodPressureDispersion);

        totalValues.put("Citizens average diastolic blood pressure", citizenAverageDiastolicBloodPressure);
        totalValues.put("Citizens diastolic blood pressure dispersion", citizensDiastolicBloodPressureDispersion);
        totalValues.put("Citizens diastolic blood pressure quadratic deviation", citizensDiastolicBloodPressureQuadraticDeviation);

        totalValues.put("Villagers average diastolic blood pressure", villagerAverageDiastolicBloodPressure);
        totalValues.put("Villagers diastolic blood pressure dispersion", villagerDiastolicBloodPressureDispersion);
        totalValues.put("Villagers diastolic blood pressure quadratic deviation", villagerDiastolicBloodPressureQuadraticDeviation);

        return totalValues;
    }
}