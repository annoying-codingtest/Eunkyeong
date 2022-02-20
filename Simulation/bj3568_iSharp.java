package DFS_BFS;
import java.util.*;

public class bj3568_iSharp {
	public static void main(String[] args0) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();

		String[] split = line.split(" "); // 입력받은 문자열을 공백으로 나누기(공통 변수형, 개별 변수형 구분)

		// 공통 변수형
		String base = split[0];

		for (int i = 1; i < split.length; i++) { //나머지 split 값에 있는 ,과 ; 없애기
			split[i] = split[i].replaceAll(",", "");
			split[i] = split[i].replaceAll(";", "");
		}

		
		for(int i = 1 ; i < split.length ; i++) { //,과 ;를 제거한 split 파싱
			split[i] = parsing(split[i]);
			System.out.println(base + split[i]+";"); //공통 변수형 + 파싱된 문자열 + ; 출력
		}

	}
	private static String parsing(String target) {
		StringBuilder sb =new StringBuilder(); //개별 변수형 저장
		StringBuilder tmpp = new StringBuilder(target); //변수명 저장
		int idx = target.length()-1; //개별 변수형과 변수명을 나눌 인덱스에 입력값의 -1 길이 할당
		while(true) { //뒷부분에 개별 변수형이 있는지 판단
			char tmp = target.charAt(idx);
			
			if(tmp >= 'a' && tmp <= 'z')
				break;
			
			if(tmp >= 'A' && tmp <= 'Z')
				break;
			
			if(tmp == '[')
				tmp = ']';
			else if(tmp == ']')
				tmp = '[';
			
			sb.append(tmp);
			idx--;
		}
		
		//앞에 연산자가 있는 경우
		if(sb.toString().isEmpty()) { //sb가 비어있다 = 뒤에 변수형 존재 x
			idx = 0;
			while(true) { //target에 있는 문자 한개씩 꺼내 검사
				char tmp = target.charAt(idx);
				
				if(tmp >= 'a' && tmp <= 'z')
					break;
				
				if(tmp >= 'A' && tmp <= 'Z')
					break;
				
				sb.append(tmp);
				idx++;
			}
			
			tmpp.delete(0, idx); //앞에 존재하는 변수형 제거
		}else //뒤에 개별 변수형이 존재할 경우
			tmpp.delete(idx+1, target.length()); //뒤에 존재하는 변수형 제거
		
		sb.append(" "); //개별 변수형(sb)과 변수명(tmpp) 사이에 공백 입력
		sb.append(tmpp);
		
		return sb.toString();
	}
}

