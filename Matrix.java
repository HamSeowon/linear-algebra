
public class Matrix {
    //private instance variables
    private int numRows;
    private int numCols;
    private double[][] data;

    //constructor | initialize variables
    public Matrix(int r, int c){
        this.numRows = r;
        this.numCols = c;
        this.data = new double[r][c];
    }

    //constructor | initalize variables | populate 2 dimensional array data with the elements in linArr
    public Matrix(int r,int c, double[] linArr){
        this.numRows = r;
        this.numCols = c;
        this.data = new double[r][c];

        //i is the number of rows. 
        //j is the number of columns. 
        for (int i = 0; i<r; i++){
            for(int j=0; j<c; j++){
                this.data[i][j] = linArr[(i*c)+j];
            }
        }
    }

    //return the number of rows.
    public int getNumRows(){
        return this.numRows;
    }

    //return the number of columns.
    public int getNumCols(){
        return this.numCols;
    }

    //return the array containing the matrix data
    public double[][] getData(){
        return this.data;
    }

    //return the value from data at specific row and column. 
    public double getElement(int r, int c){
        return this.data[r][c];
    }

    //setting value at specific row and column of data. 
    public void setElement(int r, int c, double value){
        this.data[r][c] = value;
    }

    //transpose the matrix.
    public void transpose(){
        double[][] transposedData = new double[this.numCols][this.numRows];
        //i is the number of rows. 
        //j is the number of columns. 
        for(int i = 0; i< this.numRows; i++){
            for(int j = 0; j< this.numCols;j++){
                transposedData[j][i] = this.data[i][j];
            }
        }
        int temp = this.numCols; 
        this.numCols = this.numRows;
        this.numRows = temp;
        this.data = transposedData;
    }

    //matrix multiplied by scalar, and return the result. 
    public Matrix multiply(double scalar){
        Matrix result = new Matrix(numRows, numCols);
        
        //i is the number of rows. 
        //j is the number of columns. 
        for(int i = 0; i<numRows;i++){
            for(int j = 0; j<numCols; j++){
                result.data[i][j] = this.data[i][j]*scalar;
            }
        }
        return result;
    }

    //matrix multiplied by another matrix, and return the result.
    public Matrix multiply(Matrix other){
        if (this.numCols != other.getNumRows()){
            return null;
        }
        Matrix newResultMatrix = new Matrix (this.numRows, other.getNumCols());
        double result = 0;
        
        //i is the number of rows. 
        //j is the number of columns. 
        for (int i = 0; i < newResultMatrix.getNumRows(); i++){
            for (int j = 0; j < newResultMatrix.getNumCols(); j++){
                for (int k = 0; k < newResultMatrix.getNumCols(); k++){
                    result += this.data[i][k] * other.getData()[k][j];
                }
                newResultMatrix.setElement(i, j, result);
                result = 0;
            }
        }
        return newResultMatrix;
    }

    //return in organized format.
    public String toString(){
            String str = "";
            //if the matrix is empty, return "empty matrix"
            if ((this.getNumCols() == 0) && (this.getNumRows() == 0)){
                return "Empty matrix";
            }
            //if the matrix is not empty, return 8 characters and 3 decimal place. 
            for (int i = 0; i < this.numRows; i++){
                for (int j = 0; j < this.numCols; j++){
                    str = str + String.format("%8.3f", this.getElement(i, j));
                }
                str = str + "\n";
            }
            return str.stripTrailing();
        }
    }