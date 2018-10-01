package dots;

import java.io.*;
import java.net.*;

public class Server{

	static final int PUERTO = 5555;

	public void multiCuenta(){

		Socket servicio = null;
		try{
			ServerSocket servidor = new ServerSocket(PUERTO);
			System.out.println("Esperando peticiones por el puerto " + PUERTO);
			while(true){
				servicio = servidor.accept();
				DataInputStream flujoDatosEntrada = new DataInputStream(servicio.getInputStream());  //Crea un objeto para recibir mensajes del usuario
				OutputStream escribir = servicio.getOutputStream(); //Objeto para mandar a escribir en el cliente
				DataOutputStream flujoDatosSalida = new DataOutputStream(escribir);  //Aqui se escriben las cosasx|
				//Prueba cc = new Prueba(servicio,flujoDatosEntrada,flujoDatosSalida);  //Parametros, la conexion , y los objetos de escritura/lectura
				Servidor cc = new Servidor(servicio,flujoDatosEntrada,flujoDatosSalida);  //Parametros, la conexion , y los objetos de escritura/lectura
				cc.start();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		//Se crea una instancia de la clase Servidor
		Server os= new Server();
		os.multiCuenta();
	}
}