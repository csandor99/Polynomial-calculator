package test;
import view.CalculatorView;
import controller.Controller;
import model.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class Derivative {
    @Test
    public void test()
    {
        Operations op = new Operations();
        CalculatorView view = new CalculatorView(op);
        Controller controller = new Controller(op,view);
        view.setInput1("10x^2+2x^1");
        view.getDerivative().doClick();
        assertEquals("+20x^1 +2", view.getAnswer().getText());
    }
}
