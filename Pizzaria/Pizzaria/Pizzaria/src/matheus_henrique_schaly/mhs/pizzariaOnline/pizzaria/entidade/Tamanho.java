package matheus_henrique_schaly.mhs.pizzariaOnline.pizzaria.entidade;

import com.sun.org.apache.xpath.internal.operations.Equals;

/**
 *
 * @author Mauricio e Matheus
 */
public class Tamanho {

    private final String description;
    
    private final int tamanho;
    
    public Tamanho(String description, int tamanho) {
        this.description = description;
        this.tamanho = tamanho;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public int getTamanho()
    {
        return tamanho;
    }
    
    @Override
    public boolean equals(Object obj)
    {
        Tamanho objeto = (Tamanho)obj;
        return this.description.equals(objeto.getDescription()) &&
                this.tamanho == objeto.tamanho;
    }
}
