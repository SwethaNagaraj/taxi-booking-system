package com.nutonomy.org;

/*
 * POJO containing details about Source cordinates
 */
public class Source {
	private int xCordinate;
    private int yCordinate;
    
	public Source(){
		xCordinate = 0;
		yCordinate = 0;
	}
	
    public int getxCordinate() {
        return xCordinate;
    }
    
    public void setxCordinate(int xCordinate) {
        this.xCordinate = xCordinate;
    }
    
    public int getyCordinate() {
        return yCordinate;
    }
    
    public void setyCordinate(int yCordinate) {
        this.yCordinate = yCordinate;
    }
}
