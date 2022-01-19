package workspace.createDB;

import java.util.List;
import java.util.Map;

public class Entity {

    Map<String, List<Records>> entities;

    public Map<String, List<Records>> getEntities() {
        return entities;
    }

    public void setEntities(Map<String, List<Records>> entities) {
        this.entities = entities;
    }
}
