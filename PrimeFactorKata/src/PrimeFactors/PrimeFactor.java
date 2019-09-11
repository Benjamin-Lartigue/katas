package PrimeFactors;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactor {
    public static List<Integer> generate(int integerToBreakDown){
        List<Integer> primes = new ArrayList<Integer>();
        int divisor = 2;
        while(integerToBreakDown > 1){
            if(integerToBreakDown % divisor == 0){
                primes.add(divisor);
                integerToBreakDown /= divisor;
            }else{
                divisor++;
            }
        }
        return primes;
    }

}
