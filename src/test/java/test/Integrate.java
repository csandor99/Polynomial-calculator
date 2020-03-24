package test;

import controller.Controller;
import model.Operations;
import org.junit.Test;
import view.CalculatorView;

import static org.junit.Assert.assertEquals;

public class Integrate {
    @Test
    public void test()
    {
        Operations op = new Operations();
        CalculatorView view = new CalculatorView(op);
        Controller controller = new Controller(op,view);
        view.setInput1("10x^1+2");
        view.getIntegration().doClick();
        assertEquals("+5x^2 +2x^1 ", view.getAnswer().getText());
    }
}
