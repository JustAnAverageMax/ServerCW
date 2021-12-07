package BLL.Request;

import BLL.API.SalonManager;
import com.google.gson.Gson;

import java.util.Map;

public class GetEmployeesByServiceGroupIDRequest extends Request implements IRequest{
    public GetEmployeesByServiceGroupIDRequest(SalonManager salonManager) {
        super(salonManager);
    }

    @Override
    public String execute(Map<String, String> params) {
        Gson gson = new Gson();
        return gson.toJson(salonManager.getEmployeesByServiceGroupID(Integer.parseInt(params.get("groupID"))));
    }
}
