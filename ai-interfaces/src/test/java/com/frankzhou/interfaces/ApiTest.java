package com.frankzhou.interfaces;

import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 知识星球和ChatGPT接口测试
 * @date 2023-02-15
 */
@SpringBootTest
public class ApiTest {

    private static final String QUESTION_URL = "https://api.zsxq.com/v2/groups/28885854555121/topics";

    private static final String QUERY_QUESTION_URL = "https://api.zsxq.com/v2/groups/28885854555121/topics?scope=unanswered_questions&count=20";

    private static final String ANSWER_URL = "https://api.zsxq.com/v2/topics/28885854555121/answer";

    private static final String COMMENT_URL = "https://api.zsxq.com/v2/topics/214824124125451/comments";

    @Test
    public void testRaiseQuestion() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost postRequest = new HttpPost(QUESTION_URL);
        postRequest.addHeader("cookie","sensorsdata2015jssdkcross={\"distinct_id\":\"51154488254244\",\"first_id\":\"1855310a446832-0f9a5f606e202a8-26021151-1327104-1855310a447a91\",\"props\":{\"$latest_traffic_source_type\":\"直接流量\",\"$latest_search_keyword\":\"未取到值_直接打开\",\"$latest_referrer\":\"\"},\"identities\":\"eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg1NTMxMGE0NDY4MzItMGY5YTVmNjA2ZTIwMmE4LTI2MDIxMTUxLTEzMjcxMDQtMTg1NTMxMGE0NDdhOTEiLCIkaWRlbnRpdHlfbG9naW5faWQiOiI1MTE1NDQ4ODI1NDI0NCJ9\",\"history_login_id\":{\"name\":\"$identity_login_id\",\"value\":\"51154488254244\"},\"$device_id\":\"1855310a446832-0f9a5f606e202a8-26021151-1327104-1855310a447a91\"}; zsxq_access_token=A707BBAA-80F4-CA4A-20FC-8CAF3F978124_DF94CAD894DCB4D5; zsxqsessionid=5044b53d5e46edf00b982d376dbbd20a; abtest_env=product; UM_distinctid=1865405db28fc2-0ebad71d83246d-26021051-144000-1865405db2913c9; __cuid=0111403bc6474c83968d8d93501ffe14; amp_fef1e8=e65c16c8-cdc9-43ca-90b1-e6bd8cecd574R...1gpa29mk8.1gpa29mkc.2.2.4");
        postRequest.addHeader("Content-Type","application/json; charset=UTF-8");
        postRequest.addHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/109.0.0.0 Safari/537.36");

        String postParam = "{\n" +
                "  \"type\": \"topic\",\n" +
                "  \"text\": \"@frankzhou\\n帮我写一个字典树Trie\\n\",\n" +
                "  \"image_ids\": [],\n" +
                "  \"file_ids\": [],\n" +
                "  \"mentioned_user_ids\": []\n" +
                "}";

