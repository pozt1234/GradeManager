/*
# Management 클래스 #

- 학생 성적을 관리하는 클래스
- 메소드 : 입출력, 정렬, 순위, 추가, 삭제 기능
*/


import java.util.*;

class Management{	
	private int cSize;	// 배열 크기
	private int number;	// 현재 입력된 학생수
	private Student[] s;	// 점수 저장할 클래스 배열

	Scanner scan = new Scanner(System.in);

	
	// 입력 받는 변수
	int input;
	String inputstr;

	Management(){
		cSize=0;
		number = 0;
	}

	// - 초기 시작 -
	// 처음 시작할 때 배열 크기를 할당 해주기 위함
	void init(){
		System.out.println("\n\n\t       <학생 성적 관리 프로그램>");
		System.out.println("\t       ────초기 설정────");
		System.out.print("\t\t - 등록 가능 인원 : ");

		cSize = scan.nextInt();
		s = new Student[cSize];
	}

	// - 메뉴 표시 -
	void showList(){
		System.out.println("\n\n\t  ┌────────────────┐");
		System.out.println("\t  │\t  등록 가능 인원 : "+ cSize + "\t    │");
		System.out.println("\t  ├────────────────┤");
		System.out.println("\t  │\t1. 학생 성적 등록\t    │");
		System.out.println("\t  │\t2. 순위별 학생 성적 조회    │");
		System.out.println("\t  │\t3. 번호별 학생 성적 조회    │");	
		System.out.println("\t  │\t4. 학생 상세 조회\t    │");
		System.out.println("\t  │\t5. 등록 인원 추가\t    │");
		System.out.println("\t  │\t6. 삭제\t\t\t    │");
		System.out.println("\t  │\t7. 종료\t\t\t    │");
		System.out.println("\t  ├────────────────┤");
		System.out.println("\t  │\t    등록된 인원 : " + (number)+"\t    │");
		System.out.println("\t  │\t     남은 공간 : " + (cSize-number)+"\t    │");
		System.out.println("\t  └────────────────┘");
		System.out.println();
	}


	// 메뉴 선택 -
	int selectList(){
		// 입력받을 때 정수형 외에 값이 입력되면 InputMismatchException 발생.
		// 에러가 발생하면 catch문 블럭이 실행.
		try{
			System.out.print("\t\t- 선택 : ");
			input = scan.nextInt();

		} catch(InputMismatchException e){
			System.out.println("\n\t\t숫자를 입력하세요!\n");
			scan.nextLine();	// nextInt()를 쓰고 남은 개행문자 처리
			selectList();	// 다시 메뉴 선택 메소드 실행
		}
		return input;	// 메인의 switch문이 사용하기 위해 반환
	}

	// 학생 정보 입력
	void insertInfo(){
		int size;	// 원하는 횟수만큼 입력 받기 위해
		if(number>=cSize){	// 현재 할당된 배열보다 입력된 인원이 많아지지 않기 위해서
			System.out.println("\n\t\t입력할 수 있는 인원을 초과했습니다!");
		}
		else{
			try{
				System.out.print("\n\t\t입력할 학생의 수 : ");
				size = scan.nextInt();
				if(size>cSize){	// 할당된 배열보다 크면 배열인덱스 에러 발생
					System.out.println("\n\t\t등록 가능 인원을 초과했습니다!");
					return;
				}
			}catch(InputMismatchException e){
				System.out.println("\n\t\t숫자를 입력하세요!\n");
				scan.nextLine();

				insertInfo();
				return;
			}


			// 국어, 영어, 수학 점수를 입력받아서 해당 배열의 생성자 초기화
			for(int i=0; i<size; i++){
				int kor, eng, math;
				System.out.println("\n\t\t[ "+(number+1)+" 번 학생 ]");

				System.out.print("\t\t- 이름 : ");
				inputstr = scan.nextLine();	// nextLine()이 하나만 있으면 앞에서 nextInt()를 입력하고 남은 
				inputstr = scan.nextLine();	// \n(개행문자)가 입력되서 건너뜀. 그걸 막아 주기 위해 nextLine()을 한번더 사용




				try{
					System.out.print("\t\t- 국어 : ");
					kor = scan.nextInt();
					
					System.out.print("\t\t- 영어 : ");
					eng = scan.nextInt();
					
					System.out.print("\t\t- 수학 : ");
					math = scan.nextInt();
					
				} catch(InputMismatchException e){
					// 정수형 이외 값이 입력되면 다시 재입력
					System.out.println("\n\t\t숫자를 입력하세요!\n");
					i--;
					continue;
				}

				s[number] = new Student(number+1, inputstr, kor, eng, math); 	// 매개변수 생성자로 인스턴스변수에 값 입력

				// 입력 잘됐는지 확인
				System.out.println("\t\t번호\t이름\t국어\t영어\t수학\t총점\t평균");
				System.out.printf("\t\t%3d\t%7s\t%3d\t%3d\t%3d\t%d\t%.2f", s[number].getNum(), s[number].getName(), s[number].getKor(), s[number].getEng(), s[number].getMath(), s[number].getTotal(), s[number].getAverage());
				number++;
			}
		}

		// 학생 입력하고나면 순위정하기
		countRank();
	}


