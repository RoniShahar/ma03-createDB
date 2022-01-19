package workspace.createDB;

import java.util.List;

public class DBMS implements DBMSFunctions{
    @Override
    public void createEntity(String entityName, Records records) {

    }

    @Override
    public void deleteEntity(String entityName) {

    }

    @Override
    public void insertRecord(String entityName, Records records) {

    }

    @Override
    public void deleteRecord(String entityName, Object recordKey) {

    }

    @Override
    public void updateRecord(String entityName, Records records) {

    }

    @Override
    public Entity retrieveWholeEntity(String entityName) {
        return null;
    }

    @Override
    public Records retrieveRecords(String entityName, List fields) {
        return null;
    }
}
