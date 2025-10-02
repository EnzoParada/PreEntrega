package com.techlab.pedidos;

public class Pedido {
    private static int idInc = 1;
    private int idPedido;
    private int idCliente;

    public Pedido(){
        this.idPedido = idInc ++;
        this.idCliente = idCliente;
    }

}
