package BLL.RequestHandler;

import BLL.API.SalonManager;
import BLL.Request.AddClientRequest;
import BLL.Request.AuthorizationRequest;
import BLL.Request.IRequest;
import BLL.Request.WrongCommandRequest;

public class RequestHandler {
    public static IRequest MakeQuery(String QueryName, SalonManager salonManager){
        switch (QueryName) {
            case "AddClient":
                return  new AddClientRequest(salonManager);
            default:
                return new WrongCommandRequest(salonManager);
        }
    }
}