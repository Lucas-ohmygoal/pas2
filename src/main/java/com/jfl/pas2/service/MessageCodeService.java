package com.jfl.pas2.service;

import com.jfl.pas2.dto.code.MessageCodeOutput;
import com.jfl.pas2.dto.code.MessageCodeZ1;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @Title:GetMessageCode
 * @Description:发送验证码
 * @author:刘斌
 * @Date 2017年12月10日 下午10:03:04
 */
@Service
public class MessageCodeService {
	private static final String QUERY_PATH="https://openapi.danmi.com/distributor/sendSMS";
	private static final String ACCOUNT_SID="2cbeeecc1f8601a6b90783ef67e6a69f";
	private static final String AUTH_TOKEN="c69b4d476e1972436550bc96040e815d";


    /**
     * 根据相应的手机号发送验证码
	 * @param phone
     * @return
     */
	public static MessageCodeOutput getCode(String phone) throws JSONException, ParseException {
		String rod=smsCode();
		String timestamp=getTimestamp();
		String sig=getMD5(ACCOUNT_SID,AUTH_TOKEN,timestamp);
		String tamp="【金风羚电器有限公司】短信验证码："+rod+"，如非本人操作，请忽略此短信。";
		OutputStreamWriter out=null;
		BufferedReader br=null;
		StringBuilder result=new StringBuilder();
		try {
			URL url=new URL(QUERY_PATH);
			HttpURLConnection connection=(HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoInput(true);//设置是否允许数据写入
			connection.setDoOutput(true);//设置是否允许参数数据输出
			connection.setConnectTimeout(5000);//设置链接响应时间
			connection.setReadTimeout(10000);//设置参数读取时间
			connection.setRequestProperty("Content-type","application/x-www-form-urlencoded");
			//提交请求
			out=new OutputStreamWriter(connection.getOutputStream(),"UTF-8");
			String args=getQueryArgs(ACCOUNT_SID, tamp, phone, timestamp, sig, "JSON");
			out.write(args);
			out.flush();
			//读取返回参数
			
			br=new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));
			String temp="";
			while((temp=br.readLine())!=null){
				result.append(temp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MessageCodeOutput output = new MessageCodeOutput();
		MessageCodeZ1 messageCodeZ1 = new MessageCodeZ1();
		JSONObject json=new JSONObject(result.toString());
		String respCode=json.getString("respCode");
		String defaultRespCode="0000";
		if(defaultRespCode.equals(respCode)){
			 messageCodeZ1.setCode(rod);
		}else{
			messageCodeZ1.setCode(defaultRespCode);
		}
		output.setMessageCodeZ1(messageCodeZ1);
		return output;
	}

    /**
     * 定义一个请求参数拼接方法
	 * @param accountSid
     * @param smsContent
     * @param to
     * @param timestamp
     * @param sig
     * @param respDataType
     * @return
     */
	public static String getQueryArgs(String accountSid,String smsContent,String to,String timestamp,String sig,String respDataType){
		return "accountSid="+accountSid+"&smsContent="+smsContent+"&to="+to+"&timestamp="+timestamp+"&sig="+sig+"&respDataType="+respDataType;
	}

    /**
     * 获取时间戳
	 * @return
     */
	public static String getTimestamp() throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String date = simpleDateFormat.format(new Date());
		long time = simpleDateFormat.parse(date).getTime();
		return time+"";
	}

    /**
     * sing签名
	 * @param sid
     * @param token
     * @param timestamp
     * @return
     */
	public static String getMD5(String sid,String token,String timestamp){
		
		StringBuilder result=new StringBuilder();
		String source=sid+token+timestamp;
		//获取某个类的实例
				try {					
				   MessageDigest digest=MessageDigest.getInstance("MD5");
				   //要进行加密的东西
				   byte[] bytes=digest.digest(source.getBytes());
				   for(byte b:bytes){
					   String hex=Integer.toHexString(b&0xff);
					   if(hex.length()==1){
						   result.append("0"+hex);
					   }else{
						   result.append(hex);
					   }
				   }
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
		
		return result.toString();
	}

	/**
	 * 创建验证码
	 * @return
	 */
	public static String smsCode(){
		String random=(int)((Math.random()*9+1)*100000)+"";		
		return random;
	}

	/**
	 * 注册成功通知
	 * @param phone
	 * @return
	 */
	public static void registerNotification(String phone, String userNumber) throws JSONException, ParseException {
		String timestamp=getTimestamp();
		String sig=getMD5(ACCOUNT_SID,AUTH_TOKEN,timestamp);
		String tamp="【金风羚电器】注册成功啦！欢迎您使用金风羚后台管理系统。您的登录用户号为：" +userNumber+"，如非本人操作，请忽略此短信。";
		OutputStreamWriter out=null;
		BufferedReader br=null;
		StringBuilder result=new StringBuilder();
		try {
			URL url=new URL(QUERY_PATH);
			HttpURLConnection connection=(HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoInput(true);//设置是否允许数据写入
			connection.setDoOutput(true);//设置是否允许参数数据输出
			connection.setConnectTimeout(5000);//设置链接响应时间
			connection.setReadTimeout(10000);//设置参数读取时间
			connection.setRequestProperty("Content-type","application/x-www-form-urlencoded");
			//提交请求
			out=new OutputStreamWriter(connection.getOutputStream(),"UTF-8");
			String args=getQueryArgs(ACCOUNT_SID, tamp, phone, timestamp, sig, "JSON");
			out.write(args);
			out.flush();
			//读取返回参数

			br=new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));
			String temp="";
			while((temp=br.readLine())!=null){
				result.append(temp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject json=new JSONObject(result.toString());
		String respCode=json.getString("respCode");
		String defaultRespCode="0000";
		if(defaultRespCode.equals(respCode)){

		}else{

		}

	}

	/**
	 * 产品信息入库通知
	 * @param phone
	 * @return
	 */
	public static void sendNotification(String phone, String productId) throws JSONException, ParseException {
		String timestamp=getTimestamp();
		String sig=getMD5(ACCOUNT_SID,AUTH_TOKEN,timestamp);
		String tamp="【金风羚电器】产品信息已成功入库！ 产品编号："+productId+"，如非本人操作，请忽略此短信。";
		OutputStreamWriter out=null;
		BufferedReader br=null;
		StringBuilder result=new StringBuilder();
		try {
			URL url=new URL(QUERY_PATH);
			HttpURLConnection connection=(HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoInput(true);//设置是否允许数据写入
			connection.setDoOutput(true);//设置是否允许参数数据输出
			connection.setConnectTimeout(5000);//设置链接响应时间
			connection.setReadTimeout(10000);//设置参数读取时间
			connection.setRequestProperty("Content-type","application/x-www-form-urlencoded");
			//提交请求
			out=new OutputStreamWriter(connection.getOutputStream(),"UTF-8");
			String args=getQueryArgs(ACCOUNT_SID, tamp, phone, timestamp, sig, "JSON");
			out.write(args);
			out.flush();
			//读取返回参数

			br=new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));
			String temp="";
			while((temp=br.readLine())!=null){
				result.append(temp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject json=new JSONObject(result.toString());
		String respCode=json.getString("respCode");
		String defaultRespCode="0000";
		if(defaultRespCode.equals(respCode)){

		}else{

		}

	}
}
