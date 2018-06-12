package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import HD.CONTROL.CarragarGraficos;
import HD.CONTROL.ImportarLog;


public class TELA_ARQUIVAR extends JPanel {
	
	
	
	public TELA_ARQUIVAR(final JTabbedPane tabbedPane){
		
		 JPanel ArquivarLog = this;
		 ArquivarLog.setBackground(Color.DARK_GRAY);
		 tabbedPane.addTab("Arquivar Log", null, ArquivarLog, null);
		 ArquivarLog.setLayout(null);
		 JPanel panel = new JPanel();
		 panel.setBounds(349, 105, 681, 60);
		 panel.setBackground(Color.WHITE);
		 ArquivarLog.add(panel);
		 panel.setLayout(null);
		 
		 JLabel lblOrigemDoLog = new JLabel("LOCOMOTIVA:");
		 lblOrigemDoLog.setBounds(29, 14, 199, 26);
		 panel.add(lblOrigemDoLog);
		 lblOrigemDoLog.setFont(new Font("Arial Black", Font.PLAIN, 21));
		 
		 final JComboBox ImportLoco = new JComboBox();
		 ImportLoco.setBounds(249, 12, 116, 34);
		 panel.add(ImportLoco);
		 ImportLoco.setFont(new Font("Arial Black", Font.PLAIN, 16));
		 
		 JButton btnNewButton = new JButton("Buscar Arquivos .TXT");
		 btnNewButton.setBounds(401, 11, 270, 37);
		 panel.add(btnNewButton);
		 btnNewButton.setFont(new Font("Arial", Font.PLAIN, 19));
		 btnNewButton.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		
		 	 	ImportarLog inLog = new ImportarLog((Integer) ImportLoco.getSelectedItem(),tabbedPane);
		 		inLog.start();
		 		
		 	}
		 });
		  
		CarragarLocomotiva(ImportLoco); 
		
		JLabel label = new JLabel("");
		label.setBackground(Color.DARK_GRAY);
		label.setIcon(new ImageIcon(TELA_ARQUIVAR.class.getResource("/IMG/NOVA LOGO(SEM FUNDO).png")));
		label.setBounds(436, 255, 519, 350);
		ArquivarLog.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(349, 176, 681, 67);
		ArquivarLog.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("BUSCAR  *.SER");
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 19));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CarragarGraficos gera = new CarragarGraficos(tabbedPane);
		 		gera.start();
			}
		});
		btnNewButton_1.setBounds(402, 11, 269, 44);
		panel_1.add(btnNewButton_1);
		
		JLabel lblArquivoUnificado = new JLabel("BUSCA LOG UNIFICADO:");
		lblArquivoUnificado.setFont(new Font("Arial Black", Font.PLAIN, 21));
		lblArquivoUnificado.setBounds(30, 18, 305, 26);
		panel_1.add(lblArquivoUnificado);
	}
	
	int[] locoHD = {813,814,818,823,824,829,832,857,9012,9014,9020};
	
	private void CarragarLocomotiva(JComboBox exCombloco2) {
			// TODO Auto-generated method stub
		for(int LHD : locoHD )
			exCombloco2.addItem(LHD);
	}
}
