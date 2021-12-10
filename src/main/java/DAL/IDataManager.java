package DAL;

import BLL.Model.Visit;
import DAL.entity.*;

import java.util.ArrayList;
import java.util.List;

public interface IDataManager {

    MyEntity get(int id, Class tClass);
    List getAllClients();
    void add(MyEntity tClass);
    void remove(MyEntity tClass);
    void updateService(ServiceEntity newServiceEntity);
    List getAllServices();
    List getAllEmployees();
    List getEmployeesByServiceGroupID(int groupID);
    List getAllServiceGroups();



    int count(Class tClass);
    int getClientVisitsCountByID(int id);
    UserEntity getUserByLogin(String login, Class entityClass);
    ArrayList<Visit> getClientVisits(int clientID);

    void save();
}
