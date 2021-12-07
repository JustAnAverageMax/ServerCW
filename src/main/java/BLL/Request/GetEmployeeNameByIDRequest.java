package BLL.Request;

import BLL.API.SalonManager;
import BLL.Model.Employee;
import DAL.entity.EmployeeEntity;

import java.util.Map;

public class GetEmployeeNameByIDRequest extends Request implements IRequest{
    public GetEmployeeNameByIDRequest(SalonManager salonManager) {
        super(salonManager);
    }

    @Override
    public String execute(Map<String, String> params) {
        EmployeeEntity employee = salonManager.getEmployee(Integer.parseInt(params.get("employeeID")));
        return String.format("%s %c. %c", employee.getLastName(), employee.getFirstName().charAt(0), employee.getPatronymic().charAt(0));
    }
}
