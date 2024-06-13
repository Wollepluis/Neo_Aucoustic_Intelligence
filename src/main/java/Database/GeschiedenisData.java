package Database;

public class GeschiedenisData extends DataObject {
    private String inhoud;

    public String getInhoud() {
        return inhoud;
    }

    @Override
    public String toString() {
        return null;
    }
    @Override
    public void load(SaveData saveData) {
        super.load(saveData);
        inhoud = saveData.readAttribute("inhoud");
    }

    @Override
    public SaveData save() {
        SaveData saveData = super.save();
        saveData.addAttribute("inhoud", String.valueOf(inhoud));
        return saveData;
    }

}
