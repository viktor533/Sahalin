import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by Viktor on 05.10.2015.
 */
public class Lands {
    private ArrayList<Land> lands;

    public Lands() {
        lands = new ArrayList<Land>();
    }

    public void add (String name) {
        lands.add(new Land(name));
    }

    public Iterator<Land> getIterator() { return lands.iterator(); }

    public int getCount() { return lands.size(); }

    public Land get(int index) {
        return lands.get(index);
    }

    public void readFromFile(String name) {
        Scanner in = null;
        // TODO: cath name is null
        try {
            in = new Scanner(new File(name));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        while (in.hasNext()) {
            lands.add(new Land(in.next()));
        }
    }

}
