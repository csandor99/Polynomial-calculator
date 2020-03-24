package main;

import controller.Controller;
import model.Monomial;
import model.Operations;
import model.Polynomial;
import view.CalculatorView;
import model.Operations;

import javax.swing.*;

public class Calculator {

    public static void main(String[] args) {

        Operations     model      = new Operations();
        CalculatorView view       = new CalculatorView(model);
        Controller controller = new Controller(model, view);

        view.setVisible(true);


    }
}