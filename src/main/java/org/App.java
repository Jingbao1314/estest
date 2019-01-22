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
        CreateIndex c=new CreateIndex();
        String[] s=("gid,one,two,three,brand,title,description,discount,price," +
                "pro_code,color,size,im").split("[,]");
        MyField []list=new MyField[s.length];
        MyField f;
        int flag=0;
        for (String x:s
             ) {
            System.out.println(x);
            f=new MyField();
            f.setFieldAnalyzer("ik_max_word");
            f.setFieldType("text");
            f.setFieldName(x);
            list[flag]=f;
            flag++;
        }
//        System.out.println( JsonUtil.toJson("goods",list));
        c.create("my0039","goods",JsonUtil.toJson("goods",list));
    }
}
