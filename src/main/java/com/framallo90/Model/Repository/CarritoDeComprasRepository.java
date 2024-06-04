package com.framallo90.Model.Repository;

import com.framallo90.Interface.RepositoryInterface;
import com.framallo90.Model.Entity.CarritoDeCompras;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class CarritoDeComprasRepository implements RepositoryInterface <CarritoDeCompras> {
    private Map<String, CarritoDeCompras> carritoMap = new HashMap<>();
    private static final String PATH = "src/main/resources/carrito.json";
    private Gson gson = new Gson();


    @Override
    public void add(CarritoDeCompras object) {

    }

    @Override
    public void remove(CarritoDeCompras object) {

    }

    @Override
    public void update(CarritoDeCompras object) {

    }

    @Override
    public CarritoDeCompras find(int id) {
        return null;
    }
}
