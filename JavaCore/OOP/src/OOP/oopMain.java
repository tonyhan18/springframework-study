package OOP;

public class oopMain {
	
	private int day;
	
	public static int addNum(int num1, int num2)
	{
		int result;
		
		result = num1 + num2;
		return result;
	}
	
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}



	public static void main(String[] args) {
		// project > Build Automatically 설정 필수
		int n1 = 10;
		int n2 = 20;
		
		int total = addNum(n1, n2);
		System.out.println(total);
		
		MakeReport report = new MakeReport();
		System.out.println(report.getReport());
	}
}
