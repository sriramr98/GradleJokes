package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.sriram.jokeview.Constants;
import com.sriram.jokeview.JokeActivity;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

class JokesTask extends AsyncTask<Void, Void, String> {
    private MyApi myApi = null;
    public Context context;
    private ProgressBar progressBar;

    public JokesTask(Context context, ProgressBar pb){
        this.context = context;
        this.progressBar = pb;
    }


    @Override
    protected String doInBackground(Void... voids) {
        if (myApi == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApi = builder.build();
        }

        try {
            return myApi.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (progressBar != null){
            progressBar.setVisibility(View.VISIBLE);
        }
    }


    @Override
    protected void onPostExecute(String s) {
        if (context != null){
            Intent i = new Intent(context, JokeActivity.class);
            i.putExtra(Constants.JOKE, s);
            context.startActivity(i);
            if (progressBar != null){
                progressBar.setVisibility(View.GONE);
            }
        }
    }
}


