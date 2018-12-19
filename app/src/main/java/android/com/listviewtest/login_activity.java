package android.com.listviewtest;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login_activity extends AppCompatActivity {
    Context context=this;
    EditText etPass,etUser;
    Button btnLogin,btnRegister;
    final static int GET_DATA=100;
    String user="",pass="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        etPass=findViewById(R.id.etPass);
        etUser=findViewById(R.id.etUser);
        btnLogin=findViewById(R.id.btnLogin);
        btnRegister=findViewById(R.id.btnRegister);
        intiListner();

    }

    public void intiListner() {

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(context,RegisterActivity.class);
                startActivityForResult(i2,GET_DATA);


            }

        });


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user=etUser.getText().toString().trim();
                pass=etPass.getText().toString().trim();
             //   onActivityResult(100,user,pass);


                          Intent i2=getIntent();
                          if (i2.getExtras()!=null) {
                              String user1 = i2.getExtras().getString("User");
                              String pass1 = i2.getExtras().getString("Pass");
                              if ((user1.equals( user)) && (pass1.equals(pass))) {
                                  Intent i = new Intent(context, Data.class);
                                  startActivity(i);
                              } else
                                  Toast.makeText(context, "Invalid credential ", Toast.LENGTH_LONG).show();


                          }
                          else
                          {
                              Toast.makeText(context, "Invalide userid", Toast.LENGTH_SHORT).show();
                          }




            }
        });




    }


}
