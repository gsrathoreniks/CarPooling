package gajendra.rathore.carpooling;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    TabHost tabhost;
    TextView tv1;
    Button btnAdd1;
    TextView tv2;
    LinearLayout l1;
    LinearLayout l2;
    Button btnAdd2;
    TextView s1;
    TextView d1;
    TextView s2;
    TextView d2;
    DatabaseReference root;
    DatabaseReference root2;
    Button btnNumber;
    EditText friend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        root = FirebaseDatabase.getInstance().getReference();

        tabhost = (TabHost) findViewById(R.id.tabhost);
        tabhost.setup();
        btnNumber=(Button)findViewById(R.id.buttonNumber);
        l1=(LinearLayout) findViewById(R.id.linlay1);
        l2=(LinearLayout) findViewById(R.id.linlay2);
        friend=(EditText)findViewById(R.id.numFriends);
        tv1=(TextView)findViewById(R.id.carSlot1);
        tv2=(TextView)findViewById(R.id.carSlot2);
        btnAdd1=(Button)findViewById(R.id.btncarpool);
        btnAdd2=(Button)findViewById(R.id.btncarpoo2);
        s1=(TextView)findViewById(R.id.Sou);
        d1=(TextView)findViewById(R.id.Des);
        s2=(TextView)findViewById(R.id.Sou2);
        d2=(TextView)findViewById(R.id.Des2);







        btnNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(friend.getText().toString().equals("1")||friend.getText().toString().equals("2")||friend.getText().toString().equals("3")) {
                 //   l1.setVisibility(View.VISIBLE);
                   // l2.setVisibility(View.VISIBLE);
                    startActivity(new Intent(MainActivity.this,Main3Activity.class));
                }
                else
                    Toast.makeText(MainActivity.this, ">3 friends are not accepted", Toast.LENGTH_SHORT).show();
            }
        });
        btnAdd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent av=new Intent(MainActivity.this,Main2Activity.class);
                av.putExtra("car","1");
                startActivity(av);
            }
        });
        btnAdd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent av=new Intent(MainActivity.this,Main2Activity.class);
                av.putExtra("car","2");
                startActivity(av);
            }
        });

        TabHost.TabSpec spec1 = tabhost.newTabSpec("tab1");
        spec1.setContent(R.id.tab1);
        spec1.setIndicator("Add Carpool");
        TabHost.TabSpec spec2 = tabhost.newTabSpec("tab1");
        spec2.setContent(R.id.tab2);
        spec2.setIndicator("Need a ride");

        tabhost.addTab(spec1);
        tabhost.addTab(spec2);




    }
/*
    public void readFunc(DataSnapshot dataSnapshot){
        Iterator i=dataSnapshot.getChildren().iterator();
        String sourceName;
        String DestinationName;

        while(i.hasNext()){
            sourceName=(String)((DataSnapshot)i.next()).getValue();
            DestinationName=(String)((DataSnapshot)i.next()).getValue();
            s1.append(sourceName+"");
            d1.append(DestinationName+"");
        }
    }

    public void readFuncs(DataSnapshot dataSnapshot){
        Iterator i=dataSnapshot.getChildren().iterator();
        String sourceName;
        String DestinationName;

        while(i.hasNext()){
            sourceName=(String)((DataSnapshot)i.next()).getValue();
            DestinationName=(String)((DataSnapshot)i.next()).getValue();
            s2.setText(sourceName);
            d2.setText(DestinationName);
        }
       }
  */
}
