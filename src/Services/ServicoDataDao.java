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
import Model.Servico;

public class ServicoDataDao implements DAO<Servico> {

    public String caminho = "/home/luan/Documentos/unifor/poo/trabalho-av3/src/DB/servico.txt";
    public boolean cadastrar(Servico servico){

        try {
            FileWriter fw = new FileWriter(caminho, true);
            BufferedWriter bw = new BufferedWriter(fw);

            FileReader fr = new FileReader(caminho);
            BufferedReader br = new BufferedReader(fr);

            String linha = null;
            Boolean objetoExiste = false;

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                if(dados[0].trim().equals(Integer.toString(servico.getCodigo()))){
                    objetoExiste = true;
                    System.out.println("Quarto ou ID já existente");
                    br.close();
                    break;
                }
            }
            if(!objetoExiste){
                bw.write(servico.getCodigo()+ ","+servico.getValor()+","+servico.getDescricao());
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

    public Servico consultar(Servico servico) {
        try (FileReader fr = new FileReader(caminho);
             BufferedReader br = new BufferedReader(fr)) {
            String linha;
            while ((linha = br.readLine())!= null) {
                String[] dados = linha.split(",");
                if (dados[0].trim().equals(Integer.toString(servico.getCodigo()))) {
                    System.out.println("ID: " + servico.getCodigo() + ", Status: " + servico.getValor());
                    return servico; 
                }
            }
            System.out.println("Serviço não encontrado");
            return null;
        }  catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + e.getMessage());
            return null;
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            return null;
        }
    }
    public boolean editar(Servico servico) {
	    if ( consultar(servico)!=null) {
	        System.out.println("Quarto encontrado.");   
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
	            if (data.length >= 1 && data[0].trim().equals(Integer.toString(servico.getCodigo()))) { 
	                
	                System.out.println("Novo CODIGO:");
	                String novoCodigo = scanner.nextLine().trim();
	                System.out.println("Novo Status:");
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
	        System.out.println("Falha ao editar o Serviço.");
	    }

	    return houveEdicao;
	}

     public ArrayList<Servico> listarTodos(Servico servico) {
        ArrayList<Servico> servicos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine())!= null) {
                String[] partes = linha.split(",");
                if (partes.length >= 3) { 
                   servicos.add(servico);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        System.out.println(servicos.size());
        // System.out.println(quarto.getCodigo());
        return servicos;
    }
    
}
