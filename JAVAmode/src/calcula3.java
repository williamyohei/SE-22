package Testes;

import java.util.ArrayList;
import java.util.List;
import org.jfree.chart.*;
import org.jfree.data.*;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.plot.PlotOrientation;


/* Esse programa apresenta funções que utilizei desdo ex1 até 0 ex7*/

public class calcula3 {
	private double a=0;
	private double c=0;
	private double M=0;
	 private double n=0;
	 
	public double getn()
	 {
		 return n;
	 }
	 public void setn(double n)
	 {
		 this.n = n;
	 }
	 
	 
	 public double geta()
	 {
		 return a;
	 }
	 public void seta(double a)
	 {
		 this.a = a;
	 }
	 public double getc()
	 {
		 return c;
	 }
	 public void setc(double c)
	 {
		 this.c = c;
	 }
	 public double getM()
	 {
		 return M;
	 }
	 public void setM(double M)
	 {
		 this.M = M;
	 }
	 
	 public double calc()
	 {
		 
		this.n=((a*n+c)%M);
		return n/M;
	 	} 
	 
	 
	 public double media(List lista)
	 {
		 	double media=0;
	        double total=0;
	        double x =0;
	        for(int i=0;i<lista.size();i++)
	        {
	        	 x = (Double)lista.get(i);
	            total+=x;
	        }
	        media = total/lista.size();
	        return media;
	    }
	 
	 
	 public double dp(List lista)
	 {
	        double md=0;
	        md=this.media(lista);
	        double somatoria=0;
	        double dp=0;
	        
	        for(int i=0;i<lista.size();i++)
	        {
	            somatoria+=Math.pow(((Double)lista.get(i))-md, 2);
	        }
	        dp=Math.sqrt(somatoria/(lista.size()-1));
	
	        return dp;
	    }
	 
	 
	 
	 public double cor(List lista)
	 {
	        List x=new ArrayList();
	        List y=new ArrayList();
	        
	        
	       for(int i=1;i<lista.size();i++)
	       {
	            x.add(lista.get(i));
	            y.add(lista.get(i-1));
	            
	        }
	       

	        double Somaxy=0;
	        double Somax=0;
	        double Somay=0;
	        double Somaxquad=0;
	        double Somayquad=0;
	        
	        for(int i=0;i<y.size();i++)
	        {
	            
	            Somax+=(Double)x.get(i);
	            Somay+=(Double)y.get(i);
	            Somaxquad+=Math.pow((Double)x.get(i), 2);
	            Somayquad+=Math.pow((Double)y.get(i), 2);
	            Somaxy+=(Double)x.get(i)*(Double)y.get(i);
	        }      
	        double cor=((y.size()*Somaxy)-(Somax*Somay))/(Math.sqrt((y.size()*Somaxquad)-Math.pow(Somax,2))*Math.sqrt((y.size()*Somayquad)-Math.pow(Somay,2)));      
	        
	        return cor;
	    }
	 
	 public double qui(List<Double> lista)
	 {
	       
	       double esperado = lista.size()/10;
	       List<Double> Perfeito = this.Perfeito(lista);
	       
	       
	       double qui = 0;
	       for(int i=0;i<10;i++)
	       {
	           qui+=(Math.pow(Perfeito.get(i)-(esperado), 2))/(esperado);
	       }

	       return qui;
	   }
	 
	   public List<Double> Perfeito(List<Double> lista)
	   {
	       List<Double> perfeito=new ArrayList();	 
	       int intervalo = 10;
	       double cont=0;
	       double x=0; 
	       double inicio=0; 
	       double fim = 0.1;
	       for (int i=0;i<intervalo;i++)
	       {
	           
	    	   
	    	   for(int j=0; j < lista.size(); j++)
	    	   {
	    		   x = lista.get(j);
	    		   if(x > inicio && x < fim)
	    		   {
	    			   cont++;
	    		   }
	    	   }
	    	   perfeito.add(cont);
	    	   cont = 0;
	    	   inicio+=0.1;
	    	   fim+=0.1;
	    	   
	       }  
	       return perfeito;
	   }
	   
	  
	   
	   public void geraGrafico(List <Double> x,List <Double> y)
	   {
	        XYSeries num=new XYSeries("Números Aleatorios");
	        
	        for(int i=0;i<y.size();i++)
	        {
	            num.add(x.get(i), y.get(i));
	        }
	        XYSeriesCollection dados=new XYSeriesCollection();
	        dados.addSeries(num);
	       
	       
	        JFreeChart chart = ChartFactory.createScatterPlot("Grafico", "X", "Y", dados,PlotOrientation.VERTICAL, true, true, true);
	        		
	        ChartFrame Grafico=new ChartFrame("Números Aleatorios",chart);
	        Grafico.pack();
	        Grafico.setVisible(true);
	        
	        
	        
	    }
	   
	   public void GraficoUniforme (List <Double> lista)
	   {
		   List <Double> x=new ArrayList();
	        List <Double> y=new ArrayList();
	        int a = 3;
	        int b = 5;
		   
	        double funx = 0;
	        double funy = 1/(b-a);
	        
		   for(int i=1;i<lista.size();i++)
		 	{
			   funx = ((b-a) * (Double)lista.get(i-1) + a);
	           	          
	           if(funx > a && funx < b   )
	           {
	        	   
	        	   x.add(funx);
		           y.add(funy);

	           }
	                     
	        }
		   geraGrafico(x,y);
	        
	        
	        
	        
	        
	   }
	   
