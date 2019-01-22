package util;

import field.MyField;

/**
 * @author jijngbao
 * @date 19-1-22
 */
public class JsonUtil {
    public static String toJson(String typeName, MyField [] fields){
        StringBuilder res=new StringBuilder();
        res.append("{\n \""+typeName+"\": {\n");
        res.append("    \"properties\": {\n" );
        int flag=0;
        for (MyField field:fields) {
            if (flag==fields.length-1){
                res.append("               \""+field.getFieldName()+"\":{\n");
                if (field.getFieldType()!=null&&field.getFieldType()!=""){
                    res.append("                   "+"\"type\":"+"\""+field.getFieldType()
                            +"\"");
                }
                if (field.getFieldAnalyzer()!=null&&field.getFieldAnalyzer()!=""){
                    res.append(",\n                   "+"\"analyzer\":"+"\""+field.getFieldAnalyzer()
                            +"\"");
                }
                res.append("\n                    }");



            }else {
                res.append("               \""+field.getFieldName()+"\":{\n");
                if (field.getFieldType()!=null&&field.getFieldType()!=""){
                    res.append("                   "+"\"type\":"+"\""+field.getFieldType()
                            +"\"");
                }
                if (field.getFieldAnalyzer()!=null&&field.getFieldAnalyzer()!=""){
                    res.append(",\n                   "+"\"analyzer\":"+"\""+field.getFieldAnalyzer()
                            +"\"");
                }
                res.append("\n                    },\n");

            }
            flag++;
        }
        res.append("\n       }\n");
        res.append("}\n");
        res.append("}\n");
//        System.out.println(res.toString());
        return res.toString();

    }

    public static void main(String[] args) {
        MyField field1=new MyField();
        field1.setFieldAnalyzer("1111111");
        field1.setFieldType("string");
        field1.setFieldName("qqqqqq");

        MyField field2=new MyField();
        field2.setFieldAnalyzer("22222222");
        field2.setFieldType("string");
        field1.setFieldName("yyyyy");
        MyField[] ls=new MyField[2];
        ls[0]=field1;
        ls[1]=field2;
        toJson("testxxxxx",ls);

//        StringBuilder res=new StringBuilder();
//        res.append("{\n \""+"xxx"+"\": {\n");
//        res.append("    \"properties\": {\n" );
//        res.append("               \""+"test"+"\"{\n");
//        res.append("                   \""+"test:test");
//        System.out.println(res.toString());
    }
}
