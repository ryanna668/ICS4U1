package loadingIcon;

import java.awt.Rectangle;

class Box extends Rectangle{
	int cx, cy;

	Box(int cx,int cy, int width, int height){
		super (cx-width/2,cy-height/2,width,height);

		//cx = x+width/2;
		//cy= y+width/2;
		
		this.cx = cx;
		this.cy = cy;
	}
}