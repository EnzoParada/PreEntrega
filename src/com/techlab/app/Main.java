package com.techlab.app;

import com.techlab.pedidos.Pedido;
import com.techlab.productos.Producto;
import com.techlab.productos.ServiciosProductos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ServiciosProductos sistema = new ServiciosProductos();
        Pedido pedido = new Pedido();
        Scanner scanner = new Scanner(System.in);
        int opcionUsuario;
        System.out.println("""
                =================================================
                         Bienvenido a la app de compras
                =================================================      
                """);
        label:
        while (true) {
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

            switch (opcionUsuario) {
                case 1 -> agregarProducto(scanner, sistema);
                case 2 -> lista(sistema);
                case 3 -> actProducto(scanner, sistema);
                case 4 -> eliminarProducto(scanner, sistema);

                case 7 -> {
                    System.out.println("Gracias por usar nuestra app :)");
                    break label;
                }
                default -> System.err.println("Opcion incorrecta");
            }
        }
    }


    public static void agregarProducto(Scanner scanner, ServiciosProductos sistema) {
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
        } catch (Exception e) {
            System.err.println("Error: el precio debe ser un numero decimal");
            scanner.nextLine();
            return;
        }

        System.out.println("Ingrese  el numero de stock");
        try {
            stock = scanner.nextInt();
        } catch (Exception e) {
            System.err.println("Error: El stock debe ser un número entero.");
            scanner.nextLine();
            return;
        }
        scanner.nextLine();
        try {
            sistema.añadirProducto(nombre, precio, stock);
            System.out.println(nombre + "  Fue agregado con exito");
        } catch (Exception e) {
            System.err.println("Error al agregar producto: " + e.getMessage());
        }
    }

    public static void lista(ServiciosProductos sistema) {
        System.out.println("""
                        ==============================================
                                   Lista de Productos
                        ==============================================
                        """);
        sistema.traerLista();
    }

    public static void actProducto(Scanner scanner, ServiciosProductos sistema) {
        scanner.nextLine();
        System.out.println("""
                ==============================================
                           Actualizar Producto
                ==============================================
                """);
        System.out.println("Ingrese el nombre del producto que desea actualizar:");
        String nombre = scanner.nextLine();

        double precio;
        int stock;

        System.out.println("Actualice el precio del producto (ej 12,51)");

        try {
            precio = scanner.nextDouble();
        } catch (Exception e) {
            System.err.println("Error: el precio debe ser un numero decimal");
            scanner.nextLine();
            return;
        }

        System.out.println("Actualice el numero de stock");
        try {
            stock = scanner.nextInt();
        } catch (Exception e) {
            System.err.println("Error: El stock debe ser un número entero.");
            scanner.nextLine();
            return;
        }
        scanner.nextLine();
        try{
            Producto productoActualizado = new Producto(nombre,precio,stock);

            sistema.actualizar(productoActualizado);
            System.out.println(productoActualizado.getNombre() +" Fue actualizado con exito") ;
        }catch(Exception e){
            System.err.println("Error al intentar actualizar el producto ");
        }
    }
    public static void eliminarProducto(Scanner scanner,ServiciosProductos sistema){
        scanner.nextLine();
        System.out.println("""
                ==============================================
                           Eliminar Producto
                ==============================================
                """);
        System.out.println("Ingrese el nombre del producto que desea eliminar:");
        String nombre = scanner.nextLine();

        try {
            sistema.eliminar(nombre);
            System.out.println(nombre +" Fue actualizado con exito") ;
        }catch (Exception e){
            System.err.println("Error al intentar eliminar el producto");
        }
    }
    public static void crearProducto(Scanner scanner,Pedido pedido,ServiciosProductos sistema){
        scanner.nextLine();
        int opcion;
        System.out.println("""
                ==============================================
                                Crear Pedido
                ==============================================
                """);
        label:
        while (true){
            System.out.println("""
                
                1- Añadir Productos
                2- Finalizar
                """);
            opcion=scanner.nextInt();
            scanner.nextLine();
            switch (opcion){
                case 1 ->{
                    sistema.traerLista();
                    System.out.println("Ingrese el nombre del producto: ");
                    String nombre = scanner.nextLine();

                    Producto productoBuscado = null;
                    for(Producto p: sistema.getLstProductos()){
                        if(p.getNombre().equalsIgnoreCase(nombre)){
                            productoBuscado = p;
                            break ;
                        }
                    }
                    if (productoBuscado != null){
                        try{
                            System.out.println("Ingrese la cantidad deseada");
                            int cantidad = scanner.nextInt();
                            scanner.nextLine();

                            pedido.
                        }catch ()
                    }
                }
                case 2 ->{
                    break label;
                }
                default -> System.err.println("Opcion incorrecta");
            }
        }

    }
}