package Services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import DAO.DAO;
import Model.Item;


public class ItemDataDao implements DAO<Item> {

    public String caminho = "/home/luan/Documentos/unifor/poo/trabalho-av3/src/DB/item.txt";
    public boolean cadastrar(Item item){

        try {
            FileWriter fw = new FileWriter(caminho, true);
            BufferedWriter bw = new BufferedWriter(fw);

            FileReader fr = new FileReader(caminho);
            BufferedReader br = new BufferedReader(fr);

            String linha = null;
            Boolean objetoExiste = false;

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                if(dados[0].trim().equals(Integer.toString(item.getCodigo()))){
                    objetoExiste = true;
                    System.out.println("Item ou ID já existente");
                    br.close();
                    break;
                }
            }
            if(!objetoExiste){
                bw.write(item.getCodigo()+ ","+item.getValor()+","+item.getDescricao());
                bw.newLine();
                bw.close();
                return true;
            }
            else{
                bw.close();
                return false;
            }
        }catch (FileNotFoundException e) {
                System.err.println("Arquivo não encontrado: " + e.getMessage());
                return false;
        }     
        catch (Exception e) {
            System.out.println("Erro "+e.getMessage());
            return false;
        }
        
    }

    public Item consultar(Item item) {
        try (FileReader fr = new FileReader(caminho);
             BufferedReader br = new BufferedReader(fr)) {
            String linha;
            while ((linha = br.readLine())!= null) {
                String[] dados = linha.split(",");
                if (dados[0].trim().equals(Integer.toString(item.getCodigo()))) {
                    System.out.println("ID: " + item.getCodigo() + ", Valor: " + item.getValor());
                    return item; 
                }
            }
            System.out.println("Item não encontrado");
            return null;
        }  catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + e.getMessage());
            return null;
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            return null;
        }
    }
    public boolean editar(Item item) {
	    if ( consultar(item)!=null) {
	        System.out.println("Item encontrado.");   
	    }
        else{
            return false;
        }

	    String tempFile = "/home/luan/Documentos/unifor/poo/trabalho-av3/src/DB/temp.txt";
	    String filePath = caminho;
	    boolean houveEdicao = false;

	    try (FileReader fileReader = new FileReader(filePath);
	         BufferedReader bufferedReader = new BufferedReader(fileReader);
	         FileWriter fileWriter = new FileWriter(tempFile);
	         BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
	         Scanner scanner = new Scanner(System.in)) {

	        String line;
	        while ((line = bufferedReader.readLine()) != null) {
	            String[] data = line.split(",");

	            // Verifica se os dados do hóspede no arquivo correspondem aos dados do hóspede que está sendo editado
	            if (data.length >= 1 && data[0].trim().equals(Integer.toString(item.getCodigo()))) { 
	                
	                System.out.println("Novo CODIGO:");
	                String novoCodigo = scanner.nextLine().trim();
	                System.out.println("Novo Valor:");
	                String novoValor = scanner.nextLine().trim();
	                

	                // Edita as informações
	                bufferedWriter.write(novoCodigo + "," + novoValor);
	                bufferedWriter.newLine();
	                houveEdicao = true;
	            } else {
	                // Mantém a linha original no arquivo temporário
	                bufferedWriter.write(line);
	                bufferedWriter.newLine();
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    // Substitui o arquivo original pelo temporário
	    File originalFile = new File(filePath);
	    File temp = new File(tempFile);
	    if (originalFile.delete() && temp.renameTo(originalFile)) {
	        System.out.println("Edição concluída com sucesso.");
	    } else {
	        System.out.println("Falha ao editar o Item.");
	    }

	    return houveEdicao;
	}

     public ArrayList<Item> listarTodos(Item item) {
        ArrayList<Item> itens = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine())!= null) {
                String[] partes = linha.split(",");
                if (partes.length >= 3) { 
                   itens.add(item);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        System.out.println(itens.size());
        // System.out.println(quarto.getCodigo());
        return itens;
    }
    
}
