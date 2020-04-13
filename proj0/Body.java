
public class Body{
    double xxPos;
    double yyPos;
    double xxVel;
    double yyVel;
    double mass;
    String imgFileName;

    public Body(double xP, double yP, double xV, double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass =  m;
        imgFileName = img;
    }

    public Body(Body b){
        b.xxPos = this.xxPos;
        b.yyPos = this.yyPos;
        b.xxVel = this.xxVel;
        b.yyVel = this.yyVel;
        b.mass =  this.mass;
        b.imgFileName = this.imgFileName;
    }

    public double calcDistance(Body b){
        double res;
        res = Math.sqrt((this.xxPos - b.xxPos)* (this.xxPos - b.xxPos) + (this.yyPos-b.yyPos)*(this.yyPos-b.yyPos));

        return res;
    }

    public double calcForceExertedBy(Body c){
        double res;
        res = 6.67 * 1e-11 * this.mass * c.mass / Math.pow(this.calcDistance(c),2);

        return res;
    }

    public double calcForceExertedByX(Body c){
        double force = this.calcForceExertedBy(c);

        return force * (c.xxPos- this.xxPos) / this.calcDistance(c);
    }

    public double calcForceExertedByY(Body c){
        double force = this.calcForceExertedBy(c);

        return force * (c.yyPos- this.yyPos) / this.calcDistance(c);
    }

    public double calcNetForceExertedByX(Body[] c){

        int N = c.length;
        double[] force = new double[N];
        double[] res = new double[N];


        for(int i=0; i<c.length; i++  ){
            if (c[i].equals(this)){
                res[i]=0;
                continue;
            }else{
                force[i] = this.calcForceExertedBy(c[i]);
                res[i] = (force[i] * (c[i].xxPos - this.xxPos)) / this.calcDistance(c[i]);
            }
        }

        double sum = 0;

        for(double item :res){
            sum+=item;
        }

        return sum;
    }

    public double calcNetForceExertedByY(Body[] c){
        int N = c.length;
        double[] force = new double[N];
        double[] res = new double[N];


        for(int i=0; i<c.length; i++  ){
            if (c[i].equals(this)){
                res[i]=0;
                continue;
            }else{
                force[i] = this.calcForceExertedBy(c[i]);
                res[i] = force[i] * (c[i].yyPos-this.yyPos) / this.calcDistance(c[i]);
            }
        }

        double sum = 0;

        for(double item :res){
            sum+=item;
        }
        return sum;
    }

    public void update(double t, double x, double y){
        this.xxVel = this.xxVel + t* x/this.mass;
        this.yyVel = this.yyVel + t*y/this.mass;

        this.xxPos = this.xxPos + t*this.xxVel;
        this.yyPos = this.yyPos + t*this.yyVel;

    }

    public void draw(){
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }

}
