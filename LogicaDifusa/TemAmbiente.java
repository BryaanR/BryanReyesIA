
//Alumno: Reyes Barrera Bryan Gilberto

package Entregables;

import java.util.Timer;
import java.util.TimerTask;
import java.io.File;
import java.util.Random;

import net.sourceforge.jFuzzyLogic.FIS;

public class TemAmbiente {
	
	protected static final String FIS = null;
	static double temAmbiente = 35, potencia, randomValue;
	private String fileName = "C:\\Users\\bryan\\eclipse-workspace\\InteligenciaArtificial\\src\\Entregables\\TemAmbiente.fcl";
	private Random random;

	    public static void main(String[] args) {
	    	new TemAmbiente();
	    }
	    
	    public TemAmbiente() {
	    	
	    	random = new Random();
	        Tiempo timer = new Tiempo();
	        System.out.println("Controlador de temperatura: ");
            System.out.println();
	        
		    TimerTask task = new TimerTask() {
		    	
		      public void run() {
			       File fis = FIS.load(fileName, true);

			       randomValue = -0.4 + (0.4 - -0.4) * random.nextDouble();
			       temAmbiente += randomValue;
			       
			       // 20 - 40�
			       fis.setVariable("temperatura", temAmbiente);
			        
			       fis.evaluate();
			       
			       // 0% - 100%
			       potencia = ((fis.getVariable("potencia").getLatestDefuzzifiedValue() - 17.6)*1.3);
			        
			       System.out.printf("La temperatura es de %.2f", temAmbiente);
			       System.out.printf("�, la dencidad de la temperatura climatica esta en %.2f", potencia);
			       System.out.println("% dentro del rango normal\n");
		      }
		    };
		    
		    timer.schedule(task, 0, 5000);
	   }
}