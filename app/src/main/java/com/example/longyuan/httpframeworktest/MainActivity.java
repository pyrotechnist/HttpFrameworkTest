package com.example.longyuan.httpframeworktest;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.longyuan.httpframeworktest.model.University;
import com.example.longyuan.httpframeworktest.network.api.PetApi;
import com.example.longyuan.httpframeworktest.network.utils.volley.GsonRequest;
import com.example.longyuan.httpframeworktest.network.utils.volley.VolleyManager;
import com.google.gson.Gson;

import org.json.JSONObject;

import javax.inject.Inject;

public class MainActivity extends Activity {

    @Inject
    PetApi mPetApi;

    @Inject
    RequestQueue mRequestQueue;

    private TextView mTextView;

    private ImageView mImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        App.getAppComponent().inject(this);

        mTextView = (TextView) findViewById(R.id.text);

        mImageView = (ImageView) findViewById(R.id.image);

        // Retrofit + rx
        /*mPetApi.getString()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(data -> mTextView.setText(data),
                        throwable -> processError(throwable));*/



        // Volley
        // Instantiate the RequestQueue.
        //RequestQueue queue = Volley.newRequestQueue(this);
        //RequestQueue queue = VolleyManager.getInstance(this.getApplicationContext()).getRequestQueue();

        String url ="http://10.0.2.2:1337/pet/adore";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                       // mTextView.setText("Response is: "+ response.substring(0,500));
                        mTextView.setText("Response is: "+ response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mTextView.setText("That didn't work!");
            }
        });
        // Add the request to the RequestQueue.
        //queue.add(stringRequest);




        // Volley paser Json, not automatically to object
        url ="http://10.0.2.2:1337/university/4";

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        try{
                            //mTextView.setText("Response: " + response.getString("name"));

                            // Use Gson to parse JSONObject
                            Gson gson = new Gson();
                            University university;
                            university = gson.fromJson(response.toString(),University.class);
                            mTextView.setText(""+university.getId());

                        }catch (Exception e) {
                            // If an error occurs, this prints the error to the log
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub

                    }
                });

        //queue.add(jsObjRequest);


        // Volley use customized Request to parse json
        GsonRequest<University> gsonRequest = new GsonRequest<>(url, University.class, null, new Response.Listener<University>() {
            @Override
            public void onResponse(University response) {

                mTextView.setText(""+response.getName());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        //mRequestQueue.add(gsonRequest);

        url = "http://lorempixel.com/400/200/sports/";

        ImageRequest imageRequest = new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                mImageView.setImageBitmap(response);

            }
        }, 400, 200, ImageView.ScaleType.FIT_CENTER,null, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        //mRequestQueue.add(jsObjRequest);
        mRequestQueue.add(imageRequest);

    }

    private void processError(Throwable e) {
        Log.e("Test", e.getLocalizedMessage(), e);
    }
}
