package modelo;

import java.io.Serializable;
import java.util.Objects;

//Clase artículo con las variables que vamos a necesitar
//Implementamos la interfaz Serializable para poder trabajar con Objetos en el fichero
public class Articulo implements Serializable {
	private static final long serialVersionUID = -168452911667867445L;
	private int id;
	private String nombre;
	private String descripcion;
	private int cantidad;
	private double precio;
	
	public Articulo() {
		super();
	}

	public Articulo(int id, String nombre, String descripcion, int cantidad, double precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Articulo [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", cantidad=" + cantidad
				+ ", precio=" + precio + "]";
	}	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Articulo other = (Articulo) obj;
		return id == other.id;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
