package workspace.createDB;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        DBMS dbms = new DBMS("myDB");
        RecordBuilder recordBuilder = new RecordBuilder();
        dbms.createEntity("person");

        recordBuilder.prepareToNewRecord();
        recordBuilder.addStringField("ID", "12345");
        recordBuilder.addStringField("first_name", "roni");
        recordBuilder.addStringField("last_name", "shahar");
        recordBuilder.addDateField("birt_date", new Date(2003, 1, 21));
        recordBuilder.addIntField("house_number", 5);
        dbms.insertRecord("person", "12345", recordBuilder.cells);

        recordBuilder.prepareToNewRecord();
        recordBuilder.addStringField("ID", "5555");
        recordBuilder.addStringField("first_name", "daniel");
        recordBuilder.addStringField("last_name", "cohen");
        recordBuilder.addDateField("birt_date", new Date(2000, 1, 21));
        recordBuilder.addIntField("house_number", 15);
        dbms.insertRecord("person", "5555", recordBuilder.cells);

        List<String> field = new ArrayList<>();
        field.add("ID");
        field.add("last_name");

        Entity entity = dbms.selectSpecificFields("person", field);
        entity = dbms.whereFieldBiggerThan(entity, "last_name", "ddd");

    }
}
