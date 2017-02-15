package gajendra.rathore.carpooling;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Iterator;

public class Main3Activity extends AppCompatActivity {

    DatabaseReference root;
    TextView s1, d1, s2, d2;
    LinearLayout l1;
    LinearLayout l2;
    Button loc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        l1=(LinearLayout)findViewById(R.id.linlay1);
        l2=(LinearLayout)findViewById(R.id.linlay2);

        s1 = (TextView) findViewById(R.id.Sou);
        s2 = (TextView) findViewById(R.id.Sou2);
        d1 = (TextView) findViewById(R.id.Des);
        d2 = (TextView) findViewById(R.id.Des2);
        loc =(Button)findViewById(R.id.button2);

        // Goes to Location Page from Main3Activity to Location
        loc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main3Activity.this,Location.class));
            }
        });
        //END


        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l1.setBackgroundColor(Color.GREEN);
                d1.append("\nBOOKED");
                Toast.makeText(Main3Activity.this, "Your ride is booked..!!! \n", Toast.LENGTH_SHORT).show();
            }
        });

        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l2.setBackgroundColor(Color.GREEN);
                d2.append("\nBOOKED");
                Toast.makeText(Main3Activity.this, "Your ride is booked..!!! \n", Toast.LENGTH_SHORT).show();
            }
        });


        root = FirebaseDatabase.getInstance().getReference();


        root.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                newFunc(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                newFunc(dataSnapshot);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    String s, e, f, d;

    private void newFunc(DataSnapshot dataSnapshot) {
        Iterator i = dataSnapshot.getChildren().iterator();

        while (i.hasNext()) {
            d = (String) ((DataSnapshot) i.next()).getValue();
            s = (String) ((DataSnapshot) i.next()).getValue();
            e = (String) ((DataSnapshot) i.next()).getValue();
            f = (String) ((DataSnapshot) i.next()).getValue();
            d1.setText("Destination : " + d);
            d2.setText("Destination : " + s);
            s1.setText("source : " + e);
            s2.setText("Source : " + f);
        }
    }

}
