package matheus_henrique_schaly.mhs.pizzariaOnline.pizzaria.entidade;

import java.math.BigDecimal;
import java.util.*;

/**
 * Gerencia as caracteristicas de uma Pizza.
 * 
 * @author Matheus Henrique Schaly
 */
public class Pizza {

    /**
     * Default constructor
     */
    public Pizza() {
    }

    /**
     * Nome da pizza.
     */
    private String nome;

    /**
     * Lista de ingredientes da pizza.
     */
    private ArrayList<String> ingredientes;

    /**
     * @param nome
     * @param ingredientes
     * @param valor
     */
    public Pizza(String nome, ArrayList<String> ingredientes) {
        this.nome = nome;
        this.ingredientes = ingredientes;
    }

    /**
     * @return
     */
    public String getNome() {
        return nome;
    }
}