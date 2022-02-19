//Henrique Andrew da Silva

package br.com.henriqueandrew.aula2bjavaII;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class JanelaCliente {
    
    private JFrame jan;
    int larg = 1500, alt = 1000;
    
    private JMenuBar bm;
    private JMenu menuArquivo;
    private JMenuItem abrirArquivo;
    private JMenuItem novoArquivo;
    private JMenuItem sair;
    
    private JPanel painelSul;
    
    private JButton botaoAnterior;
    private JButton botaoProximo;
    private JButton botaoNovoCliente;
    private JButton botaoGravarCliente;
    private JButton botaoEditarCliente;
    private JButton botaoApagarCliente;
    
    private JLabel nomeRotulo;
    private JLabel foneRotulo;
    private JLabel idadeRotulo;
    
    private JTextField nome;
    private JTextField fone;
    private JTextField idade;
    
    private ManipulaTexto mTexto;
    
    public JanelaCliente(){
        Componentes();
        addListeners();
    }
    
    private void Componentes(){
        
        jan = new JFrame();
        jan.setTitle("Cadastro de Clientes");
        jan.setSize(larg, alt);
        jan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //jan.setVisible(true);
        
        bm = new JMenuBar();
        jan.add(bm);
        
        menuArquivo = new JMenu();
        bm.add(menuArquivo);
        
        abrirArquivo = new JMenuItem();
        abrirArquivo.setName("Abrir Cadastro");
        //abrirArquivo.setIcon(folder.png);
        
        novoArquivo = new JMenuItem();
        novoArquivo.setName("Novo Cadastro");
        
        sair = new JMenuItem();
        sair.setName("Sair");
        
        menuArquivo.add(abrirArquivo);
        menuArquivo.add(novoArquivo);
        menuArquivo.add(new JSeparator());
        menuArquivo.add(sair);        
        
        botaoAnterior = new JButton("<< Anterior");
        botaoProximo = new JButton("Proximo >>");
        botaoNovoCliente = new JButton("Novo Cliente");
        botaoGravarCliente = new JButton("Gravar Cliente");
        botaoEditarCliente = new JButton("Editar Cliente");
        botaoApagarCliente = new JButton("Apagar Cliente");
        
        painelSul = new JPanel();
        painelSul.setLayout(new GridLayout(10,1));
        Border padding = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        painelSul.setBorder(padding);
        painelSul.add(botaoAnterior);
        painelSul.add(botaoProximo);
        painelSul.add(botaoNovoCliente);
        painelSul.add(botaoGravarCliente);
        painelSul.add(botaoEditarCliente);
        painelSul.add(botaoApagarCliente);
        
        jan.setJMenuBar(bm);
        jan.setLayout(new FlowLayout());
        jan.setVisible(true);
    }
    
    private void addListeners(){
        
        botaoAnterior.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        botaoProximo.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        botaoNovoCliente.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        botaoGravarCliente.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        botaoEditarCliente.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        botaoApagarCliente.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        abrirArquivo.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        novoArquivo.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        sair.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
    }
    
    protected void botaoAnteriorActionPerformed(ActionEvent evt){
        //if (mTexto.)
    }
    
    protected void botaoProximoActionPerformed(ActionEvent evt){
        
    }
    
    protected void botaoNovoClienteActionPerformed(ActionEvent evt){
        
    }
    
    protected void botaoGravarClienteActionPerformed(ActionEvent evt){
        
    }
    
    protected void botaoEditarClienteActionPerformed(ActionEvent evt){
        
    }
    
    protected void botaoApagarClietneActionPerformed(ActionEvent evt){
        
    }
    
    protected void abrirArquivoActionPerformed(ActionEvent evt){
        
    }
    
    protected void novoArquivoActionPerformed(ActionEvent evt){
        if (mTexto.criarArquivo()){
            botaoNovoCliente.setEnabled(true);
            botaoGravarCliente.setEnabled(true);
        }
    }
    
    protected void sairActionPerformed(ActionEvent evt){
        System.exit(0);
    }
    
    public void atualizaDados(){
        if (mTexto.clienteAtual() != null){
            Cliente c = mTexto.clienteAtual();
            nome.setText(c.getNome());
            fone.setText(c.getFone());
            idade.setValue(Integer.parseInt(c.getIdade()));
            
        }
    }
    
    public static void main(String args[]){
        //java.awt.EventQueue.invokeLater(new Runnable() {
        //public void run(){
            new JanelaCliente();
        //}
        //});
    }
}
