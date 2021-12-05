import BLL.API.SalonManager;
import BLL.Model.Message;
import BLL.RequestHandler.RequestHandler;
import DAL.ConnectionHandler;
import DAL.DataManager;
import DAL.IDataManager;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

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
                System.out.println("Server started. Waiting for clients");
                while (true) {
                    ConnectionHandler handler = new ConnectionHandler(serverSocket);
                    System.out.println("Client connected");
                    new Thread(() -> {
                        Message request = gson.fromJson(handler.readLine(), Message.class);
                        System.out.println(request);
                        String response = RequestHandler.MakeQuery(request.command, salonManager).execute(request.parameters);
                        handler.writeLine(response);

                    }).start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
//        try {
//            IDataManager dataManager = DataManager.Instance();
//            SalonManager salonManager = new SalonManager(dataManager);
//            try {
//                server = new ServerSocket(4004);
//                System.out.println("Сервер запущен!");
//                while (true) {
//                    try {
//                        Socket clientSocket = server.accept();
//                        Thread myThread = new Thread(new MyThread(clientSocket, salonManager), "MyThread");
//                        myThread.start();
//                    } catch (Exception e) {
//                        System.out.println(e.getMessage());
//                    }
//                }
//            } finally {
//                System.out.println("Сервер закрыт!");
//                server.close();
//            }
//        } catch (IOException e) {
//            System.err.println(e.getMessage());
//        }
    }
}
