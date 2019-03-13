package app.metatron.hiveudf;

import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.exec.UDF;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ConvertMMM extends UDF {

	//CAST(FROM_UNIXTIME(UNIX_TIMESTAMP(convMMM(request_time), '[dd/MMM/yyyy:HH:mm:ss Z]')) AS TIMESTAMP) as request_time_converted
	public String evaluate (String input) {
		if ( input == null ) {
			return null;
		}

		String lang = System.getProperty("user.language");
		String output = new String(input);

		//System.out.println("system language = "+ lang);

		if ( lang.equals("ko") ) {
			output = output.replace("Jan", "1월");
			output = output.replace("Feb", "2월");
			output = output.replace("Mar", "3월");
			output = output.replace("Apr", "4월");
			output = output.replace("May", "5월");
			output = output.replace("Jun", "6월");
			output = output.replace("Jul", "7월");
			output = output.replace("Aug", "8월");
			output = output.replace("Sep", "9월");
			output = output.replace("Oct", "10월");
			output = output.replace("Nov", "11월");
			output = output.replace("Dec", "12월");
		}

		//System.out.println(input + "=>" + output);

		return output;
	}

}