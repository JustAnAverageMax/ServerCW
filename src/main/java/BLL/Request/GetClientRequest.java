package BLL.Request;

import BLL.API.SalonManager;
import DAL.entity.ClientEntity;
import com.google.gson.Gson;

import java.util.Map;

public class GetClientRequest extends Request implements IRequest{
    public GetClientRequest(SalonManager salonManager) {
        super(salonManager);
    }
    @Override
    public String execute(Map<String, String> params) {
        Gson gson = new Gson();
        return gson.toJson(salonManager.getClient(Integer.parseInt(params.get("ID"))).toModel());
    }
}
