public class Atividade1_williamyohei {
    private double a=16807;
    private double c=0;
    private double M=Math.pow(2,31)-1;
    private double n=10;
    public double geta(){
        return a;
    }
    public void seta(double a){
        this.a = a;
    }
    public double getc(){
        return c;
    }
    public void setc(double c){
        this.c = c;
    }
    public double getM(){
        return M;
    }
    public void setM(double M){
        this.M = M;
    }
    public double calc(){
        this.n=((a*n+c)%M);
        return n;
    }
    public static void main(String[] args) {

        Atividade1_williamyohei mgl=new Atividade1_williamyohei();
        double m = (Math.pow(2,31)-1);
        for (int i=0;i<10;i++){
            double x=mgl.calc();
            System.out.println((i+1)+": x(i): "+x);
            System.out.println((i+1)+": x(i)/M:"+x/m+"\n\n");
        }
    }
}