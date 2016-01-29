/*
# Management Ŭ���� #

- �л� ������ �����ϴ� Ŭ����
- �޼ҵ� : �����, ����, ����, �߰�, ���� ���
*/


import java.util.*;

class Management{	
	private int cSize;	// �迭 ũ��
	private int number;	// ���� �Էµ� �л���
	private Student[] s;	// ���� ������ Ŭ���� �迭

	Scanner scan = new Scanner(System.in);

	
	// �Է� �޴� ����
	int input;
	String inputstr;

	Management(){
		cSize=0;
		number = 0;
	}

	// - �ʱ� ���� -
	// ó�� ������ �� �迭 ũ�⸦ �Ҵ� ���ֱ� ����
	void init(){
		System.out.println("\n\n\t       <�л� ���� ���� ���α׷�>");
		System.out.println("\t       ���������ʱ� ������������");
		System.out.print("\t\t - ��� ���� �ο� : ");

		cSize = scan.nextInt();
		s = new Student[cSize];
	}

	// - �޴� ǥ�� -
	void showList(){
		System.out.println("\n\n\t  ������������������������������������");
		System.out.println("\t  ��\t  ��� ���� �ο� : "+ cSize + "\t    ��");
		System.out.println("\t  ������������������������������������");
		System.out.println("\t  ��\t1. �л� ���� ���\t    ��");
		System.out.println("\t  ��\t2. ������ �л� ���� ��ȸ    ��");
		System.out.println("\t  ��\t3. ��ȣ�� �л� ���� ��ȸ    ��");	
		System.out.println("\t  ��\t4. �л� �� ��ȸ\t    ��");
		System.out.println("\t  ��\t5. ��� �ο� �߰�\t    ��");
		System.out.println("\t  ��\t6. ����\t\t\t    ��");
		System.out.println("\t  ��\t7. ����\t\t\t    ��");
		System.out.println("\t  ������������������������������������");
		System.out.println("\t  ��\t    ��ϵ� �ο� : " + (number)+"\t    ��");
		System.out.println("\t  ��\t     ���� ���� : " + (cSize-number)+"\t    ��");
		System.out.println("\t  ������������������������������������");
		System.out.println();
	}


	// �޴� ���� -
	int selectList(){
		// �Է¹��� �� ������ �ܿ� ���� �ԷµǸ� InputMismatchException �߻�.
		// ������ �߻��ϸ� catch�� ���� ����.
		try{
			System.out.print("\t\t- ���� : ");
			input = scan.nextInt();

		} catch(InputMismatchException e){
			System.out.println("\n\t\t���ڸ� �Է��ϼ���!\n");
			scan.nextLine();	// nextInt()�� ���� ���� ���๮�� ó��
			selectList();	// �ٽ� �޴� ���� �޼ҵ� ����
		}
		return input;	// ������ switch���� ����ϱ� ���� ��ȯ
	}

	// �л� ���� �Է�
	void insertInfo(){
		int size;	// ���ϴ� Ƚ����ŭ �Է� �ޱ� ����
		if(number>=cSize){	// ���� �Ҵ�� �迭���� �Էµ� �ο��� �������� �ʱ� ���ؼ�
			System.out.println("\n\t\t�Է��� �� �ִ� �ο��� �ʰ��߽��ϴ�!");
		}
		else{
			try{
				System.out.print("\n\t\t�Է��� �л��� �� : ");
				size = scan.nextInt();
				if(size>cSize){	// �Ҵ�� �迭���� ũ�� �迭�ε��� ���� �߻�
					System.out.println("\n\t\t��� ���� �ο��� �ʰ��߽��ϴ�!");
					return;
				}
			}catch(InputMismatchException e){
				System.out.println("\n\t\t���ڸ� �Է��ϼ���!\n");
				scan.nextLine();

				insertInfo();
				return;
			}


			// ����, ����, ���� ������ �Է¹޾Ƽ� �ش� �迭�� ������ �ʱ�ȭ
			for(int i=0; i<size; i++){
				int kor, eng, math;
				System.out.println("\n\t\t[ "+(number+1)+" �� �л� ]");

				System.out.print("\t\t- �̸� : ");
				inputstr = scan.nextLine();	// nextLine()�� �ϳ��� ������ �տ��� nextInt()�� �Է��ϰ� ���� 
				inputstr = scan.nextLine();	// \n(���๮��)�� �ԷµǼ� �ǳʶ�. �װ� ���� �ֱ� ���� nextLine()�� �ѹ��� ���




				try{
					System.out.print("\t\t- ���� : ");
					kor = scan.nextInt();
					
					System.out.print("\t\t- ���� : ");
					eng = scan.nextInt();
					
					System.out.print("\t\t- ���� : ");
					math = scan.nextInt();
					
				} catch(InputMismatchException e){
					// ������ �̿� ���� �ԷµǸ� �ٽ� ���Է�
					System.out.println("\n\t\t���ڸ� �Է��ϼ���!\n");
					i--;
					continue;
				}

				s[number] = new Student(number+1, inputstr, kor, eng, math); 	// �Ű����� �����ڷ� �ν��Ͻ������� �� �Է�

				// �Է� �ߵƴ��� Ȯ��
				System.out.println("\t\t��ȣ\t�̸�\t����\t����\t����\t����\t���");
				System.out.printf("\t\t%3d\t%7s\t%3d\t%3d\t%3d\t%d\t%.2f", s[number].getNum(), s[number].getName(), s[number].getKor(), s[number].getEng(), s[number].getMath(), s[number].getTotal(), s[number].getAverage());
				number++;
			}
		}

		// �л� �Է��ϰ��� �������ϱ�
		countRank();
	}


