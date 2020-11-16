/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoRosanTransports.view;

import java.awt.Color;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import projetoRosanTransports.data.motoristaData;
import projetoRosanTransports.model.administradorModel;
import projetoRosanTransports.model.motoristaModel;

/**
 *
 * @author Rafaella Alves Silva
 */
public class JFMotorista extends javax.swing.JFrame {

    /**
     * Creates new form JFMotorista
     */
    motoristaModel obj = new motoristaModel();
    administradorModel obj2 = new administradorModel();
    motoristaData DAO = new motoristaData();
    private ArrayList<motoristaModel> dados;
    int op;
    String mudar = new String();
    
    
    
    public JFMotorista() {
        initComponents();
        
        op = 0;
        this.getContentPane().setBackground(new Color(153,153,153));
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/projetoRosanTransports/imagens/caminhao3.jpg")));
   
    }
    public JFMotorista(administradorModel obj){
        
        this.obj2 = obj;
        op = 0;
        this.getContentPane().setBackground(new Color(153,153,153));
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/projetoRosanTransports/imagens/caminhao3.jpg")));
        
    }
    
    public void atualizarTabela(){
        try{
            motoristaData DAO = new motoristaData();
            dados = DAO.pesquisarMotorista(jtPesquisa.getText());
            DefaultTableModel mp = (DefaultTableModel) jtbMotorista.getModel();
            mp.setNumRows(0);
            for(motoristaModel motorista : dados){
                if(motorista.getIdPessoa() != obj.getIdPessoa()){
                    mp.addRow(new String[]{"" + motorista.getIdPessoa(), motorista.getNomePessoa(), motorista.getEmailPessoa(), motorista.getRgMotorista(), motorista.getTelefone()});
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Erro ao Pesquisar:" + e.getMessage());
        }
    }
    
    public static boolean isEmailValid(String email) {
        if ((email == null) || (email.trim().length() == 0)) {
            return false;
        }
        String emailPattern = "\\b(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b";
        Pattern pattern = Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
    private boolean validarCampos() throws Exception {
        String msg = new String();
        String jtCpf = jftCPF.getText();
        String jtTelefone = jftTel.getText();
        String jtData = this.jftDataNasc.getText();
        String jtRg = jftRG.getText();
        
        if (jtNome.getText().equals(jpfSenha.getText())) {
            msg = "Nome e Senha não podem ser iguais \n!";
        }
        if (jtNome.getText().equals("")) {
            msg += "O campo Nome Completo deve ser preenchido \n";
        } else {
            if (jtNome.getText().length() < 3 || jtNome.getText().length() > 40) {
                msg += "O Nome deve ter entre 3 e 40 caracteres \n";
            }
        }

        if (jpfSenha.getText().equals("")) {
            msg += "O campo senha deve ser preenchido \n";
        }
        if (jtEndereco.getText().equals("")) {
            msg += "O campo Endereço deve ser preenchido \n";
        } else {
            if (jtEndereco.getText().length() < 3 || jtEndereco.getText().length() > 60) {
                msg += " O Endereço deve ter entre 3 e 60 caracteres \n";
            }
        }
        if (jtCidade.getText().equals("")) {
            msg += "O campo Cidade deve ser preenchido \n";
        } else {
            if (jtCidade.getText().length() < 3 || jtCidade.getText().length() > 40) {
                msg += " O cidade deve ter entre 3 e 60 caracteres \n";
            }
        }
        
        jtCpf = jtCpf.replace(".", "");
        jtCpf = jtCpf.replace("-", "");
        jtCpf = jtCpf.trim();// remove os espaços da esquerda e da direita

        jtTelefone = jtTelefone.replace('(', ' ');
        jtTelefone = jtTelefone.replace(')', ' ');
        jtTelefone = jtTelefone.replace('-', ' ');
        jtTelefone = jtTelefone.trim();
        
        jtData = jtData.replace('/', ' ');
        jtData = jtData.replace('/', ' ');
        jtData = jtData.trim();
        
        jtRg = jtRg.replace(".", "");
        jtRg = jtRg.replace("-", "");
        jtRg = jtRg.trim();
        

        if (jtCpf.equals("")) {
            msg += "O campo CPF deve ser preenchido\n";
        } else {
            if (jtCpf.length() < 11) {
                msg += "Preencha totalmente o campo CPF\n";
            }
        }
        if (jtRg.equals("")){
            msg += "O campo RG deve ser preenchido\n";
        }else{
            if(jtRg.length() < 9){
                msg += "Preencha totalmente o campo RG\n";
            }
        }
        if (jtTelefone.equals("")) {
            msg += "O campo Telefone deve ser preenchido\n";
        } else {
            if (jtTelefone.length() < 12) {
                msg += "Preencha totalmente o campo Telefone\n";
            }
        }
        if (jtData.equals("")){
            msg += "O campo Data Nascimento deve ser preenchido\n";
        }else{
            if (jtData.length() < 8){
                msg += "Preencha totalmente o campo Data Nascimento\n";
            }
        }
        if (jtCpf.length() == 11) {
            if (ValidaCPF.isCPF(jtCpf) == false) {
                msg += "CPF Inválido!!!\n";
            }
        }
        if (jtCNH.equals("")){
            msg += "O campo CNH deve ser preenchido\n";
        }else{
            if (jtCNH.getText().length() < 10){
                msg += "Preencha totalmente o campo CNH\n";
            }
        }
         if (jcUF.getSelectedIndex() == 0) {
            msg += "O campo UF deve ser preenchido\n";
        }
         if(jcNivel.getSelectedItem() == null){
             msg += "O campo Nivel deve ser preenchido\n";
         }
        if (!isEmailValid(jtEmail.getText())) {
            msg += "Erro ao inserir o email\n";
        }
        if (msg.length() == 0) {
            return true;
        } else {
            throw new Exception(msg);
        }
    }
    
     private boolean preencherObjeto() {
        obj.setIdPessoa(Integer.parseInt(jlID.getText()));
        obj.setNomePessoa(jtNome.getText());
        obj.setTelefone(jftTel.getText());
        obj.setUfPessoa(jcUF.getSelectedItem().toString());
        obj.setCidadePessoa(jtCidade.getText());
        obj.setEnderecoPessoa(jtEndereco.getText());
        obj.setEmailPessoa(jtEmail.getText());
        int nivel = jcNivel.getSelectedIndex() - 1;
        obj.setNivelPessoa(nivel);
        obj.setDatanascimento(jftDataNasc.getText());
        obj.setCpfMotorista(jftCPF.getText()); 
        obj.setRgMotorista(jftRG.getText());
        obj.setCnhMotorista(jtCNH.getText());        
        obj.setSenhaMotorista(Criptografar.encriptografar(jpfSenha.getText()));
        
        return true;
    }
    
     private void LimparCampos(){
         jtNome.setText("");
         jtEmail.setText("");
         jpfSenha.setText("");
        jftTel.setText("");
        jtEndereco.setText("");
        jtCidade.setText("");
        jcUF.setSelectedIndex(0);
        jftRG.setText("");
        jftCPF.setText("");
        jtCNH.setText("");
        jftDataNasc.setText("");
        jcNivel.setSelectedIndex(0);
        jtPesquisa.setText("");
     }
     
     private void HabilitarCampos(boolean n){
        jtNome.setEnabled(n);
        jpfSenha.setEnabled(n);
        jtEmail.setEnabled(n);
        jftTel.setEnabled(n);
        jtEndereco.setEnabled(n);
        jtCidade.setEnabled(n);
        jcUF.setEnabled(n);
        jftRG.setEnabled(n);
        jftCPF.setEnabled(n);
        jtCNH.setEnabled(n);
        jftDataNasc.setEnabled(n);
        jcNivel.setEnabled(n);
     }
     
     private void LimparTabela(){
        
        DefaultTableModel mp = (DefaultTableModel) jtbMotorista.getModel();
        mp.setNumRows(0);
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
        jbNovo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbMotorista = new javax.swing.JTable();
        jtPesquisa = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jbCancelar = new javax.swing.JButton();
        jbVisualizar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jbDispesas = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jlID = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtNome = new javax.swing.JTextField();
        jpfSenha = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jtEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtEndereco = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jtCidade = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jcUF = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jtCNH = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jcNivel = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jbAdd = new javax.swing.JButton();
        jbAlterar = new javax.swing.JButton();
        jftTel = new javax.swing.JFormattedTextField();
        jftRG = new javax.swing.JFormattedTextField();
        jftCPF = new javax.swing.JFormattedTextField();
        jftDataNasc = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("R SILVA TRANSPORTES");
        setPreferredSize(new java.awt.Dimension(640, 380));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel1.setText("Pesquisar:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, -1, 30));

        jbNovo.setBackground(new java.awt.Color(0, 0, 0));
        jbNovo.setFont(new java.awt.Font("Cinzel Black", 0, 12)); // NOI18N
        jbNovo.setForeground(new java.awt.Color(255, 255, 255));
        jbNovo.setText("Novo");
        jbNovo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jbNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNovoActionPerformed(evt);
            }
        });
        getContentPane().add(jbNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 86, 42));

        jtbMotorista.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jtbMotorista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "E-mail", "RG", "Telefone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbMotorista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbMotoristaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbMotorista);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 500, 150));

        jtPesquisa.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jtPesquisa.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jtPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtPesquisaKeyReleased(evt);
            }
        });
        getContentPane().add(jtPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 390, 430, 20));

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(0, 0, 0));
        jTextField1.setFont(new java.awt.Font("Cinzel Black", 0, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("Página de Motoristas");
        jTextField1.setBorder(null);
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 37));

        jbCancelar.setBackground(new java.awt.Color(0, 0, 0));
        jbCancelar.setFont(new java.awt.Font("Cinzel Black", 0, 12)); // NOI18N
        jbCancelar.setForeground(new java.awt.Color(255, 255, 255));
        jbCancelar.setText("Cancelar");
        jbCancelar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jbCancelar.setEnabled(false);
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jbCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, 86, 42));

        jbVisualizar.setBackground(new java.awt.Color(0, 0, 0));
        jbVisualizar.setFont(new java.awt.Font("Cinzel Black", 0, 12)); // NOI18N
        jbVisualizar.setForeground(new java.awt.Color(255, 255, 255));
        jbVisualizar.setText("Visualizar");
        jbVisualizar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jbVisualizar.setEnabled(false);
        jbVisualizar.setMaximumSize(new java.awt.Dimension(39, 19));
        jbVisualizar.setMinimumSize(new java.awt.Dimension(39, 19));
        jbVisualizar.setPreferredSize(new java.awt.Dimension(39, 19));
        getContentPane().add(jbVisualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 590, 86, 42));

        jbExcluir.setBackground(new java.awt.Color(0, 0, 0));
        jbExcluir.setFont(new java.awt.Font("Cinzel Black", 0, 12)); // NOI18N
        jbExcluir.setForeground(new java.awt.Color(255, 255, 255));
        jbExcluir.setText("Excluir");
        jbExcluir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jbExcluir.setEnabled(false);
        getContentPane().add(jbExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 590, 86, 42));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 530, 10));

        jbDispesas.setBackground(new java.awt.Color(0, 0, 0));
        jbDispesas.setFont(new java.awt.Font("Cinzel Black", 0, 12)); // NOI18N
        jbDispesas.setForeground(new java.awt.Color(255, 255, 255));
        jbDispesas.setText("Dispesas");
        jbDispesas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jbDispesas.setEnabled(false);
        getContentPane().add(jbDispesas, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 590, 86, 42));

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jLabel2.setText("Código:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jlID.setText("0");
        getContentPane().add(jlID, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, -1));

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jLabel4.setText("Nome Completo:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, 20));

        jLabel5.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jLabel5.setText("Senha:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, -1, 20));

        jtNome.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jtNome.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jtNome.setEnabled(false);
        getContentPane().add(jtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 210, 20));

        jpfSenha.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jpfSenha.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jpfSenha.setEnabled(false);
        getContentPane().add(jpfSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 77, 130, 20));

        jLabel6.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jLabel6.setText("E-mail:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, 20));

        jtEmail.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jtEmail.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jtEmail.setEnabled(false);
        getContentPane().add(jtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 117, 210, 20));

        jLabel7.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jLabel7.setText("Telefone:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, -1, 20));

        jLabel8.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jLabel8.setText("Endereço/N°:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, 20));

        jtEndereco.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jtEndereco.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jtEndereco.setEnabled(false);
        getContentPane().add(jtEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 197, 210, 20));

        jLabel9.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jLabel9.setText("Cidade:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, 20));

        jtCidade.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jtCidade.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jtCidade.setEnabled(false);
        jtCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtCidadeActionPerformed(evt);
            }
        });
        getContentPane().add(jtCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 157, 210, 20));

        jLabel10.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jLabel10.setText("UF:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, -1, 20));

        jcUF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Selecione>", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        jcUF.setEnabled(false);
        getContentPane().add(jcUF, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, 130, -1));

        jLabel11.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jLabel11.setText("RG:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, -1, 20));

        jLabel12.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jLabel12.setText("CPF:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 240, -1, 20));

        jLabel13.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jLabel13.setText("Número CNH:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, 20));

        jtCNH.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jtCNH.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jtCNH.setEnabled(false);
        getContentPane().add(jtCNH, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 237, 210, 20));

        jLabel14.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jLabel14.setText("Data Nascimento:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, 20));

        jcNivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Selecione>", "Operador", "Administrador" }));
        jcNivel.setEnabled(false);
        getContentPane().add(jcNivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, 200, -1));

        jLabel15.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jLabel15.setText("Nível:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, -1, 20));

        jbAdd.setBackground(new java.awt.Color(0, 0, 0));
        jbAdd.setFont(new java.awt.Font("Cinzel Black", 0, 12)); // NOI18N
        jbAdd.setForeground(new java.awt.Color(255, 255, 255));
        jbAdd.setText("Inserir");
        jbAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jbAdd.setEnabled(false);
        jbAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAddActionPerformed(evt);
            }
        });
        getContentPane().add(jbAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 86, 42));

        jbAlterar.setBackground(new java.awt.Color(0, 0, 0));
        jbAlterar.setFont(new java.awt.Font("Cinzel Black", 0, 12)); // NOI18N
        jbAlterar.setForeground(new java.awt.Color(255, 255, 255));
        jbAlterar.setText("Alterar");
        jbAlterar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jbAlterar.setEnabled(false);
        jbAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAlterarActionPerformed(evt);
            }
        });
        getContentPane().add(jbAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, 86, 42));

        jftTel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        try {
            jftTel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftTel.setEnabled(false);
        getContentPane().add(jftTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 116, 130, 20));

        jftRG.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        try {
            jftRG.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftRG.setEnabled(false);
        jftRG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jftRGActionPerformed(evt);
            }
        });
        getContentPane().add(jftRG, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 196, 130, 20));

        jftCPF.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        try {
            jftCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftCPF.setEnabled(false);
        getContentPane().add(jftCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(379, 236, 130, 20));

        jftDataNasc.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        try {
            jftDataNasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####/##/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftDataNasc.setEnabled(false);
        getContentPane().add(jftDataNasc, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 276, 150, 20));

        getAccessibleContext().setAccessibleDescription("");

        setSize(new java.awt.Dimension(535, 684));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jtPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtPesquisaKeyReleased
        // TODO add your handling code here:
        try{
            motoristaData DAO = new motoristaData();
            dados = DAO.pesquisarMotorista(jtPesquisa.getText());
            DefaultTableModel mp = (DefaultTableModel) jtbMotorista.getModel();
            mp.setNumRows(0);
            for (motoristaModel motorista : dados){
                if(motorista.getIdPessoa() != obj.getIdPessoa()){
                    mp.addRow(new String[]{"" + motorista.getIdPessoa(), motorista.getNomePessoa(), motorista.getEmailPessoa(), motorista.getRgMotorista(), motorista.getTelefone()});
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Erro ao Pesquisar:" + e.getMessage());
        }
           
    }//GEN-LAST:event_jtPesquisaKeyReleased

    private void jtbMotoristaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbMotoristaMouseClicked
        // TODO add your handling code here:
        try{
            int linha = jtbMotorista.getSelectedRow();
            if(linha > -1){
                jlID.setText("" + dados.get(linha).getIdPessoa());
                jtNome.setText(dados.get(linha).getNomePessoa());
                jpfSenha.setText(dados.get(linha).getSenhaMotorista());
                jtEmail.setText(dados.get(linha).getEmailPessoa());
                jftTel.setText(dados.get(linha).getTelefone());
                jtEndereco.setText(dados.get(linha).getEnderecoPessoa());
                jtCidade.setText(dados.get(linha).getCidadePessoa());
                jcUF.setSelectedItem(dados.get(linha).getUfPessoa());
                jftRG.setText(dados.get(linha).getRgMotorista());
                jftCPF.setText(dados.get(linha).getCpfMotorista());
                jtCNH.setText(dados.get(linha).getCnhMotorista());
                jftDataNasc.setText(dados.get(linha).getDatanascimento());
                if(dados.get(linha).getNivelPessoa() == 1){
                    jcNivel.setSelectedItem("Administrador");
                }else{
                    jcNivel.setSelectedItem("Operador");
                }
                obj = dados.get(linha);
                
                
                HabilitarCampos(true);

                jbNovo.setEnabled(false);
                jbAlterar.setEnabled(true);
                jbCancelar.setEnabled(true);
                jbExcluir.setEnabled(true);
                jbVisualizar.setEnabled(true);
                jbDispesas.setEnabled(true);
            }else{
                jbNovo.setEnabled(true);
                jbAlterar.setEnabled(false);
                jbCancelar.setEnabled(false);
                jbExcluir.setEnabled(false);
                jbVisualizar.setEnabled(false);
                jbDispesas.setEnabled(false);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Erro ao selecionar registros:" + e.getMessage());
        }
    }//GEN-LAST:event_jtbMotoristaMouseClicked

    private void jbNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNovoActionPerformed
        HabilitarCampos(true);
        jbAdd.setEnabled(true);
        jbNovo.setEnabled(false);
        jbCancelar.setEnabled(true);

    }//GEN-LAST:event_jbNovoActionPerformed

    private void jtCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtCidadeActionPerformed

    private void jbAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAddActionPerformed
        // TODO add your handling code here:
        op = 1;
        try {
            if (validarCampos()) {
                if (preencherObjeto()) {
                    if (DAO.motoristaUnico(obj)) {
                        motoristaData DAO = new motoristaData();
                        if (op == 1) {
                            if (DAO.incluirMotorista(obj)) {
                                JOptionPane.showMessageDialog(this, "Gravado com sucesso", "Botão Salvar", JOptionPane.INFORMATION_MESSAGE);
                                jbExcluir.setEnabled(false);
                                jbAlterar.setEnabled(false);
                                jbAdd.setEnabled(false);
                                jbCancelar.setEnabled(false);
                                jbVisualizar.setEnabled(false);
                                jbDispesas.setEnabled(false);
                                jbNovo.setEnabled(true);
                                LimparCampos();
                                HabilitarCampos(false);
                                LimparTabela();
                                //new arquivoLog("O usuário " + objU.getUsuario() + " inseriu o usuário " + obj.getUsuario() + " " + LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)) + " às " + hora);
                                atualizarTabela();
                            }
                        }
                    }
                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar:\n" + e.getMessage(), "Botão Salvar", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbAddActionPerformed

    private void jftRGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jftRGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jftRGActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        // TODO add your handling code here:
        LimparCampos();
        HabilitarCampos(false);
        LimparTabela();
        jbExcluir.setEnabled(false);
        jbAlterar.setEnabled(false);
        jbAdd.setEnabled(false);
        jbVisualizar.setEnabled(false);
        jbDispesas.setEnabled(false);
        jbNovo.setEnabled(true);
        jbCancelar.setEnabled(false);
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jbAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAlterarActionPerformed
        // TODO add your handling code here:
        op = 2;
        try {
            if (validarCampos()) {
                if (preencherObjeto()) {
                    if (DAO.motoristaUnico(obj)) {
                        motoristaData DAO = new motoristaData();
                        if (op == 2) {
                            if (DAO.alterarMotorista(obj)) {
                                JOptionPane.showMessageDialog(this, "Alterado com sucesso", "Botão Alterar", JOptionPane.INFORMATION_MESSAGE);
                                jbExcluir.setEnabled(false);
                                jbAlterar.setEnabled(false);
                                jbAdd.setEnabled(false);
                                jbCancelar.setEnabled(false);
                                jbVisualizar.setEnabled(false);
                                jbDispesas.setEnabled(false);
                                jbNovo.setEnabled(true);
                                LimparCampos();
                                HabilitarCampos(false);
                                LimparTabela();
                                //new arquivoLog("O usuário " + objU.getUsuario() + " inseriu o usuário " + obj.getUsuario() + " " + LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)) + " às " + hora);
                                atualizarTabela();
                            }
                        }
                    }
                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar:\n" + e.getMessage(), "Botão Salvar", JOptionPane.ERROR_MESSAGE);
        }          
    }//GEN-LAST:event_jbAlterarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFMotorista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFMotorista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFMotorista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFMotorista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFMotorista().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton jbAdd;
    private javax.swing.JButton jbAlterar;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbDispesas;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbNovo;
    private javax.swing.JButton jbVisualizar;
    private javax.swing.JComboBox<String> jcNivel;
    private javax.swing.JComboBox<String> jcUF;
    private javax.swing.JFormattedTextField jftCPF;
    private javax.swing.JFormattedTextField jftDataNasc;
    private javax.swing.JFormattedTextField jftRG;
    private javax.swing.JFormattedTextField jftTel;
    private javax.swing.JLabel jlID;
    private javax.swing.JPasswordField jpfSenha;
    private javax.swing.JTextField jtCNH;
    private javax.swing.JTextField jtCidade;
    private javax.swing.JTextField jtEmail;
    private javax.swing.JTextField jtEndereco;
    private javax.swing.JTextField jtNome;
    private javax.swing.JTextField jtPesquisa;
    private javax.swing.JTable jtbMotorista;
    // End of variables declaration//GEN-END:variables
}
