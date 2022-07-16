
import java.util.concurrent.*;

public class Vehiculo implements Runnable{
	
    private String nombre;
    private Puente bridge;
    
    public Vehiculo(Puente bridge){
        this.bridge = bridge; 
    }
    
    public void run(){
        bridge.crossBridge(this);
    }
    
    
    //Metodo para conseguir el nombre del vehiculo
    public String getName(){
        return nombre;
    }
    
    
    //Metodo para el nombre del vehiculo
    public void setName(String name){
            this.nombre = name;
    }
}