package app.metatron.hiveudf;

import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.exec.UDF;
import org.joda.time.format.DateTimeFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

@Description(
		name="GetTimestamp(time string, time format)",
		value="returns unix time",
		extended="SELECT gettimestamp(request_time) from foo limit 1;"
)
public class GetTimestamp extends UDF {

	//CAST(FROM_UNIXTIME(UNIX_TIMESTAMP(convMMM(request_time), '[dd/MMM/yyyy:HH:mm:ss Z]')) AS TIMESTAMP) as request_time_converted
	public Integer evaluate (String input, String format) {
		if ( input == null ) {
			return null;
		}

		SimpleDateFormat dt = new SimpleDateFormat(format,Locale.US);

		Date outputDate = new Date();
		try {
			outputDate = dt.parse(input);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Long unixTimestamp = outputDate.getTime() / 1000;
		//System.out.println(input + "=>" + unixTimestamp.toString());
		return unixTimestamp.intValue();
	}
}