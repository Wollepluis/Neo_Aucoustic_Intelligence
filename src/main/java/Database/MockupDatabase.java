package Database;

import java.util.Map;

public class MockupDatabase extends Database {

    public MockupDatabase() {
        super(/*Communicatieprotocol protocol*/);
    }

    @Override
    public DataObject getData(String id, String type) {
        hashMap.put(id, type);
        Map<String, String> key = hashMap;
        return mapje.get(key);
    }

    public void uploadData(DataObject data, String dataType) {
        int size = hashMap.size() + 1;
        data.id = Integer.toString(size);
        SaveData saveData = new SaveData();
        hashMap.put(data.id, data.type);
        mapje.put(hashMap, data);
        SaveManager.saveData(saveData, data);
    }
}
