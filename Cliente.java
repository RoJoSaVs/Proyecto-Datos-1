package dots;

import java.net.*;
import java.io.*;
import java.util.Scanner;
/**Clase que va a establecer la conexion entre el usuario y el servidor*/
public class Cliente {
    private Socket socket;
    private DataInputStream bufferDeEntrada = null;
    private DataOutputStream bufferDeSalida = null;
    Scanner teclado = new Scanner(System.in);
    final String COMANDO_TERMINACION = "salir()";
    /**Inicia la conexion por el socket*/
    public void levantarConexion(String ip, int puerto) {
        try {
            socket = new Socket(ip, puerto);
            mostrarTexto("Conectado a :" + socket.getInetAddress().getHostName());
        } catch (Exception e) {
            mostrarTexto("Excepci�n al levantar conexi�n: " + e.getMessage());
            System.exit(0);
        }
    }

    public static void mostrarTexto(String s) {
        System.out.println(s);
    }
    /**Recibe y envia mensajes por el socket*/
    public void abrirFlujos() {
        try {
            bufferDeEntrada = new DataInputStream(socket.getInputStream());
            bufferDeSalida = new DataOutputStream(socket.getOutputStream());
            bufferDeSalida.flush();
        } catch (IOException e) {
            mostrarTexto("Error en la apertura de flujos");
        }
    }
    /**Envia el texto ingresado por el usuario*/
    public void enviar(String s) {
        try {
            bufferDeSalida.writeUTF(s);
            bufferDeSalida.flush();
        } catch (IOException e) {
            mostrarTexto("IOException on enviar");
        }
    }
    /**Cierra la conexion del socket con el comando "salir()"*/
    public void cerrarConexion() {
        try {
            bufferDeEntrada.close();
            bufferDeSalida.close();
            socket.close();
            mostrarTexto("Conexi�n terminada");
        } catch (IOException e) {
            mostrarTexto("IOException on cerrarConexion()");
        }finally{
            System.exit(0);
        }
    }
    /**Corre en un hilo para que el cliente se mantenga escuchando y le 
    *permita escribir*/
    public void ejecutarConexion(String ip, int puerto) {
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    levantarConexion(ip, puerto);
                    abrirFlujos();
                    recibirDatos();
                } finally {
                    cerrarConexion();
                }
            }
        });
        hilo.start();
    }
    /**Recibe los datos ingresados por el usuario*/
    public void recibirDatos() {
        String st = "";
        try {
            do {
                st = (String) bufferDeEntrada.readUTF();
                mostrarTexto("\n[Servidor] => " + st);
                System.out.print("\n[Usted] => ");
            } while (!st.equals(COMANDO_TERMINACION));
        } catch (IOException e) {}
    }
    /**Muestra en consola los datos ingresados por el usuario*/
    public void escribirDatos() {
        String entrada = "";
        while (true) {
            System.out.print("[Usted] => ");
            entrada = teclado.nextLine();
            if(entrada.length() > 0)
                enviar(entrada);
        }
    }

    public static void main(String[] argumentos) {
    	FrameJuego inter = new FrameJuego();
    	inter.Interfaz();
        Cliente cliente = new Cliente();
        Scanner escaner = new Scanner(System.in);
        mostrarTexto("Ingresa la IP: [localhost por defecto] ");
        String ip = escaner.nextLine();
        if (ip.length() <= 0) ip = "localhost";

        mostrarTexto("Puerto: [5050 por defecto] ");
        String puerto = escaner.nextLine();
        if (puerto.length() <= 0) puerto = "5050";
        cliente.ejecutarConexion(ip, Integer.parseInt(puerto));
        cliente.escribirDatos();
    }
}
