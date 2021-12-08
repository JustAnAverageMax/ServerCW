package BLL.Request;

import BLL.API.SalonManager;
import BLL.Model.Visit;
import DAL.entity.VisitEntity;
import com.google.gson.Gson;

import java.util.Map;

public class RemoveVisitsRequest extends Request implements IRequest{
    public RemoveVisitsRequest(SalonManager salonManager) {
        super(salonManager);
    }

    @Override
    public String execute(Map<String, String> params) {
        Gson gson = new Gson();
        Visit[] visits = gson.fromJson(params.get("visitsToRemove"), Visit[].class);
        for (Visit v :
                visits) {
            salonManager.removeVisit((VisitEntity) v.toEntity());
        }
        return "OK";
    }
}
