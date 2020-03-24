package test;
import view.CalculatorView;
import controller.Controller;
import model.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class Subtraction {
    @Test
    public void test()
    {
        Operations op = new Operations();
        CalculatorView view = new CalculatorView(op);
        Controller controller = new Controller(op,view);
        view.setInput1("10x^2+15x^1-52");
        view.setInput2("3x^2-7x^1");
        view.getSubtraction().doClick();
        assertEquals("+7x^2 +22x^1 -52", view.getAnswer().getText());
    }
}
