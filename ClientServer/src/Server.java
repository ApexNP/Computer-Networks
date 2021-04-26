import java.net.*;
import java.io.*;
import java.text.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class Server {

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(10000);
        int counter = 0;

        while (true) {
            Socket clientSocket = serverSocket.accept();

            OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String request = reader.readLine();

            Date dateNow = new Date();
            SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss a zzz");

            String response = "Текущая дата " + formatForDateNow.format(dateNow) + "\n";

            writer.write(response);
            writer.flush();
            System.out.println("Client accepted " + counter++);

            TimeUnit.SECONDS.sleep(1);

            writer.close();
            reader.close();
            clientSocket.close();
        }
        //serverSocket.close();
    }
}
