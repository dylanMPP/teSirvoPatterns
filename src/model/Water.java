package model;

public class Water extends Service {

	private String meterCode;

	public Water(String id, String addressInstallation, String dateInstallation,
				 String dateFacturation, boolean state, String meterCode, double actualValue,
				 double previousValue) {
		super(id, addressInstallation, dateInstallation, dateFacturation,
				state, actualValue, previousValue);
		this.meterCode = meterCode;
	}

	public String getMeterCode() {
		return meterCode;
	}

	public void setMeterCode(String meterCode) {
		this.meterCode = meterCode;
	}
}