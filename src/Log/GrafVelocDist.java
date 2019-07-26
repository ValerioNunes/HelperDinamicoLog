package Log;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.Marker;
import org.jfree.data.time.Month;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

import Graficos.TimeSeriesDemo1;
import Graficos.TimeSeriesDemo2;
import HD.RegrasNegocio.Func;

public class GrafVelocDist {
	

	ArrayList <XYDataset> Dados;
	Marker linha;
	DateAxis periodo;
	Func func = new Func();
	
	public GrafVelocDist (log Log,Marker linha, DateAxis periodo){
		this.linha =    linha;
		this.periodo= periodo;
		
		Dados = createDataset(Log);
	}
	
	
	 private   ArrayList <XYDataset> createDataset(log Log) {
		 	
		 
		 ArrayList <XYDataset> Data = new  ArrayList <XYDataset>();
		 
	        TimeSeries s1 = new TimeSeries("VELOCREALGPSHELPER", Second.class);
	        TimeSeries s2 = new TimeSeries("VELOC_REAL_GPS_EOT", Second.class);       
	        TimeSeries s3 = new TimeSeries("DIST_RELAT_LD", Second.class);
	        TimeSeries s4 = new TimeSeries("DIST_RELAT_LE", Second.class); 
	        TimeSeries s5 = new TimeSeries("DIST_RELATIVA_GPS_EOT_HELPER", Second.class); 
	        
	        // TimeSeries s6 = new TimeSeries("DIST_RELAT_LE", Second.class); 
	        TimeSeries s7 = new TimeSeries("LASER", Second.class); 
	        TimeSeries s8 = new TimeSeries("LIMITE", Second.class); 
	        TimeSeries s9 = new TimeSeries("GPS", Second.class); 

	        TimeSeries s10 = new TimeSeries("PRESSAO_CILINDRO_PRINCIPAL", Second.class); 
	        TimeSeries s11 = new TimeSeries("PRESSAOFREIO", Second.class);
	        TimeSeries s12 = new TimeSeries("PRESSÃO_EG_EOT", Second.class);
	        
	        for(Evento ev :  Log.Eventos ){
	        	
		        Second time = new Second(ev.getTime());
		        	s1.addOrUpdate(time, ev.getVELOCREALGPSHELPER());
		        	s2.addOrUpdate(time, ev.getVELOC_REAL_GPS_EOT());
		       
		        	
		        	s3.addOrUpdate(time, ev.getDIST_RELAT_LD());
		        	s4.addOrUpdate(time, ev.getDIST_RELAT_LE());
		         	s5.addOrUpdate(time, ev.getDIST_RELATIVA_GPS_EOT_HELPER());
	
	
		            s8.addOrUpdate(time, func.VelocidadeLimite(ev));
		            
	
		            s7.addOrUpdate(time, ev.VEL_RELAT_LE);
		            s9.addOrUpdate(time, ev.VELOC_RELATIVA_GPS_EOT_HELPER);
		            
		            s10.addOrUpdate(time, ev.getPRESSAO_CILINDRO_PRINCIPAL() );
		            s11.addOrUpdate(time, ev.getPRESSAOFREIO());
		            s12.addOrUpdate(time, ev.getPRESSÃO_EG_EOT());
	            
	        }
	        TimeSeriesCollection   Vel= new TimeSeriesCollection();
	        Vel.addSeries(s1);
	        Vel.addSeries(s2);
	    
	        
	        TimeSeriesCollection   Dis= new TimeSeriesCollection();
	        Dis.addSeries(s3);
	        Dis.addSeries(s4);
	        Dis.addSeries(s5);
	        
	        TimeSeriesCollection   VelRel= new TimeSeriesCollection();	
	        VelRel.addSeries(s7);
	        VelRel.addSeries(s8);
	        VelRel.addSeries(s9);
	        
	        TimeSeriesCollection  Pressao = new TimeSeriesCollection();	
	        Pressao.addSeries(s10);
	        Pressao.addSeries(s11);
	        Pressao.addSeries(s12);
	        
		     Data.add(Vel);
		     Data.add(Dis);
		     Data.add(VelRel);
		     Data.add(Pressao);
		     
	        return Data;

	    }
	 
	 public JPanel Velocidades(){
		 
		 TimeSeriesDemo1 demo = new TimeSeriesDemo1("Velocidades",linha,periodo,90,0);
		 
		 return demo.createDemoPanel(Dados.get(0),"km/h");
	 }
	 
	 public JPanel Distancias(){
		 
		 TimeSeriesDemo1 demo = new TimeSeriesDemo1("Distâncias",linha,periodo,110,0);
		 
		 return demo.createDemoPanel(Dados.get(1),"Metros");
	 }
	 public JPanel VelocidadesRelativas(){
		 
		 TimeSeriesDemo1 demo = new TimeSeriesDemo1("Velocidades Relativas",linha,periodo,40,0);
		 
		 return demo.createDemoPanel(Dados.get(2),"km/h");
	 }
	 public JPanel Pressao(){
		 
		 TimeSeriesDemo1 demo = new TimeSeriesDemo1("Pressão",linha,periodo,140,0);
		 
		 return demo.createDemoPanel(Dados.get(3),"PSI");
	 }
	 
}
