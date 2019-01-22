package indexDocument;

import init.InitClient;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.replication.ReplicationResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.rest.RestStatus;

import java.io.IOException;

/**
 * @author jijngbao
 * @date 19-1-14
 */
public class IndexDocument {
//    private static Logger logger = LogManager.getRootLogger();

//    public static void main(String[] args) {
//        try (RestHighLevelClient client = InitClient.getClient();) {
//            // 1、创建索引请求
//            IndexRequest request = new IndexRequest(
//                    "buisness",   //索引
//                    "man",     // mapping type
//                    "1");     //文档id
//
//            // 2、准备文档数据
//            // 方式一：直接给JSON串
//            String jsonString = "{" +
//                    "\"name\":\"lucky\"," +
//                    "\"postDate\":\"2019-01-14\"," +
//                    "\"message\":\"trying out Elasticsearch\"" +
//                    "}";
//            request.source(jsonString, XContentType.JSON);
//
//            // 方式二：以map对象来表示文档
//            /*
//            Map<String, Object> jsonMap = new HashMap<>();
//            jsonMap.put("user", "kimchy");
//            jsonMap.put("postDate", new Date());
//            jsonMap.put("message", "trying out Elasticsearch");
//            request.source(jsonMap);
//            */
//
//            // 方式三：用XContentBuilder来构建文档
//            /*
//            XContentBuilder builder = XContentFactory.jsonBuilder();
//            builder.startObject();
//            {
//                builder.field("user", "kimchy");
//                builder.field("postDate", new Date());
//                builder.field("message", "trying out Elasticsearch");
//            }
//            builder.endObject();
//            request.source(builder);
//            */
//
//            // 方式四：直接用key-value对给出
//            /*
//            request.source("user", "kimchy",
//                            "postDate", new Date(),
//                            "message", "trying out Elasticsearch");
//            */
//
//            //3、其他的一些可选设置
//            /*
//            request.routing("routing");  //设置routing值
//            request.timeout(TimeValue.timeValueSeconds(1));  //设置主分片等待时长
//            request.setRefreshPolicy("wait_for");  //设置重刷新策略
//            request.version(2);  //设置版本号
//            request.opType(DocWriteRequest.OpType.CREATE);  //操作类别
//            */
//
//            //4、发送请求
//            IndexResponse indexResponse = null;
//            try {
//                // 同步方式
//                indexResponse = client.index(request);
//            } catch(ElasticsearchException e) {
//                // 捕获，并处理异常
//                //判断是否版本冲突、create但文档已存在冲突
//                if (e.status() == RestStatus.CONFLICT) {
//                    System.out.println("冲突了，请在此写冲突处理逻辑！\n" + e
//                            .getDetailedMessage
//                            ());
//                }
//                System.out.println("索引异常");
//
////                logger.error("索引异常", e);
//            }
//
//            //5、处理响应
//            if(indexResponse != null) {
//                String index = indexResponse.getIndex();
//                String type = indexResponse.getType();
//                String id = indexResponse.getId();
//                long version = indexResponse.getVersion();
//                if (indexResponse.getResult() == DocWriteResponse.Result.CREATED) {
//                    System.out.println("新增文档成功，处理逻辑代码写到这里。");
//                } else if (indexResponse.getResult() == DocWriteResponse.Result.UPDATED) {
//                    System.out.println("修改文档成功，处理逻辑代码写到这里。");
//                }
//                // 分片处理信息
//                ReplicationResponse.ShardInfo shardInfo = indexResponse.getShardInfo();
//                if (shardInfo.getTotal() != shardInfo.getSuccessful()) {
//
//                }
//                // 如果有分片副本失败，可以获得失败原因信息
//                if (shardInfo.getFailed() > 0) {
//                    for (ReplicationResponse.ShardInfo.Failure failure : shardInfo.getFailures()) {
//                        String reason = failure.reason();
//                        System.out.println("副本失败原因：" + reason);
//                    }
//                }
//            }
//
//
//            //异步方式发送索引请求
//            /*ActionListener<IndexResponse> listener = new ActionListener<IndexResponse>() {
//                @Override
//                public void onResponse(IndexResponse indexResponse) {
//
//                }
//
//                @Override
//                public void onFailure(Exception e) {
//
//                }
//            };
//            client.indexAsync(request, listener);
//            */
////            client.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public static void put(String indexName,String jsonString){
        try (RestHighLevelClient client = InitClient.getClient();) {
            // 1、创建索引请求
            IndexRequest request = new IndexRequest(
                    indexName,   //索引
                    "goods");     //文档id

            request.source(jsonString, XContentType.JSON);

            IndexResponse indexResponse = null;
            try {
                // 同步方式
                indexResponse = client.index(request);
            } catch(ElasticsearchException e) {

                if (e.status() == RestStatus.CONFLICT) {
                    System.out.println("冲突，请在此写冲突处理逻辑！\n" + e
                            .getDetailedMessage
                                    ());
                }
                System.out.println("索引异常");

            }

            if(indexResponse != null) {
                String index = indexResponse.getIndex();
                String type = indexResponse.getType();
                String id = indexResponse.getId();
                long version = indexResponse.getVersion();
                if (indexResponse.getResult() == DocWriteResponse.Result.CREATED) {
                    System.out.println("新增文档成功，处理逻辑代码写到这里。");
                } else if (indexResponse.getResult() == DocWriteResponse.Result.UPDATED) {
                    System.out.println("修改文档成功，处理逻辑代码写到这里。");
                }
                // 分片处理信息
                ReplicationResponse.ShardInfo shardInfo = indexResponse.getShardInfo();
                if (shardInfo.getTotal() != shardInfo.getSuccessful()) {

                }
                // 如果有分片副本失败，可以获得失败原因信息
                if (shardInfo.getFailed() > 0) {
                    for (ReplicationResponse.ShardInfo.Failure failure : shardInfo.getFailures()) {
                        String reason = failure.reason();
                        System.out.println("失败原因：" + reason);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
