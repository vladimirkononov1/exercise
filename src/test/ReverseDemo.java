package test;

public class ReverseDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "civic";
		String reverse = "";
		for(int count= name.length()-1; count >= 0; count--) {
			reverse = reverse + name.charAt(count);
		}
		System.out.println(reverse);
		
		if(name.equalsIgnoreCase(reverse)) {
			System.out.println(name + " is a palindrome word");
		} else {
			System.out.println(name + " is NOT a palindrome word!!!");
		}
		
	}

}
