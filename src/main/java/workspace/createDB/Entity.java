package workspace.createDB;

import java.util.HashMap;
import java.util.Map;

public class Entity <T>{

    protected HashMap<T, Record> entity;

    public Entity() {
        this.entity = new HashMap<>();
    }

    public HashMap<T, Record> getEntity() {
        return entity;
    }

    public void setEntity(HashMap<T, Record> entity) {
        this.entity = entity;
    }
}
