package general;
import java.awt.Polygon;
import java.util.Arrays;

public class SmallestLargest
{
    public static void main (String[] args)
    {       
    	 int num[] = new int [8];
        
    	 //generate all the numbers correctly
        for (int i=0; i<num.length; i++)
        {
        	num[i] = (int) (Math.random()*100 + 1);
        	System.out.println(num[i]+"");
        }
        
        //find the lowest number
        for (int i=0; i<num.length; i++)
        {
        	if ( i != 0) 
        	{
        		if (num[0] > num[i])
        		{
        		num[0] = num[i];
        		}
        	
        		if(num[7] < num[i])
        		{
        		num[7] = num [i];
        		}
        			
        	}
        //FIXME tester
        	//TODO tester
        }
        System.out.println ("The lowest number is " + num[0]);
        System.out.println("The highest number is " + num[7]);
        
        Polygon triangle = new Polygon();
}
}
        



