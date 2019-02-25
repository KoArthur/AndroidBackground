package com.example.androidbackground.Class;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by 67698 on 2018/5/19.
 */

public class HttpConnect {
    private  String url1;
    public HttpConnect(String url)
    {
        url1=url;
    }
    public interface Callback{
        void finish(String respone);
    }
    public  void sendRequestWithHttpURLConnection(final Callback callback){
        new Thread(new Runnable() {
            @Override
            public void run() {
//                Log.d("Http", "run:进行网络连接 ");
                HttpURLConnection connection=null;
                BufferedReader reader;
                InputStream inputStream = null;
                try {
                    URL url=new URL(url1);//用接口创建一个URL对象
                    connection=(HttpURLConnection)url.openConnection();//由此打开网络连接
                    connection.setRequestMethod("GET");//网络请求分为很多种方式，常用为GET和POST
                    connection.setConnectTimeout(6000);//设置连接超时时间
                    connection.setReadTimeout(6000);//读取超时时间
                    connection.setRequestProperty("Content-type", "application/json");//设置请求头
//                    Log.d("难受啊马飞", "run: "+connection.getHeaderField(""));
                    inputStream=connection.getInputStream();//获取输入流
                    reader=new BufferedReader(new InputStreamReader(inputStream));//转化成缓冲字符流
                    StringBuilder response=new StringBuilder();//string变量,了解一些String和StringBuilder的区别
                    String line;
                    while ((line=reader.readLine())!=null)
                    {
                        response.append(line);
                    }
                    inputStream.close();
                    if(callback!=null){
                        callback.finish(response.toString());
                    }

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if(connection!=null)connection.disconnect();
                }
            }
        }).start();
    }


}
