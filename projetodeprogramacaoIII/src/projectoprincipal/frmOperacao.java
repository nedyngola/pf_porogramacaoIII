package projectoprincipal;


//Importação de todas as bibliotecas necessarias para esta seção
import static java.awt.Color.black;
import static java.awt.Color.red;
import static java.lang.Float.parseFloat;
import java.text.DateFormat;
import java.util.*;
import java.math.BigDecimal;
import static java.math.RoundingMode.HALF_EVEN;
import javax.swing.DefaultListModel;


//Criação da classe que irá fornecer os metodos para sacar e inserir valores no stock
class StockDinheiro{
    
    //Declaração dos atributos
    Float valor;
    int stock;
    int variacao;
    //Construtor sem parâmetro
    public StockDinheiro(){
        
        //para cada atributo deste objecto colocar o valor correspondente*************************
        this.valor=0.00f;
        this.stock=0;
        this.variacao=0;
        
        
    }
    //Construtor com parâmetro
    public StockDinheiro(Float val,int qtd,int var){
        
        //para cada atributo deste objecto colocar o valor correspondente
        this.valor=val;
        this.stock=qtd;
        this.variacao=var;
        //****************************************************************************************
        
    }
    
    //Método para colocar valor de cada nota ou moeda no stock************************************
    public void setValor(Float val){
        this.valor=val;
    }
    //Método para colocar valor de cada quantidade exixtente de nota ou moeda no stock************
    public void setStock(int qtd){
        this.stock=qtd;
    }
    //Método para colocar valor de cada variação de nota ou moeda no stock************************
    public void setVariacao(int var){
       this.variacao=var;
    }
    //Método para pegar valor de cada nota ou moeda no stock*************************************
    public Float getValor(){
        return valor;
    }
    //Método para pegar cada quantidade de cada valor de nota ou moeda no stock******************
    public int getStock(){
        return stock;
    }
    //Método para pegar cada quantidade de cada valor de nota ou moeda no stock******************
    public int getVariacao(){
        return variacao;
    }
    //*******************************************************************************************
}
//Classe principal que extende da classe JFrase
public class frmOperacao extends javax.swing.JFrame {
               
