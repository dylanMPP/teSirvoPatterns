package model;

public class Facturation implements IConsult {

	public Facturation() {
	}

	@Override
	public String clientsToFacture() {
		String msg = "";

		for (int i = 0; i < Singleton.teSirvoContainer.getClients().size(); i++) {
			msg += (i+1)+") CLIENT ID: "+Singleton.teSirvoContainer.getClients().get(i).getId()
					+"\n"+Singleton.teSirvoContainer.getClients().get(i).toStringContracts()+"\n";
		}

		return msg;
	}

	@Override
	public String clientsAndActivePlans() {
		String msg = "";

		for (int i = 0; i < Singleton.teSirvoContainer.getClients().size(); i++) {
			msg += (i+1)+") CLIENT ID: "+Singleton.teSirvoContainer.getClients().get(i).getId()+"\n"
					+Singleton.teSirvoContainer.getClients().get(i).toStringPlans()+"\n";
		}

		return msg;
	}

	@Override
	public String activePlans() {
		return Singleton.planContainer.toStringPlans();
	}
}