package DAL;

import BLL.Model.Visit;
import DAL.entity.*;

import java.util.ArrayList;
import java.util.List;

public interface IDataManager {

    MyEntity get(int id, Class tClass);
    void add(MyEntity tClass);
    void remove(MyEntity tClass);
    List getAllServices();
    List getEmployeesByServiceGroupID(int groupID);

    UserEntity getUserByLogin(String login, Class entityClass);
    ArrayList<Visit> getClientVisits(int clientID);

    void save();
}
