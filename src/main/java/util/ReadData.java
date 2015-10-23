package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by CHester on 15/10/15.
 */
public class ReadData {
    /**
     * 从Console当前行读取字符串
     * @return 当前Console中的字符串
     */
    public static String readDataFromConsole() {
        /**
         * 方法readDataFromConsole的功能描述:
         * 从Console当前行读取字符串
         * @param []
         * @return java.lang.String
         * @throws
         *
         * <PRE>
         * @author CHester
         * @date 15/10/15
         * </PRE>
         */
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String string = null;
        try {
            string = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return string;
    }
}
