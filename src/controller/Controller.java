package controller;

import java.util.Scanner;

import model.logic.Comparendo;
import model.logic.Modelo;
import view.View;

public class Controller {

	private Modelo modelo;
	private View view;
	public final static String RUTAGEOJASON = "./data/comparendos_dei_2018.geojson";
	public final static String JUEGUEMOS = "./data/comparendos_dei_2018_small.geojson";

	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}

	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		String dato = "";
		String respuesta = "";

		while( !fin )
		{
			view.printMenu();

			int option = lector.nextInt();
			switch(option)
			{
			case 1:
				modelo.leerGeoJson(RUTAGEOJASON);
				view.printMessage("Archivo GeoJSon Cargado");
				view.printMessage("Numero actual de comparendos " + modelo.darTamano() + "\n---------");						
				break;

			case 2:
				view.printMessage("--------- \nDar OBJECTID a buscar: ");
				dato = lector.next();

				int i = Integer.parseInt(dato);

				Comparendo x = modelo.buscar(i);

				view.printMessage("###___________________###");
				view.printMessage("Object id: " + x.darObjectid());
				view.printMessage("Fecha: " + x.darFecha_Hora());
				view.printMessage("Infraccion: " + x.darInfraccion());
				view.printMessage("Clase del Vehiculo: " + x.darClase_Vehi());
				view.printMessage("Tipo de servicio: " + x.darTipo_Servicio());
				view.printMessage("Localidad: " + x.darLocalidad());
				view.printMessage("###___________________###");

				break;

			case 3:
				view.printMessage("--------- \n Hasta pronto !! \n---------"); 
				lector.close();
				fin = true;
				break;	

			default: 
				view.printMessage("--------- \n Opcion Invalida !! \n---------");
				break;
			}
		}

	}	
}