	   public void GraficoExponencial (List <Double> lista)
	   {
		   List <Double> x=new ArrayList();
	        List <Double> y=new ArrayList();
	        int a = 2;
	        
		   
	        double funx = 0;
	        double funy =0;
	        
	        
		   for(int i=1;i<lista.size();i++)
		 	{
			   funx = (-Math.log((Double)lista.get(i-1)))/a;
			   funy = a*Math.exp(-a*funx);
			   
			  
	           	          
	           if(funx > 0 )
	           {
	        	   
	        	   x.add(funx);
		           y.add(funy);

	           }
	                     
	        }
		   geraGrafico(x,y);
   
	   }
	   
	   
	   public void GraficoWeibull (List <Double> lista)
	   {
		   List <Double> x=new ArrayList();
	        List <Double> y=new ArrayList();
	        double a = 3;
	       double b = 1;
	        double funx = 0;
	        double funy =0;
	        
	        
		   for(int i=1;i<lista.size();i++)
		 	{
			   funx = b *  ( Math.pow(-Math.log((Double)lista.get(i-1)), 1/a) );
			   funy = a*Math.pow(b,-a)* Math.pow(funx, a-1) * Math.exp(-Math.pow(funx/b, a));
			   
			   
	           	          
	          
	        	   
	        	   x.add(funx);
		           y.add(funy);

	           
	                     
	        }
		   geraGrafico(x,y);
   
	   }
	   
	   
	   public void GraficoErlang (List <Double> lista)
	   {
		   List <Double> x=new ArrayList();
	        List <Double> y=new ArrayList();
	        double a = 1;
	       double k = 3;
	        double funx = 0;
	        double funy =0;
	        
	        
		   for(int i=1;i<lista.size();i++)
		 	{
			   for(int j=0; j<k ; j++)
			   {
				   funx = (-Math.log((Double)lista.get(i-1)));
			   }
			   
			   funx = funx/a;
			  funy = (a * Math.exp(-a*funx) * Math.pow((a*funx), (k-1))) / Fatorial(k-1);
			  
	           	          
	          if(funx > 0 )
	           {
	        	   
	        	   x.add(funx);
		           y.add(funy);

	           }
	                     
	        }
		   geraGrafico(x,y);
   
	   }
	   
	   public double Fatorial (double x)
	   {
		   double f =1;
		   while (x > 1){
			   f = f *(x-1); 
			   x--;
			                     }
		   
		   return f;
	   }
	   
	   
	   public void GraficoDistribuicaoNormal (List <Double> lista)
	   {
		   List <Double> x =new ArrayList();
	        List <Double> y=new ArrayList();
	        List <Double> x2 = new ArrayList();
	        double mi = 0;
	       double desvio = 1;
	        double funx = 0;
	        
	        double funy =0;
	        
	        
		   for(int i=1;i<lista.size();i++)
		 	{
			   
			   
			   funx = (Math.sqrt(-2*Math.log((Double)lista.get(i-1))) ) * Math.cos(2*Math.PI*(Double)lista.get(i-1));
			   
			  funy = (1/(desvio* Math.sqrt(2*Math.PI)))* Math.exp(  -Math.pow(((funx) - mi), 2) / (2* Math.pow(desvio, 2) ) )   ;

	        	   x.add(funx);
	        	   x2.add(-funx);   
		           y.add(funy);
         
	        }
		   x.addAll(x2);
		   y.addAll(y);
		   geraGrafico(x,y);
   
	   }
	   
	   
	   public void GraficoDistruibuicaoPossion (List <Double> lista)
	   {
		   List <Double> x=new ArrayList();
	        List <Double> y=new ArrayList();
	        double lambda = 2;
	        double p =1;
	        double funx = -1;
	        double funy =0;
	        double ex = 0;
	        
	        ex = Math.exp(-lambda);
	        
		   for(int i=1;i<lista.size();i++)
		 	{
			   
			   p *=  (Double)lista.get(i-1);
			   if(p < ex)
			   {
				   funx++;
				   x.add(funx);
				   
				   funy = (Math.pow(lambda, funx)* Math.exp(-lambda)) / Fatorial(funx);
				   
				   
				   y.add(funy);
				   
				   p = 1;
				   funx = 0;
			   }
			   else
			   {
				   funx++;
			   }
			   

	        	   
		           

	           
	                     
	        }
		   geraGrafico(x,y);
   
	   }
	   
	   
	   public void GraficoDistruibuicaoGeometrica (List <Double> lista)
	   {
		   List <Double> x=new ArrayList();
	        List <Double> y=new ArrayList();
	        double p = 0.8;
	        double q = 1 - p;
	        double funx = 0;
	        double funy =0;
	        
	        
		   for(int i=1;i<lista.size();i++)
		 	{
			   
			   funx = 1 + ((Math.log((Double)lista.get(i-1))) / (Math.log(q)));
			   funx = Math.round(funx);
			   funy = p* Math.pow(q, funx-1);
			  
	        	   x.add(funx);
		           y.add(funy);

	           
	                     
	        }
		   geraGrafico(x,y);
   
	   }
	   
	   


}
