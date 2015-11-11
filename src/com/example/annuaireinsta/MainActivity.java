package com.example.annuaireinsta;

import helper.SessionManager;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
 
public class MainActivity extends Activity {
    // LogCat tag
	private static final String TAG = RegisterActivity.class.getSimpleName();
    private Button btnLogin;
    private Button btnLinkToRegister;
    private EditText inputLogin;
    private EditText inputPassword;
    private ProgressDialog pDialog;
    private SessionManager session;
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
 
        inputLogin = (EditText) findViewById(R.id.login);
        inputPassword = (EditText) findViewById(R.id.password);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLinkToRegister = (Button) findViewById(R.id.btnLinkToRegisterScreen);
 
        // Progress dialog
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);
 
        // Session manager
        session = new SessionManager(getApplicationContext());
 
        // Check if user is already logged in or not
        if (session.isLoggedIn()) {
            // User is already logged in. Take him to main activity
            Intent intent = new Intent(MainActivity.this, LoggedActivity.class);
            startActivity(intent);
            finish();
        }
 
        // Login button Click Event
        btnLogin.setOnClickListener(new View.OnClickListener() {
 
            public void onClick(View view) {
                String login = inputLogin.getText().toString();
                String password = inputPassword.getText().toString();
 
                // Check for empty data in the form
                if (login.trim().length() > 0 && password.trim().length() > 0) {
                    // login user
                	Login(login, password);
                } else {
                    // Prompt user to enter credentials
                    Toast.makeText(getApplicationContext(),"Veuillez remplir les champs obligatoires", Toast.LENGTH_LONG).show();
                }
            }
 
        });
 
        // Link to Register Screen
        btnLinkToRegister.setOnClickListener(new View.OnClickListener() {
 
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),
                        RegisterActivity.class);
                startActivity(i);
                finish();
            }
        });
 
    }
    
    private void Login(String login,String password){
       HttpClient httpclient  = new DefaultHttpClient();
    	// Prepare a request object
       StringBuilder url = new StringBuilder(getResources().getString(R.string.AUTHENTIFICATION_URL));
       url.append("?tag=login&login=");
       url.append(login);
       url.append("&password=");
       url.append(password);
        HttpGet httpget = new HttpGet(url.toString()); 
        
     // Execute the request
        HttpResponse response;
        try {
            response = httpclient.execute(httpget);
         // Examine the response status
            Log.i("connection prete",response.getStatusLine().toString());

            // Get hold of the response entity
			
			
			if(response.getEntity() != null){

	             InputStream inputStream = response.getEntity().getContent();

	             //Lecture du retour au format JSON
	             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
	             StringBuilder stringBuilder = new StringBuilder();

	             String ligneLue = bufferedReader.readLine();
	             while(ligneLue != null){
	                 stringBuilder.append(ligneLue + " \n");
	                 ligneLue = bufferedReader.readLine();
	             }
	             bufferedReader.close();

	          // Get hold of the response entity
	             JSONObject jsonObject = new JSONObject(stringBuilder.toString());

	             Log.i("Chaine JSON", stringBuilder.toString());   


//	             JSONObject jsonResultSet = jsonObject.getJSONObject("nb");
	             jsonObject.getJSONObject("utilisateurs").getString("mail");
	             jsonObject.get("id");
	             
	             if(jsonObject.getBoolean("error") == false)
	             {
	            	 Intent i = new Intent(getApplicationContext(),
	                         LoggedActivity.class);
	                 startActivity(i);
	             }
	             else
	             {
	            	 Toast.makeText(getApplicationContext(),"Erreur d'identification", Toast.LENGTH_LONG).show();
	             }
	             
	           
	    
            // If the response does not enclose an entity, there is no need
            // to worry about connection release

			}
        }catch (Exception e) {
        	
        	e.printStackTrace();
        }
     }
}