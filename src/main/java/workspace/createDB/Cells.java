package workspace.createDB;

import java.util.List;

public class Cells {

    protected List<StringField> stringCells;
    protected List<IntField> intCells;
    protected List<DateField> dateCells;

    public void setStringCells(List<StringField> stringCells) {
        this.stringCells = stringCells;
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
