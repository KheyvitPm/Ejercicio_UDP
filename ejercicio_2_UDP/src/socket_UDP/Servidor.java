package socket_UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final int PUERTO= 5000;
		byte[] buffer = new byte[1024];
		
		try{
			System.out.println("servidor UDP iniciado");
			DatagramSocket SocketUDP = new DatagramSocket(PUERTO);
			
			while(true){
			
			DatagramPacket peticion = new DatagramPacket(buffer,buffer.length);
			
			SocketUDP.receive(peticion);
			System.out.println("recibiendo del cliente");
			
			String mensaje = new String(peticion.getData());
			System.out.println(mensaje);
			
			int puertoCliente = peticion.getPort();
			InetAddress direccion = peticion.getAddress();
			
			mensaje= "hola desde el servidor";
			System.out.println();
			buffer = mensaje.getBytes();
			
			DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length, direccion, puertoCliente );
			
			//envio de datos desde el servidor
			boolean salir = true;
			String palabras;
			Scanner obj = new Scanner(System.in);
			
			while (salir){
				
				System.out.println("introduzca la cadena");
				palabras = obj.nextLine();
				
				
			if (palabras.equals("Exit")) {salir=false;}
	        else {
				StringTokenizer a = new StringTokenizer(palabras);
				System.out.println("el numero de la cadena es:" +" "+a.countTokens());
				System.out.println("-----------------------");
				System.out.println();
			}
			
			}
			
			System.out.println("envio informacion al cliente");
			System.out.println("---------");
			SocketUDP.send(respuesta);	
			}
		} catch(SocketException ex){
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
		}catch (IOException ex){
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
		}
		
	}

}
