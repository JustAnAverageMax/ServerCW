package BLL.Request;

import BLL.API.SalonManager;
import DAL.entity.ClientEntity;

import java.util.Map;

public class ClientAuthorizationRequest extends Request implements IRequest{
    public ClientAuthorizationRequest(SalonManager salonManager){
        super(salonManager);

    }


    @Override
    public String execute(Map<String, String> params) {

        return salonManager.auth(params, ClientEntity.class);
    }
}
