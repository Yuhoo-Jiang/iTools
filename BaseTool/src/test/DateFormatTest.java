import com.itools.date.iDateFormat;
import org.junit.Test;

import java.util.Date;

/**
 * 作者：蒋祖兵
 * 描述：
 * 时间： 2016/4/26.
 */
public class DateFormatTest {
    @Test
    public void testDateFormat(){
        System.out.println(iDateFormat.format(new Date(),null));
        System.out.println(iDateFormat.format(System.currentTimeMillis(),null));
        System.out.println(iDateFormat.format(System.currentTimeMillis(),iDateFormat.FORMAT_YYYYMMMDDHHMMSS));
        System.out.println("Util format: " + iDateFormat.format(System.currentTimeMillis(),"yyyyMMdd"));
    }
}
