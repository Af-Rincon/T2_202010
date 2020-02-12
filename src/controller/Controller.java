package controller;

import java.util.Scanner;

import model.data_structures.Cola;
import model.logic.Comparendo;
import model.logic.Modelo;
import view.View;

public class Controller {

	/* Instancia del Modelo*/
	private Modelo modelo;
	
	/* Instancia de la Vista*/
	private View view;
	
	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
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

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
				case 1:
				    modelo = new Modelo(); 
				    Cola<Comparendo> cola = modelo.cargar();
				    view.printMessage("Datos cargados: "+cola.darTamano());
				    view.printMessage("El primer dato es: "+cola.darPrimerElemento());						
					break;
					
				case 2:
					Cola<Comparendo> rep =  modelo.repetidos();
					for(Comparendo c : rep)
					{
						Comparendo actual = rep.dequeue(c);
						view.printMessage(actual.datosCluster());
					}
					view.printMessage("Cantidad: "+rep.darTamano());
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
