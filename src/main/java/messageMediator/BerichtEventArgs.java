package messageMediator;

import events.EventArgs;

public class BerichtEventArgs extends EventArgs {
    public int chatID;

    // onderstaande regel geeft error omdat chat nog niet met de main gemerged is op moment van aanmaken van de branch
    //public Bericht bericht;
}
