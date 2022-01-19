package workspace.createDB;

import java.util.Map;

public class Records <T>{

    Map<T, Cells> records;

    public Map<T, Cells> getRecords() {
        return records;
    }

    public void setRecords(Map<T, Cells> records) {
        this.records = records;
    }
}
