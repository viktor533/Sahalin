import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Viktor on 05.10.2015.
 */
public class Build {
    private String name;
    private HashMap<Resource, Integer> cost;
    private int live;
    private int Number;

    public Build (String name) {
        this.name = name;
        cost = new HashMap<Resource, Integer>();
    }

    public void changeCost(Resource resource, int value) {
        if (cost.containsValue(resource)) {
            cost.replace(resource, value);
        } else {
            cost.put(resource, value);
        }
    }

    public int getCost(Resource resource) {
        if (cost.containsValue(resource)) {
            return cost.get(resource).intValue();
        } else {
            return -1;
        }
    }

    public void setCoast(Resource resource, int setCost) {
        this.cost.put(resource, new Integer(setCost));
    }

    public int getLive() {
        return live;
    }

    public void setLive(int live) {
        this.live = live;
    }

    //public
}