        StringEntity stringEntity = new StringEntity(postParam, ContentType.create("text/json", "UTF-8"));
        postRequest.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(postRequest);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String result = EntityUtils.toString(response.getEntity());
            System.out.println(result);
        } else{
            System.out.println("知识星球提问接口调用失败,错误码:" + response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void testCommentTopic() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost postRequest = new HttpPost(COMMENT_URL);
        postRequest.addHeader("cookie","sensorsdata2015jssdkcross={\"distinct_id\":\"51154488254244\",\"first_id\":\"1855310a446832-0f9a5f606e202a8-26021151-1327104-1855310a447a91\",\"props\":{\"$latest_traffic_source_type\":\"直接流量\",\"$latest_search_keyword\":\"未取到值_直接打开\",\"$latest_referrer\":\"\"},\"identities\":\"eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg1NTMxMGE0NDY4MzItMGY5YTVmNjA2ZTIwMmE4LTI2MDIxMTUxLTEzMjcxMDQtMTg1NTMxMGE0NDdhOTEiLCIkaWRlbnRpdHlfbG9naW5faWQiOiI1MTE1NDQ4ODI1NDI0NCJ9\",\"history_login_id\":{\"name\":\"$identity_login_id\",\"value\":\"51154488254244\"},\"$device_id\":\"1855310a446832-0f9a5f606e202a8-26021151-1327104-1855310a447a91\"}; zsxq_access_token=A707BBAA-80F4-CA4A-20FC-8CAF3F978124_DF94CAD894DCB4D5; zsxqsessionid=5044b53d5e46edf00b982d376dbbd20a; abtest_env=product; UM_distinctid=1865405db28fc2-0ebad71d83246d-26021051-144000-1865405db2913c9; __cuid=0111403bc6474c83968d8d93501ffe14; amp_fef1e8=e65c16c8-cdc9-43ca-90b1-e6bd8cecd574R...1gpa29mk8.1gpa29mkc.2.2.4");
        postRequest.addHeader("Content-Type","application/json");
        postRequest.addHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/109.0.0.0 Safari/537.36");

        String postParam = "{\n" +
                "  \"text\": \"Web Server都不会回家卖红薯咯!\\n\",\n" +
                "  \"image_ids\": [],\n" +
                "  \"mentioned_user_ids\": []\n" +
                "}";

        StringEntity stringEntity = new StringEntity(postParam, ContentType.create("text/json", "UTF-8"));
        postRequest.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(postRequest);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String result = EntityUtils.toString(response.getEntity());
            System.out.println(result);
        } else {
            System.out.println("知识星球评论接口调用失败,错误码:" + response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void testQueryNoAnsweredQuestion() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet getRequest = new HttpGet(QUERY_QUESTION_URL);
        getRequest.addHeader("cookie","sensorsdata2015jssdkcross={\"distinct_id\":\"51154488254244\",\"first_id\":\"1855310a446832-0f9a5f606e202a8-26021151-1327104-1855310a447a91\",\"props\":{\"$latest_traffic_source_type\":\"直接流量\",\"$latest_search_keyword\":\"未取到值_直接打开\",\"$latest_referrer\":\"\"},\"identities\":\"eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg1NTMxMGE0NDY4MzItMGY5YTVmNjA2ZTIwMmE4LTI2MDIxMTUxLTEzMjcxMDQtMTg1NTMxMGE0NDdhOTEiLCIkaWRlbnRpdHlfbG9naW5faWQiOiI1MTE1NDQ4ODI1NDI0NCJ9\",\"history_login_id\":{\"name\":\"$identity_login_id\",\"value\":\"51154488254244\"},\"$device_id\":\"1855310a446832-0f9a5f606e202a8-26021151-1327104-1855310a447a91\"}; zsxq_access_token=A707BBAA-80F4-CA4A-20FC-8CAF3F978124_DF94CAD894DCB4D5; zsxqsessionid=5044b53d5e46edf00b982d376dbbd20a; abtest_env=product; UM_distinctid=1865405db28fc2-0ebad71d83246d-26021051-144000-1865405db2913c9; __cuid=0111403bc6474c83968d8d93501ffe14; amp_fef1e8=e65c16c8-cdc9-43ca-90b1-e6bd8cecd574R...1gpa29mk8.1gpa29mkc.2.2.4");
        getRequest.addHeader("Content-Type","application/json; charset=UTF-8");

        CloseableHttpResponse response = httpClient.execute(getRequest);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String result = EntityUtils.toString(response.getEntity());
            System.out.println(result);
        } else {
            System.out.println("知识星球查询问题接口调用失败,错误码:" + response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void testAnswerQuestion() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost postRequest = new HttpPost(ANSWER_URL);
        postRequest.addHeader("cookie","sensorsdata2015jssdkcross={\"distinct_id\":\"51154488254244\",\"first_id\":\"1855310a446832-0f9a5f606e202a8-26021151-1327104-1855310a447a91\",\"props\":{\"$latest_traffic_source_type\":\"直接流量\",\"$latest_search_keyword\":\"未取到值_直接打开\",\"$latest_referrer\":\"\"},\"identities\":\"eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg1NTMxMGE0NDY4MzItMGY5YTVmNjA2ZTIwMmE4LTI2MDIxMTUxLTEzMjcxMDQtMTg1NTMxMGE0NDdhOTEiLCIkaWRlbnRpdHlfbG9naW5faWQiOiI1MTE1NDQ4ODI1NDI0NCJ9\",\"history_login_id\":{\"name\":\"$identity_login_id\",\"value\":\"51154488254244\"},\"$device_id\":\"1855310a446832-0f9a5f606e202a8-26021151-1327104-1855310a447a91\"}; zsxq_access_token=A707BBAA-80F4-CA4A-20FC-8CAF3F978124_DF94CAD894DCB4D5; zsxqsessionid=5044b53d5e46edf00b982d376dbbd20a; abtest_env=product; UM_distinctid=1865405db28fc2-0ebad71d83246d-26021051-144000-1865405db2913c9; __cuid=0111403bc6474c83968d8d93501ffe14; amp_fef1e8=e65c16c8-cdc9-43ca-90b1-e6bd8cecd574R...1gpa29mk8.1gpa29mkc.2.2.4");
        postRequest.addHeader("Content-Type","application/json; charset=UTF-8");
        postRequest.addHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/109.0.0.0 Safari/537.36");

        String postParam = "";

        StringEntity stringEntity = new StringEntity(postParam, ContentType.create("text/json", "UTF-8"));
        postRequest.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(postRequest);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String result = EntityUtils.toString(response.getEntity());
            System.out.println(result);
        } else {
            System.out.println("知识星球回答接口调用失败,错误码:" + response.getStatusLine().getStatusCode());
        }
    }
}
