package com.framallo90.Model.Entity;

import java.util.List;

public class CarritoDeCompras {
    private int id;
    private static int idCont = 0;
    private Usuario usuario;
    private List<Libro> detalleCompra;
    private float total;

    public CarritoDeCompras(Usuario usuario, List<Libro> detalleCompra, float total) {
        this.id = ++idCont;
        this.usuario = usuario;
        this.detalleCompra = detalleCompra;
        this.total = total;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Libro> getDetalleCompra() {
        return detalleCompra;
    }

    public void setDetalleCompra(List<Libro> detalleCompra) {
        this.detalleCompra = detalleCompra;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
