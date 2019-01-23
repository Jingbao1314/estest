package codeGeneration;

import pojo.MyJson;
import pojo.SearchTitan;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * @author jijngbao
 * @date 19-1-22
 */
public class Analyzer {
    public Class doAnalyzer(String data,String className) throws IOException,
            ClassNotFoundException {
        className=className.substring(0,1)
                .toUpperCase()+className.substring(1,className.length());
        analyzer(data,className);
        return new MyClassLoder().loadClass("pojo."+className);

    }


//    public static HashMap<String,String> map=new HashMap<>();
    private void analyzer(String data,String className) throws IOException {
//        String key="set";
//        className=className.substring(0,1)
//                .toUpperCase()+className.substring(1,className.length());
        String result="";
        FileChannel outChnall=new FileOutputStream(new File
                ("/home/jingbao/code/elastic/src/main/java/pojo/"+className
                        +".java"))
                .getChannel();
        ByteBuffer buff=ByteBuffer.allocate(1024*3);
        Charset charset=Charset.forName("utf-8");
        String[] list=data.split("[,]");
        System.out.println(list.length);
        String head="package pojo;"+"\r\n"+"public class "+className+" " +
                "extends" +
                " " +
                "MyJson{"
                +"\r\n"+"    public "+className+"(){}";
//        String head="package pojo;"+"\r\n"+"public class "+className+"{"
//                +"\r\n"+"    public "+className+"(){}";
        String body="private String ";
        String shadow="}";
        String getMethod="public String get";
        String setMethod="public void set";
        String getGoods="public static "+className+
                " get"+className+"(String [] data)" +
                "{\r\n"+"        "+className+" obj=new "+className+"();\r\n"+"        ";
//        String getGoods="public static "+className+
//                " get"+className+"(String [] data)" +
//                "{\r\n"+"        ";
        for (int i=0;i<list.length;i++) {
            if(i<list.length){
//                key=key+list[i].trim().substring(0,
//                        1).toUpperCase()+list[i].trim().substring(1,list[i]
//                        .trim().length());
//                map.put(key,list[i+1]);
                head=head+"\r\n"+"    "+body+list[i].trim()+"=null;"+"\r\n";
                head=head+"\r\n"+"    "+getMethod+list[i].trim().substring(0,
                        1).toUpperCase()+list[i].trim().substring(1,list[i]
                        .trim().length())
                        +"()" +
                        "{"+"\r\n"+"        return this."+list[i].trim()
                        +";"+"\r\n"+"    "+"}"+"\r\n";
                head=head+"\r\n"+"    "+setMethod+list[i].trim().substring(0,
                        1).toUpperCase()+list[i].trim().substring(1,list[i]
                        .trim().length())
                        +"(String value)" +
                        "{"+"\r\n"+"        this."+list[i].trim()
                        +"= value"+";"+"\r\n"+"    "+"}"+"\r\n";
            }
        }
        head=head+"\r\n"+"    "+getGoods;
        for (int i=0;i<list.length;i++) {
            head=head+"obj" +
                    ".set"+ list[i].substring(0,1).toUpperCase()+
                    list[i].substring(1,list[i].length())
                    +"(data["+i+"]);" +
                    "\r\n"+"        ";
        }
        head=head+"return obj;";
        head=head+"\r\n    "+"}";
        result=head+"\r\n"+shadow;
        buff.clear();
        outChnall.write(charset.encode(result));
        outChnall.close();

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Analyzer a=new Analyzer();
        Class c=a.doAnalyzer("gid,one,two,three,brand,title,description," +
                "discount," +
                "price,pro_code,color,size,im","good");
        String[] list={"1","2","1","2","1","2","1","2","1","2","1","2","1"};
        System.out.println(c);
//        Constructor constructor=c.getConstructor(String [].class);
//        Constructor[] con=c.getConstructors();
//        for (Constructor x:con
//             ) {
//            System.out.println(x.getParameterTypes()[0]);
//
//        }

        Method method = c.getMethod("getGood", String[].class);//调Mian方法
        MyJson obj= (MyJson) method.invoke(null, new Object[]{list});
        System.out.println(obj.toJson(c));
    }
}
