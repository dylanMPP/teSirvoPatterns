package model;

import java.util.*;

public class Contract {

	private ArrayList<Service> services;
	private Plan plan;
	private String id;

	/**
	 * 
	 *
	 */
	public Contract(String id, Plan plan) {
		this.id = id;
		this.plan = plan;
		this.services = new ArrayList<>();
	}

	public boolean addService(Service service){
		services.add(service);
		return true;
	}

	public boolean updateService(String whichService, Service updatedService) {
		for (int i = 0; i < services.size(); i++) {
			if(services.get(i).getId().equalsIgnoreCase(whichService)){
				services.set(i, updatedService);
				return true;
			}
		}
		return false;
	}

	/**
	 *
	 *
	 */
	public Service consultService(String whichService) {
		for (int i = 0; i < services.size(); i++) {
			if(services.get(i).getId().equalsIgnoreCase(whichService)){
				return services.get(i);
			}
		}
		return null;
	}

	/**
	 *
	 *
	 */
	public boolean inactivateService(String whichService) {
		for (int i = 0; i < services.size(); i++) {
			if(services.get(i).getId().equalsIgnoreCase(whichService)){
				return services.get(i).inactivateService();
			}
		}
		return false;
	}

	public ArrayList<Service> getServices() {
		return services;
	}

	public void setServices(ArrayList<Service> services) {
		this.services = services;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}