package DAL.entity;

import BLL.Model.Model;
import BLL.Model.Position;

import javax.persistence.*;

@Entity
@Table(name = "Position", schema = "dbo", catalog = "TestDb")
public class PositionEntity implements MyEntity{
    private int id;
    private String name;
    private int groupId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "groupID")
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

        PositionEntity that = (PositionEntity) o;

        if (id != that.id) return false;
        if (groupId != that.groupId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + groupId;
        return result;
    }

    @Override
    public Model toModel() {
        Position position = new Position();
        position.setId(id);
        position.setGroupId(groupId);
        position.setName(name);
        return position;
    }
}
