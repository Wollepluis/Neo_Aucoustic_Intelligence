package Database;

public class GeschiedenisData extends DataObject {
    private String Inhoud;

    @Override
    public String toString() {
        return null;
    }
    @Override
    public void load(SaveData saveData) {
        super.load(saveData);
    }

    @Override
    public SaveData save() {
        SaveData saveData = super.save();
        return saveData;
    }

}
