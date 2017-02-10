package com.example.user.myassignment73;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;


public class MainActivity extends AppCompatActivity {
    public ImageView empPhoto;
    public TextView empName;
    public TextView empAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        empPhoto = (ImageView) findViewById(R.id.imageView);
        empName = (TextView) findViewById(R.id.name);
        empAge = (TextView) findViewById(R.id.age);

        DatabaseHelper db = new DatabaseHelper(this);

        if (db.checkDB()) { //default entry
            Bitmap photo = BitmapFactory.decodeResource(getResources(), R.drawable.ravi);
            byte photoBytes[] = getBytes(photo);
            Employee employee = new Employee("Ravi",60,photoBytes);
            db.AddEmployee(employee);
        }

        Employee employee = db.getEmployee(1);
        empName.setText(employee.getName());
        empAge.setText(String.valueOf(employee.getAge(22)));
        empPhoto.setImageBitmap(getPhoto(employee.getPhoto()));

    }

    public static byte[] getBytes(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, stream);
        return stream.toByteArray();
    }

    public static Bitmap getPhoto(byte[] image) {
        return BitmapFactory.decodeByteArray(image, 0, image.length);
    }


}

