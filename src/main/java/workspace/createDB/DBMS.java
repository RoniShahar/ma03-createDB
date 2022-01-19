package workspace.createDB;

import java.util.Date;
import java.util.List;

public class DBMS <T> implements DBMSFunctions{

    protected DB db;
    Message message;

    public DBMS(String dbName) {
        this.db = new DB(dbName);
        message = new Message();
    }


    @Override
    public void createEntity(String entityName) {
        db.entities.put(entityName, new Entity());
    }

    @Override
    public void insertRecord(String entityName, Object key, Record record) {
       if(db.entities.containsKey(entityName)){
           db.entities.get(entityName).getEntity().put(key, record);
       } else {
           message.printEntityNotFoundMessage(entityName, db.dbName);
       }
    }

    @Override
    public void deleteEntity(String entityName) {
        if(db.entities.containsKey(entityName)){
            db.entities.remove(entityName);
        } else {
            message.printEntityNotFoundMessage(entityName, db.dbName);
        }
    }

    @Override
    public void deleteRecord(String entityName, Object key) {
        if(db.entities.containsKey(entityName)){
            db.entities.get(entityName).getEntity().remove(key);
        } else {
            message.printEntityNotFoundMessage(entityName, db.dbName);
        }
    }

    @Override
    public void updateRecord(String entityName, Object key, Record cells) {
        if(db.entities.containsKey(entityName)){
            if(db.entities.get(entityName).getEntity().containsKey(key)){
                for (StringField stringField:cells.getStringCells()) {
                    for (int i = 0; i < ((Record)db.entities.get(entityName).getEntity().get(key)).getStringCells().size(); i++) {
                        if(stringField.fieldName.equals(((Record)db.entities.get(entityName).getEntity().get(key)).getStringCells().get(i).fieldName)){
                            ((Record)db.entities.get(entityName).getEntity().get(key)).getStringCells().get(i).setFieldValue(stringField.fieldValue);
                        }
                    }
                }

                for (IntField intField:cells.getIntCells()) {
                    for (int i = 0; i < ((Record)db.entities.get(entityName).getEntity().get(key)).getIntCells().size(); i++) {
                        if(intField.fieldName.equals(((Record)db.entities.get(entityName).getEntity().get(key)).getIntCells().get(i).fieldName)){
                            ((Record)db.entities.get(entityName).getEntity().get(key)).getIntCells().get(i).setFieldValue(intField.fieldValue);
                        }
                    }
                }

                for (DateField dateField:cells.getDateCells()) {
                    for (int i = 0; i < ((Record)db.entities.get(entityName).getEntity().get(key)).getDateCells().size(); i++) {
                        if(dateField.fieldName.equals(((Record)db.entities.get(entityName).getEntity().get(key)).getDateCells().get(i).fieldName)){
                            ((Record)db.entities.get(entityName).getEntity().get(key)).getDateCells().get(i).setFieldValue(dateField.fieldValue);
                        }
                    }
                }
            }
            else {
              message.printKeyNotFoundMessage(entityName, key);
            }
        } else {
            message.printEntityNotFoundMessage(entityName, db.dbName);
        }
    }
}
