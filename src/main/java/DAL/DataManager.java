package DAL;

import BLL.Model.Visit;
import DAL.entity.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class DataManager implements IDataManager{
    private static IDataManager dataManager;
    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;

    private DataManager(){
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
    }
    public static synchronized IDataManager Instance(){
        if(dataManager == null) dataManager = new DataManager();
        return dataManager;
    }


    @Override
    public MyEntity get(int id, Class tClass) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            MyEntity entity = (MyEntity) entityManager.find(tClass, id);
            entityTransaction.commit();
            return  entity;
        }finally {
            if(entityTransaction.isActive()){
                entityTransaction.rollback();
            }
        }
    }



    @Override
    public List getAllClients() {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            List result = entityManager.createQuery("select c from ClientEntity c").getResultList();
            entityTransaction.commit();
            return result;
        }finally {
            if(entityTransaction.isActive()){
                entityTransaction.rollback();
            }
        }
    }

    @Override
    public void add(MyEntity tClass) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try{
            entityTransaction.begin();
            entityManager.persist(tClass);
            entityTransaction.commit();
        }finally {
            if(entityTransaction.isActive()){
                entityTransaction.rollback();
            }
        }
    }

    @Override
    public void remove(MyEntity tClass) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.remove(entityManager.contains(tClass)?tClass:entityManager.merge(tClass));
            entityTransaction.commit();
        }finally {
            if(entityTransaction.isActive()){
                entityTransaction.rollback();
            }
        }
    }

    @Override
    public void updateService(ServiceEntity newServiceEntity) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try{
            entityTransaction.begin();
            entityManager.merge(newServiceEntity);
            entityTransaction.commit();

        }finally {
            if(entityTransaction.isActive()){
                entityTransaction.rollback();
            }
        }
    }

    @Override
    public List getAllServices() {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try{
            entityTransaction.begin();
            List services = entityManager.createQuery("select e from  ServiceEntity e").getResultList();

            entityTransaction.commit();
            return services;
        }finally {
            if(entityTransaction.isActive()){
                entityTransaction.rollback();
            }
        }
    }

    @Override
    public List getAllEmployees() {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try{
            entityTransaction.begin();
            List employees = entityManager.createQuery("select e from  EmployeeEntity e").getResultList();

            entityTransaction.commit();
            return employees;
        }finally {
            if(entityTransaction.isActive()){
                entityTransaction.rollback();
            }
        }
    }

    @Override
    public List getEmployeesByServiceGroupID(int groupID) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try{
            entityTransaction.begin();
            List employees = entityManager.createQuery(
                    "select e from EmployeeEntity e where e.positionId in " +
                            "(select a from PositionEntity a where a.groupId ='" + groupID + "')"
            ).getResultList();
            entityTransaction.commit();
            return employees;
        }finally {
            if(entityTransaction.isActive()){
                entityTransaction.rollback();
            }
        }
    }

    @Override
    public List getAllServiceGroups() {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try{
            entityTransaction.begin();
            List serviceGroups = entityManager.createQuery("select sg from ServiceGroupEntity sg").getResultList();
            entityTransaction.commit();
            return serviceGroups;
        }finally {
            if(entityTransaction.isActive()){
                entityTransaction.rollback();
            }
        }
    }

    @Override
    public int count(Class tClass) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            Long count = (long) entityManager.createQuery("select count(a) from "+ tClass.getName()+ " a").getSingleResult();
            int result = count.intValue();
            entityTransaction.commit();
            return result;
        }finally {
            if (entityTransaction.isActive()){
                entityTransaction.rollback();
            }
        }
    }

    @Override
    public int getClientVisitsCountByID(int id) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            Long count = (long) entityManager.createQuery("select count(v) from VisitEntity v where v.clientId='"+id+"'").getSingleResult();
            int result = count.intValue();
            return result;
        }finally {
            if(entityTransaction.isActive()){
                entityTransaction.rollback();
            }
        }
    }

    @Override
    public UserEntity getUserByLogin(String login, Class entityClass) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try{
            entityTransaction.begin();
            UserEntity user;
            try {
                 String query = "select a from " + entityClass.getName() + " a where a.login='" + login + "'";
                 user = (UserEntity) entityManager.createQuery(query).getSingleResult();
            }
            catch(NoResultException ex){
                user = null;
            }
            finally {
                entityTransaction.commit();
            }
            return user;
        }
        finally {
            if(entityTransaction.isActive()){
                entityTransaction.rollback();
            }
        }
    }

    @Override
    public ArrayList<Visit> getClientVisits(int clientID) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try{
            entityTransaction.begin();
            List result;
            try{
                result = entityManager.createQuery(
                        "select a from VisitEntity a where a.clientId='" + clientID + "'"
                ).getResultList();
            }catch (NoResultException e){
                result = null;
            }
            ArrayList<Visit> finalResult = new ArrayList<>();
            for (Object obj:
                 result) {
                VisitEntity ve = (VisitEntity) obj;
                finalResult.add((Visit) ve.toModel());
            }
            entityTransaction.commit();
            return  finalResult;
        }finally {
            if(entityTransaction.isActive()){
                entityTransaction.rollback();
            }
        }
    }

    public EmployeeEntity test(String login){
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try{
            entityTransaction.begin();
            EmployeeEntity empl = null;
            List employee = entityManager.createQuery("select a from EmployeeEntity a where a.login='"+login+"'").getResultList();
            for (Object c :
                    employee) {
                empl = (EmployeeEntity) c;
            }
            entityTransaction.commit();
            return empl;
        }finally {
            if(entityTransaction.isActive()){
                entityTransaction.rollback();
            }
        }
    }

    @Override
    public void save() {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityTransaction.commit();
        }finally {
            if(entityTransaction.isActive()){
                entityTransaction.rollback();
            }
        }
    }
}
