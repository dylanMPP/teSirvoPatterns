package model;

import java.util.ArrayList;

public abstract class Plan {

	private String planId;
	private String name;
	private double valueToPay;
	private double valueForAdditionalConsume;
	private String dateRange;
	private ArrayList<String> services;

	public Plan(String planId, String name, double valueToPay, double valueForAdditionalConsume, String dateRange,
				ArrayList<String> services){
		this.planId = planId;
		this.name = name;
		this.valueToPay = valueToPay;
		this.valueForAdditionalConsume = valueForAdditionalConsume;
		this.dateRange = dateRange;
		this.services = services;
	}

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getValueToPay() {
		return valueToPay;
	}

	public void setValueToPay(double valueToPay) {
		this.valueToPay = valueToPay;
	}

	public double getValueForAdditionalConsume() {
		return valueForAdditionalConsume;
	}

	public void setValueForAdditionalConsume(double valueForAdditionalConsume) {
		this.valueForAdditionalConsume = valueForAdditionalConsume;
	}

	public String getDateRange() {
		return dateRange;
	}

	public void setDateRange(String dateRange) {
		this.dateRange = dateRange;
	}

	public ArrayList<String> getServices() {
		return services;
	}

	public void setServices(ArrayList<String> services) {
		this.services = services;
	}

	public String toString(){
		return "PLAN ID: "+this.planId+" - NAME: "+this.name+" - VALUE TO PAY: "+this.valueToPay;
	}
}