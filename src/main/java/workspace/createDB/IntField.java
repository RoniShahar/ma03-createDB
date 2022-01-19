package workspace.createDB;

public class IntField extends FieldName{

    protected int fieldValue;

    public IntField(String filedName, Integer fieldValue) {
        super(filedName);
        this.fieldValue = fieldValue;
    }

    public int getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(int fieldValue) {
        this.fieldValue = fieldValue;
    }
}
