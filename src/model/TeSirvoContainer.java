package model;

import java.util.*;

public class TeSirvoContainer {

	private ArrayList<Client> clients;
	private ConcreteBuilder concreteBuilder;

	public TeSirvoContainer(){
		clients = new ArrayList<>();
		concreteBuilder = new ConcreteBuilder();
	}

	public boolean createContract(String whichClient, String id, Plan plan){
		Contract contract = Singleton.teSirvoContainer.getConcreteBuilder().buildContract(id, plan);

		for (int i = 0; i < Singleton.teSirvoContainer.getClients().size(); i++) {
			if(Singleton.teSirvoContainer.getClients().get(i).getId().equalsIgnoreCase(whichClient)){
				return Singleton.teSirvoContainer.getClients().get(i).addContract(contract);
			}
		}
		return false;
	}

	/**
	 * 
	 *
	 */
	public boolean createService(String whichClient, String whichContract, String whichService,
								 String id, String addressInstallation, String dateInstallation,
								 String dateFacturation, boolean state, String meterCode, double actualValue,
								 double previousValue, double amountOfConsumeIncluded,
								 double amountOfConsumed, double amountOfLocalMinutesIncluded, double amountOfLocalMinutesConsumed,
								 double amountOfLargeDistanceMinutesIncluded, double amountOfLargeDistanceMinutesConsumed,
								 String planType) {
		Service service = Singleton.teSirvoContainer.getConcreteBuilder().buildService(whichService,
				id, addressInstallation, dateInstallation,
				dateFacturation, state, meterCode, actualValue,
				previousValue, amountOfConsumeIncluded,
				amountOfConsumed, amountOfLocalMinutesIncluded, amountOfLocalMinutesConsumed,
				amountOfLargeDistanceMinutesIncluded, amountOfLargeDistanceMinutesConsumed,
				planType);

		for (int i = 0; i < Singleton.teSirvoContainer.getClients().size(); i++) {
			if(Singleton.teSirvoContainer.getClients().get(i).getId().equalsIgnoreCase(whichClient)){
				Singleton.teSirvoContainer.getClients().get(i).addService(whichContract, service);
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 *
	 */
	public boolean updateService(String whichClient, String whichContract, String whichServiceToChange, String whichService,
								 String id, String addressInstallation, String dateInstallation,
								 String dateFacturation, boolean state, String meterCode, double actualValue,
								 double previousValue, double amountOfConsumeIncluded,
								 double amountOfConsumed, double amountOfLocalMinutesIncluded, double amountOfLocalMinutesConsumed,
								 double amountOfLargeDistanceMinutesIncluded, double amountOfLargeDistanceMinutesConsumed,
								 String planType) {
		Service service = Singleton.teSirvoContainer.getConcreteBuilder().buildService(whichService,
				id, addressInstallation, dateInstallation,
				dateFacturation, state, meterCode, actualValue,
				previousValue, amountOfConsumeIncluded,
				amountOfConsumed, amountOfLocalMinutesIncluded, amountOfLocalMinutesConsumed,
				amountOfLargeDistanceMinutesIncluded, amountOfLargeDistanceMinutesConsumed,
				planType);

		for (int i = 0; i < Singleton.teSirvoContainer.getClients().size(); i++) {
			if(Singleton.teSirvoContainer.getClients().get(i).getId().equalsIgnoreCase(whichClient)){
				return Singleton.teSirvoContainer.getClients().get(i).updateService(whichServiceToChange, whichContract, service);
			}
		}
		return false;
	}

	/**
	 * 
	 *
	 */
	public Service consultService(String whichClient, String whichContract, String whichService) {
		for (int i = 0; i < Singleton.teSirvoContainer.getClients().size(); i++) {
			if(Singleton.teSirvoContainer.getClients().get(i).getId().equalsIgnoreCase(whichClient)){
				return Singleton.teSirvoContainer.getClients().get(i).consultService(whichService, whichContract);
			}
		}
		return null;
	}

	/**
	 * 
	 *
	 */
	public boolean inactivateService(String whichClient, String whichContract, String whichService) {
		for (int i = 0; i < Singleton.teSirvoContainer.getClients().size(); i++) {
			if(Singleton.teSirvoContainer.getClients().get(i).getId().equalsIgnoreCase(whichClient)){
				return Singleton.teSirvoContainer.getClients().get(i).inactivateService(whichService, whichContract);
			}
		}
		return false;
	}

	/**
	 * 
	 *
	 */
	public boolean createClient(String state, String name, String id, String date, String addressFacturation, String phoneNumber,
								String email) {
		Singleton.teSirvoContainer.getClients().add(new Client(state, name, id, date, addressFacturation, phoneNumber, email));
		return true;
	}

	/**
	 * 
	 *
	 */
	public boolean buyPlan(Plan plan, String whichContract, String whichClient,
						   String id, String addressInstallation, String dateInstallation,
						   String dateFacturation, boolean state, String meterCode, double actualValue,
						   double previousValue, double amountOfConsumeIncluded,
						   double amountOfConsumed, double amountOfLocalMinutesIncluded, double amountOfLocalMinutesConsumed,
						   double amountOfLargeDistanceMinutesIncluded, double amountOfLargeDistanceMinutesConsumed,
						   String planType) {
		int cont = 0;

		for (int i = 0; i < Singleton.teSirvoContainer.getClients().size(); i++) {
				if(Singleton.teSirvoContainer.getClients().get(i).getId().equalsIgnoreCase(whichClient)){
					if(Singleton.teSirvoContainer.getClients().get(i).buyPlan(plan, whichContract)){
						cont++; // add plan to the contract
					}
				}
		}

		// busco el plan para mirar todos los servicios que ofrece y así ir creando uno a uno para luego añadirselos al
		// cliente en el contrato especificado
		ArrayList<String> services = new ArrayList<>();

		if(cont==1){
			for (int i = 0; i < Singleton.planContainer.getPlans().size(); i++) {
				if(Singleton.planContainer.getPlans().get(i).equals(plan)){
					services = Singleton.planContainer.getPlans().get(i).getServices();
					cont++;
				}
			}
		} else {
			return false;
		}

		int amountOfTrueCreated = 0;
		// pasamos el amount de incluido como 0, pues el plan ya nos dice la capacidad y lo que viene incluido
		// creo y añado el servicio al cliente con el método createService() que usa builder
		if(cont==2){
			for (int i = 0; i < services.size(); i++) {
				if(createService(whichClient, whichContract, services.get(i), id, addressInstallation, dateInstallation,
						dateFacturation, state, meterCode, plan.getValueToPay(),
						previousValue, 0,
						amountOfConsumed, 0, amountOfLocalMinutesConsumed,
						0, amountOfLargeDistanceMinutesConsumed,
						planType)){
					amountOfTrueCreated++;
				}
			}
		} else {
			return false;
		}

		return amountOfTrueCreated == services.size();
	}

	public ArrayList<Client> getClients() {
		return clients;
	}

	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}

	public ConcreteBuilder getConcreteBuilder() {
		return concreteBuilder;
	}

	public void setConcreteBuilder(ConcreteBuilder concreteBuilder) {
		this.concreteBuilder = concreteBuilder;
	}
}