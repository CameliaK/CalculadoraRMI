import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {
    public static void main(String[] args) {
        try{
            int puerto = 8080;
            String servidor = "localhost";

            System.out.println("Iniciando Servido en:");
            System.out.println("hostname: " +  servidor);
            System.out.println("Puerto: "+puerto);

            Registry registro = LocateRegistry.createRegistry(puerto);
            System.setProperty("java.rmi.server.hostname", servidor);
            registro.rebind("Calculadora", new CalcRMI());

            System.out.println("Servidor en ejecución de espera de cliente");
        }catch(RemoteException ex){
            System.err.println(ex);
        }
    }
}
