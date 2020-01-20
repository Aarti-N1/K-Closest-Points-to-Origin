package medium;

import java.util.Collections;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin_973 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*int[][] points = {{1,3},{-2,2}}; 
		int K = 1;
		*/
		int[][] points = {{3,3},{5,-1},{-2,4}};
		int K = 2;
		KClosestPointsToOrigin_973 obj = new KClosestPointsToOrigin_973();
		int[][] res = obj.kClosest(points, K);
		for(int i =0; i<res.length;i++) {
			System.out.println("[" +res[i][0]+ "," + res[i][1]+"]," );
		}
		
	}
	class Point implements Comparable<Point>{
        int x;
        int y;
        int distance;
        
        public Point(int x, int y){
            this.x=x;
            this.y = y;
            this.distance = (x*x + y*y); 
        }
        @Override
        public int compareTo(Point p){
            return Integer.compare(this.distance, p.distance);
            //return -1*Integer.compare(this.distance, p.distance);
            
        }
    }
    public int[][] kClosest(int[][] points, int K) {
      
        PriorityQueue pq = new PriorityQueue<Point>(K, Collections.reverseOrder());
        //PriorityQueue pq = new PriorityQueue<Point>(K);
        
        int i=0;
        while (i < K){
            pq.add(new Point(points[i][0], points[i][1]));
            i++;
        }
        while(i<points.length){
            //if new point is less than max then add to pq 
            Point p = new Point(points[i][0],points[i][1]);
            Point max = (Point)pq.peek();
            if(p.distance< max.distance){
                pq.poll();
                pq.add(p);
            }
            i++;
        }
        int[][] res = new int[K][2];
        int j=0;
        while(!pq.isEmpty()){ //poll elements and add to res
            Point pointEntry = (Point)pq.poll();
            res[j][0]= pointEntry.x;
            res[j][1]= pointEntry.y;
            j++;            
        }
        return res;
    }
}
