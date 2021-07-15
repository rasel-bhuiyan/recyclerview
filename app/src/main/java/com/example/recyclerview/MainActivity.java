package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
   public RecyclerView recyclerView;
    CustomRecylerView customRecylerView;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView =findViewById(R.id.recv);

        ArrayList<ModelClass> arrayList = new ArrayList<>();
        arrayList.add(new ModelClass("Rasel","my discription",R.drawable.ic_launcher_background));
        arrayList.add(new ModelClass("nadim","a discription",R.drawable.ic_launcher_background));
        arrayList.add(new ModelClass("dolon","d discription fsdfkjsdfk kdsjf ksfdj skdfjksd jfksdjfi soifuew isjf sk",R.drawable.ic_launcher_background));
        arrayList.add(new ModelClass("akib","x discription",R.drawable.ic_launcher_background));
        arrayList.add(new ModelClass("shanto","e discription",R.drawable.ic_launcher_background));

        customRecylerView  = new CustomRecylerView(MainActivity.this,arrayList);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL);

        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(customRecylerView);


    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_minu,menu);
        MenuItem menuItem = menu.findItem(R.id.searchIcon);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Search here");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                customRecylerView.getFilter().filter(newText);
                return true;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }
}