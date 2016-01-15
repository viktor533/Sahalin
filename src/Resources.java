import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by Viktor on 05.10.2015.
 */
public class Resources {
    private ArrayList<Resource> resources;

    public Resources() {
        resources = new ArrayList<Resource>();
    }

    public void add(String name) {
        resources.add(new Resource(name));
    }

    public Resource get (int index) {
        return resources.get(index);
    }

    public Iterator<Resource> getIterator() {
        return resources.iterator();
    }

    public int getCount() { return resources.size(); }

    public void readFromFile(String name) {
        Scanner in = null;
        // TODO: cath name is null
        try {
            in = new Scanner(new File(name));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        while (in.hasNext()) {
            resources.add(new Resource(in.next()));
        }
    }

}
