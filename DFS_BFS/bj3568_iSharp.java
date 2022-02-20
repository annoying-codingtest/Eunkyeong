package DFS_BFS;
import java.util.*;

public class bj3568_iSharp {
	public static void main(String[] args0) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();

		String[] split = line.split(" ");

		// 기본 변수형
		String base = split[0];

		for (int i = 1; i < split.length; i++) {
			split[i] = split[i].replaceAll(",", "");
			split[i] = split[i].replaceAll(";", "");
		}

		
		for(int i = 1 ; i < split.length ; i++) {
			split[i] = parsing(split[i]);
			System.out.println(base + split[i]+";");
		}

	}
	private static String parsing(String target) {
		StringBuilder sb =new StringBuilder();
		StringBuilder tmpp = new StringBuilder(target);
		int idx = target.length()-1;
		while(true) {
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
		if(sb.toString().isEmpty()) {
			idx = 0;
			while(true) {
				char tmp = target.charAt(idx);
				
				if(tmp >= 'a' && tmp <= 'z')
					break;
				
				if(tmp >= 'A' && tmp <= 'Z')
					break;
				
				sb.append(tmp);
				idx++;
			}
			
			tmpp.delete(0, idx);
		}else
			tmpp.delete(idx+1, target.length());
		
		sb.append(" ");
		sb.append(tmpp);
		
		return sb.toString();
	}
}

