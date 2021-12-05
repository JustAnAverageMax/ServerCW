package BLL.Model;

import DAL.entity.MyEntity;
import DAL.entity.PositionEntity;

public class Position implements Model{
    private int id;
    private String name;
    private int groupId;

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

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return id == position.id && groupId == position.groupId && name.equals(position.name);
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", groupId=" + groupId +
                '}';
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + groupId;
        return result;
    }

    @Override
    public MyEntity toEntity() {
        PositionEntity positionEntity = new PositionEntity();
        positionEntity.setId(id);
        positionEntity.setGroupId(groupId);
        positionEntity.setName(name);
        return positionEntity;
    }
}