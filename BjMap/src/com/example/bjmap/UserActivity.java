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
		 //���÷�������ַ���������������յ���Ϣ
		 String baseURL="http://192.168.191.4:8080/MapServer/index.jsp/search.do";
		 String url = baseURL + "?startpoint=" + begin + "&endpoint=" + end;
		 
		 try{
         HttpGet httpGet = new HttpGet(url);
         HttpClient httpClient = new DefaultHttpClient();
         //����http����
         HttpResponse response = httpClient.execute(httpGet);
         //�õ�Ӧ���ַ��������ַ�����Ϊ������������·�߽ڵ㾭γ����Ϣ����json��ʽ���������
         String info = EntityUtils.toString(response.getEntity());
         //����������TypeToken��LinkedList��List�����࣬��һ��˫���������԰�json���ݺ�nodeinfo�����Ӧ
         Type listType = new TypeToken<LinkedList<nodeInfo>>(){}.getType();
		 Gson gson = new Gson();
		 LinkedList<nodeInfo> users = gson.fromJson(info, listType);
		 //��ȡ��γ����Ϣ����������
		 int i=0;
		 for (Iterator iterator = users.iterator(); iterator.hasNext();i++) {
				nodeInfo user = (nodeInfo) iterator.next();
				lats[i]=user.getLat();
				lons[i]=user.getLon();
			}
		} catch(UnknownHostException e) {
			new AlertDialog.Builder(UserActivity.this).setTitle("ϵͳ��ʾ")//���öԻ������  			      
		      .setMessage("��ȷ�ϵص���Ϣ�ڿ�������Χ�ڣ�")//������ʾ������  			
		      .setPositiveButton("ȷ��",new DialogInterface.OnClickListener() {//���ȷ����ť  			   			        		  
		         @Override  			 
		         public void onClick(DialogInterface dialog, int which) {//ȷ����ť����Ӧ�¼�  			  
		              // TODO Auto-generated method stub  			  
		             finish();  			   
		          }  			   
		      }).show();//�ڰ�����Ӧ�¼�����ʾ�˶Ի���
            e.printStackTrace();           
        } catch (IOException e) {
            e.printStackTrace();
        }
		 
		 	 
		 //����һ��intentʵ��
		 Intent intent = new Intent();
		 //��intent���������ֵ����Ϣ�������յ�
		 intent.putExtra("begin", begin);
		 intent.putExtra("end", end);
		 //ʹ��bundle������double���͵�������Ϣ��lats��lons�ֱ��Ǵӷ�������ȡ�ľ�γ��
		 Bundle nodeinfo=new Bundle();
		 nodeinfo.putDoubleArray("lat", lats);
		 nodeinfo.putDoubleArray("lon", lons);
		 //��intent���bundle����
		 intent.putExtras(nodeinfo);
		 //����intent�ķ���activity��Ŀ��activity
		 intent.setClass(UserActivity.this, OsmActivity.class);
		 //����intent
		 UserActivity.this.startActivity(intent);
	 }

}