package controlador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.Articulo;

public class Controlador {
	
	
	private static Scanner sc = new Scanner(System.in);
	public static String nombreFichero = "articulos.dat";
	private static File file = new File(nombreFichero);
	private static List<Articulo> articulos = new ArrayList<>();
	
	
	
	//metodo que carga una lista desde el fichero
	public List<Articulo> cargarLista() {		
		articulos = new ArrayList<>();
		try (FileInputStream fis = new FileInputStream(file); 
				ObjectInputStream ois = new ObjectInputStream(fis)) {

			try {
				articulos = (List<Articulo>) ois.readObject();
				
				if(articulos.isEmpty()) {
					System.out.println("La lista está vacía");
				}

				for (Articulo a : articulos) {
					System.out.println(a);
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			System.out.println("No se ha podido abrir el fichero");
			System.out.println(e.getMessage());
		}
		return articulos;

	}

	//metodo que añade un articulo a la coleccion
	public void agregarArticulo(File file) {
		Scanner sc = new Scanner(System.in);

		System.out.println("A continuación introduzca los datos del nuevo artículo1");
		int id;
		do {
			System.out.print("ID: ");
			id = sc.nextInt();
			sc.nextLine();
			//Comprobamos que no exista un articulo con la misma ID
			if (existeArticuloConId(id)) {
				System.out.println("La ID introducida ya está en uso. Por favor introduzca otra ID");
			}
		} while (existeArticuloConId(id));

		System.out.println("Nombre:");
		String nombre = sc.nextLine();

		System.out.println("Descripcion:");
		String descripcion = sc.nextLine();

		System.out.println("Precio:");
		double precio = sc.nextDouble();

		System.out.println("Cantidad:");
		int cantidad = sc.nextInt();
		sc.nextLine();
		
		
		Articulo nuevoArticulo = new Articulo(id, nombre, descripcion, id, cantidad);
		articulos.add(nuevoArticulo);
		System.out.println("Articulo guardado");
	}
	//metodo que comprueba si una id ya forma parte de la lista
		public boolean existeArticuloConId(int id) {
			for (Articulo articulo : articulos) {
				if (articulo.getId() == id) {
					return true;
				}
			}
			return false;
		}
	//metodo que elimina un articula de la lista por id
	public void borrarArticuloPorId() {
		Scanner scanner = new Scanner(System.in);
		
		if(articulos.isEmpty()) {
			System.out.println("La lista está vacía");
			return;
		}

		System.out.print("Escriba el ID del artículo que desee borrar ");
		int borrarId = scanner.nextInt();
		scanner.nextLine();

		for (Articulo a : articulos) {

			if (a.getId() == borrarId) {
				System.out.println("Articulo borrado: " + a);
				articulos.remove(a);
				return;
			}

		}

	}	
	//metodo que busca un articulo por id
	public void consultarArticuloPorId() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Escriba el ID del articulo que desee consultar ");
		int idConsultar = scanner.nextInt();
		scanner.nextLine();

		for (Articulo articulo : articulos) {
			if (articulo.getId() == idConsultar) {
				System.out.println(articulo);
				return;
			}
		}

		System.out.println("La ID no corresponde a ningún artículo de la lista.");
	}
	//metodo que devuelve todos los articulos de la lista
	public void listarArticulos() {
		System.out.println("Listando los artículos...");
		if (!articulos.isEmpty()) {
			for (Articulo articulo : articulos) {
				System.out.println(articulo);
			}
		} else {
			System.out.println("La lista no contiene ningún artículo. " + articulos);
		}	
}
	
	//metodo que guarda la lista en un fichero
		public void guardarListaEnFichero() {
			try (FileOutputStream fos = new FileOutputStream(file); 
					ObjectOutputStream oos = new ObjectOutputStream(fos);) {
				oos.writeObject(articulos);
				System.out.println("Datos guardados correctamente.");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}