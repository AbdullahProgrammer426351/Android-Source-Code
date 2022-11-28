package com.example.recyclerviewwithcardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rcv;
    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Recycler View and Card View Demo");
        rcv = (RecyclerView) findViewById(R.id.review);
        rcv.setLayoutManager(new LinearLayoutManager(this));

        adapter = new MyAdapter(dataqueue());
        rcv.setAdapter(adapter);

    }


    public ArrayList<Model> dataqueue(){
        ArrayList<Model> holder = new ArrayList<>();
        Model obj1 = new Model();
        obj1.setHeader("C Programming");
        obj1.setDesc("This is C Programming");
        obj1.setImageName(R.drawable.logo1);
        holder.add(obj1);

        Model obj2 = new Model();
        obj2.setHeader("C Programming");
        obj2.setDesc("This is C Programming");
        obj2.setImageName(R.drawable.logo2);
        holder.add(obj2);


        Model obj3 = new Model();
        obj3.setHeader("C Programming");
        obj3.setDesc("This is C Programming");
        obj3.setImageName(R.drawable.logo3);
        holder.add(obj3);


        Model obj4 = new Model();
        obj4.setHeader("C Programming");
        obj4.setDesc("This is C Programming");
        obj4.setImageName(R.drawable.logo4);
        holder.add(obj4);


        Model obj5 = new Model();
        obj5.setHeader("C Programming");
        obj5.setDesc("This is C Programming");
        obj5.setImageName(R.drawable.logo5);
        holder.add(obj5);


        Model obj6 = new Model();
        obj6.setHeader("C Programming");
        obj6.setDesc("This is C Programming");
        obj6.setImageName(R.drawable.logo6);
        holder.add(obj6);


        Model obj7 = new Model();
        obj7.setHeader("C Programming");
        obj7.setDesc("This is C Programming");
        obj7.setImageName(R.drawable.logo7);
        holder.add(obj7);



        Model obj8 = new Model();
        obj8.setHeader("C Programming");
        obj8.setDesc("This is C Programming");
        obj8.setImageName(R.drawable.logo8);
        holder.add(obj8);


        Model obj9 = new Model();
        obj9.setHeader("C Programming");
        obj9.setDesc("This is C Programming");
        obj9.setImageName(R.drawable.logo9);
        holder.add(obj9);

        Model obj10 = new Model();
        obj10.setHeader("C Programming");
        obj10.setDesc("This is C Programming");
        obj10.setImageName(R.drawable.logo10);
        holder.add(obj10);


        Model obj11 = new Model();
        obj11.setHeader("C Programming");
        obj11.setDesc("This is C Programming");
        obj11.setImageName(R.drawable.logo11);
        holder.add(obj11);


        Model obj12 = new Model();
        obj12.setHeader("C Programming");
        obj12.setDesc("This is C Programming");
        obj12.setImageName(R.drawable.logo12);
        holder.add(obj12);

        Model obj13= new Model();
        obj13.setHeader("C Programming");
        obj13.setDesc("This is C Programming");
        obj13.setImageName(R.drawable.logo13);
        holder.add(obj13);


        return holder;
    }
}