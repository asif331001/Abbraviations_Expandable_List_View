package com.example.expandablelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
    HashMap<String, List<String>> listDataChild;

    private int lastExpandedPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prepareListData();

        expandableListView = (ExpandableListView) findViewById(R.id.expandableListViewId);
        customAdapter = new CustomAdapter(this, listDataHeader, listDataChild);
        expandableListView.setAdapter(customAdapter);

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {

                String groupName = listDataHeader.get(i);
                Toast.makeText(getApplicationContext(), groupName, Toast.LENGTH_SHORT).show();

                return false;
            }
        });

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int i) {
                if (lastExpandedPosition != -1 && lastExpandedPosition != i) ;
                {

                    expandableListView.collapseGroup(lastExpandedPosition);
                }
                lastExpandedPosition = i;
            }
        });

    }

    public void prepareListData() {


        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

        listDataHeader.add("1. Overview");
        listDataHeader.add("2. ProgramStucture");
        listDataHeader.add("3. Keyword");
        listDataHeader.add("4. Variable");
        listDataHeader.add("5. Operators");
        listDataHeader.add("6. Comments");



        List<String> overView = new ArrayList<>();
        overView.add("1.1 What is c language");
        overView.add("1.2 History of c ");
        overView.add("1.3 Feature of c");
        overView.add("1.4 Advantages of c");
        List<String> programStucture = new ArrayList<>();
        programStucture.add("1.1 What is c language");
        programStucture.add("1.2 History of c ");
        programStucture.add("1.3 Feature of c");
        programStucture.add("1.4 Advantages of c");
        List<String> keyword = new ArrayList<>();
        keyword.add("1.1 What is c language");
        keyword.add("1.2 History of c ");
        keyword.add("1.3 Feature of c");
        keyword.add("1.4 Advantages of c");
        List<String> variable = new ArrayList<>();
        variable.add("1.1 What is c language");
        variable.add("1.2 History of c ");
        variable.add("1.3 Feature of c");
        variable.add("1.4 Advantages of c");
        List<String> operators = new ArrayList<>();
        operators.add("1.1 What is c language");
        operators.add("1.2 History of c ");
        operators.add("1.3 Feature of c");
        operators.add("1.4 Advantages of c");
        List<String> comments = new ArrayList<>();
        comments.add("1.1 What is c language");
        comments.add("1.2 History of c ");
        comments.add("1.3 Feature of c");
        comments.add("1.4 Advantages of c");

        listDataChild.put(listDataHeader.get(0), overView);
        listDataChild.put(listDataHeader.get(1), programStucture);
        listDataChild.put(listDataHeader.get(2), keyword);
        listDataChild.put(listDataHeader.get(3), variable);
        listDataChild.put(listDataHeader.get(4), operators);
        listDataChild.put(listDataHeader.get(5), comments);
    }
}

