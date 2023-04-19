package model;

import java.util.ArrayList;

public class HomeService extends Plan {

	private double capacityWaterValue;
	private double capacityEnergyValue;
	private double capacityGasValue;

	public HomeService(String planId, String name, double valueToPay, double valueForAdditionalConsume, String dateRange,
					   ArrayList<String> services,
					   double capacityWaterValue, double capacityEnergyValue, double capacityGasValue){
		super(planId, name, valueToPay, valueForAdditionalConsume, dateRange, services);
		this.capacityWaterValue = capacityWaterValue;
		this.capacityEnergyValue = capacityEnergyValue;
		this.capacityGasValue = capacityGasValue;
	}

	public double getCapacityWaterValue() {
		return capacityWaterValue;
	}

	public void setCapacityWaterValue(double capacityWaterValue) {
		this.capacityWaterValue = capacityWaterValue;
	}

	public double getCapacityEnergyValue() {
		return capacityEnergyValue;
	}

	public void setCapacityEnergyValue(double capacityEnergyValue) {
		this.capacityEnergyValue = capacityEnergyValue;
	}

	public double getCapacityGasValue() {
		return capacityGasValue;
	}

	public void setCapacityGasValue(double capacityGasValue) {
		this.capacityGasValue = capacityGasValue;
	}

	@Override
	public String toString(){
		return super.toString()+" - CAP WATER VALUE: "+this.capacityWaterValue+" - CAP ENERGY VALUE: "+this.capacityEnergyValue
				+" - CAP GAS VALUE: "+this.capacityGasValue;
	}
}