package sockets;
import java.net.*;
import java.io.*;


public class conector {
	ServerSocket server;
	Socket socket;
	int puerto = 5050;
	DataOutputStream salida;
	BufferedReader entrada;
		
	/**Inicia el servidor imprime un mensaje y cierra la conexion*/
	public void iniciar() {
		try {
			server = new ServerSocket(puerto);
			socket = new Socket();
			socket = server.accept();
			
			entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));	
			String mensaje = entrada.readLine();
			System.out.println(mensaje);
			salida = new DataOutputStream(socket.getOutputStream());
			salida.writeUTF("Adios Mundo");
			socket.close();
		
		}catch(Exception e) {};
	}
}


