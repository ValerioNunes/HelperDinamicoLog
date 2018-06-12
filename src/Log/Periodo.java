package Log;

import java.awt.Color;
import java.util.Date;

import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.Marker;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.data.time.Second;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.TextAnchor;

public class Periodo {
	 public DateAxis periodo = new DateAxis(); 
	 public  ValueMarker   linha = new ValueMarker(0);
	 int temp = 3;
	 
	 public int getTemp() {
		return temp;
	}

	public void setTemp(int temp) {
		this.temp = temp;
	}

	public Periodo(Date temp){
		 
		 LinhadoTempo(temp);
		 
	 }
	 
	 public void LinhadoTempo(Date Temp){
			
			Second Tempo = new Second(Temp);
			
		    double millis = Tempo.getFirstMillisecond();
		    
		    linha.setValue(millis);
		    linha.setPaint(Color.BLACK);

		    
		    Date antes =   (Date) Temp.clone();
		    antes.setMinutes(Temp.getMinutes() - temp);
		    
		    Date depois =   (Date) Temp.clone();
		    depois.setMinutes(Temp.getMinutes() + temp);
		    
		    periodo.setRange(antes,depois);
	
		}
	 
	 
}
