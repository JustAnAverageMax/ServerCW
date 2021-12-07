package BLL.Request;

import BLL.API.SalonManager;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GetClientVisitsRequest extends Request implements IRequest{
    public GetClientVisitsRequest(SalonManager salonManager) {
        super(salonManager);
    }

    @Override
    public String execute(Map<String, String> params) {
        Gson gson = new Gson();
        return gson.toJson(salonManager.getClientVisits(Integer.parseInt(params.get("ID"))));
    }
}
