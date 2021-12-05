package DAL;

import DAL.entity.*;

import javax.persistence.*;
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
            entityManager.remove(tClass);
            entityTransaction.commit();
        }finally {
            if(entityTransaction.isActive()){
                entityTransaction.rollback();
            }
        }
    }

    @Override
    public MyEntity getUserByLogin(String login, Class entityClass) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try{
            entityTransaction.begin();

            MyEntity user = (MyEntity) entityManager.createQuery(
                    "select a from " + entityClass.getName() + " a where a.login='"+login + "'").getSingleResult();

            entityTransaction.commit();
            return user;
        }
        finally {
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
