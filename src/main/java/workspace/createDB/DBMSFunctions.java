package workspace.createDB;

import java.util.List;

public interface DBMSFunctions <T> {

    void createEntity(String entityName, Records records);
    void deleteEntity(String entityName);
    void insertRecord(String entityName, Records records);
    void deleteRecord(String entityName, T recordKey);
    void updateRecord(String entityName, Records records);
    Entity retrieveWholeEntity(String entityName);
    Records retrieveRecords(String entityName, List<String> fields);
}
