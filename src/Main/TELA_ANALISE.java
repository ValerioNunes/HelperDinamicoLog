package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Log.Evento;
import Log.GrafVelocDist;
import Log.Periodo;
import Log.log;
import Tabela.Tab;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JLocaleChooser;

import HD.RegrasNegocio.Func;

import javax.swing.JComboBox;


public class TELA_ANALISE extends JPanel {

    Func func = new Func();
	JTabbedPane tabbedPane_2;
	log Log = null;
	private JTable table;
	
	
    public TELA_ANALISE(JTabbedPane tabbedPane_2, Log.log log) {
		super();
		this.tabbedPane_2 = tabbedPane_2;
		Log = log;
		
		AnalisarLog();
		
	}

	private final void AnalisarLog(){
	
	  final JPanel panel_1 = this;	  

	  panel_1.setBackground(Color.DARK_GRAY);
	 
	  tabbedPane_2.addTab("Analisar Loco: " + Log.getLocomotiva()+" - "+ Log.getData().substring(0,11), null, panel_1, null);
	  panel_1.setLayout(null);
	  setLayout(null);
	 
	  JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
	  tabbedPane_1.setBounds(10, 231, 1334, 347);
	  panel_1.add(tabbedPane_1);	
	  
	  final Periodo periodo = new Periodo(Log.time);
	 
	  GrafVelocDist Graficos = new GrafVelocDist (Log, periodo.linha,periodo.periodo);
	  final int num = Log.getEventos().size()-1;
	
	  
	  JPanel panel_2 = new JPanel();
	  panel_2.setBackground(Color.DARK_GRAY);
	  tabbedPane_1.addTab("Velocidades e Dist\u00E2ncias", null, panel_2, null);
	  panel_2.setLayout(null);
	  
	  JPanel Velocidades = new JPanel();
	  Velocidades.setBounds(10, 10, 651, 279);
	  panel_2.add(Velocidades);
	  
	 
	  
	  Velocidades.add(Graficos.Velocidades());
	  Velocidades.setLayout(new MigLayout("", "[]", "[]"));
	  
	  JPanel Distancias = new JPanel();
	  Distancias.setBounds(671, 10, 633, 279);
	  panel_2.add(Distancias);
	  
	    Distancias.add(Graficos.Distancias());
	  Distancias.setLayout(null);
	  Distancias.setLayout(new MigLayout("", "[]", "[]"));
	  
	  JPanel panel_4 = new JPanel();
	  panel_4.setBackground(Color.DARK_GRAY);
	  tabbedPane_1.addTab("Velocidades Relativas e Press\u00F5es", null, panel_4, null);
	  panel_4.setLayout(null);
	  
	  JPanel vel_relativa = new JPanel();
	  vel_relativa.setBounds(10, 11, 613, 297);
	  panel_4.add(vel_relativa);
	  vel_relativa.add(Graficos.VelocidadesRelativas());
	  vel_relativa.setLayout(new MigLayout("", "[]", "[]"));
	  
	  JPanel panel_7 = new JPanel();
	  panel_7.setBounds(667, 11, 613, 297);
	  panel_4.add(panel_7);
	  panel_7.add(Graficos.Pressao());
	  panel_7.setLayout(new MigLayout("", "[]", "[]"));
	
	 final Tab tab = new Tab();
	 tabbedPane_1.addTab("Tabela", null, tab, null);
	 
	
	 //tabbedPane_1.setEnabledAt(2, false);
	  
	/*  JPanel GPS = new JPanel();
	  tabbedPane_1.addTab("GPS", null, GPS, null);
	  GPS.setLayout(null);
	  
	  JPanel gpsPanel = new JPanel();
	  gpsPanel.setBounds(10, 11, 494, 297);
	  GPS.add(gpsPanel);*/
	  
	  JPanel panel = new JPanel();
	  panel.setBackground(Color.GRAY);
	  panel.setBounds(10, 11, 1334, 222);
	  panel_1.add(panel);
	  panel.setLayout(null);
	  
	  JLabel lblTempo = new JLabel("DATA E HORA:");
	  lblTempo.setBackground(Color.WHITE);
	  lblTempo.setForeground(Color.WHITE);
	  lblTempo.setBounds(10, 5, 103, 36);
	  panel.add(lblTempo);
	  lblTempo.setFont(new Font("Arial Black", Font.PLAIN, 12));
	  
	  final JTextArea txtrTempo = new JTextArea();
	  txtrTempo.setWrapStyleWord(true);
	  txtrTempo.setEditable(false);
	  txtrTempo.setBounds(117, 5, 212, 36);
	  panel.add(txtrTempo);
	  txtrTempo.setFont(new Font("Gisha", Font.BOLD, 17));
	  
	  JLabel lblIndicaoMaqu = new JLabel("INDICA\u00C7\u00C3O MAQUINISTA:");
	  lblIndicaoMaqu.setBackground(Color.WHITE);
	  lblIndicaoMaqu.setForeground(Color.WHITE);
	  lblIndicaoMaqu.setBounds(10, 57, 186, 17);
	  panel.add(lblIndicaoMaqu);
	  lblIndicaoMaqu.setFont(new Font("Arial Black", Font.PLAIN, 12));
	  
	  final JTextArea textArea = new JTextArea();
	  textArea.setEditable(false);
	  textArea.setForeground(Color.RED);
	  textArea.setBounds(191, 46, 138, 30);
	  panel.add(textArea);
	  textArea.setFont(new Font("Arial Black", Font.PLAIN, 20));
	  
	  JLabel lblPressaoCilindroPrincipal = new JLabel("P. C. PRINC.:");
	  lblPressaoCilindroPrincipal.setBackground(Color.WHITE);
	  lblPressaoCilindroPrincipal.setForeground(Color.WHITE);
	  lblPressaoCilindroPrincipal.setFont(new Font("Arial Black", Font.PLAIN, 12));
	  lblPressaoCilindroPrincipal.setBounds(10, 87, 103, 26);
	  panel.add(lblPressaoCilindroPrincipal);
	  
	  final JTextArea PCP = new JTextArea();
	  PCP.setEditable(false);
	  PCP.setFont(new Font("Arial", Font.PLAIN, 16));
	  PCP.setBounds(99, 85, 65, 30);
	  panel.add(PCP);
	  
	  JLabel lblPontoDeAcelerao = new JLabel("PONTO DE ACELERA\u00C7\u00C3O:");
	  lblPontoDeAcelerao.setBackground(Color.WHITE);
	  lblPontoDeAcelerao.setForeground(Color.WHITE);
	  lblPontoDeAcelerao.setFont(new Font("Arial Black", Font.PLAIN, 12));
	  lblPontoDeAcelerao.setBounds(10, 125, 212, 17);
	  panel.add(lblPontoDeAcelerao);
	  
	  final JTextArea PDA = new JTextArea();
	  PDA.setEditable(false);
	  PDA.setFont(new Font("Arial", Font.BOLD, 19));
	  PDA.setBounds(241, 121, 88, 30);
	  panel.add(PDA);
	  
	  final JTextArea CORTE_TRACAO = new JTextArea();
	  CORTE_TRACAO.setForeground(Color.LIGHT_GRAY);
	  CORTE_TRACAO.setEditable(false);
	  CORTE_TRACAO.setFont(new Font("Arial", Font.BOLD, 16));
	  CORTE_TRACAO.setBounds(454, 11, 94, 30);
	  panel.add(CORTE_TRACAO);
	  
	  JLabel lblCorteTracao = new JLabel("CORTE TRACAO:");
	  lblCorteTracao.setBackground(Color.WHITE);
	  lblCorteTracao.setForeground(Color.WHITE);
	  lblCorteTracao.setFont(new Font("Arial Black", Font.PLAIN, 12));
	  lblCorteTracao.setBounds(339, 15, 131, 17);
	  panel.add(lblCorteTracao);
	  
	  final JTextArea EMERGENCIA = new JTextArea();
	  EMERGENCIA.setForeground(Color.LIGHT_GRAY);
	  EMERGENCIA.setEditable(false);
	  EMERGENCIA.setFont(new Font("Arial", Font.BOLD, 16));
	  EMERGENCIA.setBounds(454, 46, 94, 30);
	  panel.add(EMERGENCIA);
	  
	  JLabel lblEmergencia = new JLabel("EMERGENCIA:");
	  lblEmergencia.setBackground(Color.WHITE);
	  lblEmergencia.setForeground(Color.WHITE);
	  lblEmergencia.setFont(new Font("Arial Black", Font.PLAIN, 12));
	  lblEmergencia.setBounds(339, 50, 122, 17);
	  panel.add(lblEmergencia);
	  
	  final JTextArea PINO_ENGATE = new JTextArea();
	  PINO_ENGATE.setForeground(Color.LIGHT_GRAY);
	  PINO_ENGATE.setEditable(false);
	  PINO_ENGATE.setFont(new Font("Arial", Font.PLAIN, 15));
	  PINO_ENGATE.setBounds(454, 83, 94, 30);
	  panel.add(PINO_ENGATE);
	  
	  JLabel lblTeclaLipPino = new JLabel("PINO ENGATE:");
	  lblTeclaLipPino.setBackground(Color.WHITE);
	  lblTeclaLipPino.setForeground(Color.WHITE);
	  lblTeclaLipPino.setFont(new Font("Arial Black", Font.PLAIN, 12));
	  lblTeclaLipPino.setBounds(339, 87, 131, 17);
	  panel.add(lblTeclaLipPino);
	  
	  final JTextArea textArea_4 = new JTextArea();
	  textArea_4.setEditable(false);
	  textArea_4.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 15));
	  textArea_4.setBounds(1167, 5, 84, 30);
	  panel.add(textArea_4);
	  
	  JLabel lblPosioHelperGps = new JLabel("POSI\u00C7\u00C3O HELPER:");
	  lblPosioHelperGps.setBackground(Color.WHITE);
	  lblPosioHelperGps.setForeground(Color.WHITE);
	  lblPosioHelperGps.setFont(new Font("Arial Black", Font.PLAIN, 11));
	  lblPosioHelperGps.setBounds(1032, 9, 138, 17);
	  panel.add(lblPosioHelperGps);
	  
	  JPanel panel_3 = new JPanel();
	  panel_3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
	  panel_3.setBounds(558, 5, 228, 137);
	  panel.add(panel_3);
	  panel_3.setLayout(null);
	  
	  JLabel lblEot = new JLabel("EOT");
	  lblEot.setFont(new Font("Arial Black", Font.PLAIN, 21));
	  lblEot.setBounds(10, 9, 64, 25);
	  panel_3.add(lblEot);
	  
	  JLabel lblId = new JLabel("ID :");
	  lblId.setFont(new Font("Arial", Font.PLAIN, 18));
	  lblId.setBounds(108, 14, 34, 20);
	  panel_3.add(lblId);
	  
	  final JTextField ID_EOT = new JTextField();
	  ID_EOT.setEditable(false);
	  ID_EOT.setFont(new Font("Arial", Font.PLAIN, 14));
	  ID_EOT.setBounds(150, 14, 64, 23);
	  panel_3.add(ID_EOT);
	  ID_EOT.setColumns(10);
	  
	  JLabel lblBatEot = new JLabel("BATERIA :");
	  lblBatEot.setFont(new Font("Arial", Font.PLAIN, 18));
	  lblBatEot.setBounds(10, 41, 88, 20);
	  panel_3.add(lblBatEot);
	  
	  final JTextField BAT_EOT = new JTextField();
	  BAT_EOT.setEditable(false);
	  BAT_EOT.setFont(new Font("Arial", Font.PLAIN, 14));
	  BAT_EOT.setColumns(10);
	  BAT_EOT.setBounds(150, 42, 64, 23);
	  panel_3.add(BAT_EOT);
	  
	  JLabel lblPressoEgEot = new JLabel("PRESS\u00C3O  EG :");
	  lblPressoEgEot.setFont(new Font("Arial", Font.PLAIN, 18));
	  lblPressoEgEot.setBounds(10, 76, 132, 20);
	  panel_3.add(lblPressoEgEot);
	  
	  final JTextField PRESSAO_EG = new JTextField();
	  PRESSAO_EG.setEditable(false);
	  PRESSAO_EG.setFont(new Font("Arial", Font.PLAIN, 14));
	  PRESSAO_EG.setColumns(10);
	  PRESSAO_EG.setBounds(150, 72, 64, 23);
	  panel_3.add(PRESSAO_EG);
	  
	  JLabel lblGps = new JLabel("GPS EOT :");
	  lblGps.setFont(new Font("Arial", Font.PLAIN, 18));
	  lblGps.setBounds(10, 107, 100, 20);
	  panel_3.add(lblGps);
	  
	  final JTextArea GPS_EOT = new JTextArea();
	  GPS_EOT.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 15));
	  GPS_EOT.setEditable(false);
	  GPS_EOT.setBounds(120, 101, 94, 30);
	  panel_3.add(GPS_EOT);
	  
	  JButton btnFechar = new JButton("Fechar");
	  btnFechar.setBounds(1259, 5, 65, 23);
	  panel.add(btnFechar);
	  
	  final JTextArea VEL_HELPER = new JTextArea();
	  VEL_HELPER.setForeground(Color.BLACK);
	  VEL_HELPER.setFont(new Font("Arial Black", Font.BOLD, 15));
	  VEL_HELPER.setEditable(false);
	  VEL_HELPER.setBounds(928, 5, 94, 30);
	  panel.add(VEL_HELPER);
	  
	  JLabel lblVelocHelper = new JLabel("VELOC. HELPER:");
	  lblVelocHelper.setForeground(Color.WHITE);
	  lblVelocHelper.setFont(new Font("Arial Black", Font.PLAIN, 12));
	  lblVelocHelper.setBackground(Color.WHITE);
	  lblVelocHelper.setBounds(796, 15, 122, 17);
	  panel.add(lblVelocHelper);
	  
	  final JTextArea DIST_LD = new JTextArea();
	  DIST_LD.setForeground(Color.BLACK);
	  DIST_LD.setFont(new Font("Arial Black", Font.BOLD, 16));
	  DIST_LD.setEditable(false);
	  DIST_LD.setBounds(928, 83, 94, 30);
	  panel.add(DIST_LD);
	  
	  JLabel lblDistLDir = new JLabel("DIST. LASER DIR.:");
	  lblDistLDir.setForeground(Color.WHITE);
	  lblDistLDir.setFont(new Font("Arial Black", Font.PLAIN, 12));
	  lblDistLDir.setBackground(Color.WHITE);
	  lblDistLDir.setBounds(796, 87, 122, 17);
	  panel.add(lblDistLDir);
	  
	  final JTextArea DIST_LE = new JTextArea();
	  DIST_LE.setForeground(Color.BLACK);
	  DIST_LE.setFont(new Font("Arial Black", Font.BOLD, 16));
	  DIST_LE.setEditable(false);
	  DIST_LE.setBounds(928, 121, 94, 30);
	  panel.add(DIST_LE);
	  
	  JLabel lblVelocTrem = new JLabel("VELOC. TREM:");
	  lblVelocTrem.setForeground(Color.WHITE);
	  lblVelocTrem.setFont(new Font("Arial Black", Font.PLAIN, 12));
	  lblVelocTrem.setBackground(Color.WHITE);
	  lblVelocTrem.setBounds(796, 46, 122, 17);
	  panel.add(lblVelocTrem);
	  
	  JLabel lblDistLaserEsq = new JLabel("DIST. LASER ESQ.:");
	  lblDistLaserEsq.setForeground(Color.WHITE);
	  lblDistLaserEsq.setFont(new Font("Arial Black", Font.PLAIN, 12));
	  lblDistLaserEsq.setBackground(Color.WHITE);
	  lblDistLaserEsq.setBounds(796, 127, 131, 17);
	  panel.add(lblDistLaserEsq);
	  
	  final JTextArea VELOC_EOT = new JTextArea();
	  VELOC_EOT.setForeground(Color.BLACK);
	  VELOC_EOT.setFont(new Font("Arial Black", Font.BOLD, 16));
	  VELOC_EOT.setEditable(false);
	  VELOC_EOT.setBounds(928, 43, 94, 30);
	  panel.add(VELOC_EOT);
	  
	  final JTextArea POS_TREM = new JTextArea();
	  POS_TREM.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 15));
	  POS_TREM.setEditable(false);
	  POS_TREM.setBounds(1167, 44, 84, 30);
	  panel.add(POS_TREM);
	  
	  JLabel lblPosioTrem = new JLabel("POSI\u00C7\u00C3O TREM:");
	  lblPosioTrem.setForeground(Color.WHITE);
	  lblPosioTrem.setFont(new Font("Arial Black", Font.PLAIN, 11));
	  lblPosioTrem.setBackground(Color.WHITE);
	  lblPosioTrem.setBounds(1032, 48, 138, 17);
	  panel.add(lblPosioTrem);
	  
	  final JTextArea GPS_HELPER = new JTextArea();
	  GPS_HELPER.setForeground(Color.LIGHT_GRAY);
	  GPS_HELPER.setFont(new Font("Arial", Font.BOLD, 16));
	  GPS_HELPER.setEditable(false);
	  GPS_HELPER.setBounds(454, 121, 94, 30);
	  panel.add(GPS_HELPER);
	  
	  JLabel lblGpsHelper = new JLabel("GPS HELPER:");
	  lblGpsHelper.setForeground(Color.WHITE);
	  lblGpsHelper.setFont(new Font("Arial Black", Font.PLAIN, 12));
	  lblGpsHelper.setBackground(Color.WHITE);
	  lblGpsHelper.setBounds(339, 125, 122, 17);
	  panel.add(lblGpsHelper);
	  
	  final JTextArea VEL_REL_GPS = new JTextArea();
	  VEL_REL_GPS.setFont(new Font("Dialog", Font.BOLD, 20));
	  VEL_REL_GPS.setEditable(false);
	  VEL_REL_GPS.setBounds(1167, 82, 84, 30);
	  panel.add(VEL_REL_GPS);
	  
	  final JTextArea DIST_REL_GPS = new JTextArea();
	  DIST_REL_GPS.setFont(new Font("Dialog", Font.BOLD, 20));
	  DIST_REL_GPS.setEditable(false);
	  DIST_REL_GPS.setBounds(1167, 120, 84, 30);
	  panel.add(DIST_REL_GPS);
	  
	  JLabel lblVrelativaTrem = new JLabel("DIST.RELATIVA GPS:");
	  lblVrelativaTrem.setForeground(Color.WHITE);
	  lblVrelativaTrem.setFont(new Font("Arial Black", Font.PLAIN, 11));
	  lblVrelativaTrem.setBackground(Color.WHITE);
	  lblVrelativaTrem.setBounds(1032, 130, 138, 17);
	  panel.add(lblVrelativaTrem);
	  
	  JLabel lblVelrelativaHelper = new JLabel("V.RELATIVA GPS:");
	  lblVelrelativaHelper.setForeground(Color.WHITE);
	  lblVelrelativaHelper.setFont(new Font("Arial Black", Font.PLAIN, 11));
	  lblVelrelativaHelper.setBackground(Color.WHITE);
	  lblVelrelativaHelper.setBounds(1032, 91, 138, 17);
	  panel.add(lblVelrelativaHelper);
	  
	  JPanel panel_6 = new JPanel();
	  panel_6.setBackground(Color.ORANGE);
	  panel_6.setBounds(10, 164, 394, 34);
	  panel.add(panel_6);
	  panel_6.setLayout(null);
	  
	  JLabel lblBuscarDia = new JLabel("IR DATA : ");
	  lblBuscarDia.setBounds(16, 7, 66, 18);
	  panel_6.add(lblBuscarDia);
	  lblBuscarDia.setForeground(Color.BLACK);
	  lblBuscarDia.setFont(new Font("Arial Black", Font.PLAIN, 12));
	  lblBuscarDia.setBackground(Color.WHITE);
	  
	  JPanel panel_5 = new JPanel();
	  panel_5.setBackground(Color.ORANGE);
	  panel_5.setBounds(10, 589, 1334, 68);
	  add(panel_5);
	  panel_5.setLayout(null);
	  
	  
	  final JSlider slider = new JSlider();
	  slider.setBounds(266, 29, 1058, 31);
	  panel_5.add(slider);
	  slider.setPaintTicks(true);
	  
	  slider.setBackground(Color.LIGHT_GRAY);
	  slider.setMinimum(0);
	  slider.setMaximum(num);
	  slider.setValue(num);
	  
	  final JSlider slider_1 = new JSlider();
	  slider_1.setBounds(10, 29, 251, 31);
	  panel_5.add(slider_1);
	  slider_1.setPaintTicks(true);
	  slider_1.setSnapToTicks(true);
	  slider_1.setMaximum(5);
	  slider_1.setMinimum(1);
	  slider_1.setValue(2);
	  
	  slider_1.addChangeListener(new ChangeListener() {
	  	public void stateChanged(ChangeEvent arg0) {
	  		periodo.setTemp(slider_1.getValue());
	  		periodo.LinhadoTempo( Log.getEventos().get(slider.getValue()).getTime());
	  	}
	  });
	  slider_1.setBackground(Color.LIGHT_GRAY);
	  slider_1.setForeground(Color.GRAY);
	  
	  JLabel lblPerodo = new JLabel("PER\u00CDODO: ");
	  lblPerodo.setBounds(10, 11, 122, 17);
	  panel_5.add(lblPerodo);
	  lblPerodo.setForeground(Color.BLACK);
	  lblPerodo.setFont(new Font("Arial Black", Font.PLAIN, 12));
	  lblPerodo.setBackground(Color.WHITE);
	  
	  JLabel lblLinhaDoTempo = new JLabel("LINHA DO TEMPO: ");
	  lblLinhaDoTempo.setBounds(275, 11, 136, 17);
	  panel_5.add(lblLinhaDoTempo);
	  lblLinhaDoTempo.setForeground(Color.BLACK);
	  lblLinhaDoTempo.setFont(new Font("Arial Black", Font.PLAIN, 12));
	  lblLinhaDoTempo.setBackground(Color.WHITE);
	  
	  final JTextArea VEL_REL_LIMITE = new JTextArea();
	  VEL_REL_LIMITE.setFont(new Font("Dialog", Font.BOLD, 20));
	  VEL_REL_LIMITE.setEditable(false);
	  VEL_REL_LIMITE.setBounds(1167, 161, 84, 30);
	  panel.add(VEL_REL_LIMITE);
	  
	  JLabel lblVrelativaLimite = new JLabel("V.RELATIVA LIMITE:");
	  lblVrelativaLimite.setForeground(Color.WHITE);
	  lblVrelativaLimite.setFont(new Font("Arial Black", Font.PLAIN, 11));
	  lblVrelativaLimite.setBackground(Color.WHITE);
	  lblVrelativaLimite.setBounds(1032, 170, 138, 17);
	  panel.add(lblVrelativaLimite);
	  
	  JLabel lblVrelativaLd = new JLabel("V.RELATIVA LD:");
	  lblVrelativaLd.setForeground(Color.WHITE);
	  lblVrelativaLd.setFont(new Font("Arial Black", Font.PLAIN, 11));
	  lblVrelativaLd.setBackground(Color.WHITE);
	  lblVrelativaLd.setBounds(414, 162, 113, 17);
	  panel.add(lblVrelativaLd);
	  
	  final JTextArea V_RELATIVA_LD = new JTextArea();
	  V_RELATIVA_LD.setFont(new Font("Dialog", Font.BOLD, 12));
	  V_RELATIVA_LD.setEditable(false);
	  V_RELATIVA_LD.setBounds(515, 162, 33, 17);
	  panel.add(V_RELATIVA_LD);
	  
	  JLabel lblVrelativaLe = new JLabel("V.RELATIVA LE:");
	  lblVrelativaLe.setForeground(Color.WHITE);
	  lblVrelativaLe.setFont(new Font("Arial Black", Font.PLAIN, 11));
	  lblVrelativaLe.setBackground(Color.WHITE);
	  lblVrelativaLe.setBounds(414, 181, 113, 17);
	  panel.add(lblVrelativaLe);
	  
	  final JTextArea V_RELATIVA_LE = new JTextArea();
	  V_RELATIVA_LE.setFont(new Font("Dialog", Font.BOLD, 12));
	  V_RELATIVA_LE.setEditable(false);
	  V_RELATIVA_LE.setBounds(515, 181, 33, 17);
	  panel.add(V_RELATIVA_LE);
	  
	  
	  final JTextArea Alarmes = new JTextArea();
	  Alarmes.setFont(new Font("Arial Black", Font.BOLD, 15));
	  Alarmes.setForeground(Color.RED);
	  Alarmes.setBounds(634, 155, 388, 67);
	  panel.add(Alarmes);
	  
	  
	  final JTextArea PF = new JTextArea();
	  PF.setFont(new Font("Arial", Font.PLAIN, 16));
	  PF.setEditable(false);
	  PF.setBounds(253, 83, 76, 30);
	  panel.add(PF);
	  
	  JLabel lblPFreio = new JLabel("P. FREIO:");
	  lblPFreio.setForeground(Color.WHITE);
	  lblPFreio.setFont(new Font("Arial Black", Font.PLAIN, 12));
	  lblPFreio.setBackground(Color.WHITE);
	  lblPFreio.setBounds(174, 85, 72, 26);
	  panel.add(lblPFreio);
	  
	  final JTextArea SIRENE = new JTextArea();
	  SIRENE.setForeground(Color.LIGHT_GRAY);
	  SIRENE.setFont(new Font("Arial", Font.BOLD, 10));
	  SIRENE.setEditable(false);
	  SIRENE.setBounds(1082, 198, 41, 19);
	  panel.add(SIRENE);
	  
	  JLabel lblSirene = new JLabel("Sirene");
	  lblSirene.setForeground(Color.WHITE);
	  lblSirene.setFont(new Font("Arial Black", Font.PLAIN, 12));
	  lblSirene.setBackground(Color.WHITE);
	  lblSirene.setBounds(1032, 196, 57, 17);
	  panel.add(lblSirene);
	  
	   slider.addChangeListener(new ChangeListener() {
	  	  	public void stateChanged(ChangeEvent arg0) {
	  	  		
	  	  		Evento ev = Log.getEventos().get(slider.getValue());
	  	  		
	  	  		periodo.LinhadoTempo(ev.getTime());
	  	  		txtrTempo.setText(ev.getTime().toLocaleString());
	  	  		textArea.setText(ev.getINDICAÇÃO_MAQUINISTA());
	  	  		PCP.setText(String.valueOf(ev.getPRESSAO_CILINDRO_PRINCIPAL())+" PSI");
	  	  		PDA.setText(ev.getPONTO_DE_ACELERAÇÃO());
	  	  		
	  	  	    /*
	  	  	      textArea_4.setText(String.valueOf(617000 - ev.getPOSIÇÃOHELPER_GPS()));
	  	  		  POS_TREM.setText(String.valueOf((617000  - ev.getPOSIÇÃO_EOT_GPS())));
	  	  		*/
	  	  		
	  	  		textArea_4.setText(func.posicaoHelper_KM(ev));
	  	  		POS_TREM.setText(func.posicaoTrem_KM(ev));
	  	  		
	  	  	    V_RELATIVA_LD.setText(String.valueOf(ev.getVEL_RELAT_LD()));
	  	  	    V_RELATIVA_LE.setText(String.valueOf(ev.getVEL_RELAT_LE()));
	  	  	    
	  	  		ID_EOT.setText(String.valueOf(ev.getID_EOT()));
	  	  		BAT_EOT.setText(String.valueOf(ev.getBAT_EOT() +" %"));
	  	  		PRESSAO_EG.setText(String.valueOf(ev.getPRESSÃO_EG_EOT())+" PSI");
	  	  		VELOC_EOT.setText(String.valueOf(ev.getVELOC_REAL_GPS_EOT()) +" km/h");
	  	  		
	  	  		DIST_LD.setText(String.valueOf(ev.getDIST_RELAT_LD() +" m"));
	  	  		DIST_LE.setText(String.valueOf(ev.getDIST_RELAT_LE()+" m"));
	  	  		VEL_HELPER.setText(String.valueOf(ev.getVELOCREALGPSHELPER()+ " km/h"));
	  	  		PF.setText(String.valueOf(ev.getPRESSAOFREIO() + " PSI"));
	  	  	
	  	  		func.Vel_Rel_Limite(VEL_REL_LIMITE, ev);
	  	  		func.Binario(EMERGENCIA, ev.getEMERGENCIA());
	  	  		func.Binario(CORTE_TRACAO,ev.getCORTE_TRACAO());
	  	  		func.Binario(GPS_EOT,ev.getESTADO_GPS_EOT());
	  	  		func.Binario(GPS_HELPER,ev.getESTADO_GPS_HELPER());
	  	  		func.PinoEngate(PINO_ENGATE,ev.getCILINDRO_PINO_ENGATE());
	  	  		func.Binario(SIRENE,ev.getSIRENE());
	  	  		func.RelativosVelocidade(VEL_REL_GPS, ev);
	  	  		func.RelativosDistancia(DIST_REL_GPS, ev);

	  	  	    tab.setTextAllInfos(ev.toString().replace(",","\n"));
	  	  	    
	  	  	    Alarmes.setText("A1>"+func.getAlarme1().get(ev.getALARME1()) + "\nA2>"+ func.getAlarme2().get(ev.getALARME2()) +  "\nA3>" + func.getAlarme3().get(ev.getALARME3()));
	  	  	
	  	  	}
	  	  });  
	    
		  btnFechar.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent arg0) {
		  		tabbedPane_2.remove(panel_1);
		  	}
		  });
	  
		  JLabel lblHora = new JLabel("Hora:");
		  lblHora.setForeground(Color.BLACK);
		  lblHora.setFont(new Font("Arial Black", Font.PLAIN, 12));
		  lblHora.setBackground(Color.WHITE);
		  lblHora.setBounds(192, 7, 58, 18);
		  panel_6.add(lblHora);  
		  
		  final JComboBox HORA = new JComboBox();
		  HORA.setBounds(231, 7, 45, 20);
		  panel_6.add(HORA);

		  for(int i = 0 ; i < 24 ; i++) {
			  if(i >= 10)
				  HORA.addItem(String.valueOf(i));
			  else
				  HORA.addItem("0"+i);
		  }


		  
		  final JDateChooser dateChooser = new JDateChooser();
		  dateChooser.setBounds(87, 6, 95, 20);
		  dateChooser.setMinSelectableDate(Log.getEventos().get(0).getTime());
		  dateChooser.setMaxSelectableDate(Log.getEventos().get(num).getTime());
		  dateChooser.setDate(Log.time);
		  panel_6.add(dateChooser);
		  
		  
		  JButton btnBuscar = new JButton("BUSCAR");
		  btnBuscar.setBounds(311, 6, 73, 23);
		  btnBuscar.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent arg0) {
		    
		        ArrayList<Evento> dados = Log.getEventos();
		        String tempo;     
		        String tempoPesq = dateChooser.getDate().toLocaleString().split(" ")[0]+" "+HORA.getSelectedItem();
		        boolean Flag = true;
		        
		        for(int i = 0; i < num ; i++) {
		        	tempo = dados.get(i).getTime().toLocaleString();
			  		if(tempo.contains(tempoPesq)) {
			  		   	slider.setValue(i);
			  		   	Flag = false;
			  		   	break;
			  		}
		        }
		  		   
		        if(Flag)
		          JOptionPane.showMessageDialog(null, "Hora não Encontrado");
		  	
		  	}
		  });
		  panel_6.add(btnBuscar);
		  
		  JLabel lblH = new JLabel("h");
		  lblH.setForeground(Color.BLACK);
		  lblH.setFont(new Font("Arial Black", Font.ITALIC, 15));
		  lblH.setBackground(Color.WHITE);
		  lblH.setBounds(279, 10, 28, 13);
		  panel_6.add(lblH);
		  
		  JLabel lblAlarmes = new JLabel("ALARMES:");
		  lblAlarmes.setForeground(Color.WHITE);
		  lblAlarmes.setFont(new Font("Arial Black", Font.PLAIN, 13));
		  lblAlarmes.setBackground(Color.WHITE);
		  lblAlarmes.setBounds(558, 181, 103, 17);
		  panel.add(lblAlarmes);
		  
		

		  this.tabbedPane_2.setSelectedComponent(this);
		  repaint();
		  panel_6.repaint();
		  repaint();
	 	}
}
