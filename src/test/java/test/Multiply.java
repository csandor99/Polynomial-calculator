package test;
import view.CalculatorView;
import controller.Controller;
import model.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class Multiply {
    @Test
    public void test()
    {
        Operations op = new Operations();
        CalculatorView view = new CalculatorView(op);
        Controller controller = new Controller(op,view);
        view.setInput1("10x^2");
        view.setInput2("3x^2-7x^1");
        view.getMultiplication().doClick();
        assertEquals("+30x^4 -70x^3 ", view.getAnswer().getText());
    }
}
