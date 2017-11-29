package matheus_henrique_schaly.mhs.pizzariaOnline.persistencia;

import java.util.*;
import matheus_henrique_schaly.mhs.pizzariaOnline.pizzaria.entidade.Pizza;

/**
 * Armazena as pizzas.
 * 
 * @author Matheus Henrique Schaly
 */
public class RepositorioDePizzas extends Repositorio{

    public RepositorioDePizzas() {
        elementos = new ArrayList<Pizza>();
    }

    public void salva(Pizza pizza) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}