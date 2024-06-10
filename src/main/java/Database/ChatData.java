package Database;

import java.util.ArrayList;

public class ChatData extends DataObject {
    public String onderwerp;
    ArrayList<DataObject> berichten;
    public ChatData() {
        berichten = new ArrayList<>();
    }
    public ChatData(String onderwerp) {
        this.onderwerp = onderwerp;
        berichten = new ArrayList<>();
    }

    public void addBericht(DataObject dataObject) {
        berichten.add(dataObject);
    }

    @Override
    public String toString() {
        return null;
    }
    @Override
    public void load(SaveData saveData) {
        super.load(saveData);
        onderwerp = saveData.readAttribute("onderwerp");
        int i = 0;
        while (true) {
            String bericht = saveData.readAttribute("bericht" + i);
            if (bericht == null) return;
            addBericht(SaveManager.loadDataObject(bericht, "GeschiedenisData"));
            i++;
        }
    }
    @Override
    public SaveData save() {
        SaveData saveData = super.save();
        saveData.addAttribute("onderwerp", String.valueOf(onderwerp));
        for(int i = 0; i < berichten.size(); i++) {
            saveData.addAttribute("bericht" + i, String.valueOf(berichten.get(i).id));
        }
        return saveData;
    }
}
