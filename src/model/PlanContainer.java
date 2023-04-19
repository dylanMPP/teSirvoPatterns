package model;

import java.util.*;

public class PlanContainer {

	private ArrayList<Plan> plans;

	public PlanContainer() {
		this.plans = new ArrayList<>();
	}

	/**
	 * 
	 *
	 */
	public boolean createPlan(String planId, String name, double valueToPay, double valueForAdditionalConsume, String dateRange,
							  ArrayList<String> services,
							  double capacityInternetValue, double capacityTelephonyValue,  double capacityWaterValue, double capacityEnergyValue,
							  double capacityGasValue) {
		if(name.equalsIgnoreCase("HOMESERVICE")){
			plans.add(new HomeService(planId, name, valueToPay, valueForAdditionalConsume, dateRange,
					services, capacityWaterValue, capacityEnergyValue, capacityGasValue));
			return true;
		} else if(name.equalsIgnoreCase("HOMECONNECT")){
			plans.add(new HomeConnect(planId, name, valueToPay, valueForAdditionalConsume, dateRange,
					services, capacityInternetValue, capacityTelephonyValue));
			return true;
		}
		return false;
	}

	public ArrayList<Plan> getPlans() {
		return plans;
	}

	public void setPlans(ArrayList<Plan> plans) {
		this.plans = plans;
	}

	public String toStringPlans(){
		String msg = "";

		for (int i = 0; i < plans.size(); i++) {
			msg += plans.get(i).toString()+"\n";
		}

		return msg;
	}
}