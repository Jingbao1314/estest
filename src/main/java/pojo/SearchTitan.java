package pojo;

import com.google.gson.Gson;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author jijngbao
 * @date 19-1-23
 */
public class SearchTitan {
    private BoolQueryBuilder boolQueryBuilder;
    private Goods goods=null;
    private void init(String titan){
        Gson gson=new Gson();
        goods=gson.fromJson(titan,Goods.class);
    }
    public QueryBuilder createBuilder(String titan){
        init(titan);
        Class c = null;
        try {
            c = Class.forName(goods.getClass().getName());
            Field[] fields = c.getDeclaredFields();
            for (Field f : fields) {
                String propname = f.getName();
                String methodname = "get" +
                        propname.substring(0, 1).toUpperCase()
                        + propname.substring(1, propname.length());
                Method method = c.getMethod(methodname);
                Object temp= method.invoke(goods);
                if (temp!=null&&!temp.equals("")){
                    build(propname, (String) temp);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return boolQueryBuilder;

    }

    private void build(String fieldName,String fieldValue){
        if (boolQueryBuilder==null){
            boolQueryBuilder=QueryBuilders.boolQuery().must(QueryBuilders
                    .matchPhraseQuery(fieldName,fieldValue));
        }else {
            boolQueryBuilder=boolQueryBuilder.must(QueryBuilders
                    .matchPhraseQuery(fieldName,fieldValue));
        }



    }


}
