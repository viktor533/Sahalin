import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by Viktor on 05.10.2015.
 */
public class Builds {
    private HashMap<String, Build> builds;
    private boolean isLeaveOnLands;

    public Builds () {
        builds = new HashMap<String, Build>();
    }

    public void addBuild(String name) {
        builds.put(name, new Build(name));
    }

    public Build getBuild (String name) {
        return builds.get(name);
    }

    public boolean isAllCoastSeted(Iterator<Resource> resourceIterator) {
        Resource courent;
        Iterator<Build> buildIterator;
        while (resourceIterator.hasNext()) {
            courent = resourceIterator.next();
            buildIterator = builds.values().iterator();
            while (buildIterator.hasNext()) {
                if (buildIterator.next().getCost(courent) == -1)
                    return false;
            }
        }
        return true;
    }

    public void setNotCoastToZero(Iterator<Resource> iterator) {
        Resource courent;
        while (iterator.hasNext()) {
            courent = iterator.next();
            for (int i = 0; i < builds.size(); i++) {
                if (builds.get(i).getCost(courent) == -1)
                    builds.get(i).setCoast(courent, 0);
            }
        }
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
            in.next();
        }
    }


}
