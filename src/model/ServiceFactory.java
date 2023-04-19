package model;

public class ServiceFactory {

	public ServiceFactory() {
	}

	/**
	 * 
	 *
	 */
	public Service createService(String whichService,
								 String id, String addressInstallation, String dateInstallation,
								 String dateFacturation, boolean state, String meterCode, double actualValue,
								 double previousValue, double amountOfConsumeIncluded,
								 double amountOfConsumed, double amountOfLocalMinutesIncluded, double amountOfLocalMinutesConsumed,
								 double amountOfLargeDistanceMinutesIncluded, double amountOfLargeDistanceMinutesConsumed,
								 String planType) {
		if(whichService.equalsIgnoreCase("WATER")){
			return createWater(id, addressInstallation, dateInstallation, dateFacturation,
					state, meterCode, actualValue, previousValue);
		} else if(whichService.equalsIgnoreCase("GAS")){
			return createGas(id, addressInstallation, dateInstallation, dateFacturation,
					state, meterCode, actualValue, previousValue);
		} else if(whichService.equalsIgnoreCase("ENERGY")){
			return createEnergy(id, addressInstallation, dateInstallation, dateFacturation,
					state, meterCode, actualValue, previousValue);
		} else if(whichService.equalsIgnoreCase("INTERNET LIMITED/PREPAID") ||
				whichService.equalsIgnoreCase("INTERNET")){
			return createInternet(true, id, addressInstallation, dateInstallation, dateFacturation,
					actualValue, previousValue, state, amountOfConsumeIncluded, amountOfConsumed);
		} else if(whichService.equalsIgnoreCase("INTERNET UNLIMITED")){
			return createInternet(false, id, addressInstallation, dateInstallation, dateFacturation,
					actualValue, previousValue,state, 0.0, 0.0);
		} else if(whichService.equalsIgnoreCase("TELEPHONY LIMITED/PREPAID") ||
				whichService.equalsIgnoreCase("TELEPHONY")){
			return createTelephony(true, id, addressInstallation, dateInstallation, dateFacturation,
					state, actualValue, previousValue, planType, amountOfLocalMinutesIncluded, amountOfLocalMinutesConsumed,
					amountOfLargeDistanceMinutesIncluded, amountOfLargeDistanceMinutesConsumed);
		} else {
			return createTelephony(false, id, addressInstallation, dateInstallation, dateFacturation,
					state, actualValue, previousValue, planType, 0.0, 0.0, 0.0, 0.0);
		}
	}

	/**
	 * 
	 *
	 */
	public Service createWater(String id, String addressInstallation, String dateInstallation,
							   String dateFacturation, boolean state, String meterCode, double actualValue,
							   double previousValue) {
		return new Water(id, addressInstallation, dateInstallation, dateFacturation,
				state, meterCode, actualValue, previousValue);
	}

	/**
	 * 
	 *
	 */
	public Service createGas(String id, String addressInstallation, String dateInstallation,
							 String dateFacturation, boolean state, String meterCode, double actualValue,
							 double previousValue) {
		return new Gas(id, addressInstallation, dateInstallation, dateFacturation,
				state, meterCode, actualValue, previousValue);
	}

	/**
	 * 
	 *
	 */
	public Service createEnergy(String id, String addressInstallation, String dateInstallation,
								String dateFacturation, boolean state, String meterCode, double actualValue,
								double previousValue) {
		return new Energy(id, addressInstallation, dateInstallation, dateFacturation,
				state, meterCode, actualValue, previousValue);
	}

	/**
	 * 
	 *
	 */
	public Service createInternet(boolean isLimited, String id, String addressInstallation, String dateInstallation,
								  String dateFacturation, double actualValue, double previousValue, boolean state, double amountOfConsumeIncluded,
								  double amountOfConsumed) {
		if(isLimited){
			return new IntLimitedOrPrepaid(id, addressInstallation, dateInstallation, dateFacturation,
					actualValue,previousValue, state, amountOfConsumeIncluded, amountOfConsumed);
		} else {
			return new Internet(id, addressInstallation, dateInstallation, dateFacturation,
					actualValue, previousValue, state);
		}
	}

	/**
	 * 
	 *
	 */
	public Service createTelephony(boolean isLimited, String id, String addressInstallation, String dateInstallation,
								   String dateFacturation, boolean state, double actualValue, double previousValue, String planType, double amountOfLocalMinutesIncluded, double amountOfLocalMinutesConsumed,
								   double amountOfLargeDistanceMinutesIncluded, double amountOfLargeDistanceMinutesConsumed) {
		if(isLimited){
			return new TelLimitedOrPrepaid(id, addressInstallation, dateInstallation, dateFacturation,
					state, actualValue, previousValue, planType, amountOfLocalMinutesIncluded, amountOfLocalMinutesConsumed,
					amountOfLargeDistanceMinutesIncluded, amountOfLargeDistanceMinutesConsumed);
		} else {
			return new Telephony(id, addressInstallation, dateInstallation, dateFacturation,
					state, actualValue, previousValue, planType);
		}
	}
}