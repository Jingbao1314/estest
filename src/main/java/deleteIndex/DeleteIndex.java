package deleteIndex;

import init.InitClient;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.client.RestHighLevelClient;

/**
 * @author jijngbao
 * @date 19-1-14
 */
public class DeleteIndex {
    public static void main(String[] args) {
       try(RestHighLevelClient client= InitClient.getClient();){
           DeleteRequest request = new DeleteRequest(
                   "mess",
                   "_doc",
                   "1");
           DeleteResponse response=client.delete(request);
           if (request!=null){
               System.out.println("OK");
           }


       }catch (Exception e){

       }

    }
}
