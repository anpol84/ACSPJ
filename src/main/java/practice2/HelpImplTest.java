package practice2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.rmi.RemoteException;

import static org.junit.jupiter.api.Assertions.*;

public class HelpImplTest {
    private HelpImpl help = new HelpImpl();

    @Test
    public void testSolveTaskForZeroCoefficients() throws RemoteException {
        double a = 0;
        double b = 0;
        double c = 0;

        Answer result = help.solveTask(a, b, c);

        assertNull(result.getA());
        assertNull(result.getB());
        assertFalse(result.getError());
        assertEquals(result.toString(), "Уравнение имеет бесконечное число корней");
    }

    @Test
    public void testSolveTaskForZeroCoefficientsExceptC() throws RemoteException {
        double a = 0;
        double b = 0;
        double c = 5;

        Answer result =  help.solveTask(a, b, c);

        assertNull(result.getA());
        assertNull(result.getB());
        assertTrue(result.getError());
        assertEquals(result.toString(), "Уравнение не имеет корней");
    }

    @Test
    public void testSolveTaskForLinearEquation() throws RemoteException {
        double a = 0;
        double b = 2;
        double c = 5;

        Answer result =  help.solveTask(a, b, c);

        assertEquals(result.getA(), -c/b, 0.01);
        assertNull(result.getB());
        assertFalse(result.getError());
        assertEquals(result.toString(), "Корень уравнения равен " + result.getA());
    }


    @Test
    public void testSolveTaskForNegativeDiscriminant() throws RemoteException {
        double a = 2;
        double b = 3;
        double c = 4;

        Answer result =  help.solveTask(a, b, c);

        assertNull(result.getA());
        assertNull(result.getB());
        assertTrue(result.getError());
        assertEquals(result.toString(), "Уравнение не имеет корней");
    }



    @Test
    public void testSolveTaskForZeroDiscriminant() throws RemoteException {
        double a = 1;
        double b = -4;
        double c = 4;

        Answer result =  help.solveTask(a, b, c);

        assertEquals(result.getA(), 2.0, 0.01);
        assertNull(result.getB());
        assertFalse(result.getError());
        assertEquals(result.toString(), "Корень уравнения равен " + result.getA());
    }

    @Test
    public void testSolveTaskForPositiveDiscriminant() throws RemoteException {
        double a = 1;
        double b = -5;
        double c = 6;

        Answer result =  help.solveTask(a, b, c);

        assertEquals(result.getA(), 2.0, 0.01);
        assertEquals(result.getB(), 3.0, 0.01);
        assertFalse(result.getError());
        assertEquals(result.toString(), "Корни уравнения равны " + result.getA() + " и "  + result.getB());
    }

}
