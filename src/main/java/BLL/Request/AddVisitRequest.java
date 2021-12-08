package BLL.Request;

import BLL.API.SalonManager;
import BLL.Model.Visit;
import DAL.entity.VisitEntity;
import com.google.gson.Gson;

import java.util.Map;

public class AddVisitRequest extends Request implements IRequest{
    public AddVisitRequest(SalonManager salonManager) {
        super(salonManager);
    }

    @Override
    public String execute(Map<String, String> params) {
        Gson gson = new Gson();
        Visit visit = gson.fromJson(params.get("Model"), Visit.class);
        salonManager.addVisit((VisitEntity) visit.toEntity());
        return "OK";
    }
}
