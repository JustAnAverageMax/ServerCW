package BLL.Request;

import BLL.API.SalonManager;
import BLL.Model.Service;
import DAL.entity.ServiceEntity;
import com.google.gson.Gson;

import java.util.Map;

public class RemoveServiceRequest extends Request implements IRequest{
    public RemoveServiceRequest(SalonManager salonManager) {
        super(salonManager);
    }

    @Override
    public String execute(Map<String, String> params) {
        Gson gson = new Gson();
        Service service = gson.fromJson(params.get("Service"), Service.class);
        salonManager.removeService((ServiceEntity) service.toEntity());
        return "OK";
    }
}
