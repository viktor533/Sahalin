import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.text.DefaultStyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    private JPanel getLandList() {
        JPanel landList = new JPanel();
        landList.setLayout(new BoxLayout(landList, BoxLayout.Y_AXIS));
        JLabel landsNames[] = new JLabel[game.getLandsCount()];
        Iterator<Land> iterator = game.getLandsIterator();
        int i=0;
        while (iterator.hasNext()) {
            landsNames[i] = new JLabel();
            landsNames[i].setText(iterator.next().getName());
            landsNames[i].setMaximumSize(new Dimension(100, 30));
            System.out.println(landsNames[i].getText());
            landList.add(landsNames[i]);
            i++;
        }
        return landList;
    }

    private JPanel getLandList(JPanel landList) {
        landList.removeAll();
        JLabel landsNames[] = new JLabel[game.getLandsCount()];
        Iterator<Land> iterator = game.getLandsIterator();
        int i=0;
        while (iterator.hasNext()) {
            landsNames[i] = new JLabel();
            landsNames[i].setText(iterator.next().getName());
            landsNames[i].setMaximumSize(new Dimension(100, 30));
            System.out.println(landsNames[i].getText());
            landList.add(landsNames[i]);
            i++;
        }
        return landList;
    }

    private JPanel  landsTab() {
        JPanel lands = new JPanel();
        BoxLayout landLayout = new BoxLayout(lands, BoxLayout.Y_AXIS);
        lands.setLayout(landLayout);

        JPanel landList = getLandList();
        JPanel addArea = new JPanel();
        addArea.setLayout(new BoxLayout(addArea, BoxLayout.X_AXIS));

        JButton removeAllButton = new JButton("remove All");
        removeAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.clearLands();
                getLandList(landList);
                lands.updateUI();
            }
        });

        JButton updateButton = new JButton("update");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getLandList(landList);
                lands.updateUI();
            }
        });

        JTextField landName = new JTextField();
        JButton addButton = new JButton("add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!landName.getText().isEmpty()) {
                    game.addLand(landName.getText());
                    landList.add(new JLabel(landName.getText()));
                    lands.updateUI();
                    // TODO: Добавить функцию запоминания старой строки, для проверки отличая новой.
                } else {
                    JOptionPane.showMessageDialog(null, "You should edit name!");
                }
            }
        });

        addArea.add(removeAllButton);
        addArea.add(updateButton);
        addArea.add(landName);
        addArea.add(addButton);

        JPanel dallArea = new JPanel();
        dallArea.setLayout(new BoxLayout(dallArea, BoxLayout.X_AXIS));

        JButton del = new JButton("delete");
        del.setEnabled(false);

        lands.add(landList);
        lands.add(addArea);
        lands.add(dallArea);
        return lands;
    }

    private JPanel resourcesTab() {
        JPanel resources = new JPanel();
        resources.setLayout(new FlowLayout());

        return resources;
    }

    private JPanel buildingsTab() {
        JPanel buildings = new JPanel();
        buildings.setLayout(new FlowLayout());

        return buildings;
    }


    public void drawWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 400);
        JPanel generalPanel = new JPanel(new BorderLayout());

        JPanel lands = landsTab();
        JPanel resources = resourcesTab();
        JPanel buildings = buildingsTab();
// */
        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Lands", lands);
        tabs.addTab("Resources", resources);
        tabs.addTab("Buildings", buildings);
        generalPanel.add(tabs);
        add(generalPanel);
    }

}
