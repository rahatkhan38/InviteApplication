package com.example.samsung.inviteapplication.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.samsung.inviteapplication.R;
import com.example.samsung.inviteapplication.view.customAdapter;
import com.example.samsung.inviteapplication.view.gridItems;

import java.util.ArrayList;

public class Grid_Activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private customAdapter mAdapter;
    private GridLayoutManager gridLayoutManager;
    ArrayList<gridItems> itemList;
    private static final int REQUEST_CODE = 100;
    public static final String MESSAGE_KEY="msg";
    private String eventName = "New Event";
    private int addAtThisIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_);

        createList();
        buildRecyclerView();



        mAdapter.setOnItemClickListener(new customAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                if(position==itemList.size()-1)
                {
                    Intent intent = new Intent(getApplicationContext(),gridAddEventPopUp.class);
                    intent.putExtra(MESSAGE_KEY,eventName);
                    startActivityForResult(intent,REQUEST_CODE);
                    addAtThisIndex = position;
                }
                else {
                    Intent intent = new Intent(getApplicationContext(),invite_navigation.class);
                    startActivity(intent);
                }

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data )
    {
        if(requestCode==REQUEST_CODE)
        {
            if(resultCode==RESULT_OK)
            {
                System.out.println(eventName);
                eventName = data.getStringExtra(MESSAGE_KEY);
                System.out.println("received: " + eventName);
                addItem(addAtThisIndex);
            }
        }
        super.onActivityResult(requestCode,resultCode,data);
    }

    public void addItem(int position)
    {
        itemList.add(position,new gridItems(R.drawable.try_gif, eventName));
        // mAdapter.notifyDataSetChanged();
        mAdapter.notifyItemInserted(position);
    }

    public void removeItem(int position)
    {
        itemList.remove(position);
        //mAdapter.notifyDataSetChanged();
        mAdapter.notifyItemRemoved(position);
    }

    public void createList()
    {
        itemList = new ArrayList<>();
        itemList.add(new gridItems(R.mipmap.as_bday,"Birthday"));
        itemList.add(new gridItems(R.mipmap.as_christmas,"Christmas"));
        itemList.add(new gridItems(R.mipmap.as_wed,"Wedding"));
        itemList.add(new gridItems(R.mipmap.as_newyear,"New Year"));
        itemList.add(new gridItems(R.mipmap.as_teaparty,"Tea Party"));
        itemList.add(new gridItems(R.mipmap.as_anniversary,"Anniversary"));
        itemList.add(new gridItems(R.mipmap.as_eid,"Eid"));
        itemList.add(new gridItems(R.mipmap.as_addnew,"Add Event"));
    }

    public void buildRecyclerView()
    {
        recyclerView = (RecyclerView) findViewById(R.id.gif_recycler_view);
        gridLayoutManager = new GridLayoutManager(Grid_Activity.this,2);
        mAdapter = new customAdapter(itemList);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(mAdapter);
    }
}
