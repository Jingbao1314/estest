package org;

import createIndex.CreateIndex;
import field.MyField;
import util.JsonUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String a=
                "  \"hits\": {\n" +
                "    \"total\": 3,\n" +
                "    \"max_score\": 1.2347561,\n" +
                "    \"hits\": [\n" +
                "      {\n" +
                "        \"_index\": \"my0039\",\n" +
                "        \"_type\": \"goods\",\n" +
                "        \"_id\": \"6jXbdGgBeG4rlHrlQlSP\",\n" +
                "        \"_score\": 1.2347561,\n" +
                "        \"_source\": {\n" +
                "          \"gid\": \"goods:00000007\",\n" +
                "          \"one\": \"男士\",\n" +
                "          \"two\": \"鞋子\",\n" +
                "          \"three\": \"系带鞋\",\n" +
                "          \"brand\": \"CHURCH'S\",\n" +
                "          \"title\": \"CHURCH'S 男士经典款绒面绑带鞋绑带正装鞋\",\n" +
                "          \"description\": \"Applications: brogue details<br />Closure: laces<br />Fit: G<br />Heel: flat<br />Heel type: block heel  flat<br />Pattern: solid colour<br />Sole: rubber sole<br />Toe: round towline<br />Type: heeled brogues<br>Materials: Suede<br>\",\n" +
                "          \"discount\": \"2044\",\n" +
                "          \"price\": \"4212\",\n" +
                "          \"pro_code\": \"ORBY622670GRIGIO\",\n" +
                "          \"color\": \"灰色\"\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"_index\": \"my0039\",\n" +
                "        \"_type\": \"goods\",\n" +
                "        \"_id\": \"5zXbdGgBeG4rlHrlQVR-\",\n" +
                "        \"_score\": 0.5539618,\n" +
                "        \"_source\": {\n" +
                "          \"gid\": \"goods:00000004\",\n" +
                "          \"one\": \"男士\",\n" +
                "          \"two\": \"鞋子\",\n" +
                "          \"three\": \"系带鞋\",\n" +
                "          \"brand\": \"CHURCH'S\",\n" +
                "          \"title\": \"CHURCH'S 男士经典款绒面绑带鞋绑带正装鞋\",\n" +
                "          \"description\": \"Applications: brogue details<br />Closure: laces<br />Fit: G<br />Heel: block heel<br />Pattern: solid colour<br />Sole: rubber sole<br />Toe: round towline<br />Type: lace up shoes<br>Materials: Suede<br>\",\n" +
                "          \"discount\": \"3422\",\n" +
                "          \"price\": \"4408\",\n" +
                "          \"pro_code\": \"NEWARKF0AQYMARRONE\",\n" +
                "          \"color\": \"棕色\"\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"_index\": \"my0039\",\n" +
                "        \"_type\": \"goods\",\n" +
                "        \"_id\": \"6TXbdGgBeG4rlHrlQlQ4\",\n" +
                "        \"_score\": 0.5539618,\n" +
                "        \"_source\": {\n" +
                "          \"gid\": \"goods:00000006\",\n" +
                "          \"one\": \"男士\",\n" +
                "          \"two\": \"鞋子\",\n" +
                "          \"three\": \"系带鞋\",\n" +
                "          \"brand\": \"CHURCH'S\",\n" +
                "          \"title\": \"CHURCH'S 男士经典款绒面绑带鞋绑带正装鞋\",\n" +
                "          \"description\": \"Applications: brogue details<br />Closure: laces<br />Fit: G<br />Heel: flat<br />Heel type: block heel  flat<br />Pattern: solid colour<br />Sole: rubber sole<br />Toe: round towline<br />Type: heeled brogues<br>Materials: Suede<br>\",\n" +
                "          \"discount\": \"2044\",\n" +
                "          \"price\": \"4212\",\n" +
                "          \"pro_code\": \"ORBY622639BLU\",\n" +
                "          \"color\": \"蓝色\"\n" +
                "        }\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "}";
        String b=
                "  \"hits\": {\n" +
                "    \"total\": 3,\n" +
                "    \"max_score\": 1.2347561,\n" +
                "    \"hits\": [\n" +
                "      {\n" +
                "        \"_index\": \"my0039\",\n" +
                "        \"_type\": \"goods\",\n" +
                "        \"_id\": \"6jXbdGgBeG4rlHrlQlSP\",\n" +
                "        \"_score\": 1.2347561,\n" +
                "        \"_source\": {\n" +
                "          \"gid\": \"goods:00000007\",\n" +
                "          \"one\": \"男士\",\n" +
                "          \"two\": \"鞋子\",\n" +
                "          \"three\": \"系带鞋\",\n" +
                "          \"brand\": \"CHURCH'S\",\n" +
                "          \"title\": \"CHURCH'S 男士经典款绒面绑带鞋绑带正装鞋\",\n" +
                "          \"description\": \"Applications: brogue details<br />Closure: laces<br />Fit: G<br />Heel: flat<br />Heel type: block heel  flat<br />Pattern: solid colour<br />Sole: rubber sole<br />Toe: round towline<br />Type: heeled brogues<br>Materials: Suede<br>\",\n" +
                "          \"discount\": \"2044\",\n" +
                "          \"price\": \"4212\",\n" +
                "          \"pro_code\": \"ORBY622670GRIGIO\",\n" +
                "          \"color\": \"灰色\"\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"_index\": \"my0039\",\n" +
                "        \"_type\": \"goods\",\n" +
                "        \"_id\": \"5zXbdGgBeG4rlHrlQVR-\",\n" +
                "        \"_score\": 0.5539618,\n" +
                "        \"_source\": {\n" +
                "          \"gid\": \"goods:00000004\",\n" +
                "          \"one\": \"男士\",\n" +
                "          \"two\": \"鞋子\",\n" +
                "          \"three\": \"系带鞋\",\n" +
                "          \"brand\": \"CHURCH'S\",\n" +
                "          \"title\": \"CHURCH'S 男士经典款绒面绑带鞋绑带正装鞋\",\n" +
                "          \"description\": \"Applications: brogue details<br />Closure: laces<br />Fit: G<br />Heel: block heel<br />Pattern: solid colour<br />Sole: rubber sole<br />Toe: round towline<br />Type: lace up shoes<br>Materials: Suede<br>\",\n" +
                "          \"discount\": \"3422\",\n" +
                "          \"price\": \"4408\",\n" +
                "          \"pro_code\": \"NEWARKF0AQYMARRONE\",\n" +
                "          \"color\": \"棕色\"\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"_index\": \"my0039\",\n" +
                "        \"_type\": \"goods\",\n" +
                "        \"_id\": \"6TXbdGgBeG4rlHrlQlQ4\",\n" +
                "        \"_score\": 0.5539618,\n" +
                "        \"_source\": {\n" +
                "          \"gid\": \"goods:00000006\",\n" +
                "          \"one\": \"男士\",\n" +
                "          \"two\": \"鞋子\",\n" +
                "          \"three\": \"系带鞋\",\n" +
                "          \"brand\": \"CHURCH'S\",\n" +
                "          \"title\": \"CHURCH'S 男士经典款绒面绑带鞋绑带正装鞋\",\n" +
                "          \"description\": \"Applications: brogue details<br />Closure: laces<br />Fit: G<br />Heel: flat<br />Heel type: block heel  flat<br />Pattern: solid colour<br />Sole: rubber sole<br />Toe: round towline<br />Type: heeled brogues<br>Materials: Suede<br>\",\n" +
                "          \"discount\": \"2044\",\n" +
                "          \"price\": \"4212\",\n" +
                "          \"pro_code\": \"ORBY622639BLU\",\n" +
                "          \"color\": \"蓝色\"\n" +
                "        }\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "}";
        System.out.println(a.equals(b));
//        CreateIndex c=new CreateIndex();
//        String[] s=("gid,one,two,three,brand,title,description,discount,price," +
//                "pro_code,color,size,im").split("[,]");
//        MyField []list=new MyField[s.length];
//        MyField f;
//        int flag=0;
//        for (String x:s
//             ) {
//            System.out.println(x);
//            f=new MyField();
//            f.setFieldAnalyzer("ik_max_word");
//            f.setFieldType("text");
//            f.setFieldName(x);
//            list[flag]=f;
//            flag++;
//        }
////        System.out.println( JsonUtil.toJson("goods",list));
//        c.create("my0039","goods",JsonUtil.toJson("goods",list));
    }
}
