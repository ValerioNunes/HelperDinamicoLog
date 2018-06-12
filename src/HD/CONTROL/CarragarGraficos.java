package HD.CONTROL;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import Log.Serialize;
import Log.log;
import Main.TELA_ANALISE;

public class CarragarGraficos extends Thread {
	JTabbedPane tabbedPane;
	
	public CarragarGraficos(JTabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;
		
	}
	
	  public void run () {
	 		Serialize ser = new Serialize();
	 		log log = ser.InputLog();
	 		
	 		if(log != null){
	 			
	 			new TELA_ANALISE(tabbedPane, log );
	 			//AnalisarLog(l);
	 			
	 		}else{
	 			JOptionPane.showMessageDialog(null, "Erro ou Importar Log!!!");
	 		}
	  }
	}