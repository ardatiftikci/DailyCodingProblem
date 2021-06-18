/* We are interested in finding the longest (number of characters) absolute path to a file within our file system.
 */
import java.util.Stack;

public class Problem17 {

	public static void main(String[] args) {
		String file = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
		System.out.println("The length is " + p17(file));
	}

	private static int p17(String file) {
		String[] lines = file.split("\n");
		Stack<String> stack = new Stack<String>();
		int maxLength = 0;
		int currentLength = 0;
		String path = "";
		for(String line : lines) {
			int count = numberOfOccurences(line, '\t');
			while(stack.size() != count) {
				currentLength = currentLength-stack.pop().length()-1; //find parent's path
				path = path.substring(0, currentLength);
			}
			String currentElement = line.replace("\t", "");
			currentLength += currentElement.length()+1;//add the current directory/file
			path += currentElement +"/";
			if(currentElement.indexOf('.')!=-1) {
				if(currentLength<maxLength) path="";
				maxLength = Math.max(currentLength, maxLength); //if it contains period  it is not a directory
			}
			stack.push(currentElement);
		}
		
		if(maxLength>=1) {
			System.out.println("The path is " + path.substring(0,path.length()-1));
			return maxLength-1;
		}else {
			System.out.println("No path!");
			return 0;
		}
	}

	private static int numberOfOccurences(String line, char c) {
		int count = 0;
		for(int i=0; i<line.length();i++) {
			if(line.charAt(i)==c) count++;
		}
		return count;
	}

}
