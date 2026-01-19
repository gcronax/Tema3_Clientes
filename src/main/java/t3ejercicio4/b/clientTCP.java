package t3ejercicio4.b;

import java.io.*;
import java.net.Socket;
import java.util.List;

public class clientTCP {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345);

            try {
                InputStream inputStream =
                        socket.getInputStream();
                BufferedReader in = new BufferedReader(new
                        InputStreamReader(inputStream));
                String respuesta = in.readLine();
                System.out.println("Mensaje del cliente: " +
                        respuesta);
            } catch (IOException e) {
                e.printStackTrace();
            }

            OutputStream outputStream = socket.getOutputStream();
            PrintWriter out = new PrintWriter(outputStream,
                    true);
            Float respuesta=3F;
            out.println(respuesta);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
