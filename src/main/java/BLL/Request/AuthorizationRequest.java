package BLL.Request;

import BLL.API.SalonManager;

import java.util.Map;

public class AuthorizationRequest extends Request implements IRequest{
    private Class entityClass;
    public AuthorizationRequest(SalonManager salonManager, Class entityClass){
        super(salonManager);
        this.entityClass = entityClass;
    }


    @Override
    public String execute(Map<String, String> params) {

        return salonManager.auth(params, entityClass);
    }
}
