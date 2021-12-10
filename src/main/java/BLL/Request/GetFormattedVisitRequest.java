package BLL.Request;

import BLL.API.SalonManager;

import java.util.Map;

public class GetFormattedVisitRequest extends Request implements IRequest{
    public GetFormattedVisitRequest(SalonManager salonManager) {
        super(salonManager);
    }

    @Override
    public String execute(Map<String, String> params) {

        return null;
    }
}
