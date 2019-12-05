package com.coding_cole.tasktimer;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String[] projection = { TasksContract.Coloumns._ID,
                                TasksContract.Coloumns.TASKS_NAME,
                                TasksContract.Coloumns.TASKS_DESCRIPTION,
                                TasksContract.Coloumns.TASKS_SORTORDER};

        ContentResolver contentResolver = getContentResolver();

        ContentValues values = new ContentValues();
        //3
//        values.put(TasksContract.Coloumns.TASKS_SORTORDER, "99");
//        values.put(TasksContract.Coloumns.TASKS_DESCRIPTION, "Completed");
//        String selection = TasksContract.Coloumns.TASKS_SORTORDER + " = " + 2;
//        int count = contentResolver.update(TasksContract.CONTENT_URI, values, selection, null);
//        Log.d(TAG, "onCreate: " + count + " record(s) updated");

        //4
//        values.put(TasksContract.Coloumns.TASKS_DESCRIPTION, "Completed");
//        String selection = TasksContract.Coloumns.TASKS_SORTORDER + " = ?";
//        String[] args = { "99"};
//        int count = contentResolver.update(TasksContract.CONTENT_URI, values, selection, args);
//        Log.d(TAG, "onCreate: " + count + " record(s) updated");

        //5
//        int count = contentResolver.delete(TasksContract.buildTaskUri(3), null, null);
//        Log.d(TAG, "onCreate: " + count + " record(s) deleted");

        //6
        String selection = TasksContract.Coloumns.TASKS_DESCRIPTION + " = ?";
        String[] args = { "For deletion"};
        int count = contentResolver.delete(TasksContract.CONTENT_URI, selection, args);
        Log.d(TAG, "onCreate: " + count + " record(s)");


        //2
//        values.put(TasksContract.Coloumns.TASKS_NAME, "Content Provider");
//        values.put(TasksContract.Coloumns.TASKS_DESCRIPTION, "Record content provider video");
//        int count = contentResolver.update(TasksContract.buildTaskUri(4), values, null, null);
//        Log.d(TAG, "onCreate: " + count + " record(s) updated");

        //1
//        values.put(TasksContract.TABLE_NAME, "New Task1");
//        values.put(TasksContract.Coloumns.TASKS_DESCRIPTION, "Description 1");
//        values.put(TasksContract.Coloumns.TASKS_SORTORDER, 2);
//        Uri uri = contentResolver.insert(TasksContract.CONTENT_URI, values);

        Cursor cursor = contentResolver.query(TasksContract.CONTENT_URI,
            projection,
            null,
            null,
            TasksContract.Coloumns.TASKS_NAME);

        if (cursor != null) {
            Log.d(TAG, "onCreate: number of rows: " + cursor.getCount());
            while (cursor.moveToNext()) {
                for (int i = 0; i<cursor.getColumnCount(); i++) {
                    Log.d(TAG, "onCreate: " + cursor.getColumnName(i) + ": " + cursor.getString(i));
                }
                Log.d(TAG, "onCreate: =============== ==============");
            }
            cursor.close();
        }
//        AppDatabase appDatabase = AppDatabase.getInstance(this);
//        final SQLiteDatabase db = appDatabase.getReadableDatabase();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
