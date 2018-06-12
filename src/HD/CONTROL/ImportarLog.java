package HD.CONTROL;

import java.util.ArrayList;

import javax.swing.JTabbedPane;

import Log.Evento;
import Log.Serialize;
import Log.log;
import Main.BuscaArquivos;


public class ImportarLog extends Thread {
	
	int loco;
	JTabbedPane tabbedPane;
	public ImportarLog (int loco, JTabbedPane tabbedPane){
		 this.loco = loco;
		 this.tabbedPane = tabbedPane;
	 }
	  public void run () {
		    BuscaArquivos   arq =  new BuscaArquivos();
		    ArrayList<Evento> ev=  arq.BuscarArquivo();
		    
		    if(ev.size() != 0){
				   
			 		log Log = new log(loco,ev);
			 		
			 		CarragarLog  cl = new CarragarLog(Log, tabbedPane);
					cl.start();	 
					
					Serialize ser =  new Serialize();
					ser.OutputLog(Log);		
			 
		    }
	  }
	}
