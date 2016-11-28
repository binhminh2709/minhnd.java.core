/**
 * 
 */

package math.bigdecimal;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * @author BinhMinh
 *
 */
public class BigDecimalBasic {
  
  /**
   * @param args
   */
  public static void main(String[] args) {
    
    BigDecimal bd = new BigDecimal(300000000);
    
    NumberFormat formatter = NumberFormat.getInstance(new Locale("en_US"));
    System.out.println(formatter.format(bd.longValue()));
    
    DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();
    symbols.setGroupingSeparator('.');
    DecimalFormat dformat = new DecimalFormat("###,###,###,###.##", symbols);
    System.out.println(dformat.format(bd.longValue()));
  }
  
}
