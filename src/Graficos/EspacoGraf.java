package Graficos;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Marker;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.DeviationRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.Range;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class EspacoGraf {
	
	   ChartPanel chartPanel;
	   JFreeChart chart;
	   String chartTitle = "";
	   XYDataset xyDataset;

	   static Marker linha = null;
	   static String title;
	   static DateAxis periodo;
	   static int max;
	   static int min;
	   
	   public EspacoGraf(String title, Marker linha, DateAxis periodo,int max , int min) {
	    	
	         this.linha = linha;
	         this.periodo = periodo;     
	         this.title = title; 
	         this.max = max;
	         this.min = min;
	        
		     //XYSeriesCollection xy  = new XYSeriesCollection();
		     //xy.addSeries(series);

		     this.xyDataset = new XYSeriesCollection(); 
		     this.xyDataset = xyDataset;

		     	chart = createChart(this.xyDataset);
				chartPanel = new ChartPanel(chart, true, true, true, false, true);
				chartPanel.setPreferredSize(new java.awt.Dimension(500,500));
				chartPanel.setAutoscrolls(true);

	    }
   
	   
	
	public EspacoGraf(XYSeriesCollection xyDataset,String chartTitle,int x, int y ) {
		
		// TODO Auto-generated constructor stub
		/*
		this.chart = chart;
		chart  = ChartFactory.createLineChart(
  		         "",
  		         "","",
  		         d,
  		         PlotOrientation.VERTICAL,
  		         true,true,false);
		//chart.clearSubtitles();
		chart.getPlot().setBackgroundPaint( Color.WHITE);
		chartPanel = new ChartPanel(chart, true, true, true, false, true);
		chartPanel.setPreferredSize( new java.awt.Dimension(1340,250));
		chartPanel.setAutoscrolls(true);
		
		*/
	 
	     this.chart = chart;	
	     this.chartTitle = chartTitle;
	     
	     //XYSeriesCollection xy  = new XYSeriesCollection();
	     //xy.addSeries(series);
	     
	     this.xyDataset = new XYSeriesCollection();
	     
	     this.xyDataset = xyDataset;

	     	chart = createChart(this.xyDataset);
			chartPanel = new ChartPanel(chart, true, true, true, false, true);
			chartPanel.setPreferredSize(new java.awt.Dimension(x,y));
			chartPanel.setAutoscrolls(true);
			
	}
 
    
    public void  XYupdate2(XYSeriesCollection xyDataset){
    	chart.getXYPlot().setDataset(xyDataset);
}    

	   
	public JFreeChart createChart(XYDataset xyDataset) {
		    
		String xAxisLabel = "";
		String yAxisLabel = "";
		
		JFreeChart result = ChartFactory.createXYLineChart(chartTitle,xAxisLabel, yAxisLabel, xyDataset);
	    
		result.getPlot().setBackgroundPaint(Color.WHITE);     
	    XYPlot plot = (XYPlot) result.getPlot();
		ValueAxis domainAxis = plot.getDomainAxis();
        Range range = domainAxis.getRange();
        double c = domainAxis.getLowerBound() + (70/100.0)*range.getLength();

        plot.setDomainCrosshairValue(c);
            
            return result;
		}

	


}
