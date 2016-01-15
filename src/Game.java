import java.util.Iterator;

/**
 * Created by Viktor on 09.10.2015.
 */
public class Game {
    private Lands lands;
    private Resources resources;
    private Builds builds;
    private Settings settings;

    public Game() {
        lands = new Lands();
        resources = new Resources();
        builds = new Builds();
    }

    public void addLand(String name) {
        lands.add(name);
    }

    public void addResource(String name) {
        resources.add(name);
    }

    public void addBuild(String name) {
        builds.addBuild(name);
    }

    public void setBuildCost(String name, Resource resource, int cost) {
        builds.getBuild(name).setCoast(resource, cost);
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public void readLands() {
        lands.readFromFile(settings.getLandsFileName());
    }

    public void setResources() {
        resources.readFromFile(settings.getResourceFileName());
    }

    public int getLandsCount() { return lands.getCount(); }

    public int getResourcesCount() { return resources.getCount(); }

    public boolean isAllCostSeted() {
        return builds.isAllCoastSeted(resources.getIterator());
    }

    public Iterator<Resource> getResourceIterator() {
        return resources.getIterator();
    }

    public Iterator<Land> getLandsIterator() { return  lands.getIterator(); }
}
