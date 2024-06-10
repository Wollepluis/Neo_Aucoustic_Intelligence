package Database;

public class ChatData extends DataObject {
    public String onderwerp;

    public ChatData() {

    }
    public ChatData(String onderwerp) {
        this.onderwerp = onderwerp;
    }

    @Override
    public String toString() {
        return null;
    }
    @Override
    public void load(SaveData saveData) {
        super.load(saveData);
        onderwerp = saveData.readAttribute("onderwerp");
    }
    @Override
    public SaveData save() {
        SaveData saveData = super.save();

        saveData.addAttribute("onderwerp", String.valueOf(onderwerp));
        return saveData;
    }
}
