package model;

public abstract class Service {

	private Contract contract;
	private String id;
	private String addressInstallation;
	private String dateInstallation;
	private String dateFacturation;
	private boolean state;
	private String meterCode;
	private double actualValue;
	private double previousValue;

	public Service(String id, String addressInstallation, String dateInstallation,
				   String dateFacturation, boolean state, String meterCode, double actualValue,
				   double previousValue){
		this.id = id;
		this.addressInstallation = addressInstallation;
		this.dateInstallation = dateInstallation;
		this.dateFacturation = dateFacturation;
		this.state = state;
		this.meterCode = meterCode;
		this.actualValue = actualValue;
		this.previousValue = previousValue;
	}

	/**
	 * 
	 *
	 */
	public boolean inactivateService(){
		setState(false);
		return true;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddressInstallation() {
		return addressInstallation;
	}

	public void setAddressInstallation(String addressInstallation) {
		this.addressInstallation = addressInstallation;
	}

	public String getDateInstallation() {
		return dateInstallation;
	}

	public void setDateInstallation(String dateInstallation) {
		this.dateInstallation = dateInstallation;
	}

	public String getDateFacturation() {
		return dateFacturation;
	}

	public void setDateFacturation(String dateFacturation) {
		this.dateFacturation = dateFacturation;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public String getMeterCode() {
		return meterCode;
	}

	public void setMeterCode(String meterCode) {
		this.meterCode = meterCode;
	}

	public double getActualValue() {
		return actualValue;
	}

	public void setActualValue(double actualValue) {
		this.actualValue = actualValue;
	}

	public double getPreviousValue() {
		return previousValue;
	}

	public void setPreviousValue(double previousValue) {
		this.previousValue = previousValue;
	}

	public String toString(){
		return "ID: "+this.id+" - CLASS: "+this.getClass()+"- STATE: "+this.state+ " - ACTUAL VALUE: "+this.actualValue;
	}
}