package view;

import model.Operations;
import model.Polynomial;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class CalculatorView extends JFrame {

    private static final String INITIAL_VALUE = "0";

    private JTextField polyTxt1 = new JTextField(30);
    private JTextField polyTxt2= new JTextField(30);
    private JTextField resTxt= new JTextField(30);

    private JButton addBtn = new JButton("+");;
    private JButton subBtn= new JButton("-");;
    private JButton mulBtn= new JButton("x");;
    private JButton divBtn= new JButton("/");;
    private JButton intBtn= new JButton("Integrate");;
    private JButton derBtn= new JButton("Derivative");;
    private JButton clearBtn = new JButton("Clear");

    private JLabel l1 = new JLabel("First Polynomial:");
    private JLabel l2 = new JLabel("Second Polynomial:");
    private JLabel resultLabel = new JLabel("Result:");
    private JLabel exLabel = new JLabel("Input example: 1x^2+5x^1-7");

    private Polynomial poly1=new Polynomial();
    private Polynomial poly2=new Polynomial();
    private Polynomial polyRez=new Polynomial();
    private Operations op = new Operations();

    private String p1String;
    private String p2String;

    /** Constructor */
    public CalculatorView(Operations model) {
        //... Set up the logic
        op = model;

       // m_model.setValue(INITIAL_VALUE);

        //... Initialize components
       // m_totalTf.setText(m_model.getValue());
        resTxt.setEditable(false);

        //... Layout the components.
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        p1.setLayout(new FlowLayout());
        p2.setLayout(new FlowLayout());
        p3.setLayout(new FlowLayout());
        p4.setLayout(new FlowLayout());
        p1.add(l1);
        p1.add(polyTxt1);
        p1.add(exLabel);
        p2.add(l2);
        p2.add(polyTxt2);
        p3.add(resultLabel);
        p3.add(resTxt);
        p4.add(addBtn);
        p4.add(subBtn);
        p4.add(mulBtn);
        p4.add(divBtn);
        p4.add(intBtn);
        p4.add(derBtn);
        p4.add(clearBtn);
        //... finalize layout
        this.add(p1);
        this.add(p2);
        this.add(p3);
        this.add(p4);
        this.pack();


        this.setTitle("Polynomial Calculator");
        this.setSize(500,400);
        this.setLayout(new GridLayout(4,1));
        // The window closing event should probably be passed to the
        // Controller in a real program, but this is a short example.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void reset() { resTxt.setText(INITIAL_VALUE); }

    public String getInput1() { return polyTxt1.getText(); }

    public String getInput2() { return polyTxt2.getText(); }

    public void setInput1(String str) { polyTxt1.setText(str);}

    public void setInput2(String str) { polyTxt2.setText(str);}

    public void setResult(String newResult) {
        resTxt.setText(newResult);
    }

    public void showError(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }

    public void addAdditionListener(ActionListener mal) {
        addBtn.addActionListener(mal);
    }

    public void addSubtractListener(ActionListener mal) {
        subBtn.addActionListener(mal);
    }

    public void addMultiplyListener(ActionListener mal) {
        mulBtn.addActionListener(mal);
    }

    public void addDerivativeListener(ActionListener mal) {
        derBtn.addActionListener(mal);
    }

    public void addIntegrateListener(ActionListener mal) {
        intBtn.addActionListener(mal);
    }

    public void addClearListener(ActionListener cal) { clearBtn.addActionListener(cal);}

    public JButton getAddition() {return addBtn; }
    public JButton getSubtraction() {return subBtn; }
    public JButton getMultiplication() {return mulBtn; }
    public JButton getDivision() {return divBtn; }
    public JButton getIntegration() {return intBtn; }
    public JButton getDerivative() {return derBtn; }
    public JTextField getAnswer() {return resTxt;}
}
