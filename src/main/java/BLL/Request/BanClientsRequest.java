package BLL.Request;

import BLL.API.SalonManager;
import BLL.Model.Client;
import DAL.entity.ClientEntity;
import com.google.gson.Gson;

import java.util.Map;

public class BanClientsRequest extends Request implements IRequest{
    public BanClientsRequest(SalonManager salonManager) {
        super(salonManager);
    }

    @Override
    public String execute(Map<String, String> params) {
        Gson gson = new Gson();
        Client[] clients = gson.fromJson(params.get("clientsToBan"), Client[].class);
        for (Client client :
                clients) {
            salonManager.removeClient((ClientEntity) client.toEntity());
        }
        return "OK";
    }
}
