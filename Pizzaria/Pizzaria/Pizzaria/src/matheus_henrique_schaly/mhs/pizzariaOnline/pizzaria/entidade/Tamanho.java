package matheus_henrique_schaly.mhs.pizzariaOnline.pizzaria.entidade;

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
}
