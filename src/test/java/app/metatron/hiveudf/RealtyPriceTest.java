package app.metatron.hiveudf;

import junit.framework.Assert;
import org.junit.Test;


public class RealtyPriceTest {

	@Test
	public void testUDF() {
		String originStr="    55,800";
		Integer unit=1000;
		Integer correct = 55800000;
		RealtyPrice example = new RealtyPrice();

		Assert.assertEquals(correct, example.evaluate(originStr,unit));
	}
}