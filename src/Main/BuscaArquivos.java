package Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import Log.Evento;

public class BuscaArquivos {
	private ArrayList<Evento> Eventos = new ArrayList<Evento>();	
	
 public ArrayList<Evento> BuscarArquivo(){
	 
	 	Eventos.clear();
		JFileChooser chooser = new JFileChooser();
	    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	    int returnVal = chooser.showOpenDialog(null);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	    	
	    	LerTXT(chooser.getSelectedFile().getAbsolutePath());
	    	
	    }else{
	    	return null;
	    }
	    
	    return Eventos;
	}
 
 	void LerTXT(String local){
 		
	  File folder = new File(local);
	    for (File arquivo : folder.listFiles()) {
	        if (arquivo.isFile()) {
	        	
					if(getFileExtension(arquivo).toLowerCase().equals("txt"))
							Ler(arquivo);
	        	
	        	}
	        }
 	}
 
 	
 	
	private static String getFileExtension(File file) {
	    String name = file.getName();
	    try {
	        return name.substring(name.lastIndexOf(".") + 1);
	    } catch (Exception e) {
	        return "";
	    }
	}
	
	void Ler(File nome) {
		    try {
		    	
		      BufferedReader lerArq = new BufferedReader(new FileReader(nome));
		     
		  	  ArrayList<String> linhas = new ArrayList<String>();	
		      linhas.add(lerArq.readLine());
		      
		      while (linhas.get(linhas.size()-1) != null) {
		    	String l = lerArq.readLine();
		        linhas.add(l);
	    		if(l != null ){
	        	    if( l.length() == 157  &&  l.substring(0,1).contains("#")){
	        			Evento ev = new Evento(l);
	        			Eventos.add(ev);
	        	  }
		
		      }
	    	}
		      lerArq.close();
		     
		    } catch (IOException e) {
		    	JOptionPane.showMessageDialog(null, "Erro na abertura do arquivo: %s.\n" + e.getMessage());
		       
		    }
		
		  }
 
}
