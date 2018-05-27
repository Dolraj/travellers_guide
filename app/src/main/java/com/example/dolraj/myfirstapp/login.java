package com.example.dolraj.myfirstapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    Button _btnlog;
    EditText _txtemail, _txtpass;
    Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        openHelper = new DatabaseHelper(this);
        db = openHelper.getReadableDatabase();
        _btnlog = (Button)findViewById(R.id.btnlog);
        _txtemail = (EditText)findViewById(R.id.txtemail);
        _txtpass = (EditText)findViewById(R.id.txtpass);
        _btnlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = _txtemail.getText().toString();
                String pass = _txtpass.getText().toString();
                cursor = db.rawQuery("SELECT *FROM " + DatabaseHelper.TABLE_NAME + " WHERE " + DatabaseHelper.COL_5 + "=?AND " + DatabaseHelper.COL_4 + "= ?", new String[]{email, pass});
                if (cursor != null) {
                    if (cursor.getCount() > 0) {
                        Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(getApplicationContext(), "Login error", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
