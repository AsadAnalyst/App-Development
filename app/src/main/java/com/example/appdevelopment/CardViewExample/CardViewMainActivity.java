package com.example.appdevelopment.CardViewExample;

import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import com.example.appdevelopment.R;
import com.example.appdevelopment.databinding.ActivityCardViewMainBinding;

import java.util.ArrayList;
import java.util.List;
public class CardViewMainActivity extends AppCompatActivity {

    private ActivityCardViewMainBinding binding;
    public List<MyModel> list;
    public MyCardViewAdapter adapter;

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCardViewMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());

        FloatingActionButton fab = binding.fab;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null)
                        .setAnchorView(R.id.fab).show();
            }
        });
        list=new ArrayList<>();
        adapter=new MyCardViewAdapter(this, list);
        recyclerView=findViewById(R.id.myrecyclerView);
        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new GridSpacing(2,12,true));

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        Insert();
    }

    private class GridSpacing extends RecyclerView.ItemDecoration{
        int count,spacing;
        boolean Edgeinclude;

        public GridSpacing(int count, int spacing, boolean edgeinclude) {
            this.count = count;
            this.spacing = spacing;
            Edgeinclude = edgeinclude;
        }
    }
    public void Insert(){
        int[] image=new int[]{
                R.drawable.images,
                R.drawable.images,
                R.drawable.images,
                R.drawable.images,
                R.drawable.images,
                R.drawable.images,
                R.drawable.images,
                R.drawable.images
        };
        MyModel obj=new MyModel("First", 10, image[0]);
        list.add(obj);
        MyModel obj1=new MyModel("Second", 20, image[1]);
        list.add(obj1);
        MyModel obj2=new MyModel("Third", 30, image[2]);
        list.add(obj2);
        MyModel obj3=new MyModel("Fourth", 40, image[3]);
        list.add(obj3);
        MyModel obj4=new MyModel("Five", 50, image[4]);
        list.add(obj4);
        MyModel obj5=new MyModel("Six", 60, image[5]);
        list.add(obj5);
        MyModel obj6=new MyModel("Seven", 70, image[6]);
        list.add(obj6);
        MyModel obj7=new MyModel("Eight", 80, image[7]);
        list.add(obj7);
    }
}