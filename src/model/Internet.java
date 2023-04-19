package model;

public class Internet extends Service {

	public Internet(String id, String addressInstallation, String dateInstallation,
					String dateFacturation, double actualValue, double previousValue,boolean state) {
		super(id, addressInstallation, dateInstallation, dateFacturation,
				state, actualValue, previousValue);
	}

}