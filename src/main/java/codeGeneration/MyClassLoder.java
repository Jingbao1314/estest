package codeGeneration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author jijngbao
 * @date 19-1-22
 */
public class MyClassLoder extends ClassLoader{
    private ByteBuffer getBytes(String path) throws IOException {
        FileChannel in=new FileInputStream(new File(path)).getChannel();
        ByteBuffer buffer=ByteBuffer.allocate(1024*3);
        buffer.clear();
        int flag=in.read(buffer);
        in.close();
        return buffer;
    }

    private boolean compile(String path) throws IOException, InterruptedException {
        Process process=Runtime.getRuntime().exec("javac "+path+" " +
                ""+"/home/jingbao/code/elastic/src/main/java/pojo/MyJson" +
                ".java");
        process.waitFor();
        return process.exitValue()==0?true:false;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class thisClass=null;
        String rootPath="/home/jingbao/code/elastic/src/main/java/";
        String sourcePath=rootPath+name.replace(".","/")+".java";
        String classPath=rootPath+name.replace(".","/")+".class";
        System.out.println(classPath);
        File sourceFile=new File(sourcePath);
        File classFile=new File(classPath);
        if (sourceFile.exists()){
            try {
                if (classFile.exists()){
                    if (!(classFile.lastModified()>sourceFile.lastModified())){
                        Boolean flag=compile(sourcePath);
                        if (!flag){
                            return null;
                        }
                    }
                    ByteBuffer buffer=getBytes(classPath);
                    thisClass=defineClass(name,buffer.array(),0,buffer
                            .position());
                }else {
                    Boolean flag=compile(sourcePath);
                    if (!flag){
                        return null;
                    }

                    ByteBuffer buffer=getBytes(classPath);
                    thisClass=defineClass(name,buffer.array(),0,buffer
                            .position
                            ());
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return thisClass;
    }
}
