
// Alumno: Reyes Barrera Bryan Gilberto
package primeraUnidad;
import javax.swing.JOptionPane;

public class ArbolBusqueda {

	public static void main(String[] args) {
		
		int opcion = 0;
		String nombre ="";
		Arbol arbolizza = new Arbol();
		
		do{
			try {
				opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
						"1. Arbol vacio\n"
						+ "2. Buscar un Nodo en el Arbol\n"
						+ "3. Insertar Nodo en el Arbol\n"
						+ "4. Imprimir Arbol\n"
						+ "5. Salir\n"
						+ "Elige Una Opcion...", "Arboles Binarios"
							, JOptionPane.QUESTION_MESSAGE));
				switch(opcion) {
				case 1:
					if(!arbolizza.estaVacio()) {
						JOptionPane.showMessageDialog(null, "El Arbol no esta Vacio",
								"Notificacion", JOptionPane.INFORMATION_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, "El Arbol esta Vacio",
								"Notificacion", JOptionPane.INFORMATION_MESSAGE);
					}
					break;
				case 2:
					if(!arbolizza.estaVacio()) {
						
						nombre = JOptionPane.showInputDialog(null,
						"Ingresa el nombre del Nodo Buscado...","Buscando Nodo",JOptionPane.QUESTION_MESSAGE);
						if(arbolizza.buscarNodo(nombre) == null) {
							JOptionPane.showMessageDialog(null, "El Nodo no se encuentra en el Arbol",
									" Nodo No Encontrado!", JOptionPane.INFORMATION_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(null, "Nombre: " + arbolizza.buscarNodo(nombre),
									"Nodo encontrado", JOptionPane.INFORMATION_MESSAGE);
						}
					}else {
					JOptionPane.showMessageDialog(null, "El Arbol esta Vacio",
					"Notificacion", JOptionPane.INFORMATION_MESSAGE);
				}
					break;
				case 3:
					nombre = JOptionPane.showInputDialog(null,
							"Ingresa el Nombre del Nodo...","Agregando Nodo"
							,JOptionPane.QUESTION_MESSAGE);
					arbolizza.Insertar(nombre);
					break;
				case 4:
					if(arbolizza.estaVacio()) {
						JOptionPane.showMessageDialog(null, "El Arbol esta Vacio",
								"Notificacion", JOptionPane.INFORMATION_MESSAGE);
					}else {
						System.out.println("\nArbol:");
						arbolizza.ImprimirArbol();
					}
					break;
				case 5:
					JOptionPane.showMessageDialog(null, "Aplicacion finalizada ",
							"Fin", JOptionPane.INFORMATION_MESSAGE);
					break;
					default:
						JOptionPane.showMessageDialog(null, "Opcion incorrecta",
								"Notificacion", JOptionPane.INFORMATION_MESSAGE);
				}
			}catch(NumberFormatException n) {
				if (n.getMessage().equals("null")){
					opcion=5;
					JOptionPane.showMessageDialog(null, "Aplicacion finalizada ",
							"Fin", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "Error " + n.getMessage());
				}
			}
		}while(opcion!=5);
	}

}