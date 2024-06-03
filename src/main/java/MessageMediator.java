public final class MessageMediator extends Chat extends AiModel extends Database{

    private static MessageMediator instance;



    public static MessageMediator getInstance(){
        if (instance == null){
            instance = new MessageMediator();
        }
        return instance;
    }

    private MessageMediator(){

    }
}

