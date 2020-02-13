package controller;

import java.util.Scanner;



import model.data_structures.ListaEnlazadaQueue;
import model.data_structures.ListaEnlazadaStack;
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
				view.printMessage("Numero actual de comparendos " + modelo.darTamanoStack() + "\n---------");						
				break;

			case 2:
				
				ListaEnlazadaQueue <Comparendo> resultado=modelo.darMayorCluster();
				String mensaje ="La infracción más repetida fue: " + resultado.darPrimerElemento().darInfoDelComparendo().darInfraccion()+", con un total de: "+resultado.darTamanio()+".";
				System.out.println(mensaje);
				Comparendo a;
				
				while(resultado.darTamanio()>0)
				{
					a=resultado.dequeue();
					System.out.println(a.darInfraccion()+"\n"+a.darObjectid()+"\n"+a.darFecha_Hora()+"\n"+a.darClase_Vehi()+"\n"+a.darTipo_Servicio()+"\n"+a.darLocalidad());
					System.out.println("-----------------------------------------------------------------");
				}
				
				view.printMessage(mensaje);
				
				break;
				
			case 3:
				
				//TODO Bobby
				
				view.printMessage("--------- \nDar cantidad de infracciones a reportar: ");
				dato = lector.next();
				int N = Integer.parseInt(dato);
				
				view.printMessage("--------- \nDar la infracciones a reportar: ");
				dato = lector.next();
				
				ListaEnlazadaStack<Comparendo> infraReturn = modelo.ultimosNporInfraccion(N, dato);
				
				System.out.println(infraReturn.darTamaño());
				int cantidad = infraReturn.darTamaño();
				
				if(cantidad < N)
				{
					System.out.println("Los únicos datos encontrados fueron:");
					
					for (int i = 0; i < cantidad; i++)
					{
						Comparendo actual = infraReturn.pop();
						System.out.println("Los datos del comparendo son: " + "Object id: " + actual.darObjectid() + " Fecha: " + actual.darFecha_Hora() + " Infraccion: " + actual.darInfraccion() + " Clase del Vehiculo: " + actual.darClase_Vehi() + " Tipo de servicio: " + actual.darTipo_Servicio() + " Localidad: " + actual.darLocalidad());
					}
				}
				else
				{
					System.out.println("Los datos solicitados son:");
					
					for (int i = 0; i < cantidad; i++)
					{
						Comparendo actual = infraReturn.pop();
						System.out.println("Los datos del comparendo son: " + "Object id: " + actual.darObjectid() + " Fecha: " + actual.darFecha_Hora() + " Infraccion: " + actual.darInfraccion() + " Clase del Vehiculo: " + actual.darClase_Vehi() + " Tipo de servicio: " + actual.darTipo_Servicio() + " Localidad: " + actual.darLocalidad());
					}
				}

				break;

			case 4:
				view.printMessage("--------- \n Hasta pronto !! \n---------"); 
				lector.close();
				fin = true;
				break;	

			default: 
				view.printMessage("--------- \n Opción Invalida !! \n---------");
				break;
			}
		}

	}	
}
