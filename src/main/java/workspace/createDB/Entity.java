package workspace.createDB;

import java.util.HashMap;
import java.util.Map;

public class Entity <T>{

    public Entity() {
        this.records = new HashMap<>();
    }

    protected Map<T, Record> records;

    public Map<T, Record> getRecords() {
        return records;
    }

    public void setRecords(Map<T, Record> records) {
        this.records = records;
    }
}
