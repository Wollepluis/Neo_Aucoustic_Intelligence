package Database;

public class UserData extends DataObject {
    private String gebruikersnaam;
    private String wachtwoord;

    public String getGebruikersnaam() {
        return gebruikersnaam;
    }

    public void setGebruikersnaam(String gebruikersnaam) {
        this.gebruikersnaam = gebruikersnaam;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }
    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    public String toString() {
        return null;
    }


    @Override
    public void load(SaveData saveData) {
        super.load(saveData);
        gebruikersnaam = saveData.readAttribute("gebruikersnaam");
        wachtwoord = saveData.readAttribute("wachtwoord");
    }
    @Override
    public SaveData save() {
        SaveData saveData = super.save();
        saveData.addAttribute("gebruikersnaam", String.valueOf(gebruikersnaam));
        saveData.addAttribute("wachtwoord", String.valueOf(wachtwoord));
        return saveData;
    }
}
