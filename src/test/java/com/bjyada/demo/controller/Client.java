package com.bjyada.demo.controller;
import java.io.IOException;
import java.security.PublicKey;

import com.bjyada.demo.entity.JsonReturn;
import com.bjyada.demo.util.RSA;
import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
/**
 * Created by Administrator on 2017/10/18.
 */
public class Client {
    @Test
    public void HttpPostData() {
        try {
            HttpClient httpclient = new DefaultHttpClient();
            String uri = "http://localhost:8080/sjpa2/getJson";
            HttpPost httppost = new HttpPost(uri);
            //添加http头信息
            httppost.addHeader("Authorization", "your token"); //认证token
            httppost.addHeader("Content-Type", "application/json");

            httppost.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36");
            JSONObject obj = new JSONObject();
            PublicKey pubk=RSA.getPubKeyFromPfx("F:\\self.pfx","atlas");
            String evalue= RSA.encrypt("123",pubk);
            obj.put("key", "yada");
            obj.put("value", evalue);
            System.out.println((obj ));
            httppost.setEntity(new StringEntity(obj.toString()));
            HttpResponse response;
            response = httpclient.execute(httppost);
            //检验状态码，如果成功接收数据
            int code = response.getStatusLine().getStatusCode();
            System.out.println(code+"code");
            if (code == 200) {
                String rev = EntityUtils.toString(response.getEntity());
                obj= JSONObject.fromObject(rev);
                JsonReturn json = (JsonReturn)JSONObject.toBean(obj,JsonReturn.class);
                System.out.println("返回数据==="+json.toString());
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
