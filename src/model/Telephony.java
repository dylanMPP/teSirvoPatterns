package model;

public class Telephony extends Service {

	private PlanType planType;

	public Telephony(String id, String addressInstallation, String dateInstallation,
					 String dateFacturation, boolean state, double actualValue, double previousValue, String planType) {
		super(id, addressInstallation, dateInstallation, dateFacturation,
				state, null, actualValue, previousValue);
 		
		if(planType.equalsIgnoreCase("LIMITED")){
			this.planType = PlanType.Limitado;
		} else if(planType.equalsIgnoreCase("UNLIMITED")){
			this.planType = PlanType.Ilimitado;
		} else {
			this.planType = PlanType.Prepago;
		}
	}

	public PlanType getPlanType() {
		return planType;
	}

	public void setPlanType(PlanType planType) {
		this.planType = planType;
	}
}