package com.example.dolraj.myfirstapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SQLiteOpenHelper OpenHelper;
    SQLiteDatabase db;
    Button _btnreg, _btnlog;
    EditText _txtlname, _txtemail, _txtphone, _txtpwd, _txtname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OpenHelper = new DatabaseHelper(this);
        _btnreg= (Button)findViewById(R.id.btnreg);
        _txtname=(EditText)findViewById(R.id.txtname);
        _txtemail= (EditText)findViewById(R.id.txtemail);
        _txtlname=(EditText)findViewById(R.id.txtlname);
        _txtphone=(EditText)findViewById(R.id.txtphone);
        _txtpwd=(EditText)findViewById(R.id.txtpwd);
        _btnlog= (Button)findViewById(R.id.btnlog);

        _btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db=OpenHelper.getWritableDatabase();
                String name=_txtname.getText().toString();
                String lname=_txtlname.getText().toString();
                String phone=_txtphone.getText().toString();
                String email=_txtemail.getText().toString();
                String pwd=_txtpwd.getText().toString();
                insertdata(name, lname, pwd, phone, email);
                Toast.makeText(getApplicationContext(),"register sucessful", Toast.LENGTH_LONG).show();

            }
        });

        _btnlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, login.class);
                startActivity(intent);
            }
        });

    }

    public void insertdata(String name, String lname, String email, String pwd, String phone){
        ContentValues ContentValues = new ContentValues();
        ContentValues.put(DatabaseHelper.COL_2, name);
        ContentValues.put(DatabaseHelper.COL_3, lname);
        ContentValues.put(DatabaseHelper.COL_4, email);
        ContentValues.put(DatabaseHelper.COL_5, pwd);
        ContentValues.put(DatabaseHelper.COL_6, phone);
        long id = db.insert(DatabaseHelper.TABLE_NAME, null,ContentValues);




    }
}
