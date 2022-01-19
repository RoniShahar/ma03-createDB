package workspace.createDB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DB {

    protected String dbName;
    protected Map<String, Entity> entities;

    public DB(String dbName) {
        this.dbName = dbName;
        this.entities = new HashMap<>();
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getDbName() {
        return dbName;
    }

    public Map<String, Entity> getEntities() {
        return entities;
    }

    public void setEntities(Map<String, Entity> entities) {
        this.entities = entities;
    }
}
