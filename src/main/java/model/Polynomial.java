package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Polynomial {
    private ArrayList<Monomial> poly;

    public Polynomial() {
        poly = new ArrayList<Monomial>();
    }

    public void addMonomial(Monomial mono){
        poly.add(mono);
        Collections.sort(poly, new Comparator<Monomial>() {
            @Override
            public int compare(Monomial o1, Monomial o2) {
                return Integer.valueOf(o2.getRank()).compareTo(o1.getRank());
            }
        });
    }

    public ArrayList<Monomial> getPoly() {
        return poly;
    }

}
