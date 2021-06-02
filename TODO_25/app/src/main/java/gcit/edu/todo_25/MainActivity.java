package gcit.edu.todo_25;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText fname, Lname, marks, idnum;
    Button button1, button2, button3, button4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //text view
        fname = findViewById(R.id.fname);
        Lname = findViewById(R.id.Lname);
        marks = findViewById(R.id.marks);
        idnum = findViewById(R.id.id);
//button
        button1 = (Button) findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);

        myDb = new DatabaseHelper(this);
        AddData();
    }
    public void AddData(){
       button1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               boolean isInserted = myDb.insertData(idnum.getText().toString(),
                       fname.getText().toString(),
                       Lname.getText().toString(),
                       marks.getText().toString());
               if (isInserted == true){
                   Toast.makeText(MainActivity.this,"Data is Inserted",Toast.LENGTH_SHORT).show();
               }
               else {
                   Toast.makeText(MainActivity.this,"Data is not Inserted",Toast.LENGTH_SHORT).show();

               }
           }
       });
    }

    public void Viredata(View view) {
        Cursor res = myDb.getAllData();
        if (res.getCount() == 0){
            showMessage("Error","Nothig to show");
            return;
        }
        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()){
            buffer.append("Student Id : "+ res.getString(0)+"\n");
            buffer.append("First Name : "+ res.getString(1)+"\n");
            buffer.append("Last Name : "+ res.getString(2)+"\n");
            buffer.append("ITW202 Marks : "+ res.getString(3)+"\n");
            buffer.append("\n");

        }
        showMessage("List of Student",buffer.toString());
    }
    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    public void Update(View view) {
        boolean isUpdate = myDb.updateData(idnum.getText().toString(),
                fname.getText().toString(),
                Lname.getText().toString(),
                marks.getText().toString());
        if (isUpdate == true){
            Toast.makeText(MainActivity.this,"Data is Updated",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(MainActivity.this,"Data is not Updated",Toast.LENGTH_SHORT).show();

        }

    }


    public void Delete(View view) {
        Integer deleteRows = myDb.deleteData(idnum.getText().toString());
        if (deleteRows > 0){
            Toast.makeText(MainActivity.this,"Data is Deleted",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(MainActivity.this,"Data is not Deleted",Toast.LENGTH_SHORT).show();

        }
    }
}