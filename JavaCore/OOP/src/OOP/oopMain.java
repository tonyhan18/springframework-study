package OOP;

import java.util.ArrayList;

class Book
{
	String title;
	String author;
	
	public Book(String string, String string2)
	{
		this.title = string;
		this.author = string2;
	}
}

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
		
		// ctrl + shift + o => 필요한 라이브러리 추가 및 필요 없는거 삭제
		ArrayList<Book> library = new ArrayList<Book>();
		library.add(new Book("태백산맥", "조정래"));
		
		
		for(int i = 0 ; i < library.size() ; i++)
		{
			System.out.println(library);
		}
	}
}
