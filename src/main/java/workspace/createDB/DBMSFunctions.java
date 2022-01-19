package workspace.createDB;

import java.util.List;

public interface DBMSFunctions <T> {

    void createEntity(String entityName);
    void deleteEntity(String entityName);
    void insertRecord(String entityName, T key, Record cells);
    void deleteRecord(String entityName, T key);
    void updateRecord(String entityName, T key, Record cells);
}
