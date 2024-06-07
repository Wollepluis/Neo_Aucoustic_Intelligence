package messageMediator;

import Chat.Bericht;
import events.EventArgs;

public class BerichtEventArgs extends EventArgs {
    public int chatID;
    public Bericht bericht;
}
