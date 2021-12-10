package BLL.API;

import BLL.Model.Service;
import BLL.Model.ServiceGroup;
import BLL.Model.Visit;
import BLL.Request.GetServiceGroupByServiceIDRequest;
import DAL.IDataManager;
import DAL.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SalonManager {
    IDataManager dataManager;

    public  SalonManager(IDataManager dataManager) { this.dataManager = dataManager; }


    //GET
    public VisitEntity getVisit(int id) {
        return (VisitEntity) dataManager.get(id, VisitEntity.class);
    }
    public EmployeeEntity getEmployee(int id) {
        return (EmployeeEntity) dataManager.get(id, EmployeeEntity.class);
    }
    public ClientEntity getClient(int id) {
        return (ClientEntity) dataManager.get(id, ClientEntity.class);
    }
    public PositionEntity getPosition(int id) {
        return (PositionEntity) dataManager.get(id, ClientEntity.class);
    }
    public ServiceEntity getService(int id) {
        return (ServiceEntity) dataManager.get(id, ServiceEntity.class);
    }
    public ServiceGroupEntity getServiceGroup(int id) {return (ServiceGroupEntity) dataManager.get(id, ServiceGroupEntity.class);}
    public AdminEntity getAdmin(int id){return (AdminEntity) dataManager.get(id, AdminEntity.class);}
    public int getTotal(Class tClass){return dataManager.count(tClass);}
    public ServiceGroup getServiceGroupByServiceID(int id){
        ServiceEntity serviceEntity = getService(id);
        ServiceGroupEntity serviceGroupEntity = getServiceGroup(serviceEntity.getGroupId());
        return (ServiceGroup) serviceGroupEntity.toModel();
    }

    public int getClientVisitsCountByID(int id){return dataManager.getClientVisitsCountByID(id);}
    public ArrayList<Visit> getClientVisits(int clientID) {return dataManager.getClientVisits(clientID);}
    public List getAllServices() { return dataManager.getAllServices();}
    public List getEmployeesByServiceGroupID(int groupID){return dataManager.getEmployeesByServiceGroupID(groupID);}
    public List getAllClients(){return dataManager.getAllClients();}
    public List getAllEmployees(){return dataManager.getAllEmployees();}
    public List getAllServiceGroups(){return dataManager.getAllServiceGroups();}

    //ADD
    public void addVisit(VisitEntity visit){
        dataManager.add(visit);
    }
    public void addEmployee(EmployeeEntity employee){
        dataManager.add(employee);
    }
    public void addClient(ClientEntity client){
        dataManager.add(client);
    }
    public void addPosition(PositionEntity position){
        dataManager.add(position);
    }
    public void addService(ServiceEntity service){
        dataManager.add(service);
    }
    public void addServiceGroup(ServiceGroupEntity service){
        dataManager.add(service);
    }
    public void addAdmin(AdminEntity admin){dataManager.add(admin);}

    //REMOVE
    public void removeVisit(VisitEntity visit){
        dataManager.remove(visit);
    }
    public void removeEmployee(EmployeeEntity employee){
        dataManager.remove(employee);
    }
    public void removeClient(ClientEntity client){
        dataManager.remove(client);
    }
    public void removePosition(PositionEntity position){
        dataManager.remove(position);
    }
    public void removeService(ServiceEntity service){
        dataManager.remove(service);
    }
    public void removeServiceGroup(ServiceGroupEntity serviceGroup){
        dataManager.remove(serviceGroup);
    }


    public void updateService(ServiceEntity se){dataManager.updateService(se);}
    public String auth(Map<String, String> params, Class entityClass) {
        UserEntity user = dataManager.getUserByLogin(params.get("Login"), entityClass);
        if(user != null){
            if(user.getPassword().equals(params.get("Password"))){
                return String.valueOf(user.getId());
            }
        }
        return "Failed";
    }
}
