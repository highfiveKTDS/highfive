package com.ktds.shoppingbell;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.ktds.shoppingbell.impl.DialogWindow;
import com.ktds.shoppingbell.impl.URLProtocol;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PostListActivity extends ActionBarActivity {

    private Handler handler;
    private ProgressDialog dialog;

    private String jSONData;

    public Handler getHandler() {
        return handler;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_list);

        handler = new Handler();

    }

    public void readPostList() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                getHandler().post(new Runnable() {
                    @Override
                    public void run() {
                        showDialog(DialogWindow.LOAD_POST_LIST);
                    }
                });
                getJSONData_FromWebJSONService();
                setDataFromJson();
            }
        }).start();

    }

    private void getJSONData_FromWebJSONService() {
        StringBuilder builder = new StringBuilder();
        final HttpParams httpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpParams, 10000);
        HttpClient client = new DefaultHttpClient(httpParams);

        HttpGet httpGet = new HttpGet(
                URLProtocol.IP_ADDRESS + URLProtocol.URL_PostList);

        try {
            HttpResponse response = client.execute(httpGet);
            StatusLine statusLine = response.getStatusLine();

            int statusCode = statusLine.getStatusCode();
            if (statusCode == 200) {
                HttpEntity entity = response.getEntity();
                InputStream content = entity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(content));
                String line;
                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }
                jSONData = builder.toString();
            } else {
                getHandler().post(new Runnable() {
                    @Override
                    public void run() {
                        dialog.dismiss();
                    }
                });
            }

        } catch (final ClientProtocolException e) {
            getHandler().post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(PostListActivity.this, "error:" + e.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        } catch (final IOException e) {
            e.printStackTrace();
            getHandler().post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(PostListActivity.this, "error:" + e.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        }
        finally {
            getHandler().post(new Runnable() {
                @Override
                public void run() {
                    dialog.dismiss();
                }
            });
        }
    }

    public void setDataFromJson() {
        JSONObject json = null;
        JSONArray jArray = null;

        try {

            jArray = new JSONArray(jSONData);
            int dataLength = jArray.length();

            String tvOutput =  "";

            //FIXME: 데이터를 받아올 때 Key값에 맞게 가져오도록 코드 변경이 필요
            for(int i=0; i<dataLength; i++) {
                json = jArray.getJSONObject(i);

                tvOutput += "ID\t:" + json.get("id") + "/";
                tvOutput += "SUBJECT\t:" + json.get("subject");
                tvOutput +="\n";
            }

            final String finalTvOutput = tvOutput;

            getHandler().post(new Runnable() {
                @Override
                public void run() {
                    //TODO: MainThread 데이터 컨트롤
                }
            });

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if(id == DialogWindow.LOAD_POST_LIST)  {
            dialog = new ProgressDialog(this);
            dialog.setCancelable(false);
            dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            dialog.setMessage("포스팅 리스트를 불러오고 있습니다.");

            return dialog;
        }
        return null;
    }
}
