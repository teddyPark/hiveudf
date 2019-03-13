package app.metatron.hiveudf;

import junit.framework.Assert;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertMMMTest {

	@Test
	public void testUDF() {
		ConvertMMM example = new ConvertMMM();
		Assert.assertEquals(null,null);
		Assert.assertEquals("[03/2월/2019:03:22:49 +0000]", example.evaluate(new String("[03/Feb/2019:03:22:49 +0000]")).toString());
	}
}