package workspace.createDB;

import java.util.ArrayList;
import java.util.List;

public class Record {

    protected List<StringField> stringCells;
    protected List<IntField> intCells;
    protected List<DateField> dateCells;

    public void setStringCells() {
        this.stringCells = new ArrayList<>();
        this.intCells = new ArrayList<>();
        this.dateCells = new ArrayList<>();
    }

    public void setIntCells(List<IntField> intCells) {
        this.intCells = intCells;
    }

    public void setDateCells(List<DateField> dateCells) {
        this.dateCells = dateCells;
    }

    public List<StringField> getStringCells() {
        return stringCells;
    }

    public List<IntField> getIntCells() {
        return intCells;
    }

    public List<DateField> getDateCells() {
        return dateCells;
    }

}
