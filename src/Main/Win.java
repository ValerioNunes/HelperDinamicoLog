package Main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UnsupportedLookAndFeelException;

import HD.CONTROL.CarragarGraficos;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Toolkit;
import java.awt.Window.Type;

public class Win {

	private JFrame frmValerianoSystem;
	//static SQLiteJDBCDriverConnection Banco = new SQLiteJDBCDriverConnection();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Win window = new Win();
					window.frmValerianoSystem.setVisible(true);
					 try {
				            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				                if ("Windows".equals(info.getName())) {
				                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
				                    break;
				                }
				            }	           
						} catch (ClassNotFoundException e1) {
							e1.printStackTrace();
						} catch (InstantiationException e1) {
							e1.printStackTrace();
						} catch (IllegalAccessException e1) {
							e1.printStackTrace();
						} catch (UnsupportedLookAndFeelException e1) {
							e1.printStackTrace();
						}
						 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public Win() {
		initialize();
	}
    
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		 frmValerianoSystem = new JFrame();
		
		 BorderLayout borderLayout = (BorderLayout) frmValerianoSystem.getContentPane().getLayout();
		 frmValerianoSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frmValerianoSystem.setTitle("VALERIANO SYSTEM - HELPER DIN\u00C2MICO");
		 frmValerianoSystem.setBounds(10, 10, 1345, 752);
		 final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		 frmValerianoSystem.getContentPane().add(tabbedPane, BorderLayout.CENTER);	
		 frmValerianoSystem.setExtendedState(JFrame.MAXIMIZED_BOTH);
		 
		 final JMenuBar menuBar = new JMenuBar(); 
		 JMenu mnFile = new JMenu("FILE");
		 menuBar.add(mnFile);
		 
		 JMenuItem mntmOpenlogser = new JMenuItem("Abrir Log *.ser");
		 mntmOpenlogser.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		
		 		CarragarGraficos gera = new CarragarGraficos(tabbedPane);
		 		gera.start();
		 	}
		 });
		 mnFile.add(mntmOpenlogser);
		 frmValerianoSystem.setJMenuBar(menuBar);
		 

		 
		 tabbedPane.addTab("IMPORTAR LOG", null,new TELA_ARQUIVAR(tabbedPane), null);
		 

	}
}
