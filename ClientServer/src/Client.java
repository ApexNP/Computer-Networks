import java.net.*;
import java.io.*;


public class Client {
    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket("127.0.0.1", 10000);

        OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());
        BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        writer.write("Give me info, pls!\n");
        writer.flush();

        String message = reader.readLine();
        System.out.println(message);

        reader.close();
        writer.close();
        clientSocket.close();
    }
}
