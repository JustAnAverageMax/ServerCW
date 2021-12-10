package BLL.Request;

import BLL.API.SalonManager;
import DAL.entity.AdminEntity;
import com.google.gson.Gson;

import java.util.Map;

public class GetAdminAccountsCountRequest extends Request implements IRequest{
    public GetAdminAccountsCountRequest(SalonManager salonManager) {
        super(salonManager);
    }

    @Override
    public String execute(Map<String, String> params) {
        Gson gson = new Gson();
        return gson.toJson(salonManager.getTotal(AdminEntity.class));
    }
}
