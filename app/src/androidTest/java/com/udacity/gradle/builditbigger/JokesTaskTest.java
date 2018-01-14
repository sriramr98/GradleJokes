package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;
import android.util.Log;

import java.util.concurrent.ExecutionException;

public class JokesTaskTest extends AndroidTestCase {

    private static final String TAG = "JokesTaskTest";
    private String joke;

    public void noEmptyString(){
        JokesTask task = new JokesTask(getContext(),null);
        task.execute();
        try{
            joke = task.get();
            Log.d(TAG,"Retrieved a non empty string "+ joke);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        assertNotNull(joke);
        assertTrue(joke.length() > 0);
    }
}
