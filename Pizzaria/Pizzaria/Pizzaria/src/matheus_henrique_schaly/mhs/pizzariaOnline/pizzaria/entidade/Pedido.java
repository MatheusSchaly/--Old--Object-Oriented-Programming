package matheus_henrique_schaly.mhs.pizzariaOnline.pizzaria.entidade;

import java.util.*;

/**
 * Gerencia o pedido feito por um Cliente associado a um conjunto de Pizzas.
 * 
 * @author Matheus Henrique Schaly
 */
public class Pedido {

    /**
     * @param cpf
     * @param confirmacao
     * @param itensPedidos
     */
    public Pedido(String cpf, boolean confirmacao, ArrayList<ItemPedido> itensPedidos) {
        this.cpf = cpf;
        this.confirmacao = confirmacao;
        this.id = Pedido.nextId;
        Pedido.nextId++;
        this.itensPedidos = itensPedidos;
    }
    
    /**
     * ID da classe Pedido.
     */
    private static int nextId = 1;

    /**
     * ID do objeto pedido.
     */
    private final int id;

    /**
     * Cliente que realizou o pedido.
     */
    private final String cpf;

    /**
     * Lista de pizzas pedidas.
     */
    private final ArrayList<ItemPedido> itensPedidos;
    
    private final boolean confirmacao;

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
    
    public int getId()
    {
        return this.id;
    }
    
    public String getCpf()
    {
        return this.cpf;
    }
}