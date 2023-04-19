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
		createClient2();

		createContract();
		createContract2();

		createService();
		createService2();

		consultService();
		consultService2();

		updateService();

		consultService();
		consultService2();

		inactivateService();

		createPlan();
		createPlan2();

		consultPlan();
		consultPlan2();

		buyPlan();
		buyPlan2();

		doFacturation();
		doFacturation2();
		doFacturation3();
	}

	public static void createService(){
		String serviceId = controller.createService("1", "1", "WATER",
				"Carrera 19 bis #6 bis sur 40", "20/04/2023", "20/03/2023", true,
				"100", 72000, 0,  100, 63, 0,
				0, 0, 0, "");

		if(serviceId.equalsIgnoreCase("0")){
			System.out.println("\nSERVICIO NO AGREGADO");
		} else {
			System.out.println("\nSERVICIO AGREGADO. ID = "+serviceId);
		}
	}

	public static void createService2(){
		String serviceId = controller.createService("2", "2", "INTERNET UNLIMITED",
				"Carrera 19 bis #6 bis sur 40", "20/04/2023", "20/03/2023", true,
				"100", 72000, 0,  0, 0, 0,
				0, 0, 0, "");

		if(serviceId.equalsIgnoreCase("0")){
			System.out.println("\nSERVICIO NO AGREGADO");
		} else {
			System.out.println("\nSERVICIO AGREGADO. ID = "+serviceId);
		}
	}

	public static void updateService() {
		if(controller.updateService("1", "1", "1", "WATER", "1",
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

	public static void consultService2() {
		Service serviceFound = controller.consultService("2", "2", "2");

		if(serviceFound==null){
			System.out.println("\nEl cliente no tiene ese servicio :/");
		} else {
			System.out.println("\nEl cliente tiene el servicio: \nID CONTRACT = 2"
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

	public static void createClient2() {
		if(controller.createClient("PAZ Y SALVO","Diego", "10/07/2004", "Carrera 80 40", "3173503132",
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

	public static void createContract2() {
		if(controller.createContract("2", "")){
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

	public static void createPlan2() {
		ArrayList<String> services = new ArrayList<>();
		services.add("WATER");
		services.add("ENERGY");
		services.add("GAS");

		if(controller.createPlan("HomeService", 200000, 100000, "18/04/2023 - 18/05/2023",
				services, 0, 0, 100, 300, 1000)){
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

	public static void consultPlan2() {
		Plan plan = controller.getPlan("2");

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

	public static void buyPlan2() {
		if(controller.buyPlan("2", "2", "2", "Carrera 80 40", "20/04/2023", "20/03/2023", true,
				"100", 72000, 0,  0, 0, 0,
				0, 0, 0, "")){
			System.out.println("\nPLAN CONTRATADO");
		} else {
			System.out.println("\nPLAN NO CONTRATADO");
		}
	}

	public static void doFacturation() {
		System.out.println("\nConsulta de 'Clients To Facture': \n"+controller.doFacturation("CLIENTS TO FACTURE"));
	}

	public static void doFacturation2(){
		System.out.println("\nConsulta de 'Clients & Plans': \n"+controller.doFacturation("CLIENTS AND THEIR ACTIVE PLANS"));
	}

	public static void doFacturation3(){
		System.out.println("\nConsulta de 'Active Plans': \n"+controller.doFacturation("ACTIVE PLANS"));
	}
}