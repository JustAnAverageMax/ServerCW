package BLL.Request;

import BLL.API.SalonManager;
import BLL.Model.Admin;
import DAL.entity.AdminEntity;
import com.google.gson.Gson;

import java.util.Map;

public class AddAdminRequest extends Request implements IRequest{
    public AddAdminRequest(SalonManager salonManager) {
        super(salonManager);
    }

    @Override
    public String execute(Map<String, String> params) {
        Gson gson = new Gson();
        Admin admin = gson.fromJson(params.get("Model"), Admin.class);
        salonManager.addAdmin((AdminEntity) admin.toEntity());
        return "OK";
    }
}
