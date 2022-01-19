package workspace.createDB;

public class StringField extends FieldName{

    protected String fieldValue;

    public StringField(String fieldName, String fieldValue) {
        super(fieldName);
        this.fieldValue = fieldValue;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }
}
