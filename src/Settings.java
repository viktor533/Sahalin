/**
 * Created by Viktor on 14.01.2016.
 */
public class Settings {
    private String landsFileName;
    private String buildingsFileName;
    private String resourceFileName;

    public Settings() {
        landsFileName = null;
        buildingsFileName = null;
        resourceFileName = null;
    }

    public String getLandsFileName() {
        return landsFileName;
    }

    public void setLandsFileName(String landsFileName) {
        this.landsFileName = landsFileName;
    }

    public String getBuildingsFileName() {
        return buildingsFileName;
    }

    public void setBuildingsFileName(String buildingsFileName) {
        this.buildingsFileName = buildingsFileName;
    }

    public String getResourceFileName() {
        return resourceFileName;
    }

    public void setResourceFileName(String resourceFileName) {
        this.resourceFileName = resourceFileName;
    }
}
