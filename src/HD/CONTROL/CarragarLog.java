package HD.CONTROL;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import Log.log;
import Main.TELA_ANALISE;

public class CarragarLog extends Thread {
	 log Log;
	 JTabbedPane tabbedPane;
	 public CarragarLog (log l, JTabbedPane tabbedPane){
		 this.Log = l;
		 this.tabbedPane = tabbedPane;
	 }
		
		
	  public void run () {
		
	 		if(Log != null){

	 			new TELA_ANALISE(tabbedPane,Log);
	 			
	 		}else{
	 			JOptionPane.showMessageDialog(null, "Erro ou Importar Log!!!");
	 		}
	  }
	}
