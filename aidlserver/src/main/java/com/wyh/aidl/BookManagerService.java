package com.wyh.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author WangYingHao
 * @since 2019-09-14
 */
public class BookManagerService extends Service {


    private CopyOnWriteArrayList<Book> mBookList = new CopyOnWriteArrayList<>();

    private Binder mBinder = new IBookManager.Stub() {
        @Override
        public List<Book> getBookList() throws RemoteException {
            return mBookList;
        }

        @Override
        public void addBook(Book book) throws RemoteException {
            mBookList.add(book);
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("aidl", "BookManagerService onCreate");
        mBookList.add(new Book(1, "Android 开发艺术探索"));
        mBookList.add(new Book(2, "Android 源代码情景分析"));
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("aidl", "BookManagerService onBind");
        return mBinder;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("aidl", "BookManagerService onDestroy");
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log.d("aidl", "BookManagerService onRebind");
    }
}
