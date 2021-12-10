package BLL.Request;

import BLL.API.SalonManager;
import BLL.Model.Client;
import BLL.Model.Employee;
import DAL.entity.ClientEntity;
import DAL.entity.EmployeeEntity;
import com.google.gson.Gson;

import java.util.Map;

public class FireEmployeesRequest extends Request implements IRequest{
    public FireEmployeesRequest(SalonManager salonManager) {
        super(salonManager);
    }

    @Override
    public String execute(Map<String, String> params) {
        Gson gson = new Gson();
        Employee[] employees = gson.fromJson(params.get("employeesToFire"), Employee[].class);
        for (Employee employee :
                employees) {
            salonManager.removeEmployee((EmployeeEntity) employee.toEntity());
        }
        return "OK";
    }
}
