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

    @Test
    public void testStringFormat(){
        System.out.println(iStringUtils.formatString("我有{0}个宝宝，他们的名字:{1},{2}","1","Yuhoo","Lucy"));
    }
}
