package app.metatron.hiveudf;

import org.apache.hadoop.hive.ql.exec.UDF;

public class RealtyMakeAddr extends UDF {

		public Integer evaluate (String priceStr, Integer unit) {
		if ( priceStr == null ) {
			return null;
		}

		priceStr = priceStr.replaceAll(",","").trim();
		Integer price = Integer.parseInt(priceStr);

		Integer output = price * unit;

		//System.out.println(output.toString());
		return output.intValue();
	}
}