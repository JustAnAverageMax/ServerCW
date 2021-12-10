import BLL.API.SalonManager;
import BLL.Model.Message;
import BLL.RequestHandler.RequestHandler;
import DAL.ConnectionHandler;
import DAL.DataManager;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.ServerSocket;


public class ServerMain {

    private static ServerSocket server;
    private static BufferedReader in;
    private static BufferedWriter out;
    private static SalonManager salonManager;

    public static void main(String[] args) {
        Gson gson = new Gson();
        try {
            salonManager = new SalonManager(DataManager.Instance());
            try (ServerSocket serverSocket = new ServerSocket(8080)) {
                System.out.println("Server started. Waiting for requests");
                while (true) {
                    ConnectionHandler handler = new ConnectionHandler(serverSocket);
                    new Thread(() -> {
                        Message request = gson.fromJson(handler.readLine(), Message.class);
                        System.out.println("[REQUEST]: " + request.getCommand() + " " + request.getParameters());
                        String response = RequestHandler.MakeQuery(request.getCommand(), salonManager).execute(request.getParameters());
                        System.out.println("[RESPONSE]: " + response);
                        handler.writeLine(response);
                    }).start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
