package softTeam;

/**
 * TODO @link https://github.com/DruidKuma/CodinGame/blob/master/src/main/java/com/druidkuma/codingame/asciichart/AsciiChart.java
 * Get a letter from a printed asciiArt char
 * @link https://stackoverflow.com/questions/41660809/get-a-letter-from-a-printed-asciiart-char
 * @author dell
 */
public class ScanChar {

    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

    /**
     * Return the char that is represented by s
     */
    public static char scanChar(String s) {
	// TODO Auto-generated method stub
	// Iterate over each character from A to Z.
	for (char c = 'A'; c <= 'Z'; c++) {
	    // Check to see if the character corresponds with the ASCII art.
	    if (AsciiArt.printChar(c) == s) {
		// Return the character if it does.
		return c;
	    }
	}

	// Optionally use a null character to indicate that the string passed
	// doesn't correspond to any valid ASCII art.
	return (char) 0;

    }

}

class AsciiArt {
    public static String printChar(char s) {
	return "S";
    }
}
