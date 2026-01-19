package t3ejercicio4.b;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class clientUDP {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();

            String mensaje = "Hola, servidor!";
            byte[] buffer = mensaje.getBytes();

            InetAddress direccionServidor = InetAddress.getByName("localhost");
            int puertoServidor = 12345;

            DatagramPacket paquete = new DatagramPacket(
                    buffer,
                    buffer.length,
                    direccionServidor,
                    puertoServidor
            );

            socket.send(paquete);

            byte[] bufferRespuesta = new byte[1024];
            DatagramPacket paqueteRespuesta =
                    new DatagramPacket(bufferRespuesta, bufferRespuesta.length);

            socket.receive(paqueteRespuesta);

            String respuesta = new String(
                    paqueteRespuesta.getData(),
                    0,
                    paqueteRespuesta.getLength()
            );

            System.out.println("Mensaje del servidor: " + respuesta);

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

