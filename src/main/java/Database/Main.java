package Database;

public class Main {
    public static void main(String[] args) {
        SaveManager.initialize();
        UserData dataObject = new UserData("Morris","12345");
        DataObject dataObject1 = dataObject.chats.get(0);

        if (dataObject1 instanceof ChatData chatData) {
            System.out.println(chatData.onderwerp);
        }/* else if (dataObject instanceof GeschiedenisData data) {
            String ding = data.getInhoud();
            System.out.println(ding);
        }*/
        ;
    }
}
