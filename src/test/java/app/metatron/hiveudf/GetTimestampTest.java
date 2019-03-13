package app.metatron.hiveudf;

import junit.framework.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetTimestampTest {

	@Test
	public void testUDF2() {

		String datePattern = "[dd/MMM/yyyy:HH:mm:ss Z]";
		String dateString = "[03/Feb/2019:03:22:50 +0000]";
		SimpleDateFormat df = new SimpleDateFormat(datePattern);
		Date date = new Date();

		try {
			date = df.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		GetTimestamp example = new GetTimestamp();
		Assert.assertEquals(null,null);
		Long unixtimestamp = date.getTime() / 1000;

		Assert.assertEquals(unixtimestamp.toString(), example.evaluate(dateString, datePattern).toString());
	}
}