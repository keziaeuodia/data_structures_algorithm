package sample;

import java.math.BigDecimal;

public class BigDecimalTest {

    public static void main(String[] args) {

        BigDecimal amount = BigDecimal.valueOf(100.5);
        BigDecimal fee = BigDecimal.valueOf(5);
        BigDecimal fee2 = BigDecimal.valueOf(10);
        BigDecimal feeAmount = amount.subtract(fee).subtract(fee2);

        System.out.println(feeAmount);

    }

}
