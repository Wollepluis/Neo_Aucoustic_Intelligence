package MessageMediator;

import Chat.Bericht;
import Events.EventArgs;

public class BerichtEventArgs extends EventArgs {
    public int chatID;
    public Bericht bericht;
}
