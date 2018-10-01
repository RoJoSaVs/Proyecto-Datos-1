package dots;
import java.io.*;
import java.net.*;
    

    public class Servidor extends Thread{

        Socket servicio = null;
        DataInputStream flujoDatosEntrada = null;
        DataOutputStream flujoDatosSalida = null;
        /**Constructor*/
        public Servidor(Socket servicio,DataInputStream x,DataOutputStream y){  

            this.servicio = servicio;
            flujoDatosEntrada = x;
            flujoDatosSalida = y;
        }
        /**Esto es un metodo, que corre cada hilo del servidor*/
        public void run(){  

            System.out.println("Se acepto una nueva conexion");

            try{

                String mensaje = flujoDatosEntrada.readUTF();//Recibe un mensaje

                System.out.println(mensaje);  //Imprime el mensaje recibido
            }catch(Exception e){

            }

        }

    }

