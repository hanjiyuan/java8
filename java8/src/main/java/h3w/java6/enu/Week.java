package h3w.java6.enu;

public enum Week implements IHello{
	
	SUN	("星期日",	"Sunday"),
	MON	("星期一",	"Monday"),
	TUES("星期二",	"Tuesday"),
	WED	("星期三",	"Wednesday"),
	THUR("星期四",	"Thursday"),
	FRI	("星期五",	"Friday"),
	SAT	("星期六",	"Saturday");
	
	
	private String cnDay;
	private String usDay;
	
	private Week(String cnDay, String usDay) {
		this.cnDay = cnDay;
		this.usDay = usDay;
	}

	public String getCnDay() {
		return cnDay;
	}

	public String getUsDay() {
		return usDay;
	}
	
	@Override
	public String toString() {
		return "English is " + usDay + ", 中文是" + cnDay;
	}
	
	public void h(){
	}
}
