package BLL.Request;

import BLL.API.SalonManager;
import BLL.Model.Service;
import DAL.entity.ServiceEntity;
import com.google.gson.Gson;

import java.util.Map;

public class UpdateServiceRequest extends Request implements IRequest{
    public UpdateServiceRequest(SalonManager salonManager) {
        super(salonManager);
    }

    @Override
    public String execute(Map<String, String> params) {
        Gson gson = new Gson();
        salonManager.updateService((ServiceEntity) gson.fromJson(params.get("Model"), Service.class).toEntity());
        return "OK";

    }
}
