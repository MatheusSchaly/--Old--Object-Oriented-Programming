package matheus_henrique_schaly.mhs.pizzariaOnline.pizzaria.view;

import matheus_henrique_schaly.mhs.pizzariaOnline.persistencia.Repositorio;
import matheus_henrique_schaly.mhs.pizzariaOnline.pizzaria.entidade.ItemPedido;

/**
 *
 * @author Mauricio
 */
public abstract class Relatorio {
    
    private final String cabecalho;
    
    private final String rodape;
    
    protected Repositorio<ItemPedido> itensPedidos;
    
    protected Relatorio(String cabecalho, String rodape)
    {
        this.cabecalho = cabecalho;
        this.rodape = rodape;
    }
    
    public void run()
    {
        saveCabecalho();
        saveCorpo();
        saveRodape();
    }
    
    private void saveCabecalho()
    {
        
    }
    
    private void saveRodape()
    {
        
    }
    
    private void saveCorpo()
    {
        
    }
}
