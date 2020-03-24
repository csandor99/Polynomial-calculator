package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operations {
    private Polynomial rezPoly = new Polynomial();

    public Polynomial addPoly(Polynomial p1, Polynomial p2){
        while (p1.getPoly().size() != 0 && p2.getPoly().size() != 0) {
            int rankPoly1 = p1.getPoly().get(0).getRank();
            int rankPoly2 = p2.getPoly().get(0).getRank();
            if(rankPoly1 == rankPoly2){
                int monoCoeff = p1.getPoly().get(0).getCoefficient() + p2.getPoly().get(0).getCoefficient();
                Monomial mono = new Monomial(monoCoeff,rankPoly1);
                rezPoly.addMonomial(mono);
                p1.getPoly().remove(0);
                p2.getPoly().remove(0);
            }
            if(rankPoly1 > rankPoly2){
                Monomial mono = new Monomial(p1.getPoly().get(0).getCoefficient(),rankPoly1);
                rezPoly.addMonomial(mono);
                p1.getPoly().remove(0);
            }
            if(rankPoly1 < rankPoly2){
                Monomial mono = new Monomial(p2.getPoly().get(0).getCoefficient(),rankPoly2);
                rezPoly.addMonomial(mono);
                p2.getPoly().remove(0);
            }
        }
        while (p1.getPoly().size() != 0 ){
            rezPoly.addMonomial(p1.getPoly().get(0));
            p1.getPoly().remove(0);
        }
        while (p2.getPoly().size() != 0 ){
            rezPoly.addMonomial(p2.getPoly().get(0));
            p2.getPoly().remove(0);
        }
        return rezPoly;
    }

    public Polynomial subPoly(Polynomial p1, Polynomial p2){
        while (p1.getPoly().size() != 0 && p2.getPoly().size() != 0){
            int rankPoly1 = p1.getPoly().get(0).getRank();
            int rankPoly2 = p2.getPoly().get(0).getRank();
            if(rankPoly1 == rankPoly2){
                int monoCoeff = p1.getPoly().get(0).getCoefficient() - p2.getPoly().get(0).getCoefficient();
                Monomial mono = new Monomial(monoCoeff,rankPoly1);
                rezPoly.addMonomial(mono);
                p1.getPoly().remove(0);
                p2.getPoly().remove(0);
            }
            if(rankPoly1 > rankPoly2){
                Monomial mono = new Monomial(p1.getPoly().get(0).getCoefficient(),rankPoly1);
                rezPoly.addMonomial(mono);
                p1.getPoly().remove(0);
            }
            if(rankPoly1 < rankPoly2){
                Monomial mono = new Monomial(-(p2.getPoly().get(0).getCoefficient()),rankPoly2);
                rezPoly.addMonomial(mono);
                p2.getPoly().remove(0);
            }
        }
        while (p1.getPoly().size() != 0 ){
            rezPoly.addMonomial(p1.getPoly().get(0));
            p1.getPoly().remove(0);
        }
        while (p2.getPoly().size() != 0 ){
            p2.getPoly().get(0).setCoefficient(-(p2.getPoly().get(0).getCoefficient()));
            rezPoly.addMonomial(p2.getPoly().get(0));
            p2.getPoly().remove(0);
        }
        return rezPoly;
    }

    public Polynomial mulPoly(Polynomial p1, Polynomial p2){
        Polynomial poly = new Polynomial();
        int maxRank;
        for(int i=0; i<p1.getPoly().size(); i++)
            for(int j=0; j<p2.getPoly().size(); j++){
                int coeff = p1.getPoly().get(i).getCoefficient() * p2.getPoly().get(j).getCoefficient();
                int rank = p1.getPoly().get(i).getRank() + p2.getPoly().get(j).getRank();
                Monomial mono = new Monomial(coeff, rank);
                poly.addMonomial(mono);
            }
        if(poly.getPoly().isEmpty()) return rezPoly;
        else {maxRank = poly.getPoly().get(0).getRank();}
        for(int i=0; i<=maxRank; i++) {
            int coeffMul = 0;
            for (Monomial index : poly.getPoly()) {
                if (index.getRank() == i) coeffMul = coeffMul + index.getCoefficient();
            }
            Monomial mono = new Monomial(coeffMul,i);
            rezPoly.addMonomial(mono);
        }
        return rezPoly;
    }

    public Polynomial derPoly(Polynomial p1){
        for(Monomial i: p1.getPoly()){
            Monomial mono = new Monomial(i.getCoefficient()*i.getRank(),i.getRank()-1);
            rezPoly.addMonomial(mono);
        }
        return rezPoly;
    }

    public Polynomial intPoly(Polynomial p1){
        for(Monomial i: p1.getPoly()){
            Monomial mono = new Monomial(i.getCoefficient()/(i.getRank()+1),i.getRank()+1);
            rezPoly.addMonomial(mono);
        }
        return rezPoly;
    }

    public String polyToString(Polynomial poly){
        String polyStr = "";
        for(Monomial i: poly.getPoly()){
            if(i.getCoefficient() != 0){
                if(i.getRank() == 0){
                    if(i.getCoefficient() > 0) polyStr = polyStr + "+" + i.getCoefficient();
                    else polyStr = polyStr + i.getCoefficient();
                }
                else {
                    if(i.getCoefficient() > 0) polyStr = polyStr + "+" + i.getCoefficient() + "x^" + i.getRank() + " ";
                    else polyStr = polyStr  + i.getCoefficient() + "x^" + i.getRank() + " ";
                }
            }
            else{
                polyStr = polyStr + "";
            }
        }
        return polyStr;
    }

    public Polynomial strToPoly (String polyStr){
        Polynomial poly = new Polynomial();
        String mono;
        Pattern pattern = Pattern.compile("([+-]?[^-+]+)");
        Matcher matcher = pattern.matcher(polyStr);
        while (matcher.find()){
            int coeff = 0,rank = 0;
            mono = matcher.group(1);
            if(mono.indexOf('x') == -1){
                coeff = Integer.parseInt(mono);
            }
            else{
                coeff = Integer.parseInt(mono.substring(0,mono.indexOf('x')));
                rank = Integer.parseInt(mono.substring(mono.indexOf('^') + 1, mono.length()));
            }
            Monomial monoAux = new Monomial(coeff,rank);
            poly.addMonomial(monoAux);
        }
        return poly;
    }

    public void removePoly(){
        rezPoly = new Polynomial();
    }

}
