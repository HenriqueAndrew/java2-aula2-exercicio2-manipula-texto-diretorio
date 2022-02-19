//Henrique Andrew da Silva

package br.com.henriqueandrew.aula2bjavaII;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ManipulaTexto {
    
    private File arquivo;
    private JanelaCliente interf;
    
    private ArrayList<Cliente> cadastro;
    private Cliente cliente;
    
    public ManipulaTexto(JanelaCliente interf){
        arquivo = null;
        cadastro = null;
        cliente = null;
        this.interf = interf;
    }
    
    public boolean abrirArquivo() {
		 
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int result = fileChooser.showSaveDialog(null);//posiciona a janela no centro da tela

		if (result == JFileChooser.CANCEL_OPTION) {
			return false;
		}
		
		arquivo = fileChooser.getSelectedFile();
		System.out.println(fileChooser.getName());

		if (arquivo == null || arquivo.getName() == "") {	
			JOptionPane.showMessageDialog(null, "Nome de Arquivo Inválido", 
					"Nome de Arquivo Inválido", JOptionPane.ERROR_MESSAGE);
			return false;
			
		}else {

			try { 	
				cadastro = (ArrayList<Cliente>) lerArquivo(arquivo);
				cliente = cadastro.get(0);
				interf.atualizaDados();
				return true;
			
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false; 
	}
	
	public static void salvarCliente(Object o, File file) throws IOException {
		
		ObjectOutputStream objectOutput = null;
		FileOutputStream fileOutput = null;
		
		try {
			
			if(file.exists() && file.canWrite()) {
				
				System.out.println("salvar em:"+file.getAbsolutePath());

				fileOutput = new FileOutputStream(file);
				objectOutput = new ObjectOutputStream(fileOutput);

				objectOutput.writeObject(o);

				objectOutput.close();
				fileOutput.close();
			}
					
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Cadastro gravado!");
	}	

	private static Object lerArquivo(File file) throws IOException {
		
		ObjectInputStream objectInput = null;
		FileInputStream fileInput = null;
		Object obj=null;
		
		try {

			if (file.exists() && file.canRead()) {

				System.out.println("ler arquivo:"+file.getAbsolutePath());

				fileInput = new FileInputStream(file);
				objectInput = new ObjectInputStream(fileInput);

				obj = objectInput.readObject();

				fileInput.close();
				objectInput.close();
			}else {

				System.out.println("Arquivo inexistente ou impossível de ler");
			}
		}catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Arquivo selecionado!");
		return obj;
	}	


	public boolean criarArquivo() {

    	JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int result = fileChooser.showSaveDialog(null);
        
        if (result == JFileChooser.CANCEL_OPTION) {
            return false;
        }
        
        arquivo = fileChooser.getSelectedFile();
        System.out.println(fileChooser.getName());
    
        if (arquivo == null || arquivo.getName().equals("")) {
            JOptionPane.showMessageDialog(null, "Nome de Arquivo Inválido", "Nome de Arquivo Inválido", JOptionPane.ERROR_MESSAGE);
            return false;
 			
        } else {

            try {

            	if (arquivo.exists()) {

            		System.out.println("Arquivo existe: "+arquivo.getAbsolutePath());
            	}else {
 
            		System.out.println("Arquivo não existe: "+arquivo.getAbsolutePath());
            		arquivo.createNewFile();
            	}
            	
            	cadastro =  new ArrayList<Cliente>();
            	cliente = null;
            	interf.atualizaDados();
            	return true;
            	
            } catch (IOException ioException) {
                JOptionPane.showMessageDialog(null, "Erro ao Abrir Arquivo", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
        return false;
	}

	public void imprimirCadastro() {
		for (Cliente i : cadastro) {
			System.out.println(i);
		}
	}

	public Cliente clienteAtual() {
		return cliente;
	}

	public boolean clienteProximo() {
		
		int index = cadastro.indexOf(cliente);//5
		
		if(index >= cadastro.size()-1) {//6
			System.out.println("ultimo");
			return false;
		}else {
			cliente = cadastro.get(index+1);
			System.out.println("próximo");
			return true;
		}
	}

	public boolean clienteAnterior() {
		
		int index = cadastro.indexOf(cliente);//5
		
		if(index <=0) {//6
			System.out.println("primeiro");
			return false;
		}else {
			cliente = cadastro.get(index-1);
			System.out.println("anterior");
			return true;
		}
	}

	public String selecionarArquivo() {
		if (arquivo != null) {
			return arquivo.getAbsolutePath();					
		}else {
			return "Nenhum Arquivo";
		}
	}

	public void salvarArquivo() {
		
		try {
			salvarCliente(cadastro, arquivo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void novoCliente() {
		Cliente novo = new Cliente();
		cadastro.add(novo);
		cliente = novo;
		interf.atualizaDados();
	}

	public void apagarCliente(Cliente i) {

		int index = cadastro.indexOf(i);

		if (index == 0 && cadastro.size() ==1) {
			cadastro.remove(i);
			cliente = null;
			
		}else if (index == 0 && cadastro.size() > 1) {
			cadastro.remove(cliente);
			cliente = cadastro.get(0);
		
		}else if (index == cadastro.size()-1 && cadastro.size() > 1) {
			cadastro.remove(cliente);
			cliente = cadastro.get(cadastro.size()-1);
						
		}
		interf.atualizaDados();
	}

	public void gravarCadastro(Cliente i) {
		
		if(arquivo != null) {
			cliente.setNome(i.getNome());
			cliente.setFone(i.getFone());
			cliente.setIdade(i.getIdade());
			salvarArquivo();
			interf.atualizaDados();			
		}else {
			criarArquivo();
		}
		interf.desabilitarBotaoGravar();
	}

	public void editarCliente()	{
		gravarCadastro(cliente);
		salvarArquivo();
		interf.atualizaDados();	
	}

    /*    
    public String informacaoCadastro(){
    	String info;
    	if (cadastro != null) {
    		info = "  Quantidade de Cadastros:"+cadastro.size()+
    				" [Atual:"+(cadastro.indexOf(cliente)+1)+"]"; 
    	}else {
    		info = "Nenhum Cadastro";
    	}
    	return info;
    }


    public int posicaoCadastro() {
		return cadastro.size();
	}
*/    
    
}
