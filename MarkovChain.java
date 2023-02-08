public class MarkovChain {

    //private instance varibles. 
    private Vector stateVector;
    private Matrix transitionMatrix;

    //constructor | initialize the instance variables. 
    public MarkovChain(Vector sVector, Matrix tMatrix){
        this.stateVector = sVector;
        this.transitionMatrix = tMatrix;
    }

    //checking its validity
    //return true if valid | return false if not valid. 
    public boolean isValid(){
        //state column
        double sCols = this.stateVector.getNumCols();
        //state sum
        double sSum = 0;
        //transition column
        double tCols = this.transitionMatrix.getNumCols();
        //transition row
        double tRows = this.transitionMatrix.getNumRows();
        //row sum
        double rowSum = 0;
        if ((tCols != tRows) || (tCols != sCols)){
            return false;
        }
        for (int i = 0; i < sCols; i++){
            sSum = sSum + this.stateVector.getElement(i);
        }
        if ((0.99 > sSum) || (1.01 < sSum)){
            return false;
        }
        for (int row = 0; row < tRows; row++){
            for (int column = 0; column < tCols; column++){
                rowSum = rowSum + this.transitionMatrix.getElement(row, column);
            }
            if ((0.99 > rowSum) || (1.01 < rowSum)){
                return false;
            }
            rowSum = 0;
        }
        return true;
    }

    //computing probability of markov chain. 
    public Matrix computeProbabilityMatrix(int numSteps){
        //return null if not valid.
        if (!this.isValid()){
            return null;
        }
        Matrix newMatrixResult = transitionMatrix;
        for (int i = 0; i < numSteps-1; i++){
            newMatrixResult = newMatrixResult.multiply(transitionMatrix);
        }
        return stateVector.multiply(newMatrixResult);

    }

}