	// - 번호별 출력 - 
	// 출력메소드 전에  메인에서 번호별로 배열을 정렬해준다.
	void showGradeByNum(){
		// 배열에 아무것도 없을 때
		if(number == 0){
			System.out.println("\n\t\t입력된 정보가 없습니다!");
			return;
		}

		System.out.println("\n\n\n\t\t   <번호별 학생 성적 조회>");
		System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균\t순위");
		for(int i=0; i<number; i++){
			System.out.printf("%3d%7s\t%3d\t%3d\t%3d\t%d\t%.2f\t%3d\n", s[i].getNum(), s[i].getName(), s[i].getKor(), s[i].getEng(), s[i].getMath(), s[i].getTotal(), s[i].getAverage(), s[i].getRank());
		}
		System.out.println("\n\n\n");
	}

	// - 순위별 출력 -
	// 출력메소드 전에 메인에서 순위별로 배열을 정렬해준다.
	void showGradeByRank(){
		// 배열에 아무것도 없을 때
		if(number == 0){
			System.out.println("\n\t\t입력된 정보가 없습니다!");
			return;
		}

		System.out.println("\n\n\n\t\t   <순위별 학생 성적 조회>");
		System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균\t순위");
		for(int i=0; i<number; i++){
			System.out.printf("%3d%7s\t%3d\t%3d\t%3d\t%d\t%.2f\t%3d\n", s[i].getNum(), s[i].getName(), s[i].getKor(), s[i].getEng(), s[i].getMath(), s[i].getTotal(), s[i].getAverage(), s[i].getRank());
		}
		System.out.println("\n\n\n");
	}

	// 상세 정보 조회
	void showGradeInDetail(){
		// 배열에 아무것도 없을 때
		if(number == 0){
			System.out.println("\n\t\t입력된 정보가 없습니다!");
			return;
		}

		
		try{
			System.out.println("\t\t\t- 1 : 이름 조회");
			System.out.println("\t\t\t- 2 : 번호 조회");
			System.out.print("\t\t\t\t- 선택 : ");
			input = scan.nextInt();
		}catch(InputMismatchException e){
			System.out.println("\n\t\t숫자를 입력하세요!\n");
			scan.nextLine();

			showGradeInDetail();
			return;
		}


		switch(input){
			case 1:	// 이름 조회
			boolean isName = false;	// 일치하는 이름이 있는지 없는지 확인하는 용도

			System.out.print("\t\t\t\t- 조회할 이름 : ");
			inputstr = scan.nextLine();
			inputstr = scan.nextLine();
			
			for(int i=0; i<number; i++){
				if(inputstr.equals(s[i].getName())){	// 입력받은 값과 배열값을 비교해서 일치하는지 확인
					System.out.println("\n\n번호\t이름\t국어\t영어\t수학\t총점\t평균\t순위");
					System.out.printf("%3d%7s\t%3d\t%3d\t%3d\t%d\t%.2f\t%3d", s[i].getNum(), s[i].getName(), s[i].getKor(), s[i].getEng(), s[i].getMath(), s[i].getTotal(), s[i].getAverage(), s[i].getRank());
					System.out.println("\n\n\n");
					isName = true;	// 일치 하는 값이 있기 때문에 true로 바꿈
				}
			}
			
			if(isName == false){	// 일치하는 값이 없을 경우 실행
				System.out.println("\t\t\t\t일치하는 이름이 없습니다!");
			}
			break;

			case 2:	// 번호 조회
			try{
				System.out.print("\t\t\t\t- 조회할 번호 : ");
				input = scan.nextInt();
			}catch(InputMismatchException e){
				System.out.println("\n\t\t숫자를 입력하세요!\n");
				scan.nextLine();

				showGradeInDetail();
				return;
			}

			
			if(input>number){		// 조회할 번호가 현재 배열에 들어있는 인덱스값보다 클 경우 
				System.out.println("\n\t\t조회할 대상이 없습니다\n");
				return;
			}

			System.out.println("\n\n\t\t   <"+input + " 번 학생의 성적>");
			System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균\t순위");
			System.out.printf("%3d%7s\t%3d\t%3d\t%3d\t%d\t%.2f\t%3d", s[input-1].getNum(), s[input-1].getName(), s[input-1].getKor(), s[input-1].getEng(), s[input-1].getMath(), s[input-1].getTotal(), s[input-1].getAverage(), s[input-1].getRank());
			System.out.println("\n\n\n");

		}
	}

	
	/*
	# countRank() 순서 #

	1. 처음에 모든 배열의 Rank값을 1로 초기화
	2. 이중 for문을 통해 평균값을 서로 비교
	3. 자신보다 큰 평균값이 있으면 Rank값을 +1
	*/
	void countRank(){
		// rank = 1로 초기화
		for(int i=0; i<number; i++){
			s[i].setRank(1);
		}

		// 비교
		for(int i=0; i<number; i++){
			for(int j=0; j<number; j++){
				if(i==j)	// 자기 인덱스는 건너뛰기 위해서
					continue;
				else{	// 평균값 비교해서 자기보다 클 경우 rank +1
					if(s[i].getAverage()<s[j].getAverage())	
						s[i].setRank(s[i].getRank()+1);
				}

			}

		}
	}

