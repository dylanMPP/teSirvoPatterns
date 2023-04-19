package model;

import java.util.ArrayList;

public class HomeConnect extends Plan {

	private double capacityInternetValue;
	private double capacityTelephonyValue;

	public HomeConnect(String planId, String name, double valueToPay, double valueForAdditionalConsume, String dateRange,
					   ArrayList<String> services,
					   double capacityInternetValue, double capacityTelephonyValue){
		super(planId, name, valueToPay, valueForAdditionalConsume, dateRange, services);
		this.capacityInternetValue = capacityInternetValue;
		this.capacityTelephonyValue = capacityTelephonyValue;
	}

	public double getCapacityInternetValue() {
		return capacityInternetValue;
	}

	public void setCapacityInternetValue(double capacityInternetValue) {
		this.capacityInternetValue = capacityInternetValue;
	}

	public double getCapacityTelephonyValue() {
		return capacityTelephonyValue;
	}

	public void setCapacityTelephonyValue(double capacityTelephonyValue) {
		this.capacityTelephonyValue = capacityTelephonyValue;
	}

	@Override
	public String toString(){
		return super.toString()+" - CAP INTERNET VALUE: "+this.capacityInternetValue+" - CAP TEL VALUE: "+this.capacityTelephonyValue;
	}
}