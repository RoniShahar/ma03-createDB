package workspace.createDB;

import java.util.Date;

public class DateField extends FieldName {

    protected Date fieldValue;

    public DateField(String fieldName, Date fieldValue) {
        super(fieldName);
        this.fieldValue = fieldValue;
    }

    public Date getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(Date fieldValue) {
        this.fieldValue = fieldValue;
    }
}
