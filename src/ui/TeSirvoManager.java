package ui;

import controller.*;
import model.Plan;
import model.Service;
import model.Singleton;

import java.util.ArrayList;

public class TeSirvoManager {

	private static TeSirvoController controller;

	public static void init() {
		controller = new TeSirvoController();
		Singleton.getInstance();
	}

	public static void main(String[] args){
		init();
		createClient();
		createContract();
		createService();
		consultService();
		updateService();
		consultService();
		inactivateService();
		createPlan();
		consultPlan();
		buyPlan();
		doFacturation();
	}

	public static void createService(){
		String serviceId = controller.createService("1", "1", "INTERNET UNLIMITED",
				"Carrera 19 bis #6 bis sur 40", "20/04/2023", "20/03/2023", true,
				"100", 72000, 0,  100, 63, 0,
				0, 0, 0, "");

		if(serviceId.equalsIgnoreCase("0")){
			System.out.println("\nSERVICIO NO AGREGADO");
		} else {
			System.out.println("\nSERVICIO AGREGADO. ID = "+serviceId);
		}
	}

	public static void updateService() {
		if(controller.updateService("1", "1", "1", "INTERNET UNLIMITED", "1",
				"direccion_cambiada", "20/04/2023", "20/03/2023", true,
				"", 72000, 0, 100, 63, 0,
				0, 0, 0, "")){
			System.out.println("\nSERVICIO DE CLIENTE ACTUALIZADO");
		} else {
			System.out.println("\nSERVICIO DE CLIENTE NO ACTUALIZADO");
		}
	}

	public static void consultService() {
		Service serviceFound = controller.consultService("1", "1", "1");

		if(serviceFound==null){
			System.out.println("\nEl cliente no tiene ese servicio :/");
		} else {
			System.out.println("\nEl cliente tiene el servicio: \nID CONTRACT = 1"
					+"\nCLASS = "+serviceFound.getClass()
					+"\nSTATE = "+serviceFound.isState()
					+"\nADDRESS INSTALLATION = "+serviceFound.getAddressInstallation());
		}
	}

	public static void inactivateService() {
		if(controller.inactivateService("1", "1", "1")){
			System.out.println("\nSERVICIO DESACTIVADO");
		} else {
			System.out.println("\nSERVICIO NO DESACTIVADO");
		}
	}

	public static void createClient() {
		if(controller.createClient("PAZ Y SALVO","Dylan", "01/05/2004", "Carrera 19 bis #6 bis sur 40", "3173503132",
				"dyez1110@gmail.com")){
			System.out.println("\nCLIENTE AGREGADO");
		} else {
			System.out.println("\nCLIENTE NO AGREGADO");
		}
	}

	public static void createContract() {
		if(controller.createContract("1", "")){
			System.out.println("\nCONTRATO AGREGADO");
		} else {
			System.out.println("\nCONTRATO NO AGREGADO");
		}
	}

	public static void createPlan() {
		ArrayList<String> services = new ArrayList<>();
		services.add("INTERNET");
		services.add("TELEPHONY");

		if(controller.createPlan("HomeConnect", 100000, 50000, "18/04/2023 - 18/05/2023",
				services, 100, 1000, 0, 0, 0)){
			System.out.println("\nPLAN CREADO");
		} else {
			System.out.println("\nPLAN NO CREADO");
		}
	}

	public static void consultPlan() {
		Plan plan = controller.getPlan("1");

		if(plan==null){
			System.out.println("\nNo existe plan con ese ID :/");
		} else {
			String services = "";

			for (int i = 0; i < plan.getServices().size(); i++) {
				if(i==plan.getServices().size()-1){
					services += plan.getServices().get(i);
				} else {
					services += plan.getServices().get(i)+" - ";
				}
			}

			System.out.println("\nEl plan: \nPLAN ID = "+plan.getPlanId()
					+"\nNAME = "+plan.getName()
					+"\nSERVICES = "+services);
		}
	}

	public static void buyPlan() {
		if(controller.buyPlan("1", "1", "1", "Carrera 19 bis #6 bis sur 40", "20/04/2023", "20/03/2023", true,
				"100", 72000, 0,  100, 63, 0,
				0, 0, 0, "")){
			System.out.println("\nPLAN CONTRATADO");
		} else {
			System.out.println("\nPLAN NO CONTRATADO");
		}
	}

	public static void doFacturation() {
		System.out.println("\nConsulta de 'Clients To Facture': \n"+controller.doFacturation("CLIENTS TO FACTURE"));
	}
}