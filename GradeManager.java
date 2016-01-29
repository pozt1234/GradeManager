/*
# GradeManager 클래스 #

- while문으로 종료값이 입력될 때까지 계속 실행.
- 진행 순서는 초기화 -> 메뉴출력 -> 메뉴선택(switch문 사용을 위해 return 받음)
*/


public class GradeManager{
	public static void main(String[] args) {
		Management m = new Management();

		int input = 0;
		m.init();
		while(true){
			m.showList();

			switch(input = m.selectList()){
				case 1:
				m.insertInfo();
				break;

				case 2:
				m.sortByRank();
				m.showGradeByRank();
				break;

				case 3:
				m.sortByNum();
				m.showGradeByNum();
				break;

				case 4:
				m.showGradeInDetail();
				break;

				case 5:
				m.changePeople();
				break;

				case 6:
				m.showSelectDelete();
				m.deleteInfo();
				break;

				case 7:
				System.exit(0);
			}

		}		




	}
}