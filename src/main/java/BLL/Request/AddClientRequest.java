package BLL.Request;

import BLL.API.SalonManager;
import BLL.Model.Client;
import DAL.entity.ClientEntity;
import com.google.gson.Gson;

import java.util.Map;

public class AddClientRequest extends Request implements IRequest{
    public AddClientRequest(SalonManager salonManager) {
        super(salonManager);
    }

    @Override
    public String execute(Map<String, String> params) {
        Gson gson = new Gson();
        Client client = gson.fromJson(params.get("model"), Client.class);
        System.out.println(client);
        salonManager.addClient((ClientEntity) client.toEntity());
        return "OK";
    }
}
