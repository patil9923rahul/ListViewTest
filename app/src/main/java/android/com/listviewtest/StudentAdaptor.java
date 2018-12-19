package android.com.listviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class StudentAdaptor extends BaseAdapter {
    ArrayList<StudentPojo> studentList;
    Context context;
    Holder holder;
    StudentPojo studentPojo;
    LayoutInflater lf;

    public StudentAdaptor(Context context, ArrayList<StudentPojo> studentList) {
        this.context = context;
        this.studentList = studentList;
        lf = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return studentList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = lf.inflate(R.layout.row_student, parent, false);

            holder = new Holder();
            holder.etUser = convertView.findViewById(R.id.etUser);
            holder.etPass = convertView.findViewById(R.id.etPass);
            holder.btnLogin = convertView.findViewById(R.id.btnLogin);
            holder.btnRegister = convertView.findViewById(R.id.btnRegister);
            holder.txtSkip = convertView.findViewById(R.id.txtSkip);
            //holder.imgLogo = convertView.findViewById(R.id.imgLogo);

            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();

        }
        studentPojo = studentList.get(position);
        holder.etUser.setText(studentPojo.getUser());
        holder.etPass.setText(studentPojo.getPass());
        holder.btnLogin.setText(studentPojo.getLogin());
        holder.btnRegister.setText(studentPojo.getRegister());

        //holder.imgLogo.setImageResource(studentPojo.getLogo());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "On Clicked " + studentList.get(position).getUser(), Toast.LENGTH_SHORT).show();

            }
        });

        return convertView;

    }

    private class Holder {
        EditText etUser,etPass;
        Button btnLogin,btnRegister;
        TextView txtSkip;
        //ImageView imgLogo;
    }
}

