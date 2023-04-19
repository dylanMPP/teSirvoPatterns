package model;

public class Water extends Service {

	public Water(String id, String addressInstallation, String dateInstallation,
				 String dateFacturation, boolean state, String meterCode, double actualValue,
				 double previousValue) {
		super(id, addressInstallation, dateInstallation, dateFacturation,
				state, meterCode, actualValue, previousValue);
	}
}