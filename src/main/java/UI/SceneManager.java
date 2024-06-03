package UI;

public final class SceneManager {
    private static SceneManager instance;

    

    public static SceneManager getInstance() {
        if (instance == null) {
            instance = new SceneManager();
        }
        return instance;
    }
}
