package android.com.listviewtest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etUser,etPass;
    Button btnLogin,btnRegister;
    TextView txtSkip;
    GridView lvStudent;
    ArrayList<StudentPojo> studentList;
    Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        initUi();
        initListner();
        getData();
        setData();
    }

    private void initListner() {
        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
        etUser.setOnClickListener(this);
        etPass.setOnClickListener(this);
        txtSkip.setOnClickListener(this);


    }

    private void setData() {
        StudentAdaptor sd = new StudentAdaptor(context,studentList);
        lvStudent.setAdapter(sd);
    }

    private void getData() {
        studentList=new ArrayList<>();
        StudentPojo s1= new StudentPojo();
        s1.setUser("SWAPNIL");
        s1.setPass("1");


        StudentPojo s2= new StudentPojo();
        s2.setUser("RAHUL");
        s2.setPass("2");


        StudentPojo s3= new StudentPojo();
        s3.setUser("SHRADDHA");
        s3.setPass("3");


        StudentPojo s4= new StudentPojo();
        s4.setUser("ASHWINI");
        s4.setPass("4");


        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(s4);

        //Toast.makeText(context, studentList.g, Toast.LENGTH_SHORT).show();
    }

    private void initUi() {

        lvStudent=findViewById(R.id.lvStudent);
        etPass = findViewById(R.id.etPass);
        etUser = findViewById(R.id.etUser);
        btnLogin=findViewById(R.id.btnLogin);
        btnRegister=findViewById(R.id.btnRegister);
        txtSkip=findViewById(R.id.txtSkip);
    }

    @Override
    public void onClick(View v) {


    }
}

