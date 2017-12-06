package matheus_henrique_schaly.mhs.pizzariaOnline.pizzaria.entidade;

/**
 * Gerencia as caracteristicas de um Cliente.
 * 
 * @author Matheus Henrique Schaly
 */
public class Cliente {

    /**
     * Nome do cliente.
     */
    private final String nome;

    /**
     * Telefone do cliente.
     */
    private final String telefone;

    /**
     * CPF do cliente.
     */
    private final String cpf;

    /**
     * Endereco completo do cliente.
     */
    private final String endereco;

    /**
     * @param nome 
     * @param telefone 
     * @param cpf 
     * @param endereco
     */
    public Cliente(String nome, String telefone, String cpf, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.endereco = endereco;
    }
    
    public String getNome()
    {
        return this.nome;
    }
    
    public String getTelefone()
    {
        return this.telefone;
    }
    
    public String getCpf()
    {
        return this.cpf;
    }
    
    public String getEndereco()
    {
        return this.endereco;
    }
}