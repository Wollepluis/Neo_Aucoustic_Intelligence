package Database;

import Events.EventArgs;
import MessageMediator.*;

import java.util.Map;

public class MockupDatabase extends Database {

    public MockupDatabase() {
        super();
        MessageMediator.krijgInstantie().opBerichtVerstuurd.subscribe(this::opBerichtVerstuurd);
    }

    @Override
    public DataObject getData(String id, String type) {
        hashMap.put(id, type);
        Map<String, String> key = hashMap;
        return mapje.get(key);
    }

    public void opBerichtVerstuurd(Object sender, EventArgs args){
        if (!(args instanceof BerichtEventArgs)) return;
        // TODO iemand moet dit ooit nog eens maken zodat opgeslagen wordt als verstuurd bericht wordtddt
    }

    /*
    public UserData getGebruiker(String gebruiker, String wachtwoord) {
        if(gebruiker.equals(SaveManager.loadUserData(gebruiker).getGebruikersnaam()) && (wachtwoord.equals(SaveManager.loadUserData(gebruiker).getWachtwoord()))) {
            return SaveManager.loadUserData(gebruiker);
        }
        return null;
    }*/

    public void uploadData(DataObject data, String dataType) {
        int size = hashMap.size() + 1;
        data.id = Integer.toString(size);
        SaveData saveData = new SaveData();
        hashMap.put(data.id, data.type);
        mapje.put(hashMap, data);
        SaveManager.saveData(saveData, data);
    }
}
