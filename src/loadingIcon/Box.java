/* 
 * Ryanna Luo
 * Nov 17, 2021
 * Apart of the loading icon assignment
 */

package loadingIcon;

import java.awt.Rectangle;
//Make Box a rectangle so that it has an x,y,width,height and can also access .intersects() and other Rectangle methods 
class Box extends Rectangle{
	//We do not redefine x,y,width,height here - this would totally mess up the Rectangle bits
	
	//locations of center
	int cx, cy;

	//pass in the centre, w, and h
	Box(int cx,int cy, int width, int height){
		//take cx and cy and calculate where the top left corner is
		//send these values to the Rectnagle constructor so that the rectangle is made at the correct location
		super (cx-width/2,cy-height/2,width,height);

		//cx = x+width/2;
		//cy= y+width/2;
		
		//save the values of cx and cy in the object so that we can reference them later if needed
		this.cx = cx;
		this.cy = cy;
	}
}