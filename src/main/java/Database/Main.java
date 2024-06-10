package Database;

public class Main {
    public static void main(String[] args) {
        SaveManager.initialize();
        MockupDatabase mockupDatabase = new MockupDatabase();
        DataObject dataObject = new UserData("Mr. Vooijs","IkBenDik");
        SaveManager.saveData(dataObject.save(), dataObject);


    }
}
