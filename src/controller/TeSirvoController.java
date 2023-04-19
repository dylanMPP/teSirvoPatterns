package controller;

import model.*;

import java.util.ArrayList;

public class TeSirvoController {
    private PlanSpecialized planSpecialized;
    private Facturation facturation;
    private int contractIdAccum;
    private int clientIdAccum;
    private int planIdAccum;
    private int serviceIdAccum;

    public TeSirvoController() {
        Singleton.getInstance();
        planSpecialized = new PlanSpecialized();
        facturation = new Facturation();
        contractIdAccum = 0;
        clientIdAccum = 0;
        planIdAccum = 0;
        serviceIdAccum = 0;
    }

    public boolean createContract(String whichClient, String planId) {
        Plan plan = null;

        if (!planId.equalsIgnoreCase("")) {
            plan = getPlan(planId);
        }

        contractIdAccum++;
        if (Singleton.teSirvoContainer.createContract(whichClient, contractIdAccum + "", plan)) {
            return true;
        } else {
            contractIdAccum--;
            return false;
        }
    }

    public Plan getPlan(String planId) {
        for (int i = 0; i < Singleton.planContainer.getPlans().size(); i++) {
            if (Singleton.planContainer.getPlans().get(i).getPlanId().equalsIgnoreCase(planId)) {
                return Singleton.planContainer.getPlans().get(i);
            }
        }
        return null;
    }

    /**
     *
     */
    public String createService(String whichClient, String whichContract, String whichService, String addressInstallation, String dateInstallation,
                                String dateFacturation, boolean state, String meterCode, double actualValue,
                                double previousValue, double amountOfConsumeIncluded,
                                double amountOfConsumed, double amountOfLocalMinutesIncluded, double amountOfLocalMinutesConsumed,
                                double amountOfLargeDistanceMinutesIncluded, double amountOfLargeDistanceMinutesConsumed,
                                String planType) {
        serviceIdAccum++;
        if (Singleton.teSirvoContainer.createService(whichClient, whichContract, whichService, serviceIdAccum + ""
                , addressInstallation, dateInstallation,
                dateFacturation, state, meterCode, actualValue,
                previousValue, amountOfConsumeIncluded,
                amountOfConsumed, amountOfLocalMinutesIncluded, amountOfLocalMinutesConsumed,
                amountOfLargeDistanceMinutesIncluded, amountOfLargeDistanceMinutesConsumed,
                planType)) {
            return serviceIdAccum + "";
        } else {
            serviceIdAccum--;
            return 0 + "";
        }
    }

    /**
     *
     */
    public boolean updateService(String whichClient, String whichContract, String whichServiceToChange, String whichService,
                                 String id, String addressInstallation, String dateInstallation,
                                 String dateFacturation, boolean state, String meterCode, double actualValue,
                                 double previousValue, double amountOfConsumeIncluded,
                                 double amountOfConsumed, double amountOfLocalMinutesIncluded, double amountOfLocalMinutesConsumed,
                                 double amountOfLargeDistanceMinutesIncluded, double amountOfLargeDistanceMinutesConsumed,
                                 String planType) {
        return Singleton.teSirvoContainer.updateService(whichClient, whichContract, whichServiceToChange, whichService,
                id, addressInstallation, dateInstallation,
                dateFacturation, state, meterCode, actualValue,
                previousValue, amountOfConsumeIncluded,
                amountOfConsumed, amountOfLocalMinutesIncluded, amountOfLocalMinutesConsumed,
                amountOfLargeDistanceMinutesIncluded, amountOfLargeDistanceMinutesConsumed,
                planType);
    }

    /**
     *
     */
    public Service consultService(String whichClient, String whichContract, String whichService) {
        return Singleton.teSirvoContainer.consultService(whichClient, whichContract, whichService);
    }

    /**
     *
     */
    public boolean inactivateService(String whichClient, String whichContract, String whichService) {
        return Singleton.teSirvoContainer.inactivateService(whichClient, whichContract, whichService);
    }

    /**
     *
     */
    public boolean createClient(String state, String name, String date, String addressFacturation, String phoneNumber,
                                String email) {
        clientIdAccum++;

        if (Singleton.teSirvoContainer.createClient(state, name, clientIdAccum + "", date, addressFacturation, phoneNumber, email)) {
            return true;
        } else {
            clientIdAccum--;
            return false;
        }
    }

    /**
     *
     */
    public boolean createPlan(String name, double valueToPay, double valueForAdditionalConsume, String dateRange,
                              ArrayList<String> services,
                              double capacityInternetValue, double capacityTelephonyValue, double capacityWaterValue, double capacityEnergyValue,
                              double capacityGasValue) {
        planIdAccum++;

        if (Singleton.planContainer.createPlan(planIdAccum + "", name, valueToPay, valueForAdditionalConsume, dateRange,
                services, capacityInternetValue, capacityTelephonyValue, capacityWaterValue, capacityEnergyValue,
                capacityGasValue)) {
            return true;
        } else {
            planIdAccum--;
            return false;
        }
    }

    /**
     *
     */
    // los servicios que pertenezcan a un mismo plan en un mismo contrato tendrán el mismo ID
    public boolean buyPlan(String whichContract, String whichClient, String whichPlan,
                           String addressInstallation, String dateInstallation,
                           String dateFacturation, boolean state, String meterCode, double actualValue,
                           double previousValue, double amountOfConsumeIncluded,
                           double amountOfConsumed, double amountOfLocalMinutesIncluded, double amountOfLocalMinutesConsumed,
                           double amountOfLargeDistanceMinutesIncluded, double amountOfLargeDistanceMinutesConsumed,
                           String planType) {
        serviceIdAccum++;

        if (planSpecialized.buyPlan(whichPlan, whichContract, whichClient, serviceIdAccum + "", addressInstallation, dateInstallation,
                dateFacturation, state, meterCode, actualValue,
                previousValue, amountOfConsumeIncluded,
                amountOfConsumed, amountOfLocalMinutesIncluded, amountOfLocalMinutesConsumed,
                amountOfLargeDistanceMinutesIncluded, amountOfLargeDistanceMinutesConsumed,
                planType)) {

            serviceIdAccum += (getPlan(whichPlan).getServices().size()-1);
            return true;
        } else {
            serviceIdAccum--;
            return false;
        }
    }

    /**
     *
     */
    public String doFacturation(String whichConsult) {
        if (whichConsult.equalsIgnoreCase("CLIENTS TO FACTURE")) {
            return facturation.clientsToFacture();
        } else if (whichConsult.equalsIgnoreCase("CLIENTS AND THEIR ACTIVE PLANS")) {
            return facturation.clientsAndActivePlans();
        } else if (whichConsult.equalsIgnoreCase("ACTIVE PLANS")) {
            return facturation.activePlans();
        } else {
            return "Sorry, your consult couldn't be loaded. Soon it will probably be available.";
        }
    }
}