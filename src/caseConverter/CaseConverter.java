package caseConverter;

import java.util.Scanner;

public class CaseConverter {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		showInputStringMenu();
		int inputStringOption = scanner.nextInt();
		showOutputStringMenu();
		int outputStringOption = scanner.nextInt();
		
		confirmOptions(inputStringOption, outputStringOption);
		
		System.out.print("\nEnter string to convert: ");
		scanner.nextLine();
		String stringToConvert = scanner.nextLine();
		scanner.close();
		System.out.println(stringToConvert);
		
		String convertedString = "";
		
		switch(inputStringOption) {
			case 1:
				convertedString = inputStringCamelCase(outputStringOption, stringToConvert);
				break;
			case 2:
				convertedString = inputStringSnakeCase(outputStringOption, stringToConvert);
				break;
			case 3:
				convertedString = inputStringPascalCase(outputStringOption, stringToConvert);
				break;
			case 4:
				convertedString = inputStringNormalCase(outputStringOption, stringToConvert);
		}
		
		
		System.out.println("\nConverted String: " + convertedString);

	}

	private static String inputStringNormalCase(int outputStringOption, String stringToConvert) {
		if(outputStringOption == 2) {
			stringToConvert = stringToConvert.replace(" ", "_");
			return uncapitalizeFirstLetter(stringToConvert);
		}
		
		StringBuilder sbConvertedString = new StringBuilder();
		for(int i = 0; i < stringToConvert.length(); i++) {
			if(stringToConvert.charAt(i) == ' ') {
				sbConvertedString.append(Character.toUpperCase(stringToConvert.charAt(i+1)));
				i++;
			}else {
				sbConvertedString.append(stringToConvert.charAt(i));
			}
		}
		
		if(outputStringOption == 1) {
			return uncapitalizeFirstLetter(sbConvertedString.toString());
		}
		
		return sbConvertedString.toString();
	}

	private static String inputStringPascalCase(int outputStringOption, String stringToConvert) {
		if(outputStringOption == 1) {
			return uncapitalizeFirstLetter(stringToConvert);
		}
		stringToConvert = uncapitalizeFirstLetter(stringToConvert);
		
		StringBuilder sbConvertedString = new StringBuilder();
		for(int i = 0; i < stringToConvert.length(); i++) {
			if(Character.isUpperCase(stringToConvert.charAt(i))){
				if(outputStringOption == 2)
					sbConvertedString.append("_");
				else if(outputStringOption == 4)
					sbConvertedString.append(" ");
			}
			sbConvertedString.append(Character.toLowerCase(stringToConvert.charAt(i)));
		}
		
		if(outputStringOption == 4) {
			return capitalizeFirstLetter(sbConvertedString.toString());
		}
		
		return sbConvertedString.toString();
	}

	private static String inputStringSnakeCase(int outputStringOption, String stringToConvert) {
		if(outputStringOption == 4) {
			stringToConvert = stringToConvert.replace("_", " ");
			return capitalizeFirstLetter(stringToConvert);
		}
		StringBuilder sbConvertedString = new StringBuilder();
		for(int i = 0; i < stringToConvert.length(); i++) {
			if(stringToConvert.charAt(i) == '_') {
				sbConvertedString.append(Character.toUpperCase(stringToConvert.charAt(i+1)));
				i++;
			}else {
				sbConvertedString.append(stringToConvert.charAt(i));
			}
		}
		
		if(outputStringOption == 3) {
			return capitalizeFirstLetter(sbConvertedString.toString());
		}
		return sbConvertedString.toString();
	}

	private static String optionToString(int option) {
		switch(option) {
			case 1:
				return "Camel Case";
			case 2:
				return "Snake Case";
			case 3:
				return "Pascal Case";
			case 4:
				return "Normal Case";
		}
		return null;
	}

	private static String inputStringCamelCase(int outputStringOption, String stringToConvert) {
		if(outputStringOption == 3) {
			return capitalizeFirstLetter(stringToConvert);
		}
		
		StringBuilder sbConvertedString = new StringBuilder();
		for(int i = 0; i < stringToConvert.length(); i++) {
			if(Character.isUpperCase(stringToConvert.charAt(i))){
				if(outputStringOption == 2)
					sbConvertedString.append("_");
				else if(outputStringOption == 4)
					sbConvertedString.append(" ");
			}
			sbConvertedString.append(Character.toLowerCase(stringToConvert.charAt(i)));
		}
		
		if(outputStringOption == 4) {
			return capitalizeFirstLetter(sbConvertedString.toString());
		}
		
		return sbConvertedString.toString();
	}

	private static String capitalizeFirstLetter(String string) {
		return string.substring(0,1).toUpperCase() + string.substring(1);
	}
	
	private static String uncapitalizeFirstLetter(String string) {
		return string.substring(0,1).toLowerCase() + string.substring(1);
	}

	private static void confirmOptions(int inputStringOption, int outputStringOption) {
		String opt1 = optionToString(inputStringOption);
		String opt2 = optionToString(outputStringOption);
		System.out.println(opt1 + " -> " + opt2);
		
	}

	private static void showOutputStringMenu() {
		System.out.println("\nPick output string case: ");
		System.out.println("\t1. Camel Case"
				+ "\n\t2. Snake Case"
				+ "\n\t3. Pascal Case"
				+ "\n\t4. Normal Case");
		System.out.print("\nyour option: ");
		
	}

	private static void showInputStringMenu() {
		System.out.println("Pick input string case: ");
		System.out.println("\t1. Camel Case"
						+ "\n\t2. Snake Case"
						+ "\n\t3. Pascal Case"
						+ "\n\t4. Normal Case");
		System.out.print("\nyour option: ");
	}

}
