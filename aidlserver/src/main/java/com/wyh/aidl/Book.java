package com.wyh.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author WangYingHao
 * @since 2019-09-14
 */
public class Book implements Parcelable {
    public int id;
    public String name;

    public Book(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private Book(Parcel in) {
        id = in.readInt();
        name = in.readString();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
    }
}
