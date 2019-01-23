package util;

import codeGeneration.Analyzer;
import indexDocument.IndexDocument;
import pojo.MyJson;
import pojo.SearchTitan;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author jijngbao
 * @date 19-1-22
 */
public class FileUtil {
    public static void run(String path) throws IOException,
            NoSuchMethodException,
            ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException {
        BufferedReader reader=new BufferedReader(new FileReader(path));
        String line="";
        String data="";
        int flag=0;
        Analyzer analyzer=new Analyzer();
        Class clazz=null;
        Method method = null;
        while ((line=reader.readLine())!=null){
            if (flag==0){
                String[] list=line.split("[,]");
                clazz=analyzer.doAnalyzer(line,"goods");
                method=clazz.getMethod("getGoods", String[].class);
//                    MyJson obj= (MyJson) method.invoke(null, new Object[]{list});
//                    System.out.println(obj.toJson(c));

            }else {
                MyJson obj= (MyJson) method.invoke(null, new
                        Object[]{line.split("[,]")});
                IndexDocument.put("my0039",obj.toJson(clazz));
            }
            flag++;
//            if (line.substring(0,6)=="goods:"){
//                if (flag==1){
//                    data=data+line;
//                }else {
//                    MyJson obj= (MyJson) method.invoke(null, new
//                            Object[]{line.split("[,]")});
//                    IndexDocument.put("my0039",obj.toJson(clazz));
//
//                }
//                flag++;
//
//
//            }else {
//                if (flag==0){
//                    String[] list=data.split("[,]");
//                    clazz=analyzer.doAnalyzer(line,"goods");
//                    method=clazz.getMethod("getGoods", String[].class);
////                    MyJson obj= (MyJson) method.invoke(null, new Object[]{list});
////                    System.out.println(obj.toJson(c));
//
//                }else {
//                    data=data+line;
//                }
//                flag++;
//            }

        }
    }


    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, IOException, InstantiationException {
        run("/home/jingbao/code/elastic/src/main/java/util/business.csv");
    }
}
