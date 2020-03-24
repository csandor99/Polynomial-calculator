package controller;

import model.Operations;
import model.Polynomial;
import view.CalculatorView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.CalculatorView;

public class Controller{
    //... The Controller needs to interact with both the Model and View.
    private Operations op;
    private CalculatorView  view;

    //========================================================== constructor
    /** Constructor */
    public Controller(Operations model, CalculatorView cView) {
        op = model;
        view  = cView;

        //... Add listeners to the view.
        view.addMultiplyListener(new MultiplyListener());
        view.addAdditionListener(new AdditionListener());
        view.addSubtractListener(new SubtractListener());
        view.addDerivativeListener(new DerivativeListener());
        view.addIntegrateListener(new IntegrateListener());
        view.addClearListener(new ClearListener());

    }

    public class AdditionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            op.removePoly();
            String resStr;
            try {
                String userInput1 = view.getInput1();
                String userInput2 = view.getInput2();
                Polynomial p1 = op.strToPoly(userInput1);
                Polynomial p2 = op.strToPoly(userInput2);
                Polynomial rez = op.addPoly(p1,p2);
                resStr = op.polyToString(rez);
                view.setResult(resStr);
            } catch (NumberFormatException nfex) {
                view.showError("The inputs don't match the established format.");
            }
        }
    }

    public class SubtractListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            op.removePoly();
            String resStr;
            try {
                String userInput1 = view.getInput1();
                String userInput2 = view.getInput2();
                Polynomial p1 = op.strToPoly(userInput1);
                Polynomial p2 = op.strToPoly(userInput2);
                Polynomial rez = op.subPoly(p1,p2);
                resStr = op.polyToString(rez);
                view.setResult(resStr);
            } catch (NumberFormatException nfex) {
                view.showError("The inputs don't match the established format.");
            }
        }
    }

    public class MultiplyListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            op.removePoly();
            String resStr;
            try {
                String userInput1 = view.getInput1();
                String userInput2 = view.getInput2();
                if(userInput1 == " " || userInput1 == "0" || userInput2 == " " || userInput2 == "0"){
                    resStr = "0";
                }
                else{
                    Polynomial p1 = op.strToPoly(userInput1);
                    Polynomial p2 = op.strToPoly(userInput2);
                    Polynomial rez = op.mulPoly(p1,p2);
                    resStr = op.polyToString(rez);
                }
                view.setResult(resStr);
            } catch (NumberFormatException nfex) {
                view.showError("The inputs don't match the established format.");
            }
        }
    }

    public class DerivativeListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            op.removePoly();
            String resStr;
            try {
                String userInput1 = view.getInput1();
                    Polynomial p1 = op.strToPoly(userInput1);
                    Polynomial rez = op.derPoly(p1);
                    resStr = op.polyToString(rez);
                view.setResult(resStr);
            } catch (NumberFormatException nfex) {
                view.showError("The inputs don't match the established format.");
            }
        }
    }

    public class IntegrateListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            op.removePoly();
            String resStr;
            try {
                String userInput1 = view.getInput1();
                Polynomial p1 = op.strToPoly(userInput1);
                Polynomial rez = op.intPoly(p1);
                resStr = op.polyToString(rez);
                view.setResult(resStr);
            } catch (NumberFormatException nfex) {
                view.showError("The inputs don't match the established format.");
            }
        }
    }

    class ClearListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            op.removePoly();
            view.reset();
        }
    }// end inner class ClearListener
}

