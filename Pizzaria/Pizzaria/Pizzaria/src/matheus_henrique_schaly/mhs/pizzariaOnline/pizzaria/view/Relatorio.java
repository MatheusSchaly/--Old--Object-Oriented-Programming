package matheus_henrique_schaly.mhs.pizzariaOnline.pizzaria.view;

/**
 *
 * @author Mauricio
 */
public abstract class Relatorio {
    
    private String cabecalho;
    
    private String rodape;
    
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
    
    public void saveCabecalho()
    {
        
    }
    
    public void saveRodape()
    {
        
    }
    
    protected abstract void saveCorpo();
}
