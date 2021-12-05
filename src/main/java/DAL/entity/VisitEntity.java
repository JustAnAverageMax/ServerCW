package DAL.entity;

import BLL.Model.Model;
import BLL.Model.Visit;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "Visit", schema = "dbo", catalog = "TestDb")
public class VisitEntity implements MyEntity {
    private int id;
    private int clientId;
    private int serviceId;
    private int employeeId;
    private Date date;
    private Time time;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Basic
    @Column(name = "clientID")
    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Basic
    @Column(name = "serviceID")
    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    @Basic
    @Column(name = "employeeID")
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Basic
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "time")
    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VisitEntity that = (VisitEntity) o;

        if (id != that.id) return false;
        if (clientId != that.clientId) return false;
        if (serviceId != that.serviceId) return false;
        if (employeeId != that.employeeId) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + clientId;
        result = 31 * result + serviceId;
        result = 31 * result + employeeId;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }

    @Override
    public Model toModel() {
        Visit visit = new Visit();
        visit.setDate(date);
        visit.setId(id);
        visit.setClientId(clientId);
        visit.setEmployeeId(employeeId);
        visit.setServiceId(serviceId);
        visit.setTime(time);
        return visit;
    }
}
