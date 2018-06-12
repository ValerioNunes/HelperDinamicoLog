package Tabela;

import java.awt.LayoutManager;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.ScrollPaneConstants;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.SpringLayout;
import javax.swing.JTextArea;
import java.awt.Font;

public class Tab extends JPanel {
	String[] Coluna = 	new String[] {
	  		"CILINDRO_RETORNO_E", "CILINDRO_AVANCO_E", "CILINDRO_TELEMETRO", "CHAVE_INTERLOCK", "TECLA_TELA", "TECLA_BZRESET", "TECLA_LIP_PINO_ENGATE",
            "TECLA_OP_ALINHAR","A","B","C","D","E","CILINDRO_PINO_ENGATE","CILINDRO_RETORNO_D","CILINDRO_AVANCO_D","SIRENE","VALVULA_TELEMETRO",
            "VALVULA_RETORNO_ALINHAMENTO","VALVULA_AVANÇO_ALINHAMENTO","VALVULA_PINO_ENGATE"
	  		};
	JTextArea AllInfos;
	
	public Tab() {
		super();
		  setLayout(null);
		  
		  JPanel panel = new JPanel();
		  panel.setBounds(10, 5, 1317, 400);
		  add(panel);
		  SpringLayout sl_panel = new SpringLayout();
		  panel.setLayout(sl_panel);
		
		// TODO Auto-generated constructor stub
		  JScrollPane scrollPane = new JScrollPane();
		  sl_panel.putConstraint(SpringLayout.NORTH, scrollPane, 5, SpringLayout.NORTH, panel);
		  sl_panel.putConstraint(SpringLayout.WEST, scrollPane, 0, SpringLayout.WEST, panel);
		  sl_panel.putConstraint(SpringLayout.SOUTH, scrollPane, -98, SpringLayout.SOUTH, panel);
		  sl_panel.putConstraint(SpringLayout.EAST, scrollPane, 1311, SpringLayout.WEST, panel);
		  panel.add(scrollPane);
		  scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		  scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		  
		  AllInfos = new JTextArea();
		  AllInfos.setLineWrap(true);
		  AllInfos.setFont(new Font("Arial", Font.PLAIN, 15));
		  scrollPane.setViewportView(AllInfos);
		
		  
	}

	public void setTextAllInfos(String txt){
		AllInfos.setText(txt);
	}
	
	

	
	
	
	
}