	// 번호별로 배열 정렬
	void sortByNum(){
		Student temp; //  swap을 위해 참조값을 임시로 저장할 변수

		for(int i=0; i<number-1; i++){	// 선택 정렬
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

	// 순위별로 배열 정렬
	void sortByRank(){
		Student temp;	 //  swap을 위해 참조값을 임시로 저장할 변수

		for(int i=0; i<number-1; i++){	// 선택 정렬
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

	// - 등록 인원 변경 -
	// 임시로 저장할 인스턴스를 생성한 뒤, 기존의 값들의 참조값을 
	void changePeople(){
		Student[] temp = new Student[cSize];	// 임시로 저장할 인스턴스 배열 생성

		for(int i=0; i<number;i++){	// 저장된 값을 임시 인스턴스 배열에 저장
			temp[i] = s[i];
		}

		System.out.print("\t\t   - 등록 인원 추가 : ");
		input = scan.nextInt();
		cSize += input;

		s = new Student[cSize];	// 인원을 증가 후, 크기를 증가시킴

		for(int i=0; i<number;i++){	// 다시 값 저장
			s[i] = temp[i];
		}
	}	



	void showSelectDelete(){
		System.out.println("\n\t\t\t 1. 선택 삭제");
		System.out.println("\t\t\t 2. 모두 삭제");
		System.out.println("\t\t\t 3. 처음으로");
	}

	// - 값 삭제
	// 자바에서는 인스턴스를 참조하는 참조변수가 없을 경우 일정 시간 후
	// 가비지컬렉터에 의해 메모리를 해제한다
	void deleteInfo(){
		try{
			System.out.print("\t\t\t - 선택 : ");
			input = scan.nextInt();
	
		} catch(InputMismatchException e){
			System.out.println("\n\t\t숫자를 입력하세요!\n");
			scan.nextLine();

			deleteInfo();
		}

		switch(input){
			case 1:	// 선택한 번호 삭제
			System.out.print("\t\t\t\t - 삭제할 번호 입력 : ");
			input = scan.nextInt();

			// 삭제할 번호의 참조변수에 바로 다음 번호의 참조값을 준다.
			// ex) 5번째 값을 삭제한다면 s[4]에 s[5]의 참조값을 준다.
			// 	s[5]에 s[6]의 참조값 ... 반복
			for(int i=input-1; i<number-1; i++){	// 반복문은 삭제할 번호부터 값이 들어있는 배열까지만 반복
				s[i]=s[i+1];	
				s[i].setNum(i+1);			
			}
			number--;

			System.out.println("\t\t\t\t"+input+ " 번째 삭제!!");

			countRank();	// 삭제 후 순위 다시 정함
			break;

			case 2:	// 전체 삭제
			s = new Student[cSize];	// 현재 사이즈 만큼 다시 배열 할당
			number = 0;
			System.out.println("\t\t\t모든 내용삭제!!");
			break;

			case 3:
			System.out.println("\t\t\t처음으로!");
			return;
		}
	}
}