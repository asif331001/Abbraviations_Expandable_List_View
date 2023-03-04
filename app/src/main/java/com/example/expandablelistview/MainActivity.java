package com.example.expandablelistview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView expandableListView;
    private CustomAdapter customAdapter;
    List<String> listDataHeader;
    HashMap<String,List<String>> listDataChild;

    private int lastExpandedPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prepareListData();

        expandableListView = (ExpandableListView) findViewById(R.id.expandableListViewId);
        customAdapter = new CustomAdapter(this,listDataHeader,listDataChild);
        expandableListView.setAdapter(customAdapter);

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {

                String groupName = listDataHeader.get(i);
                Toast.makeText(getApplicationContext(),groupName,Toast.LENGTH_SHORT).show();

                return false;
            }
        });

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int i) {
                if (lastExpandedPosition!= -1 && lastExpandedPosition!= i);{

                    expandableListView.collapseGroup(lastExpandedPosition);
                }
                lastExpandedPosition = i;
            }
        });

    }
    public void prepareListData(){

        String[] headerString = getResources().getStringArray(R.array.abbreviation_list_header);
        String[] childString = getResources().getStringArray(R.array.abbreviation_list_child);

        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

        for (int i=0; i<headerString.length; i++){

            //adding header data
            listDataHeader.add(headerString[i]);

            List<String> child = new ArrayList<>();
            child.add(childString[i]);

            listDataChild.put(listDataHeader.get(i),child);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_layout,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.shareid){

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");

            String menuSubject = "Abbreviation App";
            String menuBody = "This is very usefull app. \npackage com.example.expandablelistview;";

            intent.putExtra(Intent.EXTRA_SUBJECT,menuSubject);
            intent.putExtra(Intent.EXTRA_TEXT,menuBody);

            startActivity(Intent.createChooser(intent,"share With "));
        }

        if (item.getItemId()==R.id.feedbackid){

            Intent feedbackIntent = new Intent(getApplicationContext(),feedback.class);
            startActivity(feedbackIntent);
        }

        if (item.getItemId()==R.id.contactid){

            Intent contactIntent = new Intent(getApplicationContext(),Contact_us.class);
            startActivity(contactIntent);

        }

        if (item.getItemId()==R.id.aboutid){

            Intent aboutIntent = new Intent(getApplicationContext(),About_us.class);
            startActivity(aboutIntent);
        }

        return super.onOptionsItemSelected(item);
    }

}