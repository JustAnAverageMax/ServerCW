package BLL.RequestHandler;

import BLL.API.SalonManager;
import BLL.Request.*;

public class RequestHandler {
    public static IRequest MakeQuery(String QueryName, SalonManager salonManager){
        switch (QueryName) {
            case "AddClient":
                return  new AddClientRequest(salonManager);
            case "AddAdmin":
                return new AddAdminRequest(salonManager);
            case"AddService":
                return new AddServiceRequest(salonManager);
            case"RemoveService":
                return new RemoveServiceRequest(salonManager);
            case "AuthClient":
                return new ClientAuthorizationRequest(salonManager);
            case"GetAllServiceGroups":
                return new GetAllServiceGroupsRequest(salonManager);
            case "AuthAdmin":
                return new AdminAuthorizationRequest(salonManager);
            case"BanClients":
                return new BanClientsRequest(salonManager);
            case "GetServiceGroupByServiceID":
                return new GetServiceGroupByServiceIDRequest(salonManager);
            case "UpdateService":
                return new UpdateServiceRequest(salonManager);
            case "GetClientByID":
                return new GetClientRequest(salonManager);
            case "FireEmployees":
                return new FireEmployeesRequest(salonManager);
            case "GetAllEmployees":
                return new GetAllEmployeesRequest(salonManager);
            case "GetAdminByID":
                return new GetAdminByIDRequest(salonManager);
            case "GetClientVisits":
                return new GetClientVisitsRequest(salonManager);
            case "GetAdminAccountsCount":
                return new GetAdminAccountsCountRequest(salonManager);
            case "GetServiceNameByID":
                return new GetServiceNameByIDRequest(salonManager);
            case "GetEmployeeNameByID":
                return new GetEmployeeNameByIDRequest(salonManager);
            case "GetClientVisitsCountByID":
                return new GetClientVisitsCountByIDRequest(salonManager);
            case"GetAllServices":
                return new GetAllServicesRequest(salonManager);
            case"AddVisit":
                return new AddVisitRequest(salonManager);
            case "GetAllClients":
                return new GetAllClientsRequest(salonManager);
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