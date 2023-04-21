package model;

import java.util.ArrayList;

public class PlanSpecialized {
    public PlanSpecialized() {
    }

    /**
     *
     */
    // Todos los atributos en común de los servicios van a tener el mismo valor (que estén
    // en el mismo plan)
    public boolean buyPlan(String whichPlan, String whichContract, String whichClient,
                           String id, String addressInstallation, String dateInstallation,
                           String dateFacturation, boolean state, String meterCode, double actualValue,
                           double previousValue, double amountOfConsumeIncluded,
                           double amountOfConsumed, double amountOfLocalMinutesIncluded, double amountOfLocalMinutesConsumed,
                           double amountOfLargeDistanceMinutesIncluded, double amountOfLargeDistanceMinutesConsumed,
                           String planType) {
        ArrayList<String> services = new ArrayList<>();
        ArrayList<Service> createdServices = new ArrayList<>();
        Plan plan = null;
        // busco el plan para mirar todos los servicios que ofrece y así ir creando uno a uno para luego añadirselos al
        // cliente en el contrato especificado
        int cont = 0;

        for (int i = 0; i < Singleton.planContainer.getPlans().size(); i++) {
            if(Singleton.planContainer.getPlans().get(i).getPlanId().equalsIgnoreCase(whichPlan)){
                plan = Singleton.planContainer.getPlans().get(i);
                cont++;
            }
        }

        if(cont==1){
            for (int i = 0; i < Singleton.planContainer.getPlans().size(); i++) {
                if(Singleton.planContainer.getPlans().get(i).equals(plan)){
                    services = Singleton.planContainer.getPlans().get(i).getServices();
                    cont++;
                }
            }
        } else {
            return false;
        }

        int amountOfTrueCreated = 0;
        // pasamos el amount de incluido como 0, pues el plan ya nos dice la capacidad y lo que viene incluido
        // creo y añado el servicio al cliente con el método createService() que usa builder
        int idToSum = Integer.parseInt(id);
        ConcreteBuilder concreteBuilder = new ConcreteBuilder();

        if(cont==2){
            for (int i = 0; i < services.size(); i++) {
                Service service = concreteBuilder.buildService(services.get(i), idToSum+"", addressInstallation, dateInstallation,
                        dateFacturation, state, meterCode, plan.getValueToPay(),
                        previousValue, 0,
                        amountOfConsumed, 0, amountOfLocalMinutesConsumed,
                        0, amountOfLargeDistanceMinutesConsumed,
                        planType);
                if(service!=null){
                    idToSum++;
                    amountOfTrueCreated++;
                    createdServices.add(service);
                }
            }
        } else {
            return false;
        }

        if(amountOfTrueCreated == services.size()){
            return Singleton.teSirvoContainer.buyPlan(plan, whichContract, whichClient, createdServices);
        } else {
            return false;
        }
    }

    /**
     *
     */
    public Plan getPlan(String whichPlan) {
        for (int i = 0; i < Singleton.planContainer.getPlans().size(); i++) {
            if (Singleton.planContainer.getPlans().get(i).getPlanId().equalsIgnoreCase(whichPlan)) {
                return Singleton.planContainer.getPlans().get(i);
            }
        }
        return null;
    }

    /**
     *
     */
    public boolean createPlan(String planId, String name, double valueToPay, double valueForAdditionalConsume, String dateRange,
                              ArrayList<String> services,
                              double capacityInternetValue, double capacityTelephonyValue, double capacityWaterValue, double capacityEnergyValue,
                              double capacityGasValue) {
        return Singleton.planContainer.createPlan(planId, name, valueToPay, valueForAdditionalConsume, dateRange,
                services, capacityInternetValue, capacityTelephonyValue, capacityWaterValue, capacityEnergyValue, capacityGasValue);
    }

}