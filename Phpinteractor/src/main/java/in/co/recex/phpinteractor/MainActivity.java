package in.co.recex.phpinteractor;


import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.os.StrictMode;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    EditText  amount;
    EditText  id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        id = (EditText) findViewById(R.id.etID);
        amount = (EditText) findViewById(R.id.etAmount);
        Button Submit = (Button) findViewById(R.id.bSubit);

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postdata Postdata;
                Postdata = new postdata();
                Postdata.execute();

            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

  /*  public void Postdata() {

        //create a new HTTPClient and post header, and getting text from fields
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost;
        httpPost = new HttpPost("http://www.chrome.recex.co.in/canteenserver/canteeninteract.php");


        try{
            //adding the data
            List<NameValuePair> nameValuePairList = new ArrayList<NameValuePair>(2);
            nameValuePairList.add(new BasicNameValuePair("user" , id.getText().toString()));
            nameValuePairList.add(new BasicNameValuePair("amount",amount.getText().toString()));
            httpPost.setEntity(new UrlEncodedFormEntity( nameValuePairList));

            //execute the post request
            HttpResponse httpResponse = httpClient.execute(httpPost);
            Toast.makeText(getApplicationContext(),"transaction complete" , Toast.LENGTH_LONG).show();



        }catch (ClientProtocolException e){

        }catch (IOException e){

        }

    }
*/

    private class postdata extends AsyncTask<Void, Void, Void> {

        protected Void doInBackground(Void... voids){

            //create a new HTTPClient and post header, and getting text from fields
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost;
            httpPost = new HttpPost("http://www.chrome.recex.co.in/canteenserver/canteeninteract.php");


            try{
                //adding the data
                List<NameValuePair> nameValuePairList = new ArrayList<NameValuePair>(2);
                nameValuePairList.add(new BasicNameValuePair("user" , id.getText().toString()));
                nameValuePairList.add(new BasicNameValuePair("amount",amount.getText().toString()));
                httpPost.setEntity(new UrlEncodedFormEntity( nameValuePairList));

                //execute the post request
                HttpResponse httpResponse = httpClient.execute(httpPost);


            }catch (ClientProtocolException e){

            }catch (IOException e){

            }

            return null;
        }

        protected void onPostExecute(Void voids) {
            Toast.makeText(getApplicationContext(),"transaction complete" , Toast.LENGTH_LONG).show();
        }




    }


}
