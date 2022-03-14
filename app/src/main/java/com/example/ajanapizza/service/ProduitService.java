package com.example.ajanapizza.service;




import com.example.ajanapizza.beans.Produit;
import com.example.ajanapizza.dao.IDao;

import java.util.ArrayList;
import java.util.List;

public class ProduitService implements IDao<Produit> {

    private List<Produit> pizzas;
    private static ProduitService instance;
    private ProduitService()
    {
        this.pizzas=new ArrayList<>();
    }
    @Override
    public boolean create(Produit o) {
        return pizzas.add(o);
    }

    @Override
    public boolean update(Produit o) {
        return false;
    }

    @Override
    public boolean delete(Produit o) {
        return pizzas.remove(o);
    }

    @Override
    public Produit findById(int id)
    {
        for(Produit v : pizzas)
        {
            if(v.getId() == id)
            {
                return v ;
            }
        }return null;
    }

    @Override
    public List<Produit> findAll() {
        return pizzas;
    }

    public synchronized static ProduitService getInstance()
    {
        if(instance==null)
        {
            instance=new ProduitService();
        }
        return instance;
    }
}
