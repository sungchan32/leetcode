import java.util.Scanner;
import java.util.Stack;

public class ex2 {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		int end = 1;
		
		while(end == 1){
			
			System.out.println("(* (+ 10 20) (- 1 2)) 와 같이 입력해주세요. e 입력시 종료");
			
			Scanner scan = new Scanner(System.in);
			String message = "";
			
			//사용자 입력 받기
			message = scan.nextLine();
			//String[] ch = message.toCharArray();

			String result = polish(message);
			System.out.println("결과는" + result + "입니다.");
		}
	}

	
	public static String polish(String message){
		
		char[] chary = message.toCharArray();
		
		Stack<String> st = new Stack<String>();
		
		String newch = "";
		Stack<String> st1 = new Stack<String>();
		boolean f = true;
		int g = 0;
		String[] ab = {"", ""};
		for(int idx = 0; idx < chary.length;){
			
			char ch = chary[idx];
			
			//while(isspace(ch)) { ch = chary[++idx]; }
			
			if(ch == '\0') break;
			
			switch(ch){
			case '(':
				st.push(ch + "");
				break;
			case ')':
				newch = st.pop().toString();
				f = true;
				while(f) {
					st1.push(newch + "");
					newch = st.pop().toString();
					
					if(newch.equals("(")) { f = false; }
				}
				
				newch = st1.pop();
				while(newch.equals(" ")) { newch = st1.pop(); }
				
				ab = getNumber(st1);
				switch(newch){
				case "+":
					g = Integer.parseInt(ab[0]) + Integer.parseInt(ab[1]);
					st.push(g+"");
					break;
				case "-":
					g = Integer.parseInt(ab[0]) - Integer.parseInt(ab[1]);
					st.push(g+"");
					break;
				case "*":
					g = Integer.parseInt(ab[0]) * Integer.parseInt(ab[1]);
					st.push(g+"");
					break;
				case "/":
					g = Integer.parseInt(ab[0]) / Integer.parseInt(ab[1]);
					st.push(g+"");
					break;
				}
				break;
			default:
				st.push(ch + "");
				break;
			}
			idx++;
		}
		String returnValue = st.pop();
		while(returnValue.equals(" ")) { returnValue = st.pop(); }
		
		
		chary = null;
		st = null;
		newch = null;
		st1 = null;
		ab = null;
		
		return returnValue;
	}

	public static String[] getNumber(Stack<String> sk){
		String newch = "";
		String[] ab = {"", ""};
		boolean c = false;
		
		while(!(sk.isEmpty())){
			newch = sk.pop();
			if(newch.equals(" ") && !(ab[0].equals("")) ) { c = true; }
			if(!newch.equals(" "))
				if(c)
					ab[1] += newch + "";
				else
					ab[0] += newch + "";
			
		}
		return ab;
	}
}
