import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Viktor on 14.01.2016.
 */
public class MainWindow extends JFrame {

    private Game game;

    public MainWindow() {
        super("Test window");
        game = null;
    }

    public MainWindow(Game game) {
        super("Test window");
        this.game = game;
    }

    public void drawWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 400);
        JPanel generalPanel = new JPanel(new BorderLayout());
        JButton gameEditor = new JButton("Game Editor");
        JButton fieldEditor = new JButton("Field Editor");

        fieldEditor.setMaximumSize(new Dimension(200, 50));

        JButton gameButton = new JButton("Game");
        gameEditor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameEditorWindow editorWindow = new GameEditorWindow(game);
                editorWindow.drawWindow();
                editorWindow.setVisible(true);
                setVisible(false);
            }
        });
        generalPanel.add(gameEditor, BorderLayout.NORTH);
        generalPanel.add(fieldEditor, BorderLayout.CENTER);
        generalPanel.add(gameButton, BorderLayout.SOUTH);




        add(generalPanel);
    }
}
