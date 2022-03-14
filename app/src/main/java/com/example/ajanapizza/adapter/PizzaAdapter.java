package com.example.ajanapizza.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ajanapizza.beans.Produit;
import com.example.ajanapizza.R;


import java.util.List;

public class PizzaAdapter extends BaseAdapter {
    private List<Produit> produits;
    private LayoutInflater inflater;

    public PizzaAdapter(Activity activity, List<Produit> produits) {
        this.produits = produits;
        this.inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return produits.size();
    }

    @Override
    public Object getItem(int position) {
        return produits.get(position);
    }

    @Override
    public long getItemId(int position) {
        return produits.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null)
            convertView = inflater.inflate(R.layout.item, null);

        TextView id = convertView.findViewById(R.id.id);
        TextView nom = convertView.findViewById(R.id.nom);
        TextView nbrIngr = convertView.findViewById(R.id.nbrIngr);
        TextView duree = convertView.findViewById(R.id.duree);
        ImageView image = convertView.findViewById(R.id.image);

        id.setText(produits.get(position).getId()+"");
        nom.setText(produits.get(position).getNom());
        nbrIngr.setText(produits.get(position).getNbrIngredients()+"");
        duree.setText(produits.get(position).getDuree()+" minutes");
        image.setImageResource(produits.get(position).getPhoto());


        return convertView;
    }
}
