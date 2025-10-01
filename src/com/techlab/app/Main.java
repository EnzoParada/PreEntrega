package com.techlab.app;

import com.techlab.productos.Producto;
import com.techlab.productos.ServiciosProductos;

public class Main {
    public static void main(String[] args) {
        ServiciosProductos sistema = new ServiciosProductos();

        System.out.println("""
                =================================================
                         Bienvenido a la app de compras
                =================================================      
                """);

        System.out.println("""
                OPCIONES:
                1-Agregar producto
                2-Listar productos
                3-Buscar/Actualizar producto
                4-Eliminar producto
                5-Crear pedido
                6-Listar pedidos
                7-Salir
                """);
        try{
            sistema.agregarProducto("Bolsa de Granos de Café Premium (500g)", 12.75, 90);
            sistema.agregarProducto("Aceite de Oliva Extra Virgen (1 Litro)",8.50,210);
            sistema.agregarProducto("Caja de 12 Yogurt Natural",5.99,155);
            sistema.traerLista();
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
