package com.example.sqlitechallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class BookActivity extends AppCompatActivity {

    private ImageView image;
    private TextView name, author, description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        image = findViewById(R.id.bookImage);
        name = findViewById(R.id.txtName);
        author = findViewById(R.id.txtAuthor);
        description = findViewById(R.id.txtDescription);

        Intent intent = getIntent();
        if(null != intent){
            int bookId = intent.getIntExtra("book_id", -1);
            if(bookId != -1){
                new GetBookById().execute(bookId);
            }
        }
    }

    private class GetBookById extends AsyncTask<Integer, Void, Book>{
        private DatabaseHelper databaseHelper;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            databaseHelper = new DatabaseHelper(BookActivity.this);
        }

        @Override
        protected Book doInBackground(Integer... integers) {
            try {
                SQLiteDatabase db = databaseHelper.getReadableDatabase();

                Cursor cursor = db.rawQuery("SELECT * FROM books WHERE id = ?", new String[] {String.valueOf(integers[0])});
                if(null != cursor){
                    if(cursor.moveToFirst()){

                        int idIndex = cursor.getColumnIndex("id");
                        int nameIndex = cursor.getColumnIndex("name");
                        int authorIndex = cursor.getColumnIndex("author");
                        int imageUrlIndex = cursor.getColumnIndex("image_url");
                        int descriptionIndex = cursor.getColumnIndex("description");

                        Book b = new Book();
                        b.setId(cursor.getInt(idIndex));
                        b.setName(cursor.getString(nameIndex));
                        b.setAuthor(cursor.getString(authorIndex));
                        b.setImageURL(cursor.getString(imageUrlIndex));
                        b.setDescription(cursor.getString(descriptionIndex));

                        cursor.close();
                        db.close();
                        return b;
                    }else{
                        cursor.close();
                        db.close();
                    }
                }else{
                    db.close();
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Book book) {
            super.onPostExecute(book);

            if(null != book){
                name.setText(book.getName());
                author.setText(book.getAuthor());
                description.setText(book.getDescription());

                Glide.with(BookActivity.this)
                        .asBitmap()
                        .load(book.getImageURL())
                        .into(image);
            }
        }
    }
}