package Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class log implements java.io.Serializable {
	
	ArrayList<Evento> Eventos;
	int  locomotiva;
	String NomeArq, data;
	public Date time;
	
	public log(int locomotiva,ArrayList<Evento> Eventos){
			
		this.locomotiva = locomotiva;
		this.Eventos    = Eventos;
		Evento ev  = Eventos.get(Eventos.size()-1);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
		this.NomeArq = locomotiva+"_"+sdf.format(ev.getTime())+".ser";
		
		SimpleDateFormat dat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		data =  dat.format(ev.time);
		time =  ev.time;
		
		
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}


	public ArrayList<Evento> getEventos() {
		return Eventos;
	}

	public void setEventos(ArrayList<Evento> eventos) {
		Eventos = eventos;
	}

	public int getLocomotiva() {
		return locomotiva;
	}

	public void setLocomotiva(int locomotiva) {
		this.locomotiva = locomotiva;
	}

	public String getNomeArq() {
		return NomeArq;
	}

	public void setNomeArq(String nomeArq) {
		NomeArq = nomeArq;
	} 

}
