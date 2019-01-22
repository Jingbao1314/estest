package field;

/**
 * @author jijngbao
 * @date 19-1-22
 */
public class MyField {
    private String fieldName;
    private String fieldType;
    private String fieldAnalyzer;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public String getFieldAnalyzer() {
        return fieldAnalyzer;
    }

    public void setFieldAnalyzer(String fieldAnalyzer) {
        this.fieldAnalyzer = fieldAnalyzer;
    }
}
