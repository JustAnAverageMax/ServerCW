package BLL.Model;

import java.util.HashMap;
import java.util.Map;

public class Message {
    public String command;
    public Map<String,String> parameters = new HashMap<>();

    @Override
    public String toString() {
        return "Message{" +
                "command='" + command + '\'' +
                ", parameters=" + parameters +
                '}';
    }
}