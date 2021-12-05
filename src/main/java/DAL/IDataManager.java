package DAL;

import DAL.entity.*;

import java.util.List;
import java.util.Map;

public interface IDataManager {

    MyEntity get(int id, Class tClass);
    void add(MyEntity tClass);
    void remove(MyEntity tClass);



    MyEntity getUserByLogin(String login, Class entityClass);

    void save();
}
