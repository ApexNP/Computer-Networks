import java.net.*;
import java.io.*;
import java.util.concurrent.TimeUnit;

public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {

        for (int i = 0; i < 60; i++) {
            Socket clientSocket = new Socket("127.0.0.1", 10000);

            OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            writer.write("Say me data\n");
            writer.flush();

            String message = reader.readLine();
            System.out.println(message);

            reader.close();
            writer.close();

            clientSocket.close();
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
