package BLL.Request;

import BLL.API.SalonManager;
import DAL.entity.AdminEntity;

import java.util.Map;

public class AdminAuthorizationRequest extends Request implements IRequest{
    public AdminAuthorizationRequest(SalonManager salonManager) {
        super(salonManager);
    }

    @Override
    public String execute(Map<String, String> params) {
        return salonManager.auth(params, AdminEntity.class);
    }
}
