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

    /**
     * @param nome 
     * @return
     */
    public void setNome(String nome) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public HashMap<String int> getTamanho() {
        // TODO implement here
        return null;
    }

    /**
     * @param tamanho 
     * @return
     */
    public void setTamanho(HashMap<String int> tamanho) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public ArrayList<String> getIngredientes() {
        // TODO implement here
        return null;
    }

    /**
     * @param ingredientes 
     * @return
     */
    public void setIngredientes(ArrayList<String> ingredientes) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public float getValor() {
        // TODO implement here
        return 0.0f;
    }

    /**
     * @param valor 
     * @return
     */
    public void setValor(float valor) {
        // TODO implement here
        return null;
    }

}