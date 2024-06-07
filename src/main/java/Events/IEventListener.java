package Events;

@FunctionalInterface
public interface IEventListener {
    public void invoke(Object sender, EventArgs args);
}
