package BLL.Request;

import BLL.API.SalonManager;

import java.util.Map;

public class GetServiceNameByIDRequest extends Request implements IRequest{
    public GetServiceNameByIDRequest(SalonManager salonManager) {
        super(salonManager);
    }

    @Override
    public String execute(Map<String, String> params) {
        return salonManager.getService(Integer.parseInt(params.get("serviceID"))).getName();
    }
}
