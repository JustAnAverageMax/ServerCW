package BLL.Model;

import DAL.entity.MyEntity;
import DAL.entity.ServiceEntity;

public class Service implements Model{
    private int id;
    private String name;
    private Integer groupId;
    private int price;
    private String description;

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

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return id == service.id && price == service.price && name.equals(service.name) && groupId.equals(service.groupId) && description.equals(service.description);
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", groupId=" + groupId +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (groupId != null ? groupId.hashCode() : 0);
        result = 31 * result + price;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public MyEntity toEntity() {
        ServiceEntity serviceEntity = new ServiceEntity();
        serviceEntity.setDescription(description);
        serviceEntity.setId(id);
        serviceEntity.setName(name);
        serviceEntity.setGroupId(groupId);
        serviceEntity.setPrice(price);
        return serviceEntity;
    }
}