               //Declaração dos ArrayLists que serão utilizados no sistema***********************
               //Devem ser declarados de forma global porque seram usados em outras seções*******
               public static List<Float> stock=new ArrayList<Float>();
               public static List<StockDinheiro> stockAux=new ArrayList<StockDinheiro>();
               public static List<StockDinheiro> stockReal=new ArrayList<StockDinheiro>(); 
               //Criação e inicialização da matriz que contém os preços**************************
               double[][]tabelaPreco={      { 0   ,11  , 12 , 12.5 , 13   , 14   , 15   , 16  , 17  , 18.5, 19   , 19.5  },
                                            {11   ,0   , 11 , 12   , 12.5 , 13   , 14   , 15  , 16  , 17  , 18.5 , 19    },
                                            {12   ,11  , 0  , 11   , 12   , 12.5 , 13   , 14  , 15  , 16  , 17   , 18.5  },
                                            {12.5 ,12  , 11 , 0    , 11   , 12   , 12.5 , 13  , 14  , 15  , 16   , 17    },
                                            {13   ,12.5, 12 , 11   , 0    , 11   , 12   , 12.5, 13  , 14  , 15   , 16    },
                                            {14   ,13  ,12,5, 12   , 11   , 0    , 11   , 12  , 12.5, 13  , 14   , 15    },
                                            {15   ,14  ,13  , 12.5 , 12   , 11   , 0    , 11  , 12  , 12.5, 13   , 14    },
                                            {16   ,15  ,14  , 13   , 12,5 , 12   , 11   , 0   , 11  , 12  , 12.5 , 13    },
                                            {17   ,16  ,15  , 14   , 13   , 12.5 , 12   , 11  , 0   , 11  , 12   , 12.5  },
                                            {18.5 ,17  ,16  , 15   , 14   , 13   , 12.5 , 12  , 11  , 0   , 11   , 12    },
                                            {19   ,18.5,17  , 16   , 15   , 14   , 13   , 12.5, 12  , 11  , 0    , 11    },
                                            {19.5 ,19  ,18.5, 17   , 16   , 15   , 14   , 13  , 12.5, 12  , 11   , 0     }      };          
               //*******************************************************************************
     //Declaração do componente que contém os Itéms da Lista************************************
     static DefaultListModel itemsDaLista=new DefaultListModel();
     //Declaração do ArrayList que irá contér o troco*******************************************
     static ArrayList<Float> trocoDado=new ArrayList<>(); 
     //Declaração das variáveis globais para verificação e incremento **************************
     static int primeiraEntrada=0;
     static long numeroBilhete=123456;
     //*****************************************************************************************
    /**
     * Creates new form frmOperacao
     */
    public frmOperacao() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFooter = new javax.swing.JLabel();
        painelOperacao = new javax.swing.JPanel();
        painelAviso = new javax.swing.JPanel();
        lblMsgAviso = new javax.swing.JLabel();
        btnOk = new javax.swing.JButton();
        lblFecharAviso = new javax.swing.JLabel();
        lblAvisoM = new javax.swing.JLabel();
        painelParaTroco = new javax.swing.JPanel();
        lblMostrarBi = new javax.swing.JLabel();
        lstTroco = new javax.swing.JScrollPane();
        lstTroco2 = new javax.swing.JList<>();
        lbllllll = new javax.swing.JLabel();
        lblMsgAviso9 = new javax.swing.JLabel();
        lblMsgAviso7 = new javax.swing.JLabel();
        lblMsgAviso8 = new javax.swing.JLabel();
        lblAvisoM2 = new javax.swing.JLabel();
        painelParaBi = new javax.swing.JPanel();
        lblMsgAviso4 = new javax.swing.JLabel();
        lblMsgAviso3 = new javax.swing.JLabel();
        lblMsgAviso2 = new javax.swing.JLabel();
        lblFecharBi = new javax.swing.JLabel();
        lblMsgAviso1 = new javax.swing.JLabel();
        lblstet = new javax.swing.JLabel();
        lblAvisoM1 = new javax.swing.JLabel();
        lblFecharOperacao1 = new javax.swing.JLabel();
        lblStatusPagamento = new javax.swing.JLabel();
        comboOrigem = new javax.swing.JComboBox<>();
        btnProxEtapa = new javax.swing.JButton();
        comboDestino = new javax.swing.JComboBox<>();
        lbldata = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        lblValorPorPagar = new javax.swing.JLabel();
        lblValorIntroduzido = new javax.swing.JLabel();
        lblValorRequerido = new javax.swing.JLabel();
        lblb = new javax.swing.JLabel();
        lbldata1 = new javax.swing.JLabel();
        lblll = new javax.swing.JLabel();
        lbldata5 = new javax.swing.JLabel();
        lbldata6 = new javax.swing.JLabel();
        lbldata7 = new javax.swing.JLabel();
        txtPagamento = new javax.swing.JTextField();
        lbllb = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        lblValorIntroduzido1 = new javax.swing.JLabel();
        lblValorPorPagar1 = new javax.swing.JLabel();
        lblValorRequerido1 = new javax.swing.JLabel();
        lblMensagem1 = new javax.swing.JLabel();
        lblMensagem = new javax.swing.JLabel();
        lblbb = new javax.swing.JLabel();
        lblOpercao = new javax.swing.JLabel();
        lblbbb = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFooter.setBackground(new java.awt.Color(0, 51, 51));
        lblFooter.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblFooter.setName(""); // NOI18N
        lblFooter.setOpaque(true);
        getContentPane().add(lblFooter, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 850, 20));

        painelOperacao.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        painelAviso.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMsgAviso.setFont(new java.awt.Font("Vrinda", 0, 14)); // NOI18N
        lblMsgAviso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        painelAviso.add(lblMsgAviso, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 470, 100));

        btnOk.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnOk.setText("Sim");
        btnOk.setToolTipText("");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });
        painelAviso.add(btnOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 200, 70, 30));

        lblFecharAviso.setFont(new java.awt.Font("Vrinda", 1, 24)); // NOI18N
        lblFecharAviso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFecharAviso.setText("X");
        lblFecharAviso.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblFecharAviso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFecharAvisoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblFecharAvisoMouseEntered(evt);
            }
        });
        painelAviso.add(lblFecharAviso, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, 30, 30));

        lblAvisoM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/av.jpg"))); // NOI18N
        lblAvisoM.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 204), 1, true));
        lblAvisoM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblAvisoMMouseEntered(evt);
            }
        });
        painelAviso.add(lblAvisoM, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 330));

        painelOperacao.add(painelAviso, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 800, 330));

        painelParaTroco.setBackground(new java.awt.Color(0, 0, 0));
        painelParaTroco.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMostrarBi.setFont(new java.awt.Font("Vrinda", 0, 20)); // NOI18N
        lblMostrarBi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMostrarBi.setText("Gerar Bilhete");
        lblMostrarBi.setToolTipText("Mostrar Bilhete");
        lblMostrarBi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMostrarBiMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblMostrarBiMouseEntered(evt);
            }
        });
        painelParaTroco.add(lblMostrarBi, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 220, 160, 60));

        lstTroco.setToolTipText("");

        lstTroco2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 153), 1, true));
        lstTroco2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lstTroco2.setToolTipText("Troco Dado");
        lstTroco.setViewportView(lstTroco2);

        painelParaTroco.add(lstTroco, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 130, 140));

        lbllllll.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbllllll.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 153), 1, true));
        painelParaTroco.add(lbllllll, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, 260, 140));

        lblMsgAviso9.setFont(new java.awt.Font("Meiryo UI", 1, 18)); // NOI18N
        lblMsgAviso9.setForeground(new java.awt.Color(102, 0, 0));
        lblMsgAviso9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMsgAviso9.setText("Troco de  ");
        lblMsgAviso9.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblMsgAviso9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 204), 1, true));
        painelParaTroco.add(lblMsgAviso9, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 480, 200));

        lblMsgAviso7.setFont(new java.awt.Font("Vrinda", 0, 14)); // NOI18N
        lblMsgAviso7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMsgAviso7.setText("A viagem de ");
        painelParaTroco.add(lblMsgAviso7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 470, 30));

        lblMsgAviso8.setFont(new java.awt.Font("Vrinda", 0, 14)); // NOI18N
        lblMsgAviso8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMsgAviso8.setText("Quantia introduzida ");
        painelParaTroco.add(lblMsgAviso8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 440, 30));

        lblAvisoM2.setForeground(new java.awt.Color(204, 0, 0));
        lblAvisoM2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/88.jpg"))); // NOI18N
        lblAvisoM2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 204), 1, true));
        lblAvisoM2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblAvisoM2MouseEntered(evt);
            }
        });
        painelParaTroco.add(lblAvisoM2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 390));

        painelOperacao.add(painelParaTroco, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, 390));

        painelParaBi.setBackground(new java.awt.Color(0, 0, 0));
        painelParaBi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMsgAviso4.setFont(new java.awt.Font("Vrinda", 0, 14)); // NOI18N
        lblMsgAviso4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMsgAviso4.setText("Bilhete Número ");
        painelParaBi.add(lblMsgAviso4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 510, 30));

        lblMsgAviso3.setFont(new java.awt.Font("Vrinda", 0, 14)); // NOI18N
        lblMsgAviso3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMsgAviso3.setText("Preço: ");
        painelParaBi.add(lblMsgAviso3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 510, 30));

        lblMsgAviso2.setFont(new java.awt.Font("Vrinda", 0, 14)); // NOI18N
        lblMsgAviso2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMsgAviso2.setText("Válido de ");
        painelParaBi.add(lblMsgAviso2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 510, 30));

        lblFecharBi.setFont(new java.awt.Font("Vrinda", 1, 14)); // NOI18N
        lblFecharBi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFecharBi.setText("OK");
        lblFecharBi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFecharBiMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblFecharBiMouseEntered(evt);
            }
        });
        painelParaBi.add(lblFecharBi, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 300, 80, 30));

        lblMsgAviso1.setFont(new java.awt.Font("Vrinda", 0, 14)); // NOI18N
        lblMsgAviso1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMsgAviso1.setText("Emitido em ");
        painelParaBi.add(lblMsgAviso1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 510, 30));

        lblstet.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 204), 1, true));
        lblstet.setName(""); // NOI18N
        painelParaBi.add(lblstet, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 650, 170));

        lblAvisoM1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/troco.jpg"))); // NOI18N
        lblAvisoM1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 204), 1, true));
        lblAvisoM1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblAvisoM1MouseEntered(evt);
            }
        });
        painelParaBi.add(lblAvisoM1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 380));

        painelOperacao.add(painelParaBi, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, 380));

        lblFecharOperacao1.setBackground(new java.awt.Color(0, 51, 51));
        lblFecharOperacao1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblFecharOperacao1.setForeground(new java.awt.Color(255, 255, 255));
        lblFecharOperacao1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFecharOperacao1.setToolTipText("Cancele a operação!");
        lblFecharOperacao1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 51), 1, true));
        lblFecharOperacao1.setOpaque(true);
        lblFecharOperacao1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFecharOperacao1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblFecharOperacao1MouseEntered(evt);
            }
        });
        painelOperacao.add(lblFecharOperacao1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, 200, 40));

        lblStatusPagamento.setBackground(new java.awt.Color(0, 102, 102));
        lblStatusPagamento.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        lblStatusPagamento.setForeground(new java.awt.Color(255, 255, 255));
        lblStatusPagamento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStatusPagamento.setToolTipText("Valor Pago ");
        lblStatusPagamento.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 204), 2, true));
        lblStatusPagamento.setOpaque(true);
        painelOperacao.add(lblStatusPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 290, 100));

        comboOrigem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " Luanda ", "Canhoca ", "Queta ", "N'dalatando", "Lucala ", "Quizenga ", "Cambunze ", "Cacuso ", "Matete ", "Zanga ", "Lombe ", "Malange " }));
        comboOrigem.setToolTipText("Escolha a mesma localidade para cancelar.");
        comboOrigem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboOrigemMouseClicked(evt);
            }
        });
        comboOrigem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboOrigemActionPerformed(evt);
            }
        });
        painelOperacao.add(comboOrigem, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 110, -1));

        btnProxEtapa.setText("Proximo");
        btnProxEtapa.setToolTipText("Escolha a mesma localidade para cancelar.");
        btnProxEtapa.setActionCommand("");
        btnProxEtapa.setEnabled(false);
        btnProxEtapa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProxEtapaActionPerformed(evt);
            }
        });
        painelOperacao.add(btnProxEtapa, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, -1, 40));

        comboDestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " Luanda ", "Canhoca ", "Queta ", "N'dalatando", "Lucala ", "Quizenga ", "Cambunze ", "Cacuso ", "Matete ", "Zanga ", "Lombe ", "Malange " }));
        comboDestino.setToolTipText("Escolha a mesma localidade para cancelar.");
        comboDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDestinoActionPerformed(evt);
            }
        });
        painelOperacao.add(comboDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 120, -1));

        lbldata.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        painelOperacao.add(lbldata, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 450, 300, 20));

        lbl2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lbl2.setText("Data :");
        painelOperacao.add(lbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 40, 20));

        lblValorPorPagar.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lblValorPorPagar.setText("0.00");
        lblValorPorPagar.setToolTipText("");
        painelOperacao.add(lblValorPorPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, 130, 20));

        lblValorIntroduzido.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lblValorIntroduzido.setText("0.00");
        lblValorIntroduzido.setToolTipText("");
        painelOperacao.add(lblValorIntroduzido, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 130, 20));

        lblValorRequerido.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lblValorRequerido.setText("0.00");
        painelOperacao.add(lblValorRequerido, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, 130, 20));

        lblb.setBackground(new java.awt.Color(0, 51, 51));
        lblb.setForeground(new java.awt.Color(255, 255, 255));
        lblb.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "      Origem             Destino", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Vrinda", 1, 18), new java.awt.Color(0, 0, 204))); // NOI18N
        lblb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblbMouseEntered(evt);
            }
        });
        painelOperacao.add(lblb, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 290, 100));

        lbldata1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbldata1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbldata1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));
        painelOperacao.add(lbldata1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 800, 40));

        lblll.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        lblll.setText("Velamos pela simplicidade...");
        painelOperacao.add(lblll, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 450, 150, 20));

        lbldata5.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lbldata5.setText("Custo Requerido :");
        painelOperacao.add(lbldata5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 110, 20));

        lbldata6.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lbldata6.setText("Quantia Introduida :");
        lbldata6.setToolTipText("");
        painelOperacao.add(lbldata6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 120, 20));

        lbldata7.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lbldata7.setText("Quantia por Pagar :");
        painelOperacao.add(lbldata7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 120, 20));

        txtPagamento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPagamento.setText("Valor AKZ");
        txtPagamento.setToolTipText("");
        txtPagamento.setEnabled(false);
        txtPagamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPagamentoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtPagamentoMousePressed(evt);
            }
        });
        txtPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPagamentoActionPerformed(evt);
            }
        });
        txtPagamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPagamentoKeyPressed(evt);
            }
        });
        painelOperacao.add(txtPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 300, 90, 30));

        lbllb.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbllb.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbllb.setText("  Insira o Valor  a ser Pago (Enter)");
        lbllb.setToolTipText("");
        lbllb.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 204), 2, true));
        painelOperacao.add(lbllb, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 290, 320, 50));

        btnCancelar.setText("Cancelar");
        btnCancelar.setActionCommand("");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        painelOperacao.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 180, 170, 40));

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });
        painelOperacao.add(btnVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(691, 180, 70, 40));

        lblValorIntroduzido1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lblValorIntroduzido1.setText("KZ");
        lblValorIntroduzido1.setToolTipText("");
        painelOperacao.add(lblValorIntroduzido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, 20, 20));

        lblValorPorPagar1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lblValorPorPagar1.setText("KZ");
        lblValorPorPagar1.setToolTipText("");
        painelOperacao.add(lblValorPorPagar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 320, 20, 20));

        lblValorRequerido1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lblValorRequerido1.setText("KZ");
        painelOperacao.add(lblValorRequerido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 290, 20, 20));

        lblMensagem1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblMensagem1.setForeground(new java.awt.Color(255, 0, 0));
        lblMensagem1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMensagem1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblMensagem1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 51), 1, true));
        painelOperacao.add(lblMensagem1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 420, 240));

        lblMensagem.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblMensagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMensagem.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 204), 2, true));
        painelOperacao.add(lblMensagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 290, 100));

        lblbb.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 51), 1, true));
        painelOperacao.add(lblbb, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 330, 240));

        lblOpercao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Modulo3.jpg"))); // NOI18N
        lblOpercao.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 51), 2, true));
        lblOpercao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblOpercaoMouseEntered(evt);
            }
        });
        painelOperacao.add(lblOpercao, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, -1));

        lblbbb.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        painelOperacao.add(lblbbb, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 430, 300, 20));

        getContentPane().add(painelOperacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Método para atualizar o ArrayList auxiliar apartir do principal(Real)***************************************
    static void preecheStockGeral(){
         for(int pos1=0;pos1<stockReal.size();pos1++)
           stockAux.add(new StockDinheiro(stockReal.get(pos1).getValor(),stockReal.get(pos1).getStock(),stockReal.get(pos1).getVariacao())); 
    }
    //Método para atualizar o ArrayList principal apartir do auxili***********************************************
     static void atualizaStock(){
         for(int pos1=0;pos1<stockAux.size();pos1++)
            stockReal.add(new StockDinheiro(stockAux.get(pos1).getValor(),stockAux.get(pos1).getStock(),stockAux.get(pos1).getVariacao()));      
     }
    //Método para formatar os valores que serám manipulados ao longo de cada processo de venda
    //Este método recebe um parâmetro do tipo Float
    private static Float formatador(Float num){
        //formatando o número (num) usando o BigDecimal
        BigDecimal formato=new BigDecimal(num).setScale(2, HALF_EVEN);
        //após a formatação do número retornamos o novo número(já formatádo)
        //apartir do método 'floatValue()'
        return formato.floatValue();
      
    }
    //Método que emite um numéro inteiro para cada Bilhete
    static long numBi(){
        return ++numeroBilhete;
    }
    //Método para preparação do painel que imprime o Bilhete*********************************
      static void esvaziaBi(){
        
        DefaultListModel modeloTrocoDado=new DefaultListModel();        
          
        lblMsgAviso2.setText("Válido de ");
        lblMsgAviso1.setText("Emitido em ");
        lblMsgAviso4.setText("Nº do Bilhete ");
        lblMsgAviso3.setText("Preço: ");        
        lblMsgAviso7.setText("A viagem de ");
        lblMsgAviso8.setText("Quantia introduzida ");
        lblMsgAviso9.setText("Troco de ");
        
      }
    //Método que preenche o Bilhete**********************************************************
    static void preencheBi(){
        //Criação de um calendário
        Calendar cal=Calendar.getInstance();
        //Criação de uma data deste calendario
        Date date = cal.getTime();
        //Formatando a data
        DateFormat dataHora=DateFormat.getDateTimeInstance();

        //Na linha abaixo foi feito para os labels, o seguinte:
        //Usou-se o método setText() para introduzirmos um valor a respectiva label
        //Pega-se o valor que se encontra na respectiva label(nomeLabel.getText())
        //De seguida concatenamos ao valor que se encontra na label que foi pega o valor que vem de uma certa origem
        //Usando o método concat()
        //E concatena-se novamente com a palavra 'para', finalmente concatenamos com o valor que vem de um certo destino
        
        lblMsgAviso2.setText(lblMsgAviso2.getText().concat(comboOrigem.getSelectedItem().toString().concat(" "
        + "para ").concat(comboDestino.getSelectedItem().toString())));
        
        lblMsgAviso1.setText(lblMsgAviso1.getText().concat(dataHora.format(date)));
        
        lblMsgAviso4.setText(lblMsgAviso4.getText().concat(""+numBi()));
        
        lblMsgAviso3.setText(lblMsgAviso3.getText().concat(""+lblValorRequerido.getText()+" Akz"+""
        + "(Impostos incluíndo à taxa legal em vigor)"));  
        
        lblMsgAviso7.setText(lblMsgAviso7.getText().concat(comboOrigem.getSelectedItem().toString().concat(" "
        +"para ").concat(comboDestino.getSelectedItem().toString().concat(" tem um custo de "+lblValorRequerido.getText()+" Akz."))));
        
        lblMsgAviso8.setText(lblMsgAviso8.getText().concat(lblValorIntroduzido.getText()+" Akz. Faltam 0 Akz"));
        
        lblMsgAviso9.setText(lblMsgAviso9.getText().concat(lblValorPorPagar.getText()+" Akz. "));
        //Limpando os items do listModel que será introduzido em uma lista irá apresentar um novo troco******
        itemsDaLista.clear();
        //Percorrendo o ArrayList que armazena o troco para poder inserir em uma lista***********************
        for( int i=0; i<trocoDado.size();i++ ){
            //Introduzindo o novo troco no listModel (addElement())
            String auxTroco=trocoDado.get(i).toString().concat("      AKZ");
            itemsDaLista.addElement("   "+auxTroco);        
        }  
        //Introduzindo na lista o novo troco a ser mostrado *************************************************
        lstTroco2.setModel(itemsDaLista);
        //***************************************************************************************************
    }
    
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing
    //Método que auxilia na hora de preencher o valor da quantidade de cada nota e moeda em stock************  
    static int preencheStockAux(int i){
        
        int retornaQtd = 0;

        switch(i){
            
            case 1: {
                retornaQtd = 3;
                break;
            }
           
            case 2:{
                retornaQtd = 7;
                break;
            }
            case 3:{
                retornaQtd = 10;
                break;
            }
            case 4:{
                retornaQtd = 0;
                break;
            }
            case 5:{
                retornaQtd = 1; 
                break;
            }
             case 6:{
                retornaQtd = 1;
                break;
             }
             case 7:{
                retornaQtd = 10;
                break;
             }
             case 8:{
                retornaQtd = 10;
                break;
             }
             case 9:{
                retornaQtd = 12;
                break;
             }
             case 10:{
                retornaQtd = 3;
                break;
             }
             case 11:{
                retornaQtd = 1;
                break;
             }
             default:
                 break;
        }
        return retornaQtd;
    }
    //Ao abrir o form operação é criado um calendário para poder-se criar uma data e hora para posteriormente *******************
    //Formatar as mesmas usando a classe DateFormat e finalmente apresentar a data **********************************************
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        Calendar cal=Calendar.getInstance();
        Date date = cal.getTime();
        DateFormat formato=DateFormat.getDateInstance(DateFormat.FULL);
        DateFormat dataHora=DateFormat.getDateTimeInstance();
        lbldata.setText(formato.format(date));
        painelAviso.setVisible(false);
        painelParaBi.setVisible(false);
        painelParaTroco.setVisible(false);
        lblStatusPagamento.setVisible(false);
        // Fazendo com que o splach seja mostrado apenas uma vez***************************************************************
        Home.sinalSplach=false;   
  
    }//GEN-LAST:event_formWindowOpened

    private void lblOpercaoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOpercaoMouseEntered
        
    }//GEN-LAST:event_lblOpercaoMouseEntered
    // No click do botão (voltar) somos levados ao form principal**************************************************************
    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        //Devemos indicar ao form principal que o sistema esta correndo( Não deve fazer alteração ao valor do stock )
        Home.sistemaCorrendo=true;
        //Fechar o form em questão e mostrar o form principal******************************************************************
        dispose();
        new Home().setVisible(true);
        //*********************************************************************************************************************
    }//GEN-LAST:event_btnVoltarActionPerformed
    // A seguir temos um trecho de código que é executado quando o botão de cancelar é clicado*********************************  
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        btnOk.setText(" OK ");
        lblMsgAviso.setText("Deseja cancelar esta operação ?");
        painelAviso.setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed
    //*************************************************************************************************************************
    private void txtPagamentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPagamentoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPagamentoKeyPressed
    
    //Tratando do pagamento
    private void txtPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPagamentoActionPerformed

        // Declaração das variáveis********************************************************************************************

        Float valorRestante = null;
        Float valorFinal;
        Float verificador;
        int pegaIndice=0;
        boolean sinal;
        
        //********************************************************************************************************************
        try{
            //pegando o valor da txtPagamento e convertendo para Float********************************************************
            verificador=parseFloat(txtPagamento.getText());
            //Se este valor faz parte do stock de notas e moedas iremos entrar na strutura************************************
            if(stock.contains(verificador)){
                //PegaIndice é uma variável que irá conter o valor que foi introduzido****************************************
                pegaIndice=stock.indexOf(verificador);
                //Pegando o índice onde está contido a nota ou moeda digitada usando o método get()
                //De seguida adiciona-se uma unidade no campo stock e no campo variação apartir da posição sacada pelo metodo indexOf()
                stockAux.get(pegaIndice).setStock(stockAux.get(pegaIndice).getStock()+1);
                stockAux.get(pegaIndice).setVariacao(stockAux.get(pegaIndice).getVariacao()+1);
                //Na primeira vez que for digitado um valor (nota ou moeda), coloca os valores certos nas labels correspondente 
                if(primeiraEntrada==0){
                    lblValorIntroduzido.setText(txtPagamento.getText());
                    valorRestante=parseFloat(lblValorPorPagar.getText()) - parseFloat(txtPagamento.getText());
                    valorRestante=formatador(valorRestante);
                    lblValorPorPagar.setText(Double.toString(valorRestante));
                    primeiraEntrada++;
                }else{
                //Atualiza os valores contidos nas respectivas labels, a cada valor de nota ou moeda digitada.
                    valorRestante=parseFloat(lblValorPorPagar.getText()) - parseFloat(txtPagamento.getText());
                    valorRestante=formatador(valorRestante);
                    valorFinal= parseFloat(lblValorIntroduzido.getText())+ parseFloat(txtPagamento.getText());
                    valorFinal=formatador(valorFinal);
                    lblValorIntroduzido.setText(Float.toString(valorFinal));
                    lblValorPorPagar.setText(Float.toString(valorRestante));
                }
                //*******************************************************************************************************
                txtPagamento.setText("");
                //verificando se valor pago já é igual ou superior ao valor requerido************************************
                if(valorRestante<=0){
                    //Se sim termina a etapa de pagamento
                    lbldata7.setText("Troco por entregar :");
                    valorFinal=parseFloat(lblValorIntroduzido.getText()) - parseFloat(lblValorRequerido.getText());
                    System.out.println("(((((((((((((Troco dado antes da formatação: "+valorFinal+")))))))))))))");
                    valorFinal=formatador(valorFinal);
                    lblValorPorPagar.setText(Float.toString(valorFinal));
                    btnProxEtapa.setEnabled(true);
                    txtPagamento.setEnabled(false);
                    txtPagamento.setText("Valor AKZ");
                }
                //*******************************************************************************************************
            }else {
                //Se o valor digitado não existe no stock, entao a venda é cancelada*************************************
                lblMsgAviso.setText("<html><p>A máquina XPTO apenas aceita notas de <strong>20Akz, 10Akz ou 5Akz.</strong><br/> "
                    + "E moedas de <strong>2Akz, 1Akz 0.5Akz, 0.02Akz ou 0.01Akz.</strong></p></html>");
                btnOk.setText("OK");
                painelAviso.setVisible(true);
            }
            lblStatusPagamento.setText(lblValorIntroduzido.getText()+" AKZ ");
        }catch(NumberFormatException e){
            //Tratamento quando ocorre uma exceção ao digitar um valor invalido*****************************************
        }

    }//GEN-LAST:event_txtPagamentoActionPerformed

    private void txtPagamentoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPagamentoMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPagamentoMousePressed

    private void txtPagamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPagamentoMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_txtPagamentoMouseClicked

    private void lblbMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblbMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lblbMouseEntered
    //Escolha do destino************************************************************************
    private void comboDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDestinoActionPerformed
        // Declaração das variáveis*************************************************************
        Double valorRequerido;
        int posOrigem=0,posDestino=0;
        String origem =  (String)comboOrigem.getSelectedItem();
        String destino=  (String)comboDestino.getSelectedItem();
        //Se a origem for igual ao destino então o processo é cancelado*************************
        if(origem.equals(destino)){
            stockAux.clear();
            preecheStockGeral();
            lbldata7.setText("Valor por pagar :");
            lblValorPorPagar.setText("0.00");
            btnVoltar.setEnabled(true);
            txtPagamento.setEnabled(false);
            txtPagamento.setText("Valor AKZ");
            btnProxEtapa.setText("Proximo");
            primeiraEntrada=0;
            btnCancelar.setEnabled(false);
            btnProxEtapa.setEnabled(false);
            lblValorIntroduzido.setText("0.00 ");
            lblValorPorPagar.setText("0.00 ");
            lblValorRequerido.setText("0.00 ");
        //************************************************************************************************************
        }else{
            //Caso a origem seja diferente do destino então podemos passar para aetapa de pagamento*******************
            btnVoltar.setEnabled(false);
            //Pegando os índices da linha e coluna, para poder-se pegar o correspondente preço************************  
            posOrigem = comboOrigem.getSelectedIndex();
            posDestino= comboDestino.getSelectedIndex();
            //Na matriz que contém o preço pegamos o valor correspondente a linha e coluna indicada*******************
            valorRequerido=tabelaPreco[posOrigem][posDestino];
            //Colocação dos resultados obtidos nas respectivas labes*************************************************
            lblValorRequerido.setText(Double.toString(valorRequerido));
            lblValorPorPagar.setText(lblValorRequerido.getText());
            //********************************************************************************************************
            btnProxEtapa.setEnabled(true);
            btnCancelar.setEnabled(true);
        }
    }//GEN-LAST:event_comboDestinoActionPerformed
    //Terminando a etapa 2 ou 3******************************************************************************************
    private void btnProxEtapaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProxEtapaActionPerformed

        //Decaração das variáveis locais*********************************************************************************
        Float troco=0.00f;

        Double auxTroco=0.00;

        boolean deoTroco=false;

        int pegaIndice=0,indice=0;
        //**************************************************************************************************************
        if(btnProxEtapa.getText().equals("Proximo")){
            //Instruções para preparação para o 2º módulo*************************************************************** 
            lblStatusPagamento.setVisible(true);
            lblStatusPagamento.setText(lblValorIntroduzido.getText()+" AKZ ");
            btnProxEtapa.setText("Finalizar");
            btnProxEtapa.setEnabled(false);
            txtPagamento.setEnabled(true);
            txtPagamento.setText("");
            //**********************************************************************************************************
        }else{
            //Instrução para o 3º módulo********************************************************************************
            //Se valor requerido for igual ao valor introduzido*********************************************************
            //Limpa stockReal e atualiza com os novos valores***********************************************************
            if(parseFloat(lblValorRequerido.getText()) == parseFloat(lblValorIntroduzido.getText())){

                stockReal.clear();

                atualizaStock();

                preencheBi();
                //Não há troco, logo simplesmente imprimimos o Bilhete**************************************************
                painelParaBi.setVisible(true);

            }else{
                //Caso exista troco ************************************************************************************
                troco = parseFloat(lblValorIntroduzido.getText()) - parseFloat(lblValorRequerido.getText());
                //Formatamos o mesmo ***********************************************************************************
                troco = formatador(troco);
                //Se o valor deste troco existe em nosso stock**********************************************************
                if(stock.contains(troco)){
                    //pegamos o indice em que se encontra este valor no stock*******************************************
                    pegaIndice=stock.indexOf(troco);
                    //se no stock auxiliar (stockAux) na posição do índice em questão, no campo stock for maior que zero
                    if(stockAux.get(pegaIndice).getStock()>0){
                        //Subtraimos ao valor do stock na respectiva posição uma unidade********************************
                        stockAux.get(pegaIndice).setStock(stockAux.get(pegaIndice).getStock()-1);
                        //Subtraimos ao valor da variação na respectiva posição uma unidade*****************************
                        stockAux.get(pegaIndice).setVariacao(stockAux.get(pegaIndice).getVariacao()-1);
                        //Devemos indicar ao sistema que foi possivel dar troco*****************************************
                        deoTroco=true;
                        //Devemos guardar o troco que foi dado para posteriormente ser mostrado no fim do módulon 3*****
                        trocoDado.add(troco);
                    }

                }//Caso o valor do troco não faça parte do nosso stock**************************************************
                //Percorremos todo stock********************************************************************************
                for(indice=0;indice<stock.size();indice++){
                    //Se já foi alcançado o troco a ser dado saímos do loop*********************************************
                    if(deoTroco)break;
                    //Caso contrario, enquanto o troco a ser dado for maior que o valor no stock************************
                    while((troco >= stock.get(indice))&&(stockAux.get(indice).getStock()>0)){
                        //Descontamos no troco este valor de stock******************************************************
                        troco-=stock.get(indice);
                        //Formatamos o valor do resultado obtido********************************************************
                        troco= formatador(troco);
                        //Imprimindo na consola cada troco dado, a fim de verificações *********************************
                        System.out.println(troco+"=> Troco Dado");
                        //Adicionando o troco parcial a lista de troco a ser dado***************************************
                        trocoDado.add(stock.get(indice));
                        //Subtraimos ao valor do stock na respectiva posição uma unidade********************************
                        stockAux.get(indice).setStock(stockAux.get(indice).getStock()-1);
                        //Subtraimos ao valor da variação na respectiva posição uma unidade*****************************
                        stockAux.get(indice).setVariacao(stockAux.get(indice).getVariacao()-1);

                    }
                    //Se o troco = zero então devemos indicar que foi possivel dar troco********************************
                    if(troco==0){
                        deoTroco=true;
                        break;
                    }//************************************************************************************************
                }
                //Se foi possivel dar troco ***************************************************************************
                if(deoTroco){
                    //Chamamos o método que prepara o bilhete que será imprenço****************************************
                    preencheBi();
                    //Após a preparar do bilhette, mostramos inicialmente o troco dado*********************************
                    painelParaTroco.setVisible(true);

                }else{
                    //Se não for possivel dar o troco******************************************************************
                    //Limpamos as alterações feitas no stock e emitimos uma mensagem do ocorrido***********************
                    trocoDado.clear();
                    btnOk.setText("  Ok  ");
                    lblMsgAviso.setText("<html><p><strong>Lamentamos informar que não temos moedas suficientes para lhe dar troco. A venda do</strong> "
                        + "<strong>bilhete será cancelada. Por favor introduza uma quantia certa ou dirija-se a outra máquina.</strong></p></html>");
                    painelAviso.setVisible(true);
                    //*************************************************************************************************
                }

            }

        }

    }//GEN-LAST:event_btnProxEtapaActionPerformed
    //Escolha do destino***********************************************************************
    private void comboOrigemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboOrigemActionPerformed
       // Declaração das variáveis*************************************************************
        Double valorRequerido;
        int posOrigem=0,posDestino=0;
        String origem =  (String)comboOrigem.getSelectedItem();
        String destino=  (String)comboDestino.getSelectedItem();
        //Se a origem for igual ao destino então o processo é cancelado************************
        if(origem.equals(destino)){
            stockAux.clear();
            lbldata7.setText("Valor por pagar :");
            lblValorPorPagar.setText("0.00");
            preecheStockGeral();
            btnVoltar.setVisible(true);
            txtPagamento.setEnabled(false);
            txtPagamento.setText("Valor AKZ");
            btnProxEtapa.setText("Proximo");
            primeiraEntrada=0;
            btnCancelar.setEnabled(false);
            btnProxEtapa.setEnabled(false);
            lblValorIntroduzido.setText("0.00");
            lblValorPorPagar.setText("0.00");
            lblValorRequerido.setText("0.00");
        //************************************************************************************************************
        }else{
            //Caso a origem seja diferente do destino então podemos passar para aetapa de pagamento*******************
            btnVoltar.setEnabled(false);
            //Pegando os índices da linha e coluna, para poder-se pegar o correspondente preço************************
            posOrigem = comboOrigem.getSelectedIndex();
            posDestino= comboDestino.getSelectedIndex();
            valorRequerido=tabelaPreco[posOrigem][posDestino];
            //Na matriz que contém o preço pegamos o valor correspondente a linha e coluna indicada*******************
            lblValorRequerido.setText(Double.toString(valorRequerido));
            //Colocação dos resultados obtidos nas respectivas labes*************************************************
            lblValorPorPagar.setText(lblValorRequerido.getText());
            btnProxEtapa.setEnabled(true);
            btnCancelar.setEnabled(true);
            //********************************************************************************************************
        }

    }//GEN-LAST:event_comboOrigemActionPerformed

    private void comboOrigemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboOrigemMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_comboOrigemMouseClicked

    private void lblFecharOperacao1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFecharOperacao1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lblFecharOperacao1MouseEntered

    private void lblFecharOperacao1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFecharOperacao1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblFecharOperacao1MouseClicked

    private void lblAvisoM2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAvisoM2MouseEntered
        // Ao entrar na área desta label, alteramos a sua cor para preto***********************************
        lblMostrarBi.setForeground(black);
    }//GEN-LAST:event_lblAvisoM2MouseEntered

    private void lblMostrarBiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMostrarBiMouseEntered
        // Ao entrar na área desta label, alteramos a sua cor para vermelho***********************************
        lblMostrarBi.setForeground(red);
    }//GEN-LAST:event_lblMostrarBiMouseEntered

    private void lblMostrarBiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMostrarBiMouseClicked
        // Ao mostrarmos o bilhete, antes limpamos o ArrayList de trocos e mostramos**************************
        trocoDado.clear();
        painelParaTroco.setVisible(false);
        painelParaBi.setVisible(true);
        //****************************************************************************************************
    }//GEN-LAST:event_lblMostrarBiMouseClicked

    private void lblAvisoMMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAvisoMMouseEntered
        // Ao entrar na área desta label, alteramos a sua cor para preto***********************************
        lblFecharAviso.setForeground(black);
    }//GEN-LAST:event_lblAvisoMMouseEntered

    private void lblFecharAvisoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFecharAvisoMouseEntered
        // Ao entrar na área desta label, alteramos a sua cor para vermelho***********************************
        lblFecharAviso.setForeground(red);
    }//GEN-LAST:event_lblFecharAvisoMouseEntered
    // A seguir é mostrado como é que o sistema trata de tudo antes de fechar uma dada seção*************************
    private void lblFecharAvisoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFecharAvisoMouseClicked
        
        if(btnOk.getText().equals("OK")||btnOk.getText().equals(" OK ")){
            //Caso desejamos abulir um cancelamento******************************************************************
            painelAviso.setVisible(false);
            btnOk.setText("Sim");
        }else{
            //Caso desejamos cancelar uma operação voltamos tudo ao normal sem alterações****************************
            stockAux.clear();
            preecheStockGeral();
            btnOk.setText("Sim");
            lblStatusPagamento.setVisible(false);
            btnVoltar.setEnabled(true);
            comboOrigem.setSelectedIndex(0);
            comboDestino.setSelectedIndex(0);
            primeiraEntrada=0;
            btnProxEtapa.setText("Proximo");
            txtPagamento.setEnabled(false);
            btnCancelar.setEnabled(false);
            btnProxEtapa.setEnabled(false);
            txtPagamento.setText("Valor AKZ");
            lblValorIntroduzido.setText("0.00");
            lblValorPorPagar.setText("0.00");
            lblValorRequerido.setText("0.00");
            painelAviso.setVisible(false);
            //Immpreção para futuras verificações*******************************************************************
            System.out.println("*****************StockAux-Cancelado-ST********************");
            for(int k=0;k<stockAux.size();k++){

                System.out.print("      "+stockAux.get(k).valor+"      ");

                System.out.print("      "+stockAux.get(k).stock+"      ");

                System.out.print("      "+stockAux.get(k).variacao+"      ");
                System.out.println(" ");
            }
            System.out.println("*****************StockReal-Cancelado-ST*****************");
            for(int k=0;k<stockReal.size();k++){

                System.out.print("      "+stockReal.get(k).valor+"      ");

                System.out.print("      "+stockReal.get(k).stock+"      ");

                System.out.print("      "+stockReal.get(k).variacao+"      ");
                System.out.println(" ");
            }
            //******************************************************************************************************
        }
    }//GEN-LAST:event_lblFecharAvisoMouseClicked
    // Procedimento análogo ao anterior*****************************************************************************
    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        // TODO add your handling code here:
        if(btnOk.getText().equals(" OK")){
            painelAviso.setVisible(false);
            btnOk.setText("Sim");
            txtPagamento.setEnabled(false);
        }else{
        
                if(btnOk.getText().equals("OK")){
                    painelAviso.setVisible(false);
                    btnOk.setText("Sim");
                    txtPagamento.setEnabled(true);
                }else{

                    if(btnOk.getText().equals(" OK ")){

                        lblMsgAviso.setText("Compra de viagem cancelada. Foram devolvidos: " + lblValorIntroduzido.getText() + " Akz ao viajante.");
                        btnOk.setText(" OK");
                        lbldata7.setText("Valor por pagar :");
                        lblValorPorPagar.setText("0.00");
                        lblStatusPagamento.setVisible(false);
                        btnVoltar.setEnabled(true);
                        comboOrigem.setSelectedIndex(0);
                        comboDestino.setSelectedIndex(0);
                        primeiraEntrada=0;
                        btnProxEtapa.setText("Proximo");
                        txtPagamento.setEnabled(false);
                        btnCancelar.setEnabled(false);
                        btnProxEtapa.setEnabled(false);
                        txtPagamento.setEnabled(false);
                        txtPagamento.setText("Valor AKZ");
                        lblValorIntroduzido.setText("0.00");
                        lblValorPorPagar.setText("0.00");
                        lblValorRequerido.setText("0.00");
                        stockAux.clear();
                        preecheStockGeral();
                        System.out.println("*****************StockAux-Cancelado********************");
                        for(int k=0;k<stockAux.size();k++){

                            System.out.print("      "+stockAux.get(k).valor+"      ");

                            System.out.print("      "+stockAux.get(k).stock+"      ");

                            System.out.print("      "+stockAux.get(k).variacao+"      ");
                            System.out.println(" ");
                        }
                        System.out.println("*****************StockReal-Cancelado*****************");
                        for(int k=0;k<stockReal.size();k++){

                            System.out.print("      "+stockReal.get(k).valor+"      ");

                            System.out.print("      "+stockReal.get(k).stock+"      ");

                            System.out.print("      "+stockReal.get(k).variacao+"      ");
                            System.out.println(" ");

                        }
                        //**********************************************************************************************
                    }else{
                        //Idem. Mas não para cancelamento***************************************************************
                        //Será executado este trecho quando o bilhete for dado******************************************
                        lbldata7.setText("Valor por pagar :");
                        lblValorPorPagar.setText("0.00");
                        lblStatusPagamento.setVisible(false);
                        btnVoltar.setEnabled(true);
                        comboOrigem.setSelectedIndex(0);
                        comboDestino.setSelectedIndex(0);
                        primeiraEntrada=0;
                        btnProxEtapa.setText("Proximo");
                        txtPagamento.setEnabled(false);
                        btnCancelar.setEnabled(false);
                        btnProxEtapa.setEnabled(false);
                        txtPagamento.setText("Valor AKZ");
                        lblValorIntroduzido.setText("0.00");
                        lblValorPorPagar.setText("0.00");
                        lblValorRequerido.setText("0.00");
                        painelAviso.setVisible(false);
                        stockAux.clear();
                        preecheStockGeral();
                        System.out.println("*****************StockAux-Sem Troco********************");
                        for(int k=0;k<stockAux.size();k++){

                            System.out.print("      "+stockAux.get(k).valor+"      ");

                            System.out.print("      "+stockAux.get(k).stock+"      ");

                            System.out.print("      "+stockAux.get(k).variacao+"      ");
                            System.out.println(" ");

                        }
                        System.out.println("*****************StockReal-Sem Troco*****************");
                        for(int k=0;k<stockReal.size();k++){

                            System.out.print("      "+stockReal.get(k).valor+"      ");

                            System.out.print("      "+stockReal.get(k).stock+"      ");

                            System.out.print("      "+stockReal.get(k).variacao+"      ");
                            System.out.println(" ");
                        }
                //************************************************************************************************************
                 }
            }
        }
    }//GEN-LAST:event_btnOkActionPerformed

    private void lblAvisoM1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAvisoM1MouseEntered
        // Ao entrar na área desta label, alteramos a sua cor para preto***********************************
        lblFecharBi.setForeground(black);
    }//GEN-LAST:event_lblAvisoM1MouseEntered

    private void lblFecharBiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFecharBiMouseEntered
        // Ao entrar na área desta label, alteramos a sua cor para vermelho********************************
        lblFecharBi.setForeground(red);

    }//GEN-LAST:event_lblFecharBiMouseEntered

    private void lblFecharBiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFecharBiMouseClicked
        //Ao fechar o painel que contém as informações relativas ao bilhete em questão**********************
        //Esvaziamos (Limpamos as informações) do bilhete***************************************************
        esvaziaBi();
        //Atualizamos o stock real  ************************************************************************
        stockReal.clear();
        atualizaStock();
        //Impreção a fim de verificações********************************************************************
        System.out.println("*****************StockAux********************");
        for(int k=0;k<stockAux.size();k++){

            System.out.print("      "+stockAux.get(k).valor+"      ");

            System.out.print("      "+stockAux.get(k).stock+"      ");

            System.out.print("      "+stockAux.get(k).variacao+"      ");
            System.out.println(" ");
        }
        System.out.println("*****************StockReal*****************");
        for(int k=0;k<stockReal.size();k++){

            System.out.print("      "+stockReal.get(k).valor+"      ");

            System.out.print("      "+stockReal.get(k).stock+"      ");

            System.out.print("      "+stockReal.get(k).variacao+"      ");
            System.out.println(" ");
        }
        //Voltando para o primeiro módulo*********************************************************************
        lbldata7.setText("Valor por pagar :");
        lblValorPorPagar.setText("0.00");
        lblStatusPagamento.setVisible(false);
        btnVoltar.setEnabled(true);
        txtPagamento.setEnabled(false);
        txtPagamento.setText("Valor AKZ");
        btnProxEtapa.setText("Proximo");
        primeiraEntrada=0;
        btnCancelar.setEnabled(false);
        btnProxEtapa.setEnabled(false);
        lblValorIntroduzido.setText("0.00 ");
        lblValorPorPagar.setText("0.00 ");
        lblValorRequerido.setText("0.00 ");
        painelParaBi.setVisible(false);
        comboOrigem.setSelectedIndex(0);
        comboDestino.setSelectedIndex(0);
        //**************************************************************************************************
    }//GEN-LAST:event_lblFecharBiMouseClicked

    /**
     * @param args the command line arguments
     */
    //Método main(){} que carrega o form Operação***********************************************************
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
            java.util.logging.Logger.getLogger(frmOperacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmOperacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmOperacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmOperacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmOperacao().setVisible(true);
            }
        });
    }//*****************************************************************************************************

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnProxEtapa;
    private javax.swing.JButton btnVoltar;
    private static javax.swing.JComboBox<String> comboDestino;
    private static javax.swing.JComboBox<String> comboOrigem;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lblAvisoM;
    private javax.swing.JLabel lblAvisoM1;
    private javax.swing.JLabel lblAvisoM2;
    private javax.swing.JLabel lblFecharAviso;
    private javax.swing.JLabel lblFecharBi;
    private javax.swing.JLabel lblFecharOperacao1;
    private javax.swing.JLabel lblFooter;
    private javax.swing.JLabel lblMensagem;
    private javax.swing.JLabel lblMensagem1;
    private javax.swing.JLabel lblMostrarBi;
    private javax.swing.JLabel lblMsgAviso;
    public static javax.swing.JLabel lblMsgAviso1;
    private static javax.swing.JLabel lblMsgAviso2;
    private static javax.swing.JLabel lblMsgAviso3;
    private static javax.swing.JLabel lblMsgAviso4;
    private static javax.swing.JLabel lblMsgAviso7;
    public static javax.swing.JLabel lblMsgAviso8;
    public static javax.swing.JLabel lblMsgAviso9;
    private javax.swing.JLabel lblOpercao;
    private javax.swing.JLabel lblStatusPagamento;
    private static javax.swing.JLabel lblValorIntroduzido;
    private javax.swing.JLabel lblValorIntroduzido1;
    private static javax.swing.JLabel lblValorPorPagar;
    private javax.swing.JLabel lblValorPorPagar1;
    private static javax.swing.JLabel lblValorRequerido;
    private javax.swing.JLabel lblValorRequerido1;
    private javax.swing.JLabel lblb;
    private javax.swing.JLabel lblbb;
    private javax.swing.JLabel lblbbb;
    private javax.swing.JLabel lbldata;
    private javax.swing.JLabel lbldata1;
    private javax.swing.JLabel lbldata5;
    private javax.swing.JLabel lbldata6;
    private javax.swing.JLabel lbldata7;
    private javax.swing.JLabel lbllb;
    private javax.swing.JLabel lblll;
    private javax.swing.JLabel lbllllll;
    private javax.swing.JLabel lblstet;
    private static javax.swing.JScrollPane lstTroco;
    private static javax.swing.JList<String> lstTroco2;
    private javax.swing.JPanel painelAviso;
    private javax.swing.JPanel painelOperacao;
    private javax.swing.JPanel painelParaBi;
    private javax.swing.JPanel painelParaTroco;
    private javax.swing.JTextField txtPagamento;
    // End of variables declaration//GEN-END:variables
}
