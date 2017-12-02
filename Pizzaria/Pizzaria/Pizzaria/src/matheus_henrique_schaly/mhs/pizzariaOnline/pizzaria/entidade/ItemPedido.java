package matheus_henrique_schaly.mhs.pizzariaOnline.pizzaria.entidade;

import java.math.BigDecimal;

/**
 *
 * @author Mauricio e Matheus Skalhy
 */
public class ItemPedido {

    private final Pizza pizza;
    
    private final Tamanho tamanho;
    
    private final BigDecimal preco;
    
    public ItemPedido(Pizza pizza, Tamanho tamanho, BigDecimal preco) {
        this.pizza = pizza;
        this.tamanho = tamanho;
        this.preco = preco;
    }
    
    public Pizza getPizza()
    {
        return pizza;
    }
    
    public Tamanho getTamanho()
    {
        return tamanho;
    }
    
    public BigDecimal getPreco()
    {
        return preco;
    }
    
    
    
}
