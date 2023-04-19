package model;

public class TelLimitedOrPrepaid extends Telephony {

	private double amountOfLocalMinutesIncluded;
	private double amountOfLocalMinutesConsumed;
	private double amountOfLargeDistanceMinutesIncluded;
	private double amountOfLargeDistanceMinutesConsumed;

	public TelLimitedOrPrepaid(String id, String addressInstallation, String dateInstallation,
							   String dateFacturation, boolean state, double actualValue, double previousValue, String planType,
							   double amountOfLocalMinutesIncluded, double amountOfLocalMinutesConsumed,
							   double amountOfLargeDistanceMinutesIncluded, double amountOfLargeDistanceMinutesConsumed) {
		super(id, addressInstallation, dateInstallation, dateFacturation,
				state, actualValue, previousValue, planType);

		this.amountOfLocalMinutesIncluded = amountOfLocalMinutesIncluded;
		this.amountOfLocalMinutesConsumed = amountOfLocalMinutesConsumed;
		this.amountOfLargeDistanceMinutesIncluded = amountOfLargeDistanceMinutesIncluded;
		this.amountOfLargeDistanceMinutesConsumed = amountOfLargeDistanceMinutesConsumed;
	}

	public double getAmountOfLocalMinutesIncluded() {
		return amountOfLocalMinutesIncluded;
	}

	public void setAmountOfLocalMinutesIncluded(double amountOfLocalMinutesIncluded) {
		this.amountOfLocalMinutesIncluded = amountOfLocalMinutesIncluded;
	}

	public double getAmountOfLocalMinutesConsumed() {
		return amountOfLocalMinutesConsumed;
	}

	public void setAmountOfLocalMinutesConsumed(double amountOfLocalMinutesConsumed) {
		this.amountOfLocalMinutesConsumed = amountOfLocalMinutesConsumed;
	}

	public double getAmountOfLargeDistanceMinutesIncluded() {
		return amountOfLargeDistanceMinutesIncluded;
	}

	public void setAmountOfLargeDistanceMinutesIncluded(double amountOfLargeDistanceMinutesIncluded) {
		this.amountOfLargeDistanceMinutesIncluded = amountOfLargeDistanceMinutesIncluded;
	}

	public double getAmountOfLargeDistanceMinutesConsumed() {
		return amountOfLargeDistanceMinutesConsumed;
	}

	public void setAmountOfLargeDistanceMinutesConsumed(double amountOfLargeDistanceMinutesConsumed) {
		this.amountOfLargeDistanceMinutesConsumed = amountOfLargeDistanceMinutesConsumed;
	}

	@Override
	public String toString() {
		return super.toString()+" - AMOUNT OF LOCAL MIN CONSUMED: "+this.amountOfLocalMinutesConsumed+
				" - AMOUNT OF LARGE DIST MIN CONSUMED: "+this.amountOfLargeDistanceMinutesConsumed;
	}
}