package com.wyh.aidlClient;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.wyh.aidl.Book;
import com.wyh.aidl.IBookManager;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("aidl", "MainActivity  onCreate");
    }


    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d("aidl", "onServiceConnected");
            IBookManager bookManager = IBookManager.Stub.asInterface(service);
            try {
                List<Book> bookList = bookManager.getBookList();
                Log.d("aidl", "bookList:" + bookList.toString());
            } catch (RemoteException e) {
                e.printStackTrace();
            }

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d("aidl", "onServiceDisconnected");

        }
    };


    public void connect(View view) {
        Log.d("aidl", "MainActivity  connect");
        Intent intent = new Intent();
        intent.setAction("com.wyh.aidl.BookManagerService");
        intent.setPackage("com.wyh.aidlserver");
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
    }
}
