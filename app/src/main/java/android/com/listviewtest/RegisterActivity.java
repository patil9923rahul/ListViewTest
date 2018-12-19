package android.com.listviewtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
EditText etUser,etPass;
Button btnRegister;
ImageView imgVisible,imgHide;
boolean flag=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etUser=findViewById(R.id.etUser);
        etPass=findViewById(R.id.etPass);
        imgVisible=findViewById(R.id.imgVisible);
        imgHide=findViewById(R.id.imgHide);

        btnRegister=findViewById(R.id.btnRegister);
        initListner();
    }

    private void initListner() {


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(RegisterActivity.this,login_activity.class);
                String user= etUser.getText().toString().trim();
                String pass= etPass.getText().toString().trim();
                if(user.equals(""))
                {
                    Toast.makeText(RegisterActivity.this, "Registration field should not be blank", Toast.LENGTH_LONG).show();
                }
                else {
                    i.putExtra("User", user);
                    i.putExtra("Pass", pass);
                    startActivity(i);
                    Toast.makeText(RegisterActivity.this, "Register Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        imgVisible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag==false)
                {
                    imgVisible.setImageResource(R.drawable.hidepass);
                    imgHide.setImageResource(R.drawable.hidepass);
                    flag=true;
                }
                else
                {
                imgVisible.setImageResource(R.drawable.visiblepass);
                imgHide.setImageResource(R.drawable.visiblepass);
                    flag=true;
                }
            }
        });
    }
}
