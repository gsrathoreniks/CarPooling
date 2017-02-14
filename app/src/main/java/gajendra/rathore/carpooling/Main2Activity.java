package gajendra.rathore.carpooling;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main2Activity extends AppCompatActivity {
    EditText sourc;
    EditText desti;
    Button btnSubmit;
    DatabaseReference root;
    TextView S1;

    String s=null;
    String d=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final String AB=getIntent().getExtras().getString("car");
        root=FirebaseDatabase.getInstance().getReference();
        sourc=(EditText)findViewById(R.id.source);
        desti=(EditText)findViewById(R.id.destination);
        btnSubmit=(Button)findViewById(R.id.btnSubmit);
        S1=(TextView)findViewById(R.id.Sou);



        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(AB.toString().equals("1")){
                    if(!sourc.getText().toString().equals("")||!desti.getText().toString().equals("")) {
                        root = FirebaseDatabase.getInstance().getReference().child("car1");
                        Map<String, Object> map = new HashMap<String, Object>();
                        map.put("source", sourc.getText().toString());
                        map.put("destination", desti.getText().toString());
                        root.updateChildren(map);
                        Toast.makeText(Main2Activity.this, "Carpool added successfully!!!", Toast.LENGTH_SHORT).show();
                        sourc.setText("");
                        desti.setText("");
                    }
                    else
                        Toast.makeText(Main2Activity.this, "please fill all details", Toast.LENGTH_SHORT).show();
                }
                else if(AB.toString().equals("2")){
                    if(!sourc.getText().toString().equals("")||!desti.getText().toString().equals("")) {
                        root = FirebaseDatabase.getInstance().getReference().child("car1");
                        Map<String, Object> map = new HashMap<String, Object>();
                        map.put("source2", sourc.getText().toString());
                        map.put("destination2", desti.getText().toString());
                        root.updateChildren(map);
                        Toast.makeText(Main2Activity.this, "Carpool added successfully!!!", Toast.LENGTH_SHORT).show();
                        sourc.setText("");
                        desti.setText("");
                    }
                    else
                        Toast.makeText(Main2Activity.this, "please fill all details", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    }

