package com.example.itaykan.firebase1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mDatabaseReference = mDatabase.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //mDatabaseReference = mDatabase.getReference().child("name");
       // mDatabaseReference.setValue("Donald Duck");


        //mDatabase.getReference().child("users/1").addListenerForSingleValueEvent();

        mDatabase.getReference().child("users/1").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                Toast.makeText(getBaseContext(), "User: " + user.getName() + " " + String.valueOf(user.getAge()),
                Toast.LENGTH_SHORT).show();
                int x = 1;
                // ...
                //writeNewMessage(...);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                int x= 1;
                Toast.makeText(getBaseContext(), "User: " + error,
                        Toast.LENGTH_SHORT).show();
            }
        });


        //Toast.makeText(this, mDatabaseReference.toString(), Toast.LENGTH_SHORT).show();

       mDatabaseReference = mDatabase.getReference().child("users/1");
       User u = new User("itay", 18);
       mDatabaseReference.setValue(u);
    }
}
