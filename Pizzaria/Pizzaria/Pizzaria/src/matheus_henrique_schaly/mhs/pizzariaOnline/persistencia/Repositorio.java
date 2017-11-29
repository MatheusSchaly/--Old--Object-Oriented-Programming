package matheus_henrique_schaly.mhs.pizzariaOnline.persistencia;

import java.util.*;

/**
 * Repositorio que armazena elementos.
 * 
 * @author Matheus Henrique Schaly
 */
public abstract class Repositorio<T> {

    /**
     * Default constructor
     */
    public Repositorio() {
    }

    /**
     * Todos os elementos do repositorio.
     */
    private ArrayList<T> elementos;

    /**
     * Salva um elemento no repositorio.
     * @param elemento 
     * @return
     */
    protected void salva(T elemento) {
        // TODO implement here
        return null;
    }

    /**
     * Recupera todos os elementos do repositorio.
     * @return
     */
    protected ArrayList<T> getAll() {
        // TODO implement here
        return null;
    }

}