package Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import Diretorio.Pastas;

public class Serialize {
	
	       Pastas pasta = new Pastas();
	
			public String OutputLog(log l){
				 pasta.pasta();
				 try {
					 String dir = pasta.getBackup()+"\\"+l.locomotiva+"\\"+l.getNomeArq();
					 File ll =  new File(dir);
					 
					 if(!ll.exists()){
		
						     pasta.pasta(l.locomotiva);
					         FileOutputStream fileOut = new FileOutputStream(dir);
					         ObjectOutputStream out   = new ObjectOutputStream(fileOut);
					         out.writeObject(l);
					         out.close();
					         fileOut.close();
					 }
					         return dir;
					         
			      }catch(IOException i) {
			         i.printStackTrace();
			         JOptionPane.showMessageDialog(null, "Erro ao Importado!");
			         return "";
			      }
			}
			
			public log InputLog(){
				log e = null;
				 try {
					 
					    JFileChooser chooser = new JFileChooser();
					    int returnVal = chooser.showOpenDialog(null);
					    if(returnVal == JFileChooser.APPROVE_OPTION) {
			
							 FileInputStream fileIn =
							 new FileInputStream(chooser.getSelectedFile().getAbsolutePath());
					         ObjectInputStream in = new ObjectInputStream(fileIn);
					         e = (log) in.readObject();
					         in.close();
					         fileIn.close();
					  }
					    
					 return e;
			      }catch(IOException i) {
			         i.printStackTrace();
			         return e; 
			      }catch(ClassNotFoundException c) {
			         System.out.println("Employee class not found");
			         c.printStackTrace();
			         return e;
			      }
			}
			public log InputLog(String local){
				log e = null;
				 try {
							 FileInputStream fileIn = new FileInputStream(local);
					         ObjectInputStream in = new ObjectInputStream(fileIn);
					         e = (log) in.readObject();
					         in.close();
					         fileIn.close();				    
					 return e;
			      }catch(IOException i) {
			         i.printStackTrace();
			         return e; 
			      }catch(ClassNotFoundException c) {
			         System.out.println("Employee class not found");
			         c.printStackTrace();
			         return e;
			      }
			}
			
	
}
