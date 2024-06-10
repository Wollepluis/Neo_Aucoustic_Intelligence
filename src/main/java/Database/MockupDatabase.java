package Database;

import java.util.Map;

public class MockupDatabase extends Database {

    public MockupDatabase() {
        super();
    }

    @Override
    public DataObject getData(String id, String type) {
        hashMap.put(id, type);
        Map<String, String> key = hashMap;
        return mapje.get(key);
    }

    public UserData getGebruiker(String gebruiker, String wachtwoord) {
        if(gebruiker.equals(SaveManager.loadUserData(gebruiker).getGebruikersnaam()) && (wachtwoord.equals(SaveManager.loadUserData(gebruiker).getWachtwoord()))) {
            return SaveManager.loadUserData(gebruiker);
        }
        return null;
    }

    public void uploadData(DataObject data) {
        SaveData saveData = new SaveData();
        hashMap.put(data.id, data.type);
        mapje.put(hashMap, data);
        SaveManager.saveData(saveData, data);
    }
}
