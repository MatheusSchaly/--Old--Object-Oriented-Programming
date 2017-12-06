package matheus_henrique_schaly.mhs.pizzariaOnline.pizzaria.view;

import matheus_henrique_schaly.mhs.pizzariaOnline.persistencia.Repositorio;
import matheus_henrique_schaly.mhs.pizzariaOnline.pizzaria.entidade.Pedido;

/**
 *
 * @author Mauricio
 */
public class Vendido extends Relatorio{

    public Vendido(String cabecalho, String rodape, Repositorio<Pedido> pedidos) {
        super(cabecalho, rodape);
        
        boolean nova;
        for (int i=0; i<pedidos.getAll().size(); i++)
        {
            if (pedidos.get(i).getConfirmacao())
            {
                for (int j=0; i<pedidos.get(i).getItemPedidos().size(); i++)
                {
                    nova = true;
                    for (int k=0; k<itensPedidos.getAll().size(); k++)
                    {
                        if (    
                                itensPedidos.get(k).getPizza().getNome().equals(
                                pedidos.get(i).getItemPedido(j).getPizza().getNome()) &&

                                itensPedidos.get(k).getTamanho().equals(
                                pedidos.get(i).getItemPedido(j).getTamanho())
                            )
                        {
                            nova = false;
                            break;
                        }
                    }
                    if (nova)
                    {
                        itensPedidos.salva(pedidos.get(i).getItemPedido(j));
                    }
                }
            }
        }
    }
    
}
