package com.umkc.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import com.mongodb.util.JSON;

public class RegisterMongolab extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	try {
		doPost(req, resp);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=req.getParameter("username");
		String firstName=req.getParameter("firstName");
		String lastName=req.getParameter("lastName");
		String phoneNumber=req.getParameter("phoneNumber");
		String emailId=req.getParameter("emailId");
		String password=req.getParameter("password");
		String confirmPassword=req.getParameter("confirmPassword");
		
		String URL = "https://api.mongolab.com/api/1/databases/testing/collections/venubabukolla?apiKey=VH-BdhSnipYJ5AtkUcdvpnZRs2cKoWLN";
		
		JSONObject details = new JSONObject();
		

		try {
			details.put("username", username);
			details.put("firstName", firstName);
			details.put("lastName", lastName);
			details.put("phoneNumber", phoneNumber);
			details.put("emailId",emailId);
			details.put("password",password);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
HttpClient hclient = new DefaultHttpClient();
		
		HttpPost httpPut = new HttpPost(URL);
		
		String message = details.toString();
		
		System.out.println("Message sending:"+ message);
		
		try {
			httpPut.setEntity(new StringEntity(message, "UTF8"));
			httpPut.setHeader("Content-type", "application/json");
			
		} catch (UnsupportedEncodingException e) {
			System.out.println("Exception in setting up the URL data");
		}
		
		System.out.println("hhhhhh"+httpPut.toString());
		HttpResponse hResponse = hclient.execute(httpPut);
		
		
		
		
		System.out.println("response"+ hResponse);
		boolean result;
		if(hResponse != null){
			if(hResponse.getStatusLine().getStatusCode() == 200){
				 result = true;
				System.out.println("Hello World");
				req.getRequestDispatcher("Login.jsp").forward(req, resp);
				
			}
		}
		
		//Receiving the data from the mongoLab
	/*	
		HttpClient hclient1 = new DefaultHttpClient();
		
		HttpGet httpGET = new HttpGet("https://api.mongolab.com/api/1/databases/testing/collections/venubabukolla?apiKey=VH-BdhSnipYJ5AtkUcdvpnZRs2cKoWLN");
		
		HttpResponse hresponceData = hclient1.execute(httpGET);
		
		BufferedReader breader = new BufferedReader(new InputStreamReader(hresponceData.getEntity().getContent()));
		
		String line ="";
		System.out.println("Reading the data");
		
		*/
		
		
		
		
//			System.out.println(jsonOup.get("Address"));
			
		}
	}

		
	
		
	

