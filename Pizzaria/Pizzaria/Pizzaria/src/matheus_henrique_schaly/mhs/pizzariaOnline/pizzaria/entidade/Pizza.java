package matheus_henrique_schaly.mhs.pizzariaOnline.pizzaria.entidade;

import java.util.*;

/**
 * Gerencia as caracteristicas de uma Pizza.
 * 
 * @author Matheus Henrique Schaly
 */
public class Pizza {
    
    /**
     * @param nome
     * @param ingredientes
     */
    public Pizza(String nome, ArrayList<String> ingredientes) {
        this.nome = nome;
        this.ingredientes = ingredientes;
    }

    /**
     * Nome da pizza.
     */
    private final String nome;

    /**
     * Lista de ingredientes da pizza.
     */
    private final ArrayList<String> ingredientes;

    /**
     * @return
     */
    public String getNome() {
        return nome;
    }
    
    public ArrayList<String> getIngredients()
    {
        return ingredientes;
    }
}