package HD.RegrasNegocio;

import java.awt.Color;
import java.awt.TextArea;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JTextArea;

import Log.Evento;

public class Func {
	
	Map<String,String> Alarme1 = new HashMap<String,String>();
	Map<String,String> Alarme2 = new HashMap<String,String>();
	Map<String,String> Alarme3 = new HashMap<String,String>();
	
	public  Func(){
		
		Alarme1.put("000", "");
		Alarme1.put("001", "VEL. TREM");
		Alarme1.put("002", "DATALOGGER LIG");
		Alarme1.put("004", "DATALOGGER LIVRE");
		Alarme1.put("008", "GPS LOC. OK");
		Alarme1.put("016", "AR CILINTRO PRINC");
		Alarme1.put("032", "GPS ATIVO");
		Alarme1.put("064", "APLICACAO FREIO GRAD.");
		Alarme1.put("128", "-----");
		
		Alarme2.put("000", "");		
		Alarme2.put("001", "EOT BAT.");
		Alarme2.put("002", "TELEMETRO ATIVO");
		Alarme2.put("004", "CIL.ALIN.E.AV.");
		Alarme2.put("008", "CIL.ALIN.E.REC.");
		Alarme2.put("016", "CIL.ALIN.D.AV");
		Alarme2.put("032", "CIL.ALIN.D.REC");
		Alarme2.put("064", "PINO ENGATE");
		Alarme2.put("128", "FREI HELPER (CF)");

		Alarme3.put("000", "");
		Alarme3.put("001", "DISTANCIA RELATIVA");
		Alarme3.put("002", "VELOCIDADE RELATIVA");
		Alarme3.put("004", "DEFEITO LASER E");
		Alarme3.put("008", "DEFEITO LASER D");
		Alarme3.put("016", "VELOCIDADE HELPER");
		Alarme3.put("032", "FREIO TREM (EG)");
		Alarme3.put("064", "EOT ATIVO");
		Alarme3.put("128", "EOT ID");
	}
	
	public void Binario(JTextArea textArea,  int valor){
		if(valor == 1){
			textArea.setText("TRUE");
			textArea.setBackground(Color.GREEN);
			textArea.setForeground(Color.BLACK);
		}
		else{
			textArea.setText("FALSE");
			textArea.setBackground(Color.darkGray);
			textArea.setForeground(Color.WHITE);
		}
		
	}
	
	static public Double Distancia(Evento ev) {
		
		if(ev.getDIST_RELAT_LE() < 1)
			return Double.valueOf(ev.getDIST_RELATIVA_GPS_EOT_HELPER());
		else
			return ev.getDIST_RELAT_LE();
		
	}
	
	
	public void Vel_Rel_Limite(JTextArea textArea, Evento ev){
	 
		textArea.setText(String.valueOf(VelocidadeLimite(ev)) + " km/h");
		
	}
	
	
		
	  		
	public void PinoEngate(JTextArea textArea,  int valor){
		if(valor == 1){
			textArea.setText("ABAIXADO");
			textArea.setBackground(Color.GREEN);
			textArea.setForeground(Color.BLACK);
		}
		else{
			textArea.setText("LEVANTADO");
			textArea.setBackground(Color.darkGray);
			textArea.setForeground(Color.WHITE);
		}
		
	}
	
	public void RelativosVelocidade(JTextArea textArea, Evento ev ){
		
		int valor = ev.getVELOCREALGPSHELPER() -  ev.getVELOC_REAL_GPS_EOT();
		JTextArea t = ColorTextArea(textArea,valor);
		t.setText( ev.getVELOC_RELATIVA_GPS_EOT_HELPER() +  " km/h");
		
	}
	
	public void RelativosDistancia(JTextArea textArea, Evento  ev){
		
		int valor = posicaoHelper_KM_Int(ev) - posicaoTrem_KM_Int(ev)  ;
		
		JTextArea t = ColorTextArea(textArea,  valor);
		t.setText(ev.getDIST_RELATIVA_GPS_EOT_HELPER() + " m");
		
	}
	
	public String posicaoHelper_KM(Evento  ev) {
		return String.valueOf(617000 - ev.getPOSI플OHELPER_GPS());
	}
	
	public String posicaoTrem_KM(Evento  ev) {
		if( ev.getPOSI플OHELPER_GPS() < 0)
			return String.valueOf(617000 +  Math.abs(ev.getPOSI플O_EOT_GPS()));
		else
			return String.valueOf(617000 -  Math.abs(ev.getPOSI플O_EOT_GPS()));
	}
	
	public int posicaoHelper_KM_Int(Evento  ev) {
		return (617000 - ev.getPOSI플OHELPER_GPS());
	}
	
	public int posicaoTrem_KM_Int(Evento  ev) {
		if( ev.getPOSI플OHELPER_GPS() < 0)
			return (617000 +  Math.abs(ev.getPOSI플O_EOT_GPS()));
		else
			return (617000 -  Math.abs(ev.getPOSI플O_EOT_GPS()));
	}
	
	
	
	public JTextArea ColorTextArea(JTextArea textArea, int valor){
		
		
		if(valor >= 0 ){
			textArea.setBackground(Color.GREEN);
			textArea.setForeground(Color.BLACK);
		}
		else{
			textArea.setBackground(Color.RED);
			textArea.setForeground(Color.WHITE);
		}
		
		return textArea;
		
	}
	
	
	public int VelocidadeLimite(Evento ev){
		double  d = Distancia (ev); 
		
		return  (d > 600) ? 30 :
			    	 (d >= 560) ? 27 :
			    		 (d >= 500) ? 26 :
			    			 (d >= 470) ? 25 :
			    				 (d >= 430) ? 24 :
			    					 (d >= 390) ? 23 :
			    						 (d >= 350) ? 22 :
			    							 (d >= 290) ? 20 :
			    								 (d >= 250) ? 18 :
			    									 (d >= 220) ? 16 :
			    										 (d >= 150) ? 14 :
			    											 (d >= 100) ? 10 :
			    												 (d >= 87) ? 9 :
			    													 (d >= 74) ? 8 :
			    														 (d >= 59) ? 7:
			    															 (d >= 40) ? 6:
			    																 (d >= 29) ? 5:
			    																	 (d >= 14) ? 4:
			    																		 (d >= 0) ? 3:3;
	}

	public Map<String, String> getAlarme1() {
		return Alarme1;
	}

	public void setAlarme1(Map<String, String> alarme1) {
		Alarme1 = alarme1;
	}

	public Map<String, String> getAlarme2() {
		return Alarme2;
	}

	public void setAlarme2(Map<String, String> alarme2) {
		Alarme2 = alarme2;
	}

	public Map<String, String> getAlarme3() {
		return Alarme3;
	}

	public void setAlarme3(Map<String, String> alarme3) {
		Alarme3 = alarme3;
	}
	
}
