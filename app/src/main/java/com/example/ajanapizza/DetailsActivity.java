package com.example.ajanapizza;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ajanapizza.beans.Produit;
import com.example.ajanapizza.service.ProduitService;

public class DetailsActivity extends AppCompatActivity {
    ProduitService ps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ps = ProduitService.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        /*TextView=findViewById(R.id.)*/
        Intent myIntent = getIntent();
        String ids= myIntent.getStringExtra("idpizza");
        Toast.makeText(this,"helo "+ids,Toast.LENGTH_LONG);
        int id=Integer.parseInt(ids);
        Produit p = ps.findById(id);
        TextView nom = (TextView) findViewById(R.id.nom);
        TextView des = (TextView) findViewById(R.id.descr1);
        TextView ing = (TextView) findViewById(R.id.ingred1);
        ImageView i = (ImageView) findViewById(R.id.imageView4);
        i.setImageResource(p.getPhoto());
        nom.setText(p.getNom());
        des.setText(p.getDescription());
        ing.setText(p.getDetailsIngred());




    }
}
