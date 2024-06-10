package Database;

import java.util.ArrayList;

public class UserData extends DataObject {
    private String gebruikersnaam;
    private String wachtwoord;
    private ArrayList<DataObject> chats;

    public UserData() {
        chats = new ArrayList<>();
    }
    public UserData(String gebruikersnaam, String wachtwoord) {
        this.id = gebruikersnaam;
        this.type = "UserData";
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
        chats = new ArrayList<>();
    }


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
    public DataObject getChat(DataObject dataObject) {
        return dataObject;
    }
    public void addChat(DataObject chatData) {
        chats.add(chatData);
    }
    public void getChats() {
        for (int i = 0; i < chats.size(); i++) {
            System.out.println(getChat(chats.get(i)).id);
            System.out.println(getChat(chats.get(i)).type);
        }
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ID: ").append(id).append("\n");
        stringBuilder.append("Type: ").append(type).append("\n");
        stringBuilder.append("Gebruikersnaam: ").append(gebruikersnaam).append("\n");
        stringBuilder.append("Wachtwoord: ").append(wachtwoord).append("\n");
        stringBuilder.append("Chat: \n");
        for (DataObject chat : chats) {
            stringBuilder.append(chat.toString()).append("\n");
        }
        return stringBuilder.toString();
    }



    @Override
    public void load(SaveData saveData) {
        super.load(saveData);
        gebruikersnaam = saveData.readAttribute("gebruikersnaam");
        wachtwoord = saveData.readAttribute("wachtwoord");
        int i = 0;
        while (true) {
            String chat = saveData.readAttribute("chat" + i);
            if (chat == null) return;
            addChat(SaveManager.loadDataObject(chat, "ChatData"));
            i++;
        }
    }

    @Override
    public SaveData save() {
        SaveData saveData = super.save();
        saveData.addAttribute("gebruikersnaam", String.valueOf(gebruikersnaam));
        saveData.addAttribute("wachtwoord", String.valueOf(wachtwoord));
        for(int i = 0; i < chats.size(); i++) {
            saveData.addAttribute("chat" + i, String.valueOf(chats.get(i).id));
        }
        return saveData;
    }
}
