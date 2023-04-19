package model;

public interface Builder {

	/**
	 * 
	 *
	 */
	public Contract buildContract(String id, Plan plan);

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
								String planType);

}