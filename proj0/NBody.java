
public class NBody {


    public static double readRadius(String filename){
        In in = new In(filename);

        int firstItemInFile = in.readInt();
        double secondItemInFile = in.readDouble();

        return secondItemInFile;


    }

    public static Body[] readBodies(String filename){
        In in = new In(filename);
        Body [] ans = new Body[5];
        int firstItemInFile = in.readInt();
        double secondItemInFile = in.readDouble();

        for (int i=0; i<ans.length; i++){
            double x = in.readDouble();
            double y = in.readDouble();
            double vx = in.readDouble();
            double vy = in.readDouble();
            double mass = in.readDouble();
            String img = in.readString();
            Body p = new Body(x,y,vx,vy,mass,img);
            ans[i] = p;
            }

        return ans;

    }

    public static void main(String[] args){

        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        Body[] bodies = readBodies(filename);
        double radius = readRadius(filename);
        int N = bodies.length;

        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        StdDraw.picture(0, 0, "images/starfield.jpg");

        for (Body plante :bodies){
            plante.draw();

        }

        StdDraw.enableDoubleBuffering();

        double time = 0;

        while(time<T){
            StdDraw.clear();
            double[] xForces = new double[N];
            double[] yForces = new double[N];

            for (int i=0; i<N;i++){
                xForces[i] = bodies[i].calcNetForceExertedByX(bodies);
                yForces[i] = bodies[i].calcNetForceExertedByY(bodies);
            }

            for (int j=0; j<N;j++){
                bodies[j].update(dt,xForces[j],yForces[j]);
            }

            StdDraw.picture(0, 0, "images/starfield.jpg");

            for (Body plante :bodies){
                plante.draw();

            }

            StdDraw.show();
            StdDraw.pause(10);
            time += dt;



        }

        StdOut.printf("%d\n", bodies.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < bodies.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
                    bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);
        }



    }

}

