package model;

public class Singleton {

	public static Singleton singleton;
	public static TeSirvoContainer teSirvoContainer;
	public static PlanContainer planContainer;

	public static Singleton getInstance(){
		if(singleton==null){
			singleton = new Singleton();
			teSirvoContainer = new TeSirvoContainer();
			planContainer = new PlanContainer();
			return singleton;
		} else {
			return singleton;
		}
	}
}