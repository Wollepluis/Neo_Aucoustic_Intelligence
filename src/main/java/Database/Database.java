package Database;

import javafx.scene.chart.PieChart;

import java.util.HashMap;
import java.util.*;
public abstract class Database {

    public static Map<String, String> hashMap = new HashMap<>();
    public static Map<Map<String, String>, DataObject> mapje = new HashMap<>();
    public Database() {
    }

    public abstract DataObject getData(String id, String type);

    public abstract void uploadData(DataObject data, String dataType);



}
