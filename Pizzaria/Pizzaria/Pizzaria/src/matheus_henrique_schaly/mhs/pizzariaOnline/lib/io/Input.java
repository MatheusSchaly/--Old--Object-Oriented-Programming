package matheus_henrique_schaly.mhs.pizzariaOnline.lib.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import matheus_henrique_schaly.mhs.pizzariaOnline.persistencia.*;
import matheus_henrique_schaly.mhs.pizzariaOnline.pizzaria.entidade.*;

/**
 * Gerencia os arquivos recebidos e controla o fluxo do sistema.
 * 
 * @author Matheus Henrique Schaly
 */
public class Input {

    /**
     * Repositorio de pedidos.
     */
    private RepositorioDePedidos repositorioDePedidos;

    /**
     * Repositorio de clientes.
     */
    private RepositorioDeClientes repositorioDeClientes;

    /**
     * Repositorio de pizzas.
     */
    private RepositorioDePizzas repositorioDePizzas = new RepositorioDePizzas();

    /**
     * Inicia o programa.
     */
    public void run() {
        geraMenu();
        geraClientes();
        geraPedidos();
    }

    /**
     * Le o arquivo de menu e gera os objetos pizza.
     */
    private void geraMenu() {
        String nomeArquivo = "menu.txt";
        String nome, tamanho, linha;
        int quantidadeIngredientes, quantidadeTamanhos, quantidadePizzas;
        HashMap<String, Integer> tamanhoFatias;
        ArrayList<String> ingredientes;
        float valor;
        
        try {
          FileReader leitorDeArquivo = new FileReader(nomeArquivo);
          BufferedReader leitorDeBuffer = new BufferedReader(leitorDeArquivo);
          
          // Le primeira linha, quantidade de tamanhos
          quantidadeTamanhos = Integer.parseInt(leitorDeBuffer.readLine());
          tamanhoFatias = new HashMap<>(quantidadeTamanhos);
          
          // Le tamanhos e quantidade de fatias
          for (int i = 0; i < quantidadeTamanhos; i++) {
              tamanho = leitorDeBuffer.readLine();
              tamanhoFatias.put(tamanho, Integer.parseInt(leitorDeBuffer.readLine()));
          }
          
          // Le quantidade de pizzas
          quantidadePizzas = Integer.parseInt(leitorDeBuffer.readLine());
          
          for (int i = 0; i < quantidadePizzas; i++) {
              // Le nome da pizza
              nome = leitorDeBuffer.readLine();
              
              // Le quantidade de ingredientes
              quantidadeIngredientes = Integer.parseInt(leitorDeBuffer.readLine());
              ingredientes = new ArrayList<>(quantidadeIngredientes);
              
              // Le ingredientes
              for (int j = 0; j < quantidadeIngredientes; j++) {
                  ingredientes.add(leitorDeBuffer.readLine());
              }
              
              // Le valores e cria pizzas
              for (int j = 0; j < quantidadeTamanhos; j++) {
                  repositorioDePizzas.salva(new Pizza(nome, tamanhoFatias, ingredientes, Integer.parseInt(leitorDeBuffer.readLine())));
              }
          }

          leitorDeBuffer.close();         
        }
        
        catch(FileNotFoundException ex) {
          System.out.println("Erro ao encontrar o arquivo '" + nomeArquivo + "'");             
        }
         catch(IOException ex) {
          System.out.println("Erro ao ler o arquivo '" + nomeArquivo + "'");
        }
    }

    /**
     * Le o arquivo de clientes e gera os objetos cliente.
     */
    private void geraClientes() {
        String nomeArquivo = "clientes.txt";
        String nome, telefone, cpf, endereco, linha;
        int quantidadeClientes;
        
        try {
          FileReader leitorDeArquivo = new FileReader(nomeArquivo);
          BufferedReader leitorDeBuffer = new BufferedReader(leitorDeArquivo);
          
          // Le primeira linha, quantidade de clientes
          quantidadeClientes = Integer.parseInt(leitorDeBuffer.readLine());
          
          // Le cliente
          for (int i = 0; i < quantidadeClientes; i++) {
              nome = leitorDeBuffer.readLine();
              telefone = leitorDeBuffer.readLine();
              cpf = leitorDeBuffer.readLine();
              endereco = leitorDeBuffer.readLine();
              repositorioDeClientes.salva(new Cliente(nome, telefone, cpf, endereco));
          }

          leitorDeBuffer.close();         
        }
        
        catch(FileNotFoundException ex) {
          System.out.println("Erro ao encontrar o arquivo '" + nomeArquivo + "'");             
        }
         catch(IOException ex) {
          System.out.println("Erro ao ler o arquivo '" + nomeArquivo + "'");
        }
    }

    /**
     * Le o arquivo pedidos e gera os objetos pedido.
     */
    private void geraPedidos() {
        String nomeArquivo = "pedidos.txt";
        String cpf;
        boolean confirmacao;
        HashMap<String, String> pizzas; 
        int quantidadePedidos, quantidadePizzas;
        
        try {
          FileReader leitorDeArquivo = new FileReader(nomeArquivo);
          BufferedReader leitorDeBuffer = new BufferedReader(leitorDeArquivo);
          
          // Le primeira linha, quantidade de pedidos
          quantidadePedidos = Integer.parseInt(leitorDeBuffer.readLine());
          
          for (int i = 0; i < quantidadePedidos; i++) {
              // Le CPF do cliente que realizou o pedido
              cpf = leitorDeBuffer.readLine();
              
              // Le quantidade de pizzas pedidas
              quantidadePizzas = Integer.parseInt(leitorDeBuffer.readLine());
              pizzas = new HashMap<>(quantidadePizzas);
              
              // Le nome da pizza e tamanho
              for (int j = 0; j < quantidadePizzas; j++) {
                  pizzas.put(leitorDeBuffer.readLine(), leitorDeBuffer.readLine());
              }

              // Le se pedido foi confirmado
              if (leitorDeBuffer.readLine().equals("Confirmado")) {
                  confirmacao = true;
              }
              else {
                  confirmacao = false;
              }
              
              repositorioDePedidos.salva(new Pedido(cpf, confirmacao, pizzas));
          }

          leitorDeBuffer.close();         
        }
        
        catch(FileNotFoundException ex) {
          System.out.println("Erro ao encontrar o arquivo '" + nomeArquivo + "'");             
        }
         catch(IOException ex) {
          System.out.println("Erro ao ler o arquivo '" + nomeArquivo + "'");
        }
    }

    /**
     * Seleciona as pizzas vendidas e invoca o relatorio.
     */
    private void pizzasVendidas() {
        // TODO implement here
        return null;
    }

    /**
     * Seleciona as pizzas nao vendidas e invoca o relatorio.
     */
    private void pizzasNaoVendidas() {
        // TODO implement here
        return null;
    }

}