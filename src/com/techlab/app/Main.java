package com.techlab.app;

import com.techlab.productos.Producto;
import com.techlab.productos.ServiciosProductos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ServiciosProductos sistema = new ServiciosProductos();
        Scanner scanner = new Scanner(System.in);
        int opcionUsuario;
        System.out.println("""
                =================================================
                         Bienvenido a la app de compras
                =================================================      
                """);
        label:
        while (true){
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
            opcionUsuario = scanner.nextInt();

            switch (opcionUsuario){
                case 1 -> agregarProducto(scanner, sistema);
                case 7 ->{
                    System.out.println("Gracias por usar nuestra app :)");
                    break label;
                }
                default -> System.err.println("Opcion incorrecta");
            }
        }

    }

    public static void agregarProducto(Scanner scanner, ServiciosProductos sistema){
        scanner.nextLine();

        System.out.println("""
                        ==============================================
                                   Ingreso Nuevo Producto
                        ==============================================
                        """);

        System.out.println("Ingreser el nombre del producto: ");
        String nombre = scanner.nextLine();

        double precio;
        int stock;

        System.out.println("Ingrese  el precio del producto (ej 12,51)");

        try {
            precio = scanner.nextDouble();
        }catch (Exception e){
            System.err.println("Error: el precio debe ser un numero decimal");
            scanner.nextLine();
            return;
        }

        System.out.println("Ingrese  el numero de stock");
        try{
            stock = scanner.nextInt();
        }catch (Exception e){
            System.err.println("Error: El stock debe ser un número entero.");
            scanner.nextLine();
            return;
        }

        try{
            sistema.añadirProducto(nombre,precio,stock);
            System.out.println(nombre +"  Fue agregado con exito");
        }catch (Exception e){
            System.err.println("Error al agregar producto: "+ e.getMessage());
        }
    }
}
