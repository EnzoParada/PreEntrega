package com.techlab.pedidos;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private static int idInc = 1;
    private int idPedido;
    private List<LineaPedido> lineasPedido;
    private String estado;

    public Pedido() {
        this.idPedido = idInc++;
        this.lineasPedido = new ArrayList<LineaPedido>();
        this.estado = "PENDIENTE";
    }

}