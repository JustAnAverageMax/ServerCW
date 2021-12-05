import BLL.API.SalonManager;
import BLL.Model.Message;
import BLL.QueryManager.QueryManager;
import BLL.Request.IRequest;
import DAL.DataManager;
import DAL.IDataManager;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import com.google.gson.Gson;

class MyThread implements Runnable {
    Socket clientSocket;
    SalonManager salonManager;
    public MyThread(Socket clientSocket,SalonManager salonManager) {
        this.clientSocket = clientSocket;
        this.salonManager = salonManager;
    }
    public void run() {
        BufferedReader in = null;
        BufferedWriter out = null;
        try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            Gson gson = new Gson();
            Message message = gson.fromJson(in.readLine(),Message.class);
            String str = null;
            // IRequest query = QueryManager.MakeQuery(message.command, salonManager);
            //str = query.Execute(message.parameters);
            //out.write(str);
            out.flush();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                clientSocket.close();
                System.out.println("Client socket close");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

