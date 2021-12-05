package BLL.Request;

import BLL.API.SalonManager;

import java.util.Map;

public class WrongCommandRequest extends Request implements IRequest{
    public WrongCommandRequest(SalonManager salonManager) {
        super(salonManager);
    }

    @Override
    public String execute(Map<String, String> params) {

        return null;
    }
}
