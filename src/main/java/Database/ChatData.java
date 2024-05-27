package Database;

public class ChatData extends DataObject {
    private int chatID;
    private String onderwerp;

    @Override
    public String toString() {
        return null;
    }
    @Override
    public void load(SaveData saveData) {
        super.load(saveData);
        chatID = Integer.parseInt(saveData.readAttribute("chatID"));
        onderwerp = saveData.readAttribute("onderwerp");
    }
    @Override
    public SaveData save() {
        SaveData saveData = super.save();
        saveData.addAttribute("chatID", String.valueOf(Integer.valueOf(chatID)));
        saveData.addAttribute("onderwerp", String.valueOf(onderwerp));
        return saveData;
    }
}
