package Implementation;
import java.util.*;

public class bj1978_소수찾기{

   public static void main (String[] args) {
      Scanner sc = new Scanner(System.in);
      
      int test = sc.nextInt();           //테스트 갯수
      int [] testNumber = new int [test];  // 테스트 넘버 저장
      int count = 0;           //소수 인지 판별하는 변수
      int primeNumber =0;      //소수 갯수 확인
      
      for (int i=0; i<test; i++) {
    	 count =0;
         testNumber[i] = sc.nextInt();
         for(int j=1 ; j<=testNumber[i]; j++) {
        	 if(testNumber[i]%j ==0) {
        		 count++;
        	 }	}
         if(count ==2) 
        	 primeNumber++;
      }
     System.out.println(primeNumber);
      
   }	
   }