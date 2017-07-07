package Chapter4_LoopsFiles.workshop3;

import java.text.DecimalFormat;

/**
 *
 */
public class AboutDecimalFormat {

    public static void main(String[] args) {


        DecimalFormat df1 = new DecimalFormat(".00");
        assert "1234.50".equals(df1.format(1234.5));

        DecimalFormat df2 = new DecimalFormat(".##");
        assert "1234.5".equals(df2.format(1234.5));

        DecimalFormat df3 = new DecimalFormat(".00");
        assert "1234.57".equals(df3.format(1234.5678));

        DecimalFormat df4 = new DecimalFormat(".##");
        assert "1234.57".equals(df4.format(1234.5678));

        DecimalFormat df5 = new DecimalFormat("$0");
        assert "$1238".equals(df5.format(1237.5));

        DecimalFormat df6 = new DecimalFormat("$#");
        assert "$1238".equals(df6.format(1237.5));

        DecimalFormat df7 = new DecimalFormat("$0,000");
        assert "$1,237,898".equals(df7.format(1237898.5));

        DecimalFormat df8 = new DecimalFormat("$#,###");
        assert "$1,237,898".equals(df8.format(1237898.5));

        DecimalFormat df9 = new DecimalFormat("$0,000.");
        assert "$1,237,898.".equals(df9.format(1237898.5));

        DecimalFormat df10 = new DecimalFormat("$#,###.");
        assert "$1,237,898.".equals(df10.format(1237898.5));
    }
}
