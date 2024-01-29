package testing;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controlador.Controlador;
import controlador.ControladorCSV;
import modelo.Articulo;
//creamos las variables que vamos a necesitar
public class Main {
	public static String nombreFichero = "articulos.dat";
	private static File file = new File(nombreFichero);
	private static List<Articulo> articulos = new ArrayList<>();
	private static Scanner sc = new Scanner(System.in);
	static Controlador controlador = new Controlador();
	static ControladorCSV controladorCSV = new ControladorCSV();

	//Iniciamos el main comprobando si existe o no el fichero de datos
	public static void main(String[] args){
		if (!file.exists()) {
			System.out.println("Creando un nuevo fichero...");
			articulos = new ArrayList<Articulo>();
			menu();
		} else {
			System.out.println("Cargando el fichero anterior...");
			articulos = controlador.cargarLista();
			menu();
		}
	}	
	//Una vez hecha la comprobación de existencia del fichero le mostramos el menú al usuario
	public static void menu() {
		Scanner leer = new Scanner(System.in);
		int opcion;

		do {
			System.out.println("\n------- MENU -------");
			System.out.println("1- Añadir nuevo artículo");
			System.out.println("2- Borrar artículo por id");
			System.out.println("3- Consultar artículo por id");
			System.out.println("4- Listar todos los artículos");
			System.out.println("5- Exportar artículos a archivo CSV");
			System.out.println("6- Terminar el programa y crear el fichero");
			System.out.print("Seleccione una opción: ");

			opcion = leer.nextInt();
			leer.nextLine();
			//llamamos al metodo correspondiente según la opcion seleccionada por el usuario
			switch (opcion) {
			case 1:
				controlador.agregarArticulo(file);
				break;
			case 2:
				controlador.borrarArticuloPorId();
				break;
			case 3:
				controlador.consultarArticuloPorId();
				break;
			case 4:
				controlador.listarArticulos();
				break;
			case 5:
				controladorCSV.exportarCSV(articulos);
				break;
			case 6:
				controlador.guardarListaEnFichero();
				System.out.println("--- FIN ---");
				return;
			default:
				System.out.println("Opción no válida. Seleccione una de las opciones de la lista");
			}

		} while (opcion != 6);
		leer.close();
	}	
}