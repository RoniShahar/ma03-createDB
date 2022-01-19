package workspace.createDB;

import java.util.Date;

public interface RecordBuilderFunctions {
    
    void addStringField(String fieldName, String fieldValue);
    void addIntField(String fieldName, int fieldValue);
    void addDateField(String fieldName, Date fieldValue);
}