	// - ��ȣ�� ��� - 
	// ��¸޼ҵ� ����  ���ο��� ��ȣ���� �迭�� �������ش�.
	void showGradeByNum(){
		// �迭�� �ƹ��͵� ���� ��
		if(number == 0){
			System.out.println("\n\t\t�Էµ� ������ �����ϴ�!");
			return;
		}

		System.out.println("\n\n\n\t\t   <��ȣ�� �л� ���� ��ȸ>");
		System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���\t����");
		for(int i=0; i<number; i++){
			System.out.printf("%3d%7s\t%3d\t%3d\t%3d\t%d\t%.2f\t%3d\n", s[i].getNum(), s[i].getName(), s[i].getKor(), s[i].getEng(), s[i].getMath(), s[i].getTotal(), s[i].getAverage(), s[i].getRank());
		}
		System.out.println("\n\n\n");
	}

	// - ������ ��� -
	// ��¸޼ҵ� ���� ���ο��� �������� �迭�� �������ش�.
	void showGradeByRank(){
		// �迭�� �ƹ��͵� ���� ��
		if(number == 0){
			System.out.println("\n\t\t�Էµ� ������ �����ϴ�!");
			return;
		}

		System.out.println("\n\n\n\t\t   <������ �л� ���� ��ȸ>");
		System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���\t����");
		for(int i=0; i<number; i++){
			System.out.printf("%3d%7s\t%3d\t%3d\t%3d\t%d\t%.2f\t%3d\n", s[i].getNum(), s[i].getName(), s[i].getKor(), s[i].getEng(), s[i].getMath(), s[i].getTotal(), s[i].getAverage(), s[i].getRank());
		}
		System.out.println("\n\n\n");
	}

	// �� ���� ��ȸ
	void showGradeInDetail(){
		// �迭�� �ƹ��͵� ���� ��
		if(number == 0){
			System.out.println("\n\t\t�Էµ� ������ �����ϴ�!");
			return;
		}

		
		try{
			System.out.println("\t\t\t- 1 : �̸� ��ȸ");
			System.out.println("\t\t\t- 2 : ��ȣ ��ȸ");
			System.out.print("\t\t\t\t- ���� : ");
			input = scan.nextInt();
		}catch(InputMismatchException e){
			System.out.println("\n\t\t���ڸ� �Է��ϼ���!\n");
			scan.nextLine();

			showGradeInDetail();
			return;
		}


		switch(input){
			case 1:	// �̸� ��ȸ
			boolean isName = false;	// ��ġ�ϴ� �̸��� �ִ��� ������ Ȯ���ϴ� �뵵

			System.out.print("\t\t\t\t- ��ȸ�� �̸� : ");
			inputstr = scan.nextLine();
			inputstr = scan.nextLine();
			
			for(int i=0; i<number; i++){
				if(inputstr.equals(s[i].getName())){	// �Է¹��� ���� �迭���� ���ؼ� ��ġ�ϴ��� Ȯ��
					System.out.println("\n\n��ȣ\t�̸�\t����\t����\t����\t����\t���\t����");
					System.out.printf("%3d%7s\t%3d\t%3d\t%3d\t%d\t%.2f\t%3d", s[i].getNum(), s[i].getName(), s[i].getKor(), s[i].getEng(), s[i].getMath(), s[i].getTotal(), s[i].getAverage(), s[i].getRank());
					System.out.println("\n\n\n");
					isName = true;	// ��ġ �ϴ� ���� �ֱ� ������ true�� �ٲ�
				}
			}
			
			if(isName == false){	// ��ġ�ϴ� ���� ���� ��� ����
				System.out.println("\t\t\t\t��ġ�ϴ� �̸��� �����ϴ�!");
			}
			break;

			case 2:	// ��ȣ ��ȸ
			try{
				System.out.print("\t\t\t\t- ��ȸ�� ��ȣ : ");
				input = scan.nextInt();
			}catch(InputMismatchException e){
				System.out.println("\n\t\t���ڸ� �Է��ϼ���!\n");
				scan.nextLine();

				showGradeInDetail();
				return;
			}

			
			if(input>number){		// ��ȸ�� ��ȣ�� ���� �迭�� ����ִ� �ε��������� Ŭ ��� 
				System.out.println("\n\t\t��ȸ�� ����� �����ϴ�\n");
				return;
			}

			System.out.println("\n\n\t\t   <"+input + " �� �л��� ����>");
			System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���\t����");
			System.out.printf("%3d%7s\t%3d\t%3d\t%3d\t%d\t%.2f\t%3d", s[input-1].getNum(), s[input-1].getName(), s[input-1].getKor(), s[input-1].getEng(), s[input-1].getMath(), s[input-1].getTotal(), s[input-1].getAverage(), s[input-1].getRank());
			System.out.println("\n\n\n");

		}
	}

	
	/*
	# countRank() ���� #

	1. ó���� ��� �迭�� Rank���� 1�� �ʱ�ȭ
	2. ���� for���� ���� ��հ��� ���� ��
	3. �ڽź��� ū ��հ��� ������ Rank���� +1
	*/
	void countRank(){
		// rank = 1�� �ʱ�ȭ
		for(int i=0; i<number; i++){
			s[i].setRank(1);
		}

		// ��
		for(int i=0; i<number; i++){
			for(int j=0; j<number; j++){
				if(i==j)	// �ڱ� �ε����� �ǳʶٱ� ���ؼ�
					continue;
				else{	// ��հ� ���ؼ� �ڱ⺸�� Ŭ ��� rank +1
					if(s[i].getAverage()<s[j].getAverage())	
						s[i].setRank(s[i].getRank()+1);
				}

			}

		}
	}

