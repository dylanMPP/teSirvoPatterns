package model;

import java.util.ArrayList;

public class PlanSpecialized {

	public PlanSpecialized() {
	}

	/**
	 *
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
		for (int i = 0; i < Singleton.planContainer.getPlans().size(); i++) {
			if(Singleton.planContainer.getPlans().get(i).getPlanId().equalsIgnoreCase(whichPlan)){
				return Singleton.teSirvoContainer.buyPlan(Singleton.planContainer.getPlans().get(i), whichContract, whichClient,
						id, addressInstallation, dateInstallation,
						dateFacturation, state, meterCode, actualValue,
						previousValue, amountOfConsumeIncluded,
						amountOfConsumed, amountOfLocalMinutesIncluded, amountOfLocalMinutesConsumed,
						amountOfLargeDistanceMinutesIncluded, amountOfLargeDistanceMinutesConsumed,
						planType);
			}
		}
		return false;
	}

	/**
	 * 
	 *
	 */
	public Plan getPlan(String whichPlan) {
		for (int i = 0; i < Singleton.planContainer.getPlans().size(); i++) {
			if(Singleton.planContainer.getPlans().get(i).getPlanId().equalsIgnoreCase(whichPlan)){
				return Singleton.planContainer.getPlans().get(i);
			}
		}
		return null;
	}

	/**
	 * 
	 *
	 */
	public boolean createPlan(String planId, String name, double valueToPay, double valueForAdditionalConsume, String dateRange,
							  ArrayList<String> services,
							  double capacityInternetValue, double capacityTelephonyValue,  double capacityWaterValue, double capacityEnergyValue,
							  double capacityGasValue) {
		return Singleton.planContainer.createPlan(planId, name, valueToPay, valueForAdditionalConsume, dateRange,
				services, capacityInternetValue, capacityTelephonyValue, capacityWaterValue, capacityEnergyValue, capacityGasValue);
	}

}