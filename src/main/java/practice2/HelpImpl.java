package practice2;

import java.rmi.RemoteException;

public class HelpImpl implements Help{
    @Override
    public Answer solveTask(double a, double b, double c) throws RemoteException {
        Answer answer = new Answer();
        if (a == 0 && b == 0 && c == 0){
            return answer;
        }
        if (a == 0 && b == 0){
            answer.setError(true);
            return answer;
        }
        if (a == 0){
            answer.setA(-c/(double)b);
            return answer;
        }
        double d = b*b - 4 * a * c;
        if (d < 0){
            answer.setError(true);
            return answer;
        }
        if (d == 0){
            answer.setA(-b/((double) 2*a));
            return answer;
        }
        answer.setA((-b-Math.pow(d, 0.5))/((double)2*a));
        answer.setB((-b+Math.pow(d, 0.5))/((double)2*a));
        return answer;
    }
}
