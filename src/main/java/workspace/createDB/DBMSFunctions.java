package workspace.createDB;

import java.util.List;

public interface DBMSFunctions <T> {

    void createEntity(String entityName);
    void deleteEntity(String entityName);
    void insertRecord(String entityName, T key, Record cells);
    void deleteRecord(String entityName, T key);
    void updateRecord(String entityName, T key, Record cells);
    Entity selectWholeEntity(String entityName);
    Entity selectSpecificFields(String entityName, List<String> fieldsNames);
    Entity whereFieldBiggerThan(Entity entity, String fieldName, T value);
    Entity joinEntity(String fieldName, String entityName1, List<String> fieldsNames1, String entityName2, List<String> fieldsNames2);
}
