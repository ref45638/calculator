import java.math.BigDecimal;
import java.math.RoundingMode;


public class rr {
	public static void main(String[] args)
	{
		BigDecimal b1 = new BigDecimal("2");
		BigDecimal b2 = new BigDecimal("3");
		System.out.println(b1.divide(b2, 10,RoundingMode.HALF_UP).toString());
	}
}
