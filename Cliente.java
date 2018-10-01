package dots;
import java.io.*;
import java.net.*;

class Cliente{

    public static void main(String[] args){
        //public void Conexion() { 
        
        //Cliente client = new Cliente();
        //client.Conexion();
        
        String ip = "192.168.137.1";
        Socket conexion = null;
        int PUERTO = 5555;

        try{
            conexion = new Socket(ip,PUERTO);

            DataOutputStream flujoDatosSalida = new DataOutputStream(conexion.getOutputStream());//Creamos objeto para enviar
            flujoDatosSalida.writeUTF("Gracias por aceptarme");  //Mandamos el mensaje al servidor

        }catch(Exception e){

            System.out.println("No se puedo crear la conexion");
            e.printStackTrace();
        }
        FrameJuego game = new FrameJuego();
        game.Start();
    }
    
}