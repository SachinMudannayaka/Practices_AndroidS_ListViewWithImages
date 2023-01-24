package com.pmadcode13.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String title[]={"Sachin Mudannayaka","Shehan Rasmika","R G U Kithmin","Sathmi Jayasuriya","Vinudha Mandinu"};

    String description[]={"0762838883","0782638556","0764537758","0783546687","0852534467"};

    int image[]={R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listView);

        CustomAdapter adapter=new CustomAdapter(this,title,image,description);
        listView.setAdapter(adapter);

    }
}

class CustomAdapter extends ArrayAdapter<String>{
    Context context;
    int images[];
    String titles[];
    //String[] title;

    String []des;
    CustomAdapter(Context context,String[]title,int[] image,String[]des){
        super(context,R.layout.single_row,R.id.title,title);
        this.context=context;
        this.images=image;
        this.titles=title;
        this.des=des;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       View row= inflater.inflate(R.layout.single_row,parent,false);
        ImageView imageView=row.findViewById(R.id.imageView);
        TextView titleview=row.findViewById(R.id.title);
        TextView descriptionview=row.findViewById(R.id.description);

        imageView.setImageResource(images[position]);
        titleview.setText(titles[position]);
        descriptionview.setText(des[position]);
        return row;
    }
}
