package BLL.API;

import DAL.IDataManager;
import DAL.entity.*;

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
    public ServiceGroupEntity getServiceGroup(int id) {
        return (ServiceGroupEntity) dataManager.get(id, ServiceEntity.class);
    }



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
    public void addServiceGroup(ServiceEntity service){
        dataManager.add(service);
    }

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


    public String auth(Map<String, String> params, Class entityClass) {
        MyEntity user = dataManager.getUserByLogin(params.get("Login"), entityClass);
        if(user!=null){
            
        }

        return "Failed";
    }
}
