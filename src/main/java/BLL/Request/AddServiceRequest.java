package BLL.Request;

import BLL.API.SalonManager;
import BLL.Model.Service;
import DAL.entity.ServiceEntity;
import com.google.gson.Gson;

import java.util.Map;

public class AddServiceRequest extends Request implements IRequest{
    public AddServiceRequest(SalonManager salonManager) {
        super(salonManager);
    }

    @Override
    public String execute(Map<String, String> params) {
        Gson gson = new Gson();
        Service service = gson.fromJson(params.get("addedServiceModel"), Service.class);
        salonManager.addService((ServiceEntity) service.toEntity());
        return "OK";
    }
}
