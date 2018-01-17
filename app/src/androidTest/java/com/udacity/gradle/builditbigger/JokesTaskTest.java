package com.udacity.gradle.builditbigger;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.AndroidTestCase;
import android.util.Log;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@RunWith(AndroidJUnit4.class)
public class JokesTaskTest {

    @Test
    public void jokesTaskTest() throws Exception{
        JokesTask task = new JokesTask(null,null);
        task.execute();
        String joke = task.get();
        Assert.assertNotEquals(joke,null);
        Assert.assertTrue(joke.length() > 0);
    }

}
