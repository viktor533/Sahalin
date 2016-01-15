/**
 * Created by Viktor on 09.10.2015.
 */
public class Main {
    public static void main(String[] args) {
        Settings settings = new Settings();
        settings.setBuildingsFileName("buildings.txt");
        settings.setLandsFileName("Lands.txt");
        settings.setResourceFileName("resources.txt");
        Game game = new Game();
        game.setSettings(settings);
        game.readLands();

        MainWindow window = new MainWindow(game);
        window.drawWindow();
        window.setVisible(true);

//        Creator creator = new Creator();
//        creator.speaker();
    }
}
