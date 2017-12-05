package h3w.web.util;

import org.junit.Test;
import static java.lang.System.*;

import java.io.IOException;

public class HttpWebUtilTest {

	@Test
	public void test() {
		try {
			out.println(HttpWebUtil.getWebContent("www.baidu.com", "utf-8", 10000));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}