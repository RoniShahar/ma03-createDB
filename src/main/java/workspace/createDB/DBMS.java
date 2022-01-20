package workspace.createDB;

import java.util.ArrayList;
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

    @Override
    public Entity selectWholeEntity(String entityName) {
        if(db.entities.containsKey(entityName)){
            return db.entities.get(entityName);
        } else {
            message.printEntityNotFoundMessage(entityName, db.dbName);
            return null;
        }
    }


    @Override
    public Entity whereFieldBiggerThan(Entity entity, String fieldName, Object value) {
        Entity selectEntity = new Entity<>();
        Record record = new Record();
        List<StringField> stringFields;
        List<IntField> intFields;
        List<DateField> dateFields;

        for (Object key : entity.getEntity().keySet()) {

            stringFields = new ArrayList<>();
            intFields = new ArrayList<>();
            dateFields = new ArrayList<>();
            for (int i = 0; i < ((Record) entity.getEntity().get(key)).getStringCells().size(); i++) {
                if (fieldName.equals(((Record) entity.getEntity().get(key)).getStringCells().get(i).fieldName)) {
                    if (((Record) entity.getEntity().get(key)).getStringCells().get(i).fieldValue.compareTo(String.valueOf(value)) > 0) {
                        stringFields.add(((Record)entity.getEntity().get(key)).getStringCells().get(i));
                        intFields = ((Record)entity.getEntity().get(key)).getIntCells();
                        dateFields = ((Record)entity.getEntity().get(key)).getDateCells();
                    }
                }
            }
            record.setStringCells(stringFields);
            record.setIntCells(intFields);
            record.setDateCells(dateFields);

            selectEntity.getEntity().put(key, record);
        }

        for (Object key : entity.getEntity().keySet()) {

            stringFields = new ArrayList<>();
            intFields = new ArrayList<>();
            dateFields = new ArrayList<>();
            for (int i = 0; i < ((Record) entity.getEntity().get(key)).getIntCells().size(); i++) {
                if (fieldName.equals(((Record) entity.getEntity().get(key)).getIntCells().get(i).fieldName)) {
                    if (((Object)((Record) entity.getEntity().get(key)).getIntCells().get(i).fieldValue).equals(value)) {
                        stringFields = ((Record)entity.getEntity().get(key)).getStringCells();
                        intFields.add(((Record)entity.getEntity().get(key)).getIntCells().get(i));
                        dateFields = ((Record)entity.getEntity().get(key)).getDateCells();
                    }
                }
            }
            record.setStringCells(stringFields);
            record.setIntCells(intFields);
            record.setDateCells(dateFields);

            selectEntity.getEntity().put(key, record);
        }

        for (Object key : entity.getEntity().keySet()) {

            stringFields = new ArrayList<>();
            intFields = new ArrayList<>();
            dateFields = new ArrayList<>();
            for (int i = 0; i < ((Record) entity.getEntity().get(key)).getDateCells().size(); i++) {
                if (fieldName.equals(((Record) entity.getEntity().get(key)).getDateCells().get(i).fieldName)) {
                    if (((Record) entity.getEntity().get(key)).getDateCells().get(i).fieldValue.compareTo((Date) value) > 0) {
                        stringFields = ((Record)entity.getEntity().get(key)).getStringCells();
                        intFields = ((Record)entity.getEntity().get(key)).getIntCells();
                        dateFields.add(((Record)entity.getEntity().get(key)).getDateCells().get(i));
                    }
                }
            }
            record.setStringCells(stringFields);
            record.setIntCells(intFields);
            record.setDateCells(dateFields);

            selectEntity.getEntity().put(key, record);
        }

        return selectEntity;
    }

    @Override
    public Entity joinEntity(String fieldName, String entityName1, List fieldsNames1, String entityName2, List fieldsNames2) {

        return null;
    }


    @Override
    public Entity selectSpecificFields(String entityName, List fieldsNames) {
        if(db.entities.containsKey(entityName)){

            Entity selectEntity = new Entity<>();
            Record record = new Record();
            List<StringField> stringFields;
            List<IntField> intFields;
            List<DateField> dateFields;

            for (Object key:db.entities.get(entityName).getEntity().keySet()) {
                stringFields = new ArrayList<>();
                intFields = new ArrayList<>();
                dateFields = new ArrayList<>();

                for (Object fieldName:fieldsNames) {
                    for (int i = 0; i < ((Record) db.entities.get(entityName).getEntity().get(key)).getStringCells().size(); i++) {
                        if (fieldName.equals(((Record) db.entities.get(entityName).getEntity().get(key)).getStringCells().get(i).fieldName)) {
                            String s = ((Record) db.entities.get(entityName).getEntity().get(key)).getStringCells().get(i).fieldValue;
                            stringFields.add(((Record) db.entities.get(entityName).getEntity().get(key)).getStringCells().get(i));
                        }
                    }

                    for (int i = 0; i < ((Record) db.entities.get(entityName).getEntity().get(key)).getIntCells().size(); i++) {
                        if (fieldName.equals(((Record) db.entities.get(entityName).getEntity().get(key)).getIntCells().get(i).fieldName)) {
                            intFields.add(((Record) db.entities.get(entityName).getEntity().get(key)).getIntCells().get(i));
                        }
                    }


                    for (int i = 0; i < ((Record) db.entities.get(entityName).getEntity().get(key)).getDateCells().size(); i++) {
                        if (fieldName.equals(((Record) db.entities.get(entityName).getEntity().get(key)).getDateCells().get(i).fieldName)) {
                            dateFields.add(((Record) db.entities.get(entityName).getEntity().get(key)).getDateCells().get(i));
                        }
                    }
                }

                record.setStringCells(stringFields);
                record.setIntCells(intFields);
                record.setDateCells(dateFields);

                selectEntity.getEntity().put(key, record);
            }

            return selectEntity;
        } else {
            message.printEntityNotFoundMessage(entityName, db.dbName);
            return null;
        }
    }
}
