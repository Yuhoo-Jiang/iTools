import com.itools.file.FileHelper;
import org.junit.Test;

import java.io.IOException;

/**
 * 作者：蒋祖兵
 * 描述：
 * 时间： 2016/4/27.
 */
public class FileHelperTest {
    @Test
    public void testWriteString2File(){
        try {
            FileHelper.createFile("d:/temp/","myFile.txt","我们都是中国人，钓鱼岛是中国的!!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
