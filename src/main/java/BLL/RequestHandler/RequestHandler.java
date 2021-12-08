package BLL.RequestHandler;

import BLL.API.SalonManager;
import BLL.Request.*;

public class RequestHandler {
    public static IRequest MakeQuery(String QueryName, SalonManager salonManager){
        switch (QueryName) {
            case "AddClient":
                return  new AddClientRequest(salonManager);
            case "AuthorizeClient":
                return new ClientAuthorizationRequest(salonManager);
            case "GetClientByID":
                return new GetClientRequest(salonManager);
            case "GetClientVisits":
                return new GetClientVisitsRequest(salonManager);
            case "GetServiceNameByID":
                return new GetServiceNameByIDRequest(salonManager);
            case "GetEmployeeNameByID":
                return new GetEmployeeNameByIDRequest(salonManager);
            case"GetAllServices":
                return new GetAllServicesRequest(salonManager);
            case"AddVisit":
                return new AddVisitRequest(salonManager);
            case"RemoveVisits":
                return new RemoveVisitsRequest(salonManager);
            case"GetEmployee":
                return  new GetEmployeeRequest(salonManager);
            case "GetService":
                return new GetServiceRequest(salonManager);
            case"GetEmployeesByServiceGroupID":

                return new GetEmployeesByServiceGroupIDRequest(salonManager);
            default:
                return new WrongCommandRequest(salonManager);
        }
    }
}