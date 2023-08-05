import java.util.HashMap;

public class DataService {

    public static HashMap<Integer,Student> data = new HashMap<>();

    public static HashMap<Integer, Student> getData() {
        return data;
    }

    public static void setData(HashMap<Integer, Student> data) {
        DataService.data = data;
    }
}
