package matheus_henrique_schaly.mhs.pizzariaOnline.pizzaria.entidade;

import java.util.*;

/**
 * Gerencia o pedido feito por um Cliente associado a um conjunto de Pizzas.
 * 
 * @author Matheus Henrique Schaly
 */
public class Pedido {

    /**
     * Default constructor
     */
    public Pedido() {
    }

    /**
     * ID da classe Pedido.
     */
    private static int nextId = 1;

    /**
     * ID do objeto pedido.
     */
    private int id;

    /**
     * Cliente que realizou o pedido.
     */
    private String cpf;

    /**
     * Lista de pizzas pedidas.
     */
    private ArrayList<ItemPedido> itensPedidos;
    
    private boolean confirmacao;

    /**
     * @param cpf
     * @param confirmacao
     * @param itensPedidos
     */
    public Pedido(String cpf, boolean confirmacao, ArrayList<ItemPedido> itensPedidos) {
        // TODO implement here
    }

    public ArrayList<ItemPedido> getItemPedidos()
    {
        return itensPedidos;
    }
    
    public ItemPedido getItemPedido(int i)
    {
        return itensPedidos.get(i);
    }
    
    public boolean getConfirmacao()
    {
        return this.confirmacao;
    }
}