	// ��ȣ���� �迭 ����
	void sortByNum(){
		Student temp; //  swap�� ���� �������� �ӽ÷� ������ ����

		for(int i=0; i<number-1; i++){	// ���� ����
			int min = i;
			for(int j=i+1; j<number; j++){
				if(s[i].getNum()>s[j].getNum()){	
					temp = s[i];
					s[i] = s[j];
					s[j] = temp;
				}
			}

		}
	}

	// �������� �迭 ����
	void sortByRank(){
		Student temp;	 //  swap�� ���� �������� �ӽ÷� ������ ����

		for(int i=0; i<number-1; i++){	// ���� ����
			int min = i;
			for(int j=i+1; j<number; j++){
				if(s[i].getAverage()<s[j].getAverage()){
					temp = s[i];
					s[i] = s[j];
					s[j] = temp;
				}
			}
		}
	}

	// - ��� �ο� ���� -
	// �ӽ÷� ������ �ν��Ͻ��� ������ ��, ������ ������ �������� 
	void changePeople(){
		Student[] temp = new Student[cSize];	// �ӽ÷� ������ �ν��Ͻ� �迭 ����

		for(int i=0; i<number;i++){	// ����� ���� �ӽ� �ν��Ͻ� �迭�� ����
			temp[i] = s[i];
		}

		System.out.print("\t\t   - ��� �ο� �߰� : ");
		input = scan.nextInt();
		cSize += input;

		s = new Student[cSize];	// �ο��� ���� ��, ũ�⸦ ������Ŵ

		for(int i=0; i<number;i++){	// �ٽ� �� ����
			s[i] = temp[i];
		}
	}	



	void showSelectDelete(){
		System.out.println("\n\t\t\t 1. ���� ����");
		System.out.println("\t\t\t 2. ��� ����");
		System.out.println("\t\t\t 3. ó������");
	}

	// - �� ����
	// �ڹٿ����� �ν��Ͻ��� �����ϴ� ���������� ���� ��� ���� �ð� ��
	// �������÷��Ϳ� ���� �޸𸮸� �����Ѵ�
	void deleteInfo(){
		try{
			System.out.print("\t\t\t - ���� : ");
			input = scan.nextInt();
	
		} catch(InputMismatchException e){
			System.out.println("\n\t\t���ڸ� �Է��ϼ���!\n");
			scan.nextLine();

			deleteInfo();
		}

		switch(input){
			case 1:	// ������ ��ȣ ����
			System.out.print("\t\t\t\t - ������ ��ȣ �Է� : ");
			input = scan.nextInt();

			// ������ ��ȣ�� ���������� �ٷ� ���� ��ȣ�� �������� �ش�.
			// ex) 5��° ���� �����Ѵٸ� s[4]�� s[5]�� �������� �ش�.
			// 	s[5]�� s[6]�� ������ ... �ݺ�
			for(int i=input-1; i<number-1; i++){	// �ݺ����� ������ ��ȣ���� ���� ����ִ� �迭������ �ݺ�
				s[i]=s[i+1];	
				s[i].setNum(i+1);			
			}
			number--;

			System.out.println("\t\t\t\t"+input+ " ��° ����!!");

			countRank();	// ���� �� ���� �ٽ� ����
			break;

			case 2:	// ��ü ����
			s = new Student[cSize];	// ���� ������ ��ŭ �ٽ� �迭 �Ҵ�
			number = 0;
			System.out.println("\t\t\t��� �������!!");
			break;

			case 3:
			System.out.println("\t\t\tó������!");
			return;
		}
	}
}