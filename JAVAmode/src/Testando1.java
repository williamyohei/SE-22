package Testes;

import java.util.ArrayList;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;



public class Testando1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		calcula3 mgl=new calcula3();
				
		
				mgl.setn(10);
				mgl.seta(16807);
				mgl.setM(Math.pow(2, 31)-1);
				mgl.setc(0);
				double tam = 10000;
		
		List <Double> lista=new ArrayList();
		
 
		 	for (int i=0;i<tam;i++)
		 	{
		 		lista.add(mgl.calc());
		 		//System.out.println((i+1)+": x(i): "+mgl.calc());
		 	}
  
		 	System.out.println("Media: "+ mgl.media(lista));
		 	System.out.println("Desvio Padrão: "+ mgl.dp(lista));
		 	System.out.println("Correlacao: "+ mgl.cor(lista));
		 	System.out.println("Qui-Quadrado: "+ mgl.qui(lista));
		 		        
		 	

	}

}
