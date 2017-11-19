package com.codekul.uithread;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler=new Handler(Looper.getMainLooper());
    }

    public void btnOkay(View view){
//        threadCounter();
//        handlerCounter();
        new MyTask().execute(0,10/*params*/);
    }

    private void counter(){
        for(int i=0;i<100;i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ((TextView) findViewById(R.id.txtCount)).setText(String.valueOf(i));
        }
    }

    private void threadCounter(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                counter();
            }
        }).start();
    }

    int i=0;

    private void handlerCounter(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(i=0;i<100;i++){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            ((TextView) findViewById(R.id.txtCount)).setText(String.valueOf(i));

                        }
                    });

                }
            }
        }).start();

    }

    private class MyTask extends AsyncTask<Integer/*params*/,String/*progress*/,Boolean/*result*/>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            //UI Thread
        }

        @Override
        protected Boolean doInBackground(Integer... params) {

            //Worker Thread

            for (int i=params[0];i<params[1];i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(String.valueOf(i));
            }
             return true;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);

            //UI Thread
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);

            //UI Thread
            ((TextView) findViewById(R.id.txtCount)).setText(values[0]);

        }

    }

}