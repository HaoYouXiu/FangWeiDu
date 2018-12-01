package com.bwei.model.fangweidushangcheng.net;

import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * date:2018/12/1
 * author:郝仁（Thinkpad)
 * function:
 */
public class OkHttpUtil {
    OkHttpUtil(){}

    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

    public OkHttpUtil get(String uri){
        final OkHttpClient okHttpClient = new OkHttpClient();
        StringBuilder stringBuilder = new StringBuilder();
        String s = stringBuilder.toString();
        RequestBody requestBody = RequestBody.create(MediaType.parse("application charcet=utf-8"), s);
        Request build = new Request.Builder().url(uri).post(requestBody).build();
         okHttpClient.newCall(build).enqueue(new Callback() {
             @Override
             public void onFailure(Call call, IOException e) {

             }

             @Override
             public void onResponse(Call call, final Response response) throws IOException {
                 final String s1 = response.body().string();
                 mHandler.post(new Runnable() {
                   @Override
                   public void run() {
                       try {
                           mGetDate.Feast(s1);
                       } catch (Exception e) {
                           e.printStackTrace();
                       }
                   }
               });
             }
         });
        return this;
    }

    private GetDate mGetDate;

    public void setGetDate(GetDate getDate) {
        mGetDate = getDate;
    }

    public interface GetDate{

        void Feast(String s);
    }
}
