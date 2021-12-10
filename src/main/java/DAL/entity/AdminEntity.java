package DAL.entity;

import BLL.Model.Admin;
import BLL.Model.Model;

import javax.persistence.*;

@Entity
@Table(name = "Admin", schema = "dbo", catalog = "TestDb")
public class AdminEntity extends UserEntity implements MyEntity{


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdminEntity that = (AdminEntity) o;

        if (id != that.id) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public Model toModel() {
        Admin admin = new Admin();
        admin.setId(id);
        admin.setLogin(login);
        admin.setPassword(password);
        return admin;
    }
}
