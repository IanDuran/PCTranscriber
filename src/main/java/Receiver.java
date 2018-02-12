import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Receiver {
    private final int PORT = 6666;
    private ServerSocket serverSocket;
    private BufferedReader input;

    public String receiveString(){
        String message = "";
        try {
            StringBuilder builder = new StringBuilder();
            this.serverSocket = new ServerSocket(PORT);
            Socket clientSocket = serverSocket.accept();
            input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            for (String currLine = this.input.readLine(); currLine != null; currLine = this.input.readLine()){
                builder.append(currLine).append("\n");
            }

            message = builder.toString();

            this.input.close();
            clientSocket.close();
            this.serverSocket.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        return message;
    }
}
