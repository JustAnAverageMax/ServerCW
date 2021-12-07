import BLL.API.SalonManager;
import BLL.Model.Visit;
import DAL.DataManager;
import DAL.IDataManager;
import DAL.entity.ClientEntity;

import java.util.List;

public class TestMain {
    public static void main(String[] args) {
        IDataManager dataManager = DataManager.Instance();
        List visits = dataManager.getClientVisits(11);
        for (Object v :
                visits) {
            System.out.println(v);
        }
        System.out.println(dataManager.getClientVisits(11));
    }
}
