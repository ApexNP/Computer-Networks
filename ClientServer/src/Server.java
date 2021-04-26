import java.net.*;
import java.io.*;
import java.nio.charset.StandardCharsets;


public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10000);
        int counter = 0;

        while (true) {
            Socket clientSocket = serverSocket.accept();

            OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String request = reader.readLine();
            String response = counter + ", ur message length is " + request.length() + "\n";

            /* Writer для корректного отображения в браузерах
            writer.write("HTTP/1.0 200 OK\r\n" +
                    "Content-type: text/html\r\n" +
                    "\r\n" +
                    "<H2>Hello</H2>\r\n");
             */
            writer.write(response);
            System.out.println("Client accepted " + counter++);
            writer.flush();

            writer.close();
            reader.close();
            clientSocket.close();
        }
        //serverSocket.close();
    }
}
