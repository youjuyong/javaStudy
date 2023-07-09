package DataCalendarStudy;

import java.util.Calendar;

public class CalendarEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Calendar today = Calendar.getInstance();
		final int YEAR = Calendar.YEAR;
		
		
		System.out.println("이해의 연도 : " + today.get(YEAR));
		System.out.println("월 (0~11, 0:1월) : " + today.get(Calendar.MONTH));
		System.out.println("이해의 몇째 주 : " + today.get(Calendar.WEEK_OF_YEAR));
		
		System.out.println("이달의 몇 째 주:" + today.get(Calendar.WEEK_OF_MONTH));
		System.out.println("이달의 몇 일 : " + today.get(Calendar.DATE));
		System.out.println("이해의 몇 일 : " + today.get(Calendar.DAY_OF_YEAR));
		System.out.println("이주의 몇 일 : " + today.get(Calendar.DAY_OF_WEEK));
		
		System.out.println("오전_오후 (0: 오전, 1:오후) : " + today.get(Calendar.AM_PM));
		
		System.out.println("이 달의 마지막 날 : " + today.getActualMaximum(Calendar.DATE));
		
		// getInstance() 를 통해서 얻은 인스턴스는 기본적으로 현재 시스템의 날짜와 시간에 대한 정보를 담고 있다.
		// 원하는 시간 날짜를 설정하려면 set메서드를 사용한다.
		
		final String[] DAY_OF_WEEK = {"", "일", "월", "화", "수", "목", "금", "토"};
		
		Calendar date1 = Calendar.getInstance();
		Calendar date2 = Calendar.getInstance();
		
		date1.set(2015, 7, 15);
		System.out.println("date1은 " + toString(date1) + " " + DAY_OF_WEEK[date2.get(Calendar.DAY_OF_WEEK)] + " 요일");
		
		long difference = (date2.getTimeInMillis() - date1.getTimeInMillis()) / (24*60*60);
		
		System.out.println("date2 와 date1의 차이는 : " + difference + "입니다." );
		
		
		Calendar date3 = Calendar.getInstance();
		
		System.out.println(toString(date3));
		System.out.println("= 1일 후 = ");
		date3.add(Calendar.DATE, 1);
		System.out.println(toString(date3));
		
		System.out.println("=6달전 =");
		date3.add(Calendar.MONTH, -6);
		System.out.println(toString(date3));
	
	}
	
	public static String toString (Calendar value) {
		return value.get(Calendar.YEAR) + "년 " + (value.get(Calendar.MONTH) + 1)  + "월 " + value.get(Calendar.DATE) +"일 ";
	}
}
