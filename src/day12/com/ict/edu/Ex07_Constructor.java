package day12.com.ict.edu;

public class Ex07_Constructor {
	// 생성자는 다른 생성자를 호출 할 수 있다.
	// 생성자는 다른 메서드를 호출 할 수 있다.
	// 메서드는 자기를 호출 한 곳으로 되돌아감. 메서드는 다른 메서드를 호출 할 수 있음
	private String name = "홍길동";
	private int kor = 90;
	private int eng = 80;
	private int math = 80;
	private int sum = 0;
	private double avg = 0.0;
	private String hak = "";
	
	
	public Ex07_Constructor() { // 생성자
		// 생성자가 다른 생성자 호출 할 수 있다. ***무조건 첫째줄에서 호출해야됨. 생성자 이름을 쓰면 안됨 @@!!!!!!

	}
	
	public Ex07_Constructor(String name) {
		this(70, 80, 70); //생성자가 다른 생성자 호출 ~~! >> ***무조건 첫째줄에서 호출해야됨. 생성자 이름을 쓰면 안됨 @@!!!!!! 
		this.name = name; // 이름 대신 this() @@@!!!!!!!!!
		
	}
	
	public Ex07_Constructor(int kor,int eng,int math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		
	}
	// 총점 구하기
	public void gSum(int kor, int eng, int math){
		sum = kor+eng+math;
		
	}
	
	public void gSum() {
		sum = kor+eng+math;
	}
	
	// 평균 구하기
	public void gAvg() {
		avg = (int)((sum/3.0*10)/10.0);
		
	}
	// 학점 구하기
	public void gHak() {
		if(avg>=90) {
			hak = "A학점";
		}else if(avg>=80) {
			hak = "B학점";
	}else if(avg>=70) {
		hak = "C학점";
	} else {
		hak = "F학점";
	}
		
	}
	//출력하는 메서드
		public void gPrn() {
			System.out.println("이름: " + name);
			System.out.println("총점: " + sum);
			System.out.println("평균: " + avg);
			System.out.println("학점: " + hak);
		}
	
		
		
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public String getHak() {
		return hak;
	}
	public void setHak(String hak) {
		this.hak = hak;
	}
	
}
