package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomRecylerView extends RecyclerView.Adapter<CustomRecylerView.MyViewHolder> implements Filterable  {

    Context context;
    ArrayList<ModelClass> arrayList;
    ArrayList<ModelClass> searchListExamplelistFull;

     CustomRecylerView(Context context, ArrayList<ModelClass> arrayList) {

        this.context = context;
        this.arrayList = arrayList;

        this.searchListExamplelistFull = new ArrayList<>(arrayList); //for search bar

    }


    //class

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView Sname,Sdis;
        ImageView Simg;

        public MyViewHolder( View itemView) {
            super(itemView);

            Sname = itemView.findViewById(R.id.Rname);
            Sdis =itemView.findViewById(R.id.Rdis);
            Simg = itemView.findViewById(R.id.Rimage);

        }
    }






    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
       View view = layoutInflater.inflate(R.layout.single_row,viewGroup,false);

       MyViewHolder myViewHolder = new MyViewHolder(view);


        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.Simg.setImageResource(arrayList.get(i).Fimage);
        myViewHolder.Sname.setText(arrayList.get(i).Name.toString());
        myViewHolder.Sdis.setText(arrayList.get(i).Description.toString());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    ///


    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
           List<ModelClass> filteredList = new ArrayList<>();

           if (constraint == null || constraint.length() == 0){
               filteredList.addAll(searchListExamplelistFull);
           }else {
               String filterPattern = constraint.toString().toLowerCase().trim();

               for (ModelClass item: searchListExamplelistFull){
                   if (item.getName().toLowerCase().contains(filterPattern)){
                       filteredList.add(item);
                   }

               }
           }

           FilterResults results = new FilterResults();
           results.values = filteredList;

           return results;

        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            arrayList.clear();
            arrayList.addAll((List)results.values);
            notifyDataSetChanged();
        }
    };


    @Override
    public Filter getFilter() {
        return examplFilter;
    }
    private Filter examplFilter =new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
           List<ModelClass> filteredList = new ArrayList<>();
           if(constraint == null || constraint.length() == 0){
               filteredList.addAll(searchListExamplelistFull);
           }else {
               String filterPattern = constraint.toString().toLowerCase().trim();
               for (ModelClass item : searchListExamplelistFull) {
                   if(item.getName().toLowerCase().contains(filterPattern) || item.getDescription().toLowerCase().contains(filterPattern)){
                       filteredList.add(item);
                   }
               }
           }
           FilterResults results = new FilterResults();
           results.values = filteredList;

           return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            arrayList.clear();;
            arrayList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };
}
