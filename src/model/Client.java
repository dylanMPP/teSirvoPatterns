package model;

import java.util.*;

public class Client {

	private State state;
	private ArrayList<Contract> contracts;
	private String name;
	private String id;
	private String date;
	private String addressFacturation;
	private String phoneNumber;
	private String email;

	/**
	 * 
	 *
	 */
	public Client(String state, String name, String id, String date, String addressFacturation, String phoneNumber,
				  String email) {
		this.name = name;
		this.id = id;
		this.date = date;
		this.addressFacturation = addressFacturation;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.contracts = new ArrayList<>();

		if(state.equalsIgnoreCase("POTENCIAL")){
			this.state = State.Potencial;
		} else if(state.equalsIgnoreCase("PAZ Y SALVO")){
			this.state = State.Paz_y_Salvo;
		} else if(state.equalsIgnoreCase("CON DEUDA")){
			this.state = State.Con_Deuda;
		} else if(state.equalsIgnoreCase("MOROSO")){
			this.state = State.Moroso;
		} else if(state.equalsIgnoreCase("RETIRADO")){
			this.state = State.Retirado;
		} else {
			this.state = State.Cartera_Castigada;
		}
	}

	public String toStringContracts(){
		String msg = "";

		for (int i = 0; i < contracts.size(); i++) {
			if(contracts.get(i).getPlan()!=null){
				msg += "- CONTRACT ID: "+contracts.get(i).getId()+"\n"+"- PLAN: "+contracts.get(i).getPlan().getName()+
						"\n"+"- SERVICES: "+toStringServices(contracts.get(i).getServices())+"\n\n";
			} else {
				msg += "- CONTRACT ID: "+contracts.get(i).getId()+"\n"+"- PLAN: No plan associated"+
						"\n"+"- SERVICES: "+toStringServices(contracts.get(i).getServices())+"\n\n";
			}
		}

		return msg;
	}


	public String toStringPlans(){
		String msg = "";

		for (int i = 0; i < contracts.size(); i++) {
			if(contracts.get(i).getPlan()!=null){
				msg += "- CONTRACT ID: "+contracts.get(i).getId()+"\n"+"- PLAN: "+contracts.get(i).getPlan().getName()+
						"\n"+"- SERVICES ASSOCIATED TO PLAN: "+toStringServicesOfPlan(contracts.get(i).getPlan().getServices())+"\n\n";
			} else {
				msg += "- CONTRACT ID: "+contracts.get(i).getId()+"\n"+"- PLAN: No plan associated";
			}
		}

		return msg;
	}

	public String toStringServices(ArrayList<Service> services){
		String msg = "";

		for (int i = 0; i < services.size(); i++) {
			msg += ""+services.get(i).toString()+"\n";
		}

		return msg;
	}

	public String toStringServicesOfPlan(ArrayList<String> services){
		String msg = "";

		for (int i = 0; i < services.size(); i++) {

			if(i != services.size()-1){
				msg += services.get(i)+" - ";
			} else {
				msg += services.get(i)+"";
			}
		}
		return msg;
	}

	/**
	 *
	 *
	 */
	public boolean addService(String whichContract, Service service){
		for (int i = 0; i < contracts.size(); i++) {
			if(contracts.get(i).getId().equalsIgnoreCase(whichContract)){
				return contracts.get(i).addService(service);
			}
		}
		return false;
	}

	/**
	 * 
	 *
	 */
	public boolean updateService(String whichService, String whichContract, Service updatedService) {
		for (int i = 0; i < contracts.size(); i++) {
			if(contracts.get(i).getId().equalsIgnoreCase(whichContract)){
				return contracts.get(i).updateService(whichService, updatedService);
			}
		}
		return false;
	}

	/**
	 * 
	 *
	 */
	public Service consultService(String whichService, String whichContract) {
		for (int i = 0; i < contracts.size(); i++) {
			if(contracts.get(i).getId().equalsIgnoreCase(whichContract)){
				return contracts.get(i).consultService(whichService);
			}
		}
		return null;
	}

	/**
	 * 
	 *
	 */
	public boolean inactivateService(String whichService, String whichContract) {
		for (int i = 0; i < contracts.size(); i++) {
			if(contracts.get(i).getId().equalsIgnoreCase(whichContract)){
				return contracts.get(i).inactivateService(whichService);
			}
		}
		return false;
	}

	public boolean addContract(Contract contract){
		contracts.add(contract);
		return true;
	}

	public boolean buyPlan(Plan plan, String whichContract){
		for (int i = 0; i < contracts.size(); i++) {
			if(contracts.get(i).getId().equalsIgnoreCase(whichContract)){
				if(contracts.get(i).getPlan()==null){
					contracts.get(i).setPlan(plan);
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public ArrayList<Contract> getContracts() {
		return contracts;
	}

	public void setContracts(ArrayList<Contract> contracts) {
		this.contracts = contracts;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAddressFacturation() {
		return addressFacturation;
	}

	public void setAddressFacturation(String addressFacturation) {
		this.addressFacturation = addressFacturation;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}