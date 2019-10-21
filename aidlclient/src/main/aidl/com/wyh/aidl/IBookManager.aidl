// IBookManager.com.wyh.aidl
package com.wyh.aidl;

import com.wyh.aidl.Book;


interface IBookManager {
  List<Book> getBookList();

  void addBook(in Book book);
}
