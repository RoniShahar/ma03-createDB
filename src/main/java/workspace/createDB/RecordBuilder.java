package workspace.createDB;

import java.util.ArrayList;
import java.util.Date;

public class RecordBuilder implements RecordBuilderFunctions {

    protected Record cells;

    public RecordBuilder() {
        this.cells = new Record();
        this.cells.stringCells = new ArrayList<>();
        this.cells.intCells = new ArrayList<>();
        this.cells.dateCells = new ArrayList<>();
    }

    public void prepareToNewRecord(){
        this.cells.stringCells.clear();
        this.cells.intCells.clear();
        this.cells.dateCells .clear();
    }

    @Override
    public void addStringField(String fieldName, String fieldValue) {
        this.cells.stringCells.add(new StringField(fieldName, fieldValue));
    }

    @Override
    public void addIntField(String fieldName, int fieldValue) {
        this.cells.intCells.add(new IntField(fieldName, fieldValue));
    }

    @Override
    public void addDateField(String fieldName, Date fieldValue) {
        this.cells.dateCells.add(new DateField(fieldName, fieldValue));
    }


}
