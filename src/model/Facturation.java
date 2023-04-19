package model;

public class Facturation implements IConsult {

	public Facturation() {
	}

	@Override
	public String clientsToFacture() {
		String msg = "";

		for (int i = 0; i < Singleton.teSirvoContainer.getClients().size(); i++) {
			msg += (i+1)+") CLIENT ID: "+Singleton.teSirvoContainer.getClients().get(i).getId()
					+"\n"+Singleton.teSirvoContainer.getClients().get(i).toStringContracts()+"\n\n";
		}

		return msg;
	}

	@Override
	public String clientsAndActivePlans() {
		String msg = "";

		for (int i = 0; i < Singleton.teSirvoContainer.getClients().size(); i++) {
			msg += (i+1)+") CLIENT ID: "+Singleton.teSirvoContainer.getClients().get(i).getId()+"\n"
					+Singleton.teSirvoContainer.getClients().get(i).toStringContracts()+"\n\n";
		}

		return msg;
	}

	@Override
	public String activePlans() {
		String msg = "";

		for (int i = 0; i < Singleton.planContainer.getPlans().size(); i++){
			msg += (i+1)+") "+Singleton.planContainer.toStringPlans();
		}

		return msg;
	}
}