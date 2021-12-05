package BLL.Request;

import java.util.Map;

public interface IRequest {
    String execute(Map<String, String> params);
}
