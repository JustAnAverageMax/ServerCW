package BLL.Request;

import BLL.API.SalonManager;

public abstract class Request {
    SalonManager salonManager;
    public Request(SalonManager salonManager){ this.salonManager = salonManager; }
}
