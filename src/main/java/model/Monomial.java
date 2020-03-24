package model;

public class Monomial {
    private int coefficient;
    private int rank;

    public Monomial(int coefficient, int rank){
        this.coefficient = coefficient;
        this.rank = rank;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public int getRank() {
        return rank;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String toString(){
        return Integer.toString(coefficient) + " " + Integer.toString(rank);
    }
}
