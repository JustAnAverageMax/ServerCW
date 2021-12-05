package BLL.Model;

import DAL.entity.MyEntity;
import DAL.entity.ServiceGroupEntity;

public class ServiceGroup implements Model{
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ServiceGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceGroup that = (ServiceGroup) o;
        return id == that.id && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public MyEntity toEntity() {
        ServiceGroupEntity serviceGroupEntity = new ServiceGroupEntity();
        serviceGroupEntity.setId(id);
        serviceGroupEntity.setName(name);
        return serviceGroupEntity;
    }
}