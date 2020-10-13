package Labs;

public class Point3d {
    public static void main(String[] args) {
        Point3d myPoint = new Point3d ();//создает точку (0.0,0.0,0.0)
        Point3d myOtherPoint = new Point3d (5,3,3);//создает точку (5,3,3)
        Point3d myOtherPoint3 = new Point3d (5,3,3);//создает точку (5,3,3)
        Point3d myOtherPoint1 = new Point3d (3,2,1);//создает точку (5,3,3)
        System.out.println(myOtherPoint.distanceTo(myOtherPoint1));
        System.out.println(myOtherPoint.comparePoint3d(myOtherPoint3)+"=true");
        System.out.println(myOtherPoint.comparePoint3d(myOtherPoint1)+"=false");

    }
    private double xCoord;

    private double yCoord;
    private double zCoord;

    public double distanceTo(Point3d s){
        double D=Math.sqrt(Math.pow(s.xCoord - this.xCoord,2)+Math.pow(s.yCoord - this.yCoord,2)+Math.pow(s.zCoord - this.zCoord,2));
        return D;
    }
    public Point3d ( double x, double y, double z) {
        xCoord = x;
        yCoord = y;
        zCoord = z;
    }

    public Point3d () {
        this(0.0, 0.0,0.0);
    }
    public double getX () {
        return xCoord;
    }
    public double getZ () {
        return zCoord;
    }

    public double getY () {
        return yCoord;
    }

    public void setX ( double val) {
        xCoord = val;
    }
    public void setZ ( double val) {
        zCoord = val;
    }

    public void setY ( double val) {
        yCoord = val;
    }
    public boolean comparePoint3d (Point3d one){
        int c1,c2,c3;
        c1=Double.compare(one.xCoord,this.xCoord);
        c2=Double.compare(one.yCoord,this.yCoord);
        c3=Double.compare(one.zCoord,this.zCoord);
        return (c1==0 && c2==0 && c3==0);
    }
}
