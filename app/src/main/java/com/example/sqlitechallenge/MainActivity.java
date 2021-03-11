package com.example.sqlitechallenge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements BookAdapter.DeleteBook {

    @Override
    public void onDeleteBookResult(int bookId) {
        new DeleteBookById().execute(bookId);
    }

    private RecyclerView recyclerView;
    private BookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new BookAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        // TODO: 11.03.2021 Get the books
        new GetAllBooks().execute();
    }

    private class GetAllBooks extends AsyncTask<Void, Void, ArrayList<Book>>{

        private DatabaseHelper databaseHelper;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            databaseHelper = new DatabaseHelper(MainActivity.this);
        }

        @Override
        protected ArrayList<Book> doInBackground(Void... voids) {
            try {
                SQLiteDatabase db = databaseHelper.getReadableDatabase();
                Cursor cursor = db.query("books", null, null, null, null, null, null);
                if(null != cursor){
                    if(cursor.moveToFirst()){
                        ArrayList<Book> books = new ArrayList<>();

                        int idIndex = cursor.getColumnIndex("id");
                        int nameIndex = cursor.getColumnIndex("name");
                        int authorIndex = cursor.getColumnIndex("author");
                        int imageUrlIndex = cursor.getColumnIndex("image_url");
                        int descriptionIndex = cursor.getColumnIndex("description");

                        for(int i = 0; i < cursor.getCount(); i++){
                            Book b = new Book();
                            b.setId(cursor.getInt(idIndex));
                            b.setName(cursor.getString(nameIndex));
                            b.setAuthor(cursor.getString(authorIndex));
                            b.setImageURL(cursor.getString(imageUrlIndex));
                            b.setDescription(cursor.getString(descriptionIndex));
                            books.add(b);

                            cursor.moveToNext();
                        }

                        cursor.close();
                        db.close();
                        return books;
                    }else{
                        cursor.close();
                        db.close();
                    }
                }else{
                    db.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(ArrayList<Book> books) {
            super.onPostExecute(books);

            if(null != books){
                adapter.setBooks(books);
            }else {
                adapter.setBooks(new ArrayList<Book>());
            }
        }
    }

    private class DeleteBookById extends AsyncTask<Integer, Void, Boolean>{
        private DatabaseHelper databaseHelper;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            databaseHelper = new DatabaseHelper(MainActivity.this);
        }



        @Override
        protected Boolean doInBackground(Integer... integers) {
            try {
                SQLiteDatabase db = databaseHelper.getWritableDatabase();
                int deletedRows = db.delete("books", "id=?", new String[]{String.valueOf(integers[0])});
                db.close();
                if(deletedRows > 0){
                    return true;
                }
            }catch (SQLException e){
                e.printStackTrace();
            }

            return false;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            if(aBoolean){
                Toast.makeText(MainActivity.this, "Buch erfolgreich gelöscht", Toast.LENGTH_LONG).show();
                new GetAllBooks().execute();
            }
        }
    }
}