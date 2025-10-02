package com.techlab.pedidos;

import com.techlab.productos.Producto;

public class LineaPedido {
    private Producto producto;
    private int cantidad;

    public LineaPedido(Producto producto,int cantidad) {
        if(cantidad <=0 ){
            throw  new IllegalArgumentException("La cantidad no puede ser menor o igual a 0");
        }
        if(producto == null){
            throw  new IllegalArgumentException("La cantidad no puede ser nula");
        }
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad){
        if(cantidad <=0){
            throw  new IllegalArgumentException("La cantidad no puede ser menor o igual a 0");
        }
        this.cantidad = cantidad;
    }
    public double calcularCosto(){
        return producto.getPrecio()*cantidad;
    }
}
