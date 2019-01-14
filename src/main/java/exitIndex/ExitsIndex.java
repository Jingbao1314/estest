package exitIndex;

import init.InitClient;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;

/**
 * @author jijngbao
 * @date 19-1-14
 */
public class ExitsIndex {
    public static void main(String[] args) {
//        try(RestHighLevelClient client= InitClient.getClient();){
//            GetRequest getRequest = new GetRequest(
//                    "posts",
//                    "doc",
//                    "1");
//            getRequest.fetchSourceContext(new FetchSourceContext(false));
//            getRequest.storedFields("_none_");
//            boolean exists = client.exists(getRequest, RequestOptions.DEFAULT);
//
//        }catch (Exception e){
//
//        }
    }
}
