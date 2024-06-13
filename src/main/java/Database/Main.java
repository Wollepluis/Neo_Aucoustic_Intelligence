package Database;

public class Main {
    public static void main(String[] args) {

        System.out.println("HOOOOOOOOI");

        SaveManager.initialize();
        MockupDatabase mockupDatabase = new MockupDatabase();
        DataObject dataObject = new UserData("Mr. Vooijs","IkBenDik");
        SaveManager.saveData(dataObject.save(), dataObject);


    }
}
