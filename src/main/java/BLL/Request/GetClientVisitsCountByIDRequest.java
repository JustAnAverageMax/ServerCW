package BLL.Request;

import BLL.API.SalonManager;

import java.util.Map;

public class GetClientVisitsCountByIDRequest extends Request implements IRequest{
    public GetClientVisitsCountByIDRequest(SalonManager salonManager) {
        super(salonManager);
    }

    @Override
    public String execute(Map<String, String> params) {
        return Integer.toString(salonManager.getClientVisitsCountByID(Integer.parseInt(params.get("ID"))));
    }
}
