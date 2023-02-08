//inherit from the Matrix class.
public class Vector extends Matrix {

    //constructor | call the Matrix constructor. 
    public Vector(int c){
        //send in 1 as the value of r
        super(1, c);
    }

    //constructor | call the Matrix constructor.
    public Vector(int c, double[] linArr){
        //send in 1 as the value of r
        super(1, c, linArr);
    }

    //return the value at row 0 and column c. 
    public double getElement(int c){
        return super.getElement(0, c);
    }
}
