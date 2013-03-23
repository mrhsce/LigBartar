package com.mehdie19.lig;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.util.Log;

public class ParserFunctions {
	private static String html_text=null;
	private static data my_data;

	 public static String getXML(){	 
		 //this function read html file from Internet and set to line
		 //line is all sorce of site 90
			String line = null;
			Log.d("getxml","get");
			try {
				DefaultHttpClient httpClient = new DefaultHttpClient();
				HttpPost httpPost = new HttpPost("http://90.irib.ir/");
				HttpResponse httpResponse = httpClient.execute(httpPost);
				HttpEntity httpEntity = httpResponse.getEntity();
				line = EntityUtils.toString(httpEntity);
			} catch (UnsupportedEncodingException e) {
				line = "<results status=\"error\"><msg>Can't connect to server</msg></results>";
			} catch (MalformedURLException e) {
				line = "<results status=\"error\"><msg>Can't connect to server</msg></results>";
			} catch (IOException e) {
				line = "<results status=\"error\"><msg>Can't connect to server</msg></results>";
			}
			html_text=line;
			return line;//html source
	}
	 
	 public final static String Delete_space(String s)
	 {
		 //is for a bug in parseing for ex: convert "  30     " to "30"
		 Log.d("delete is start","d");//log is a tool for debuging that is appered in Logcat
		 String new_s="";
		 for (int i=0;i<s.length();i++)
		 {
			 
			 if (s.charAt(i)==' ')
			 {
				 if ( i!=s.length()-1)
				 {
				if (s.charAt(i+1)!=' ')
					new_s=new_s+s.charAt(i);
				 }
			 }
			 else if (s.charAt(i)!='\n')
				 new_s=new_s+s.charAt(i);
		 }
		 Log.d("delete ended","k");
		 return new_s;
	 }

	 @SuppressWarnings("static-access")
	public final static void setData(String s){
			Log.d("setData is start","jjj");
		 	String temp="<td class=\""+s+"\">";
		 	int start=0;
		 	int end=0;
		 	while (html_text.indexOf(temp, end)!=-1)
		 	{
			 	start=html_text.indexOf(temp, start)+temp.length();
			 	end=html_text.indexOf("</td>", start);
			 	if (html_text.substring(start, end).indexOf("<a")==-1)
			 	{//is for a bug in parse html(for prepare correct data)
			 		if (s=="views-field views-field-title")
			 			my_data.setTeamName(Delete_space(html_text.substring(start, end)));
			 		else if (s=="views-field views-field-field-game-no-value")
			 			my_data.setGameNo(Delete_space(html_text.substring(start, end)));
			 		else if (s=="views-field views-field-field-play-win-value")
			 			my_data.setPlayWin(Delete_space(html_text.substring(start, end)));
			 		else if (s=="views-field views-field-field-play-equal-value")
			 			my_data.setPlayEqual(Delete_space(html_text.substring(start, end)));
			 		else if (s=="views-field views-field-field-play-faild-value")
			 			my_data.setPlayFaild(Delete_space(html_text.substring(start, end)));
			 		else if (s=="views-field views-field-field-emtiaz-value")
				 		my_data.setEmtiaz(Delete_space(html_text.substring(start, end)));
			 	}
			 }
		 	Log.d("setdata is kill","hhh");
		 
	 }
	 
	 public final static data Parse(String s)
	 {
		 Log.d("start parse","dddd");
		 html_text=s;
		 setData("views-field views-field-title");
		 setData("views-field views-field-field-game-no-value");
		 setData("views-field views-field-field-play-win-value");
		 setData("views-field views-field-field-play-equal-value");
		 setData("views-field views-field-field-play-faild-value");
		 setData("views-field views-field-field-emtiaz-value");
		 return my_data;
		 
	 }
}