
// Reyes Barrera Bryan Gilberto
package busquedaNoInformadas;

import java.util.Collection;


public class pieza {
	public static String estadoInicial = "1 2453786" ;
    public static String estadoendal = "12345678 ";
    
    public static void main(String[] args) {
    	busqueda a = new busqueda(new nodo(estadoInicial), estadoendal);
     // Medicion anchura

        long start = System.nanoTime();

        a.busquedaPorAnchura();

        long end = System.nanoTime();

        double TimeAnchura = (double) (end - start) / 1000000000;
        System.out.println(" Busqueda Terminada por anchura ---> \n");

        // Medicion profundidad

        start = System.nanoTime();

        a.busquedaPorProfundidad();

        end = System.nanoTime();

        double TimeProfundidad = (double) (end - start) / 1000000000;
        System.out.println(" Busqueda Terminada por profundidad ---> \n");

        start = System.nanoTime();
        a.busquedaPorHeuristica(1);
        end = System.nanoTime();
        double TimeHeuristica_1era = (double) (end - start) / 1000000000;
        System.out.println(" Heur stica Terminada ---> " + 1 +"\n");


        start = System.nanoTime();
        a.busquedaPorHeuristica(2);
        end = System.nanoTime();
        double TimeHeuristica_2da = (double) (end - start) / 1000000000;
        System.out.println(" Heur stica Terminada ---> " + 2 +"\n");


        start = System.nanoTime();
        a.busquedaPorHeuristica(3);
        end = System.nanoTime();
        double TimeHeuristica_3era = (double) (end - start) / 1000000000;
        System.out.println(" Heur stica Terminada ---> " + 3 +"\n");

 
        System.out.println("Anchura = " + TimeAnchura);
        System.out.println("Profundidad = " + TimeProfundidad);
        System.out.println("Heuristica 1 = " + TimeHeuristica_1era);
        System.out.println("Heuristica 2 = " + TimeHeuristica_2da);
        System.out.println("Heuristica 3 = " + TimeHeuristica_3era);


     estadoInicial = "41275386 ";
	a = new busqueda(new nodo(estadoInicial), estadoendal);
	
 // Medicion anchura
     start = System.nanoTime();
    a.busquedaPorAnchura();
     end = System.nanoTime();
    TimeAnchura = (double) (end - start) / 1000000000;
    System.out.println(" Busqueda Terminada por anchura ---> \n");

    // Medicion profundidad
    start = System.nanoTime();
    a.busquedaPorProfundidad();
    end = System.nanoTime();
    TimeProfundidad = (double) (end - start) / 1000000000;
    System.out.println(" Busqueda Terminada por profundidad ---> \n");
  
    start = System.nanoTime();
    a.busquedaPorHeuristica(1);
    end = System.nanoTime();
    TimeHeuristica_1era = (double) (end - start) / 1000000000;
    System.out.println(" Heur stica Terminada ---> " + 1 +"\n");

    start = System.nanoTime();
    a.busquedaPorHeuristica(2);
    end = System.nanoTime();
     TimeHeuristica_2da = (double) (end - start) / 1000000000;
    System.out.println(" Heur stica Terminada ---> " + 2 +"\n");

    start = System.nanoTime();
    a.busquedaPorHeuristica(3);
    end = System.nanoTime();
    TimeHeuristica_3era = (double) (end - start) / 1000000000;
    System.out.println(" Heur stica Terminada ---> " + 3 +"\n");

    System.out.println("Anchura: " + TimeAnchura);
    System.out.println("Profundidad: " + TimeProfundidad);
    System.out.println("Heuristica 1: " + TimeHeuristica_1era);
    System.out.println("Heuristica 2: " + TimeHeuristica_2da);
    System.out.println("Heuristica 3: " + TimeHeuristica_3era);


   estadoInicial = "8721 4356";
	a = new busqueda(new nodo(estadoInicial), estadoendal);
   start = System.nanoTime();

  a.busquedaPorAnchura();

   end = System.nanoTime();

  TimeAnchura = (double) (end - start) / 1000000000;
  System.out.println(" Busqueda Terminada por anchura ---> \n");

  // Medicion profundidad
  start = System.nanoTime();
  a.busquedaPorProfundidad();
  end = System.nanoTime();
  TimeProfundidad = (double) (end - start) / 1000000000;
  System.out.println(" Busqueda Terminada por profundidad ---> \n");

  
  start = System.nanoTime();
  a.busquedaPorHeuristica(1);
  end = System.nanoTime();
  TimeHeuristica_1era = (double) (end - start) / 1000000000;
  System.out.println(" Heur stica Terminada ---> " + 1 +"\n");


  start = System.nanoTime();
  a.busquedaPorHeuristica(2);
  end = System.nanoTime();
   TimeHeuristica_2da = (double) (end - start) / 1000000000;
  System.out.println(" Heur stica Terminada ---> " + 2 +"\n");


  start = System.nanoTime();
  a.busquedaPorHeuristica(3);
  end = System.nanoTime();
  TimeHeuristica_3era = (double) (end - start) / 1000000000;
  System.out.println(" Heur stica Terminada ---> " + 3 +"\n");

  System.out.println("Anchura: " + TimeAnchura);
  System.out.println("Profundidad: " + TimeProfundidad);
  System.out.println("Heuristica 1: " + TimeHeuristica_1era);
  System.out.println("Heuristica 2: " + TimeHeuristica_2da);
  System.out.println("Heuristica 3: " + TimeHeuristica_3era);

}
   }
