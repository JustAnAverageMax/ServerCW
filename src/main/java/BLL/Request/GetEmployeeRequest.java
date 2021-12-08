package BLL.Request;

import BLL.API.SalonManager;
import com.google.gson.Gson;

import java.util.Map;

public class GetEmployeeRequest extends Request implements IRequest{
    public GetEmployeeRequest(SalonManager salonManager) {
        super(salonManager);
    }

    @Override
    public String execute(Map<String, String> params) {
        Gson gson = new Gson();
        return gson.toJson(salonManager.getEmployee(Integer.parseInt(params.get("employeeID"))));
    }
}
