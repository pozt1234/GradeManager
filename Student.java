/*
# Student Ŭ���� #

- �л��� ���� (��ȣ, �̸�, ��������, ����, ���, ����)�� ���� �ϴ� Ŭ����
- �޼ҵ� : �л��� ������ ����, �ٸ� Ŭ������ ������ ��ȯ���ִ� ���
*/

class Student{
	private int num;

	private String name;
	private int kor;
	private int eng;
	private int math;

	private int total;
	private double average;

	private int rank;

	Student(){

	}
	Student(int num, String name, int kor, int eng, int math){
		this.num = num;
		this.name = name;
 		this.kor = kor;
 		this.eng = eng;
 		this.math = math;

 		total = (kor+eng+math);
 		average = (double)total/3;
	}

	// ��ȣ
	int getNum(){
		return num;
	}
	void setNum(int num){
		this.num = num;
	}

	// �̸�, ����, ����, ����
	String getName(){
		return name;
	}
	int getKor(){
		return kor;
	}
	int getEng(){
		return eng;
	}
	int getMath(){
		return math;
	}

	// ����
	int getTotal(){
		return total;
	}

	// ���
	double getAverage(){
		return average;
	}

	// ����
	int getRank(){
		return rank;
	}
	void setRank(int rank){
		this.rank = rank;
	}
}
