package com.example.administrator.cardioapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.administrator.cardioapp.adapter.CardioListAdapter;
import com.example.administrator.cardioapp.db.CardioDbHelper;
import com.example.administrator.cardioapp.model.CardioItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private CardioDbHelper mHelper;
    private SQLiteDatabase mDb;

    private ArrayList<CardioItem> mCardioItemList = new ArrayList<>();
    private CardioListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHelper = new CardioDbHelper(this);
        mDb = mHelper.getReadableDatabase();

        loadDataFromDb();

        mAdapter = new CardioListAdapter(
                this,
                R.layout.item,
                mCardioItemList
        );

        ListView lv = findViewById(R.id.List_View);
        lv.setAdapter(mAdapter);



    }

    private void loadDataFromDb() {
        Cursor cursor = mDb.query(
                CardioDbHelper.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );

        mCardioItemList.clear();

        while (cursor.moveToNext()) {
            String title = cursor.getString(cursor.getColumnIndex(CardioDbHelper.COL_TITLE));
            String picture = cursor.getString(cursor.getColumnIndex(CardioDbHelper.COL_PICTURE));
            String detail = cursor.getString(cursor.getColumnIndex(CardioDbHelper.COL_DETAIL));

            CardioItem item = new CardioItem(title,picture,detail);
            mCardioItemList.add(item);
        }
    }
}
