package Database;

public abstract class DataObject implements ISaveable {
    public String id;
    public String type;
    public abstract String toString();
    public void load(SaveData saveData) {
        id = saveData.readAttribute("id");
        type = saveData.readAttribute("type");
    }
    public SaveData save(){
        SaveData saveData = new SaveData();
        saveData.addAttribute("id", String.valueOf(id));
        saveData.addAttribute("type", String.valueOf(type));
        return saveData;
    }
}
