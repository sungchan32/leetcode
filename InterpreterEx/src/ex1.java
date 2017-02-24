import java.util.Scanner;

public class ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int end = 1;
		
		while(end == 1){
			
			System.out.println("(+ 1 2) 와 같이 입력해주세요. e 입력시 종료");
			
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			String message = "";
			int result = 0;
			//사용자 입력 받기
			message = scan.nextLine();
			//String[] ch = message.toCharArray();
			
			
			int startIdx = 0;
			int endIdx = 0;
			
			startIdx = message.indexOf('(');
			endIdx = message.indexOf(')'); 
			
			if(startIdx == -1 || endIdx == -1){
				System.out.print("다시 입력해주세요.");
				continue;
			}
			
			message = message.substring(startIdx, endIdx);
			
			
			if(message.indexOf('+') != -1){
				String[] ch = message.substring(message.indexOf('+')).split("\\s+");
				result = Integer.parseInt(ch[1]) + Integer.parseInt(ch[2]); 
			} else if (message.indexOf('-') != -1){
				String[] ch = message.substring(message.indexOf('-')).split("\\s+");
				result = Integer.parseInt(ch[1]) - Integer.parseInt(ch[2]);
			}
			
			
			
			System.out.println("결과는" + result + "입니다.");
		}
	}
	
	
	
}
