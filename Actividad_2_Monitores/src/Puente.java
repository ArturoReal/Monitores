
import java.util.concurrent.*;

public class Puente{
	
    private final Semaphore sema;  
    public Puente()
    {
        sema = new Semaphore(1);  //formamos el semáforo
    }
    
    public void crossBridge(Vehiculo vehicle)
    {
        try
        {
            System.out.printf("%s está esperando para cruzar el puente.\n",vehicle.getName());  
            sema.acquire(); //solicita el permiso hasta que se libere
            
            System.out.printf("%s está cruzando el puente.\n",vehicle.getName());  
            long duration = (long)(Math.random()*10); //Esperamos un tiempo aleatorio 
            TimeUnit.SECONDS.sleep(duration);
        }
        catch(InterruptedException iex)
        { 
            iex.printStackTrace();
        }
        finally
        {
            System.out.printf("%s ha terminado de cruzar el puente.\n",vehicle.getName());  
            sema.release();  //liberamos el permiso
        }
    }

  
}