package model;

public class Energy extends Service {

	public Energy(String id, String addressInstallation, String dateInstallation,
				  String dateFacturation, boolean state, String meterCode, double actualValue,
				  double previousValue) {
		// TODO - implement Energy.Energy
		super(id, addressInstallation, dateInstallation, dateFacturation,
				state, meterCode, actualValue, previousValue);
	}
}