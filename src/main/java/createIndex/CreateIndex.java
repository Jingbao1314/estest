package createIndex;

import init.InitClient;
import org.elasticsearch.action.admin.indices.alias.Alias;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

/**
 * @author jijngbao
 * @date 19-1-13
 */
public class CreateIndex {
    public static void main(String[] args) {
        try (RestHighLevelClient client = InitClient.getClient();) {

            // 1、创建 创建索引request 参数：索引名mess
            CreateIndexRequest request = new CreateIndexRequest("testxxxxs");

            // 2、设置索引的settings
//            request.settings(Settings.builder().put("index.number_of_shards", 3) // 分片数
//                    .put("index.number_of_replicas", 2) // 副本数
//                    .put("analysis.analyzer.default.tokenizer", "ik_smart") // 默认分词器
//            );

            // 3、设置索引的mappings
            request.mapping("women",
                    "  {\n" +
                            "    \"women\": {\n" +
                            "      \"properties\": {\n" +
                            "        \"one\": {\n" +
                            "          \"type\": \"text\"\n" +
                            "        },\n" +
                            "        \"two\": {\n" +
                            "          \"type\": \"text\"\n" +
                            "        },\n" +
                            "        \"three\": {\n" +
                            "          \"type\": \"text\"\n" +
                            "        },\n" +
                            "        \"desc\": {\n" +
                            "          \"type\": \"text\"\n" +
                            "        }\n" +
                            "      }\n" +
                            "    }\n" +
                            "  }",
                    XContentType.JSON);

            // 4、 设置索引的别名
//            request.alias(new Alias("mmm"));

            // 5、 发送请求
            // 5.1 同步方式发送请求
            CreateIndexResponse createIndexResponse = client.indices()
                    .create(request);

            // 6、处理响应
            boolean acknowledged = createIndexResponse.isAcknowledged();
            boolean shardsAcknowledged = createIndexResponse
                    .isShardsAcknowledged();
            System.out.println("acknowledged = " + acknowledged);
            System.out.println("shardsAcknowledged = " + shardsAcknowledged);

            // 5.1 异步方式发送请求
            /*ActionListener<CreateIndexResponse> listener = new ActionListener<CreateIndexResponse>() {
                @Override
                public void onResponse(
                        CreateIndexResponse createIndexResponse) {
                    // 6、处理响应
                    boolean acknowledged = createIndexResponse.isAcknowledged();
                    boolean shardsAcknowledged = createIndexResponse
                            .isShardsAcknowledged();
                    System.out.println("acknowledged = " + acknowledged);
                    System.out.println(
                            "shardsAcknowledged = " + shardsAcknowledged);
                }

                @Override
                public void onFailure(Exception e) {
                    System.out.println("创建索引异常：" + e.getMessage());
                }
            };

            client.indices().createAsync(request, listener);
            */
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void create(String indexName,String typeName,String mapping){

        try (RestHighLevelClient client = InitClient.getClient();) {

            // 1、创建 创建索引request 参数：索引名mess
            CreateIndexRequest request = new CreateIndexRequest(indexName);

            // 2、设置索引的settings
//            request.settings(Settings.builder().put("index.number_of_shards", 3) // 分片数
//                    .put("index.number_of_replicas", 2) // 副本数
//                    .put("analysis.analyzer.default.tokenizer", "ik_smart") // 默认分词器
//            );

            // 3、设置索引的mappings
            request.mapping(typeName,mapping, XContentType.JSON);

            // 4、 设置索引的别名
//            request.alias(new Alias("mmm"));

            // 5、 发送请求
            // 5.1 同步方式发送请求
            CreateIndexResponse createIndexResponse = client.indices()
                    .create(request);

            // 6、处理响应
            boolean acknowledged = createIndexResponse.isAcknowledged();
            boolean shardsAcknowledged = createIndexResponse
                    .isShardsAcknowledged();
            System.out.println("acknowledged = " + acknowledged);
            System.out.println("shardsAcknowledged = " + shardsAcknowledged);

            // 5.1 异步方式发送请求
            /*ActionListener<CreateIndexResponse> listener = new ActionListener<CreateIndexResponse>() {
                @Override
                public void onResponse(
                        CreateIndexResponse createIndexResponse) {
                    // 6、处理响应
                    boolean acknowledged = createIndexResponse.isAcknowledged();
                    boolean shardsAcknowledged = createIndexResponse
                            .isShardsAcknowledged();
                    System.out.println("acknowledged = " + acknowledged);
                    System.out.println(
                            "shardsAcknowledged = " + shardsAcknowledged);
                }

                @Override
                public void onFailure(Exception e) {
                    System.out.println("创建索引异常：" + e.getMessage());
                }
            };

            client.indices().createAsync(request, listener);
            */
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
