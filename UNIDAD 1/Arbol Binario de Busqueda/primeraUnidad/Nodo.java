
// Alumno: Reyes Barrera Bryan Gilberto
package primeraUnidad;
public class Nodo {
	
	Nodo hijoIzquierdo, hijoDerecho;
	String nombre;
	
    public Nodo (String nom) {
    	this.nombre=nom;
    	this.hijoDerecho=null;
    	this.hijoIzquierdo=null;
    }
    
    public Nodo AuxBuscar(String nombre) {
		Nodo n = null;
		if(nombre.equals( this.nombre )) return this;
		if(hijoIzquierdo != null) n = hijoIzquierdo.AuxBuscar(nombre);
		else if (hijoDerecho != null) n = hijoDerecho.AuxBuscar(nombre);
		if(n != null) return n;
		return null;
	}
    

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Nodo getHijoIzquierdo() {
		return hijoIzquierdo;
	}

	public void setHijoIzquierdo(Nodo hijoIzquierdo) {
		this.hijoIzquierdo = hijoIzquierdo;
	}

	public Nodo getHijoDerecho() {
		return hijoDerecho;
	}

	public void setHijoDerecho(Nodo hijoDerecho) {
		this.hijoDerecho = hijoDerecho;
	}
    
    public String toString() {
    	return nombre;
    }
}