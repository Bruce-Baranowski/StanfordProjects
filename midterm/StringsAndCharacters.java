package midterm;

public class StringsAndCharacters {
	
	public static void main(String[] args) {
		System.out.println(removeDoubledLetters("aabccdde"));
	}

	public static String removeDoubledLetters(String input) {
		String output = ""+input.charAt(0);
		char lastChar = input.charAt(0);
		for (int i = 1; i < input.length(); i++) {
			if (input.charAt(i) != lastChar) {
				output+=input.charAt(i);
			}
			lastChar = input.charAt(i);
		}
		
		return output;
	}
}
