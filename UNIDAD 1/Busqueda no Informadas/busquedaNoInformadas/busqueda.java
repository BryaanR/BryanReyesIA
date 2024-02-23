
// Reyes Barrera Bryan Gilberto
package busquedaNoInformadas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class busqueda {
    
	nodo raiz;
    String objetivo;
    
    public busqueda(nodo raiz, String objetivo)
    {
        this.raiz = raiz;
        this.objetivo = objetivo;
    }
    
    //Busqueda por Anchura
    public void busquedaPorAnchura()
    {
    	nodo nodoActual = raiz;
        Collection<String> estadosVisitados = new ArrayList();
        Queue<nodo> estadosPorVisitar = new LinkedList();
        while(!nodoActual.getEstado().equals(objetivo))
        {
            estadosVisitados.add(nodoActual.getEstado());
            //Nodos Hijos
            Collection<String> hijos = nodoActual.generaHijos();	//<-- Cada Equipo tiene que ingeniarselas para crear este metodo!
            for (String hijo : hijos) {
                if(!estadosVisitados.contains(hijo))
                {

                    //Crear nuevo Nodo.
                	nodo nHijo = new nodo(hijo);
                    nHijo.setPadre(nodoActual);
                    estadosPorVisitar.add(nHijo);
                }
            }
            nodoActual = estadosPorVisitar.poll();
        }
        System.out.println(nodoActual.imprimirSolucion());
    }
    
    public Comparator<nodo> Heuristica_1ra() {
        Comparator<nodo> c = new Comparator<nodo>() {
            @Override
            public int compare(nodo nodo, nodo nodo2) {
            	return Heuristica_1ra(raiz.getEstado());
            }
        };
        return c;
    }
    
    public int Heuristica_1ra(String estado) {
		
		int heuristico = 0;
		
		for(int i = 0; i < estado.length(); i++) {
			if(estado.charAt(i) != objetivo.charAt(i)) {
				heuristico++;
			}
		}
		return heuristico;
	}
    
    public Comparator<nodo> Heuristica_2da() {
        Comparator<nodo> c = new Comparator<nodo>() {
            @Override
            public int compare(nodo nodo, nodo nodo2) {
            	return Heuristica_2da(raiz.getEstado());
            }
        };
        return c;
    }
    
	private int Heuristica_2da(String estado) {
		
		int heuristico = 0, caracter1 = 0, caracter2 = 0, heuristicaIndice = 0;
		
		for(int i = 0; i < estado.length(); i++) {
			heuristicaIndice = 0;
			caracter1 = (int) estado.charAt(i);
			caracter2 = (int) objetivo.charAt(i);
			heuristicaIndice = caracter1 - caracter2;
			heuristicaIndice = Math.abs(heuristicaIndice);
			heuristico = heuristicaIndice + heuristico;
		}
		return heuristico;
	}

    
    public Comparator<nodo> Heuristica_3era() {
        Comparator<nodo> c = new Comparator<nodo>() {
            @Override
            public int compare(nodo nodo, nodo nodo2) {
            	return Heuristica_3era(raiz.getEstado());
            }
        };
        return c;
    }

	public int Heuristica_3era(String estado) {
     	int filas = 0, columnas = 0;
        int filasObj = 0, columnasObj = 0;
        int devolver = 0;


        devolver = 0;
        filas =  (int)estado.charAt(0)  +  (int)estado.charAt(1)  +  (int) estado.charAt(2);
        filasObj =  (int) objetivo.charAt(0)  +  (int) objetivo.charAt(1)  +  (int) objetivo.charAt(2);
        devolver += Math.abs(filas - filasObj);


        filas =  (int)estado.charAt(3)  +  (int)estado.charAt(4)  +  (int) estado.charAt(5);
        filasObj =  (int) objetivo.charAt(3)  +  (int) objetivo.charAt(4)  +  (int) objetivo.charAt(5);
        devolver += Math.abs(filas - filasObj);

        filas =  (int)estado.charAt(6)  +  (int)estado.charAt(7)  +  (int) estado.charAt(8);
        filasObj =  (int) objetivo.charAt(6)  +  (int) objetivo.charAt(7)  +  (int) objetivo.charAt(8);
        devolver += Math.abs(filas - filasObj);

        columnas =  (int)estado.charAt(0)  +  (int)estado.charAt(3)  +  (int) estado.charAt(6);
        columnasObj =  (int)objetivo.charAt(0)  +  (int)objetivo.charAt(3)  +  (int) objetivo.charAt(6);
        devolver += Math.abs(columnas - columnasObj);

        columnas =  (int)estado.charAt(1)  +  (int)estado.charAt(4)  +  (int) estado.charAt(7);
        columnasObj =  (int)objetivo.charAt(1)  +  (int)objetivo.charAt(4)  +  (int) objetivo.charAt(7);
        devolver += Math.abs(columnas - columnasObj);

        columnas =  (int)estado.charAt(2)  +  (int)estado.charAt(5)  +  (int) estado.charAt(8);
        columnasObj =  (int)objetivo.charAt(2)  +  (int)objetivo.charAt(5)  +  (int) objetivo.charAt(8);
        devolver += Math.abs(columnas - columnasObj);

        return devolver;
    }
    
    public void busquedaPorHeuristica(int Heuristica)
    {
    	Comparator<nodo> heuristica = null;
    	switch (Heuristica) {
	    	case 1:
	    		heuristica = Heuristica_1ra();
	    		break;
	    	case 2:
	    		heuristica = Heuristica_2da();
	    		break;
	    	case 3:
	    		heuristica = Heuristica_3era();
	    		break;
    	}
    	nodo nodoActual = raiz;
        Collection<String> estadosVisitados = new ArrayList();
        PriorityQueue<nodo> estadosPorVisitar = new PriorityQueue(heuristica);
        while(!nodoActual.getEstado().equals(objetivo))
        {
            estadosVisitados.add(nodoActual.getEstado());
            //Generar a los Nodos Hijos
            Collection<String> hijos = nodoActual.generaHijos();	
            for (String hijo : hijos) {
                if(!estadosVisitados.contains(hijo))
                {
                    
                    //nuevo Nodo.
                	nodo nHijo = new nodo(hijo);
                    nHijo.setPadre(nodoActual);
                    estadosPorVisitar.add(nHijo);
                }
            }
            nodoActual = estadosPorVisitar.poll();
        }
        
        System.out.println(nodoActual.imprimirSolucion());
    }
    
    //Busqueda por Profunfidad
    public void busquedaPorProfundidad()
    {
    	nodo nodoActual = raiz;
        Collection<String> estadosVisitados = new ArrayList();
        Stack<nodo> estadosPorVisitar = new Stack();
        while(!nodoActual.getEstado().equals(objetivo))
        {
            estadosVisitados.add(nodoActual.getEstado());
            //Generar a los Nodos Hijos
            Collection<String> hijos = nodoActual.generaHijos();	//<-- Cada Equipo tiene que ingeniarselas para crear este metodo!
            for (String hijo : hijos) {
                if(!estadosVisitados.contains(hijo))
                {

                    //Crear nuevo Nodo.
                	nodo nHijo = new nodo(hijo);
                    nHijo.setPadre(nodoActual);
                    estadosPorVisitar.add(nHijo);
                }
            }
            nodoActual = estadosPorVisitar.pop();
        }
        System.out.println(nodoActual.imprimirSolucion());
    }
    
}
