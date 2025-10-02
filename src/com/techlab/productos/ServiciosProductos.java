package com.techlab.productos;

import java.util.ArrayList;
import java.util.List;

public class ServiciosProductos {
    private List<Producto> lstProductos;

    public ServiciosProductos() {
        this.lstProductos = new ArrayList<Producto>();
    }

    public List<Producto> getLstProductos() {
        return lstProductos;
    }

    public void añadirProducto(String nombre, double precio, int stock) throws Exception {
        for (Producto p : lstProductos) {
            if (p.getNombre().equals(nombre)) {
                throw new Exception("Ya existe este producto: " + p.getNombre());
            }
        }
        Producto producto = new Producto(nombre, precio, stock);
        lstProductos.add(producto);
    }

    public void traerLista() {
        for (Producto p : lstProductos) {
            System.out.println(p);
        }
    }

    public void actualizar(Producto productoActualizado) throws Exception {
        String nombreActualizado = productoActualizado.getNombre();
        boolean encontrado = false;
        for (Producto p : lstProductos) {
            if (p.getNombre().equals(nombreActualizado)) {
                p.setPrecio(productoActualizado.getPrecio());
                p.setStock(productoActualizado.getStock());
                encontrado = true;
                break;
            }
            if (!encontrado) {
                throw new Exception("no existe este producto: " + p.getNombre());
            } ;
        }
    }

    public void eliminar(String nombre) throws Exception {
        for (Producto p : lstProductos) {
            if (p.getNombre().equals(nombre)) {
                lstProductos.remove(p);
                break;
            }
            throw new Exception("no existe este producto: " + p.getNombre());
        }
    }
}
