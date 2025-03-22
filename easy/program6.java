/* 
 * Find distance between two coordinates (Point)
**/

import java.util.*;

class Point
{
    int x;
    int y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class program6 {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        
        Point p1 = new Point(x1, y1);
        Point p2 = new Point(x2, y2);
        
        System.out.format("%.3f", findDistance(p1, p2));
    }
    
    public static double findDistance(Point p1, Point p2)
    {
        return Math.sqrt(Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y - p2.y), 2));
    }
}