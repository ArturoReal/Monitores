
import java.util.concurrent.*;

public class Ordenacion 
{
    public static void main(String[] args)
    {
        final Puente bridge = new Puente();  //constructor de puente
        Thread Sur = new Thread(new Runnable()  
        {
            @Override
            public void run()
            {
                while(true)
                {
                    Vehiculo vehicle = new Vehiculo(bridge);  //crea el vehiculo
                    Thread a = new Thread(vehicle);  //hacemos que el vehiculo forme parte del hilo
                    
                    vehicle.setName("Vehiculo Sur: "+a.getId()); 
                    a.start(); 
                    
                    try{   
                        TimeUnit.SECONDS.sleep((long)(Math.random()*10));
                    }
                    catch(InterruptedException iex){  
                        iex.printStackTrace();
                    }
                }
            }
        });
        
        
        Thread Norte = new Thread(new Runnable() 
        {
            @Override
            public void run()
            {
                while(true)
                {
                    Vehiculo vehicle = new Vehiculo(bridge);  
                    Thread a = new Thread(vehicle);  
                    
                    vehicle.setName("Vehiculo Norte:  "+a.getId());  
                    a.start();
 
                    try{   
                        TimeUnit.SECONDS.sleep((long)(Math.random()*10));
                    }
                    catch(InterruptedException iex){  
                        iex.printStackTrace();        
                    }
                }
            }
        });
        
        
        Sur.start();  
        Norte.start();  
    }
}