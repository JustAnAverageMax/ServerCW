package BLL.Request;

import BLL.API.SalonManager;
import com.google.gson.Gson;

import java.util.Map;

public class GetAllServicesRequest extends Request implements IRequest{
    public GetAllServicesRequest(SalonManager salonManager) {
        super(salonManager);
    }

    @Override
    public String execute(Map<String, String> params) {
        Gson gson = new Gson();
        return gson.toJson(salonManager.getAllServices());
    }
}
