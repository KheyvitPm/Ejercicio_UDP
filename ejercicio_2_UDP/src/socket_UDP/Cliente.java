package socket_UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final int PUERTO_SERVIDOR= 5000;
		byte[] buffer = new byte[1024];
		
		try{
			InetAddress direccionServidor = InetAddress.getByName("localhost");
		    DatagramSocket socketUDP = new DatagramSocket();
		
		    String mensaje = "hola desde el cliente";
		
		    buffer = mensaje.getBytes();
		    
			DatagramPacket pregunta = new DatagramPacket(buffer, buffer.length, direccionServidor, PUERTO_SERVIDOR );
			System.out.println("cliente iniciado");
			System.out.println("envie datos al servidor ");
			socketUDP.send(pregunta);
			
			DatagramPacket peticion = new DatagramPacket(buffer,buffer.length);
			
			//desde el cliente 
			
			//boolean salir = true;
			//String palabras;
			//Scanner obj = new Scanner(System.in);
			
			//while (salir){
				
			//	System.out.println("introduzca la cadena");
			//	palabras = obj.nextLine();
				
				
			//if (palabras.equals("Exit")) {salir=false;}
	       // else {
			//	StringTokenizer a = new StringTokenizer(palabras);
			//	System.out.println("el numero de la cadena es:" +" "+a.countTokens());
			//	System.out.println("-----------------------");
			//	System.out.println();
			//}
			
			//}
			
			socketUDP.receive(peticion);
								
			mensaje = new String (peticion.getData());
			System.out.println(mensaje);
			
			socketUDP.close();
			
		
		}catch(SocketException ex){
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
		}catch (UnknownHostException ex){
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
		}catch (IOException ex){
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
		}
		}

}
