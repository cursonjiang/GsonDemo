package com.cursonjiang.gsondemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String URL = "http://cv3.233118.zxxk.com/FlatApp/AppListByR.aspx?etag=&source=ZxxkCom0000000000000&t=20150629090333&machinecode=680571464C40&appver=1.0&appkey=com.zxxk.xueyi.appmanage.student&curpage=1&ttid=android_5.0.2_SM-T800_wifi&pagesize=15&format=json&ver=1.1&accept=808a850e0b1463f9a22d3b92b12cca79";

    private ListView listView;

    private List<Json.Success_responseEntity.App> appEntityList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appEntityList = new ArrayList<>();
        listView = (ListView) findViewById(R.id.listView);

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        GsonRequest<Json> gsonRequest = new GsonRequest<>(
                URL,
                Json.class,
                new Response.Listener<Json>() {
                    @Override
                    public void onResponse(Json response) {
                        List<Json.Success_responseEntity.App> app = response.getSuccess_response().getApp();
                        for (Json.Success_responseEntity.App apps : app) {
                            Log.i("App名字", apps.getAppname());
                            Log.i("App地址", apps.getDownloadurl());
                            appEntityList.add(apps);
                        }
                        listView.setAdapter(new MyAdapter(MainActivity.this, appEntityList));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("请求出错", error.getMessage());
                    }
                }
        );
        requestQueue.add(gsonRequest);
    }

    private class MyAdapter extends BaseAdapter {

        Context context;
        List<Json.Success_responseEntity.App> appEntityList;

        public MyAdapter(Context context, List<Json.Success_responseEntity.App> appEntityList) {
            this.appEntityList = appEntityList;
            this.context = context;
        }

        @Override
        public int getCount() {
            Log.d("appEntityList数量", appEntityList.size() + "");
            return appEntityList.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.item, null);
                viewHolder = new ViewHolder();
                viewHolder.appId = (TextView) convertView.findViewById(R.id.appId);
                viewHolder.appName = (TextView) convertView.findViewById(R.id.appName);
                viewHolder.appAtate = (TextView) convertView.findViewById(R.id.appAtate);
                viewHolder.downloadUrl = (TextView) convertView.findViewById(R.id.downloadUrl);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.appId.setText(appEntityList.get(position).getAppid() + "");
            viewHolder.appAtate.setText(appEntityList.get(position).getAppstate() + "");
            viewHolder.appName.setText(appEntityList.get(position).getAppname());
            viewHolder.downloadUrl.setText(appEntityList.get(position).getDownloadurl());
            return convertView;
        }

        class ViewHolder {
            private TextView appId;
            private TextView appName;
            private TextView appAtate;
            private TextView downloadUrl;
        }
    }
}
