import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

/**
 * Created by Viktor on 14.01.2016.
 */
public class GameEditorWindow extends JFrame {

    private Game game;

    public GameEditorWindow(Game game) {
        super("Game Editor");
        this.game = game;
    }

    public void drawWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 400);
        JPanel generalPanel = new JPanel(new BorderLayout());

        JPanel lands = new JPanel();
        BoxLayout landLayout = new BoxLayout(lands, BoxLayout.Y_AXIS);
        lands.setLayout(landLayout);
        JPanel resources = new JPanel();
        resources.setLayout(new FlowLayout());

        JTextPane landsNames[] = new JTextPane[game.getLandsCount()];
        Iterator<Land> iterator = game.getLandsIterator();
        int i=0;
        while (iterator.hasNext()) {
            landsNames[i] = new JTextPane();
            landsNames[i].setText(iterator.next().getName());
            landsNames[i].setMaximumSize(new Dimension(100, 30));
            System.out.println(landsNames[i].getText());
            lands.add(landsNames[i]);
            i++;
        }
// */
        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Lands", lands);
        tabs.addTab("Resources", resources);
        generalPanel.add(tabs);
        add(generalPanel);
    }

}
