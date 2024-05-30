package events;

public class EventListenerExample {
    private int invokeCounter = 0;

    public int getInvocationCount(){
        return invokeCounter;
    }

    public void MethodToSubscribe(Object sender, EventArgs args){
        invokeCounter += 1;
    }
}
