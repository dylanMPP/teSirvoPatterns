package model;

public class IntLimitedOrPrepaid extends Internet {

	private double amountOfConsumeIncluded;
	private double amountOfConsumed;

	public IntLimitedOrPrepaid(String id, String addressInstallation, String dateInstallation,
							   String dateFacturation, double actualValue, double previousValue, boolean state, double amountOfConsumeIncluded,
							   double amountOfConsumed) {
		super(id, addressInstallation, dateInstallation, dateFacturation,
				actualValue, previousValue, state);
		this.amountOfConsumed = amountOfConsumed;
		this.amountOfConsumeIncluded = amountOfConsumeIncluded;
	}


	public double getAmountOfConsumeIncluded() {
		return amountOfConsumeIncluded;
	}

	public void setAmountOfConsumeIncluded(double amountOfConsumeIncluded) {
		this.amountOfConsumeIncluded = amountOfConsumeIncluded;
	}

	public double getAmountOfConsumed() {
		return amountOfConsumed;
	}

	public void setAmountOfConsumed(double amountOfConsumed) {
		this.amountOfConsumed = amountOfConsumed;
	}

	@Override
	public String toString() {
		return super.toString()+" - AMOUNT OF INT CONSUMED: "+this.amountOfConsumed;
	}
}