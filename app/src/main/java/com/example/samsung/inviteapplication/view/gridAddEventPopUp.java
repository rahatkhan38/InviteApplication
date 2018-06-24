package com.example.samsung.inviteapplication.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.samsung.inviteapplication.R;

public class gridAddEventPopUp extends AppCompatActivity {

    public static final String MESSAGE_KEY="msg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_add_event_pop_up);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*0.8), (int)(height*0.5));

         final EditText addNewEvent = (EditText)findViewById(R.id.newEvent);
        addNewEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewEvent.setText("");
            }
        });

        //addEvent_button
        final Button addEvent;
        addEvent = (Button) findViewById(R.id.addEvent_button);
        addEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText new_Event = (EditText)findViewById(R.id.newEvent);
                String message = new_Event.getText().toString();
                Intent intent = new Intent();
                intent.putExtra(MESSAGE_KEY,message);
                setResult(RESULT_OK,intent);
                System.out.println(message);
                finish();
                //Intent intent = new Intent(gridAddEventPopUp.this, make_invitation.class);
                //startActivity(intent);
            }
        });
    }
}