package com.example.bjmap;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class UserActivity extends Activity {

	private ImageView logoImageView;
	private TextView appnameTextView;
	private TextView beginTextView;
	private TextView endTextView;
	private EditText beginEditText;
	private EditText endEditText;
	private Button enterButton;	
	private String begin;
	private String end;
	private double[] lats=new double[50];
	private double[] lons=new double[50];
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);						
		setContentView(R.layout.user);		
		
		logoImageView=(ImageView)findViewById(R.id.logoImageView);
		appnameTextView=(TextView)findViewById(R.id.appnameTextView);
		beginTextView=(TextView)findViewById(R.id.beginTextView);
		endTextView=(TextView)findViewById(R.id.endTextView);		
		beginEditText=(EditText)findViewById(R.id.beginEditText);
		endEditText=(EditText)findViewById(R.id.endEditText);
		enterButton=(Button)findViewById(R.id.enterButton);
		
		logoImageView.setImageResource(R.drawable.logo);
		appnameTextView.setText(R.string.appname);
		beginTextView.setText(R.string.begin);
		endTextView.setText(R.string.end);
		enterButton.setText(R.string.enter);
		
	}
	
	 public void onClick_Event(View view){
		 
		 begin=beginEditText.getText().toString();
		 end=endEditText.getText().toString();
		 //设置服务器地址，并附带上起点和终点信息
		 String baseURL="http://192.168.191.4:8080/MapServer/index.jsp/search.do";
		 String url = baseURL + "?startpoint=" + begin + "&endpoint=" + end;
		 
		 try{
         HttpGet httpGet = new HttpGet(url);
         HttpClient httpClient = new DefaultHttpClient();
         //发送http请求
         HttpResponse response = httpClient.execute(httpGet);
         //得到应答字符串，该字符串即为服务器发来的路线节点经纬度信息，是json格式保存的数据
         String info = EntityUtils.toString(response.getEntity());
         //声明抽象类TypeToken，LinkedList是List的子类，是一个双向链表，可以把json数据和nodeinfo对象对应
         Type listType = new TypeToken<LinkedList<nodeInfo>>(){}.getType();
		 Gson gson = new Gson();
		 LinkedList<nodeInfo> users = gson.fromJson(info, listType);
		 //获取经纬度信息并放入数组
		 int i=0;
		 for (Iterator iterator = users.iterator(); iterator.hasNext();i++) {
				nodeInfo user = (nodeInfo) iterator.next();
				lats[i]=user.getLat();
				lons[i]=user.getLon();
			}
		} catch(UnknownHostException e) {
			new AlertDialog.Builder(UserActivity.this).setTitle("系统提示")//设置对话框标题  			      
		      .setMessage("请确认地点信息在可搜索范围内！")//设置显示的内容  			
		      .setPositiveButton("确定",new DialogInterface.OnClickListener() {//添加确定按钮  			   			        		  
		         @Override  			 
		         public void onClick(DialogInterface dialog, int which) {//确定按钮的响应事件  			  
		              // TODO Auto-generated method stub  			  
		             finish();  			   
		          }  			   
		      }).show();//在按键响应事件中显示此对话框
            e.printStackTrace();           
        } catch (IOException e) {
            e.printStackTrace();
        }
		 
		 	 
		 //声明一个intent实例
		 Intent intent = new Intent();
		 //在intent里绑定两个键值对信息：起点和终点
		 intent.putExtra("begin", begin);
		 intent.putExtra("end", end);
		 //使用bundle来传递double类型的数组信息：lats和lons分别是从服务器获取的经纬度
		 Bundle nodeinfo=new Bundle();
		 nodeinfo.putDoubleArray("lat", lats);
		 nodeinfo.putDoubleArray("lon", lons);
		 //在intent里绑定bundle对象
		 intent.putExtras(nodeinfo);
		 //设置intent的发起activity和目的activity
		 intent.setClass(UserActivity.this, OsmActivity.class);
		 //启动intent
		 UserActivity.this.startActivity(intent);
	 }

}