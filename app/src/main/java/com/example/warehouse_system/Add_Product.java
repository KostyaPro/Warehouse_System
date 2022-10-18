package com.example.warehouse_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class Add_Product extends AppCompatActivity {
private Button btChange,btSave;
private EditText txtID,txtName, txtDescribe, txtAmount, txtPrice, txtProducer;
private Context context;
private ImageView imgPicture;
private SQLiteDatabase db;

    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        txtID=(EditText)findViewById(R.id.txtID);
        txtName=(EditText) findViewById(R.id.txtName);
        txtDescribe=(EditText) findViewById(R.id.txtDescribe);
        txtAmount=(EditText) findViewById(R.id.txtAmount);
        txtPrice=(EditText) findViewById(R.id.txtPrice);
        txtProducer=(EditText)findViewById(R.id.txtProducer);
        imgPicture=(ImageView) findViewById(R.id.imgPicture);

        dbHelper = new DBHelper(this);
        SQLiteDatabase db=dbHelper.getWritableDatabase();

    }
//кнопка изменить
    public void change_data(View view) {

    }
//кнопка сохранить
    public void save_data(View view) {
// создаем объект для данных
        ContentValues cv = new ContentValues();
        String _id=txtID.getText().toString();
        String name=txtName.getText().toString();
        //нужно как-то указать где лежит картинка
        String describe=txtDescribe.getText().toString();
        String amount=txtAmount.getText().toString();
        String price=txtPrice.getText().toString();
        String producer=txtProducer.getText().toString();

        cv.put(DBHelper.COLUMN_ID,_id);
        cv.put(DBHelper.COLUMN_NAME,name);
        cv.put(DBHelper.COLUMN_DESCRIBE,describe);
        //cv.put(DBHelper.COLUMN_LINK_PICTURE,ссылка на картинку);
        cv.put(DBHelper.COLUMN_AMOUNT,amount);
        cv.put(DBHelper.COLUMN_PRICE,price);
        cv.put(DBHelper.COLUMN_PRODUCER,producer);
        db.insert(DBHelper.TABLE_NAME,null,cv);
    }
}