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
    private ArrayList<String, String> pizzas;

    /**
     * @param cpf
     * @param cliente
     * @param Boolean 
     * @param pizzas
     */
    public void Pedido(String cpf, ArrayList<String, String> pizzas) {
        // TODO implement here
    }

    /**
     * @return
     */
    public int getId() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public String getCpf() {
        // TODO implement here
        return null;
    }

    /**
     * @param cliente 
     * @return
     */
    public void setCpf(String cpf) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public ArrayList<String> getPizzas() {
        // TODO implement here
        return null;
    }

    /**
     * @param pizzas 
     * @return
     */
    public void setPizzas(ArrayList<String> pizzas) {
        // TODO implement here
        return null;
    }

}