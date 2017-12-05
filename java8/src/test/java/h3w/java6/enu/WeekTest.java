package h3w.java6.enu;

import org.junit.Test;

import h3w.java6.enu.Week;

import static java.lang.System.*;

public class WeekTest {

	/**
	 * 与常量类相比较,枚举类型可以携带多个值.
	 * 本例中,MON可以关联"星期一"和"Monday"两个值.
	 * 这是枚举类型的一个优势.
	 * 
	 * 枚举类型还可以配合switch语句使用.
	 * 从java1.7开始,switch语句支持String类型.
	 * 
	 * @author hanjiyuan.zh
	 * @since 2017-11-11 22:30:46
	 */
	@Test
	public void test() {
		Week day = Week.MON;
		switch (day) {
		case MON:
			break;
		case TUES:
			out.println(day.getUsDay());
			break;
		case WED:
			out.println(day.getUsDay());
			break;
		case THUR:
			out.println(day.getUsDay());
			break;
		case FRI:
			out.println(day.getUsDay());
			break;
		case SAT:
			out.println(day.getUsDay());
			break;
		case SUN:
			out.println(day.getUsDay());
			break;
		}
	}
	
	/**
	 * 枚举类型除了从Enum继承的方法(比如values)外,
	 * 还可自定义方法,这让代码看起来更加优雅,
	 * 也是优于常量类的地方.
	 * 
	 * @author hanjiyuan.zh
	 * @since 2017-11-11 22:42:31
	 */
	
	@Test
	public void testTravers() {
		for (Week w : Week.values()) {
			out.println(w);
			out.println(w.ordinal());
		}
		out.println(Week.FRI.compareTo(Week.MON));
	}
}
