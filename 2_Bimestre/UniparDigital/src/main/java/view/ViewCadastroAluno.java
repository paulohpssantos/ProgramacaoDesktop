/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import dao.AlunoDAO;
import dto.EnderecoDTO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import modelo.Aluno;
import service.EnderecoService;

/**
 *
 * @author paulodossantos
 */
public class ViewCadastroAluno extends javax.swing.JFrame {

    private AlunoDAO alunoDao = new AlunoDAO();
    private boolean alunoPesquisado;
    private ArrayList<Aluno>lista;
    
    public ViewCadastroAluno() {
        initComponents();
        
        atualizaGrid();
        
    }
    
    public void atualizaGrid(){
        try{
            String sql = "SELECT * FROM public.\"Aluno\" ORDER BY \"RA_ALUNO\";";
            lista = new ArrayList<>();
            lista = alunoDao.retornaLista(sql);
            
            //Manipulação da tabela
            tbAlunos.removeAll();
            
            //Cria as colunas
            DefaultTableModel tableModel = 
                    new DefaultTableModel(new Object[][]{},
                              new String[]{"RA", "Nome", "Dt. Nascimento"}){
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
                
            };
            
            //seta as colunas na tabela
            tbAlunos.setModel(tableModel);
            
            
            
            //Adiciona as linhas a tabela com os dados dos alunos
            DefaultTableModel dm = (DefaultTableModel)tbAlunos.getModel();
            for (Aluno aluno : lista) {
                dm.addRow(new Object[]{aluno.getRaAluno(), aluno.getNomeAluno(),
                aluno.getDtNascAluno()});
                
                
            }
            
            tbAlunos.getSelectionModel()
                    .addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    int linhaSelecionada = tbAlunos.getSelectedRow();
                    if(linhaSelecionada != -1)
                        mostrarAluno(lista.get(linhaSelecionada));
                }
            });
            
        }catch(Exception ex){
            
        }
        
        
    }
    
    public void limparCampos(){
        tfRaAluno.setText("");
        tfNomeAluno.setText("");
        tfDtNascAluno.setText("");
        tfRaAluno.setEditable(true);
        btSalvar.setEnabled(true);
    }
    
    private void mostrarAluno(Aluno aluno){
        tfRaAluno.setText(String.valueOf(aluno.getRaAluno()));
        tfNomeAluno.setText(aluno.getNomeAluno());
        tfDtNascAluno.setText(aluno.getDtNascAluno());
        tfRaAluno.setEditable(false);
        btSalvar.setEnabled(false);
        alunoPesquisado = true;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tfRaAluno = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfNomeAluno = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfDtNascAluno = new javax.swing.JFormattedTextField();
        btRemover = new javax.swing.JButton();
        btAtualizar = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btPesquisar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        tfCep = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfLogradouro = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfNumero = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfBairro = new javax.swing.JTextField();
        tfCidade = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbAlunos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CADASTRO DE ALUNOS");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("R.A.");

        tfRaAluno.setToolTipText("");

        jLabel3.setText("Nome:");

        jLabel4.setText("Data Nascimento:");

        tfDtNascAluno.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        tfDtNascAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDtNascAlunoActionPerformed(evt);
            }
        });

        btRemover.setText("Remover");
        btRemover.setPreferredSize(new java.awt.Dimension(90, 23));
        btRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverActionPerformed(evt);
            }
        });

        btAtualizar.setText("Atualizar");
        btAtualizar.setPreferredSize(new java.awt.Dimension(90, 23));
        btAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizarActionPerformed(evt);
            }
        });

        btSalvar.setText("Salvar");
        btSalvar.setPreferredSize(new java.awt.Dimension(90, 23));
        btSalvar.setSize(new java.awt.Dimension(80, 23));
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btPesquisar.setText("Pesquisar");
        btPesquisar.setMaximumSize(new java.awt.Dimension(90, 23));
        btPesquisar.setMinimumSize(new java.awt.Dimension(90, 23));
        btPesquisar.setPreferredSize(new java.awt.Dimension(90, 23));
        btPesquisar.setSize(new java.awt.Dimension(80, 23));

        jLabel5.setText("CEP");

        tfCep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfCepKeyPressed(evt);
            }
        });

        jLabel6.setText("Logradouro");

        jLabel7.setText("Nº");

        jLabel8.setText("Bairro");

        jLabel9.setText("Cidade/UF");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(88, 88, 88)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(tfDtNascAluno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btRemover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfCidade))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfRaAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(tfCep, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfNomeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(237, 237, 237)
                                .addComponent(jLabel9)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfRaAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNomeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDtNascAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btRemover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tbAlunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbAlunos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfDtNascAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDtNascAlunoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDtNascAlunoActionPerformed

    private void btRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverActionPerformed
        
        if(alunoPesquisado){
            alunoDao.delete(
                    Integer.parseInt(tfRaAluno.getText()), 
                    "Aluno", "RA_ALUNO");
            
            JOptionPane.showMessageDialog(this, 
                       "Aluno atualizado com sucesso!");
            limparCampos();
            atualizaGrid();
            
        }else{
            JOptionPane.showMessageDialog(this, 
                       "Selecione um Aluno para remover!",
                       "Atenção",
                       JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_btRemoverActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        
        Aluno novoAluno = new Aluno();
        novoAluno.setRaAluno(Integer.parseInt(tfRaAluno.getText()));
        novoAluno.setNomeAluno(tfNomeAluno.getText());
        novoAluno.setDtNascAluno(tfDtNascAluno.getText());
        
        if(alunoDao.salvar(novoAluno)){
            JOptionPane.showMessageDialog(this, 
                    "Aluno salvo com Sucesso!",
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, 
                    "Erro ao salvar Aluno, solicite suporte técnico!",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
        atualizaGrid();
        limparCampos();
        
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed
        
        if(alunoPesquisado){
            
            Aluno aluno = new Aluno();
            aluno.setRaAluno(Integer.parseInt(tfRaAluno.getText()));
            aluno.setNomeAluno(tfNomeAluno.getText());
            aluno.setDtNascAluno(tfDtNascAluno.getText());
            
            if(alunoDao.atualizar(aluno)){
               JOptionPane.showMessageDialog(this, 
                       "Aluno atualizado com sucesso!");
               limparCampos();
               atualizaGrid();
            }else{
                JOptionPane.showMessageDialog(this, 
                       "Erro ao atualizar o aluno, "
                               + "Solicite suporte técnico.",
                       "Erro",
                       JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(this, 
                       "Selecione um Aluno para atualizar!",
                       "Atenção",
                       JOptionPane.WARNING_MESSAGE);
        }
        
        
    }//GEN-LAST:event_btAtualizarActionPerformed

    private void tfCepKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCepKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER) {
            if(!tfCep.getText().equals("")){
                try {
                    EnderecoDTO endereco =
                            EnderecoService.buscaEndereco(tfCep.getText());
                    
                    tfLogradouro.setText(endereco.getLogradouro());
                    tfBairro.setText(endereco.getBairro());
                    tfCidade.setText(endereco.getLocalidade()+"/"+endereco.getUf());
                } catch (Exception ex) {
                    Logger.getLogger(ViewCadastroAluno.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_tfCepKeyPressed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAtualizar;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton btRemover;
    private javax.swing.JButton btSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbAlunos;
    private javax.swing.JTextField tfBairro;
    private javax.swing.JTextField tfCep;
    private javax.swing.JTextField tfCidade;
    private javax.swing.JFormattedTextField tfDtNascAluno;
    private javax.swing.JTextField tfLogradouro;
    private javax.swing.JTextField tfNomeAluno;
    private javax.swing.JTextField tfNumero;
    private javax.swing.JTextField tfRaAluno;
    // End of variables declaration//GEN-END:variables
}
