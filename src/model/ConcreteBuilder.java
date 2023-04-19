package model;

public class ConcreteBuilder implements Builder {

	public ConcreteBuilder() {
	}

	/**
	 * 
	 *
	 */
	public Contract buildContract(String id, Plan plan) {
		return new Contract(id, plan);
	}

	/**
	 * 
	 *
	 */
	public Service buildService(String whichService,
								String id, String addressInstallation, String dateInstallation,
								String dateFacturation, boolean state, String meterCode, double actualValue,
								double previousValue, double amountOfConsumeIncluded,
								double amountOfConsumed, double amountOfLocalMinutesIncluded, double amountOfLocalMinutesConsumed,
								double amountOfLargeDistanceMinutesIncluded, double amountOfLargeDistanceMinutesConsumed,
								String planType) {
		return new ServiceFactory().createService(whichService,
				id, addressInstallation, dateInstallation,
				dateFacturation, state, meterCode, actualValue,
				previousValue, amountOfConsumeIncluded,
				amountOfConsumed, amountOfLocalMinutesIncluded, amountOfLocalMinutesConsumed,
				amountOfLargeDistanceMinutesIncluded, amountOfLargeDistanceMinutesConsumed,
				planType);
	}

}