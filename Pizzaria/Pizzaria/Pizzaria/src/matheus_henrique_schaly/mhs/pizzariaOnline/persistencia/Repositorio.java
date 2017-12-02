package matheus_henrique_schaly.mhs.pizzariaOnline.persistencia;

import java.util.*;

/**
 * Repositorio que armazena elementos.
 * 
 * @author Matheus Schaly e Mauricio Farias 
 * @param <T>
 */
public class Repositorio<T> {

    public ArrayList<T> elementos = new ArrayList<>();
    
    /**
     * Default constructor
     */
    public Repositorio() {}
    
    /**
     * 
     * @param elemento 
     */
    public void salva(T elemento)
    {
        elementos.add(elemento);
    }

    /**
     * 
     * @return 
     */
    public ArrayList getAll() 
    {
        return elementos;
    }
    
    /**
     * 
     * @param posicao
     * @return 
     */
    public T get(int posicao)
    {
        return elementos.get(posicao);
    }
}