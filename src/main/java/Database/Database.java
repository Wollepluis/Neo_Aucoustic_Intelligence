package Database;

import javafx.scene.chart.PieChart;

import java.util.HashMap;
import java.util.*;
public abstract class Database {

    public static Map<String, String> hashMap;
    public static Map<Map<String, String>, DataObject> mapje;
    public Database(/*CommunicatieProtocol protocol*/) {
        hashMap = new HashMap<>();
        mapje = new HashMap<>();
    }

    public abstract DataObject getData(String id, String type);

    public abstract void uploadData(DataObject data, String dataType);



}
