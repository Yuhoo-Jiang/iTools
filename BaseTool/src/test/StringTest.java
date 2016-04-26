import com.itools.string.iStringUtils;
import org.junit.Test;

/**
 * 作者：蒋祖兵
 * 描述：
 * 时间： 2016/4/26.
 */

public class StringTest {
    @Test
    public void testStringEmpty(){
        String str = null;
        System.out.println("string is null:" + iStringUtils.isEmpty(str));

        str = "";
        System.out.println("string is null:" + iStringUtils.isEmpty(str));

        str = "test";
        System.out.println("string is null:" + iStringUtils.isEmpty(str));

    }
}
