import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AuthorshipRunner {

	public static void main(String[] args) throws FileNotFoundException {
		File[] authorFiles = getFilesInDir("Signature Stats");
		File[] mysteryFiles = getFilesInDir("Mystery Texts");
		
		AuthorStats[] authorStats = loadAuthorStats(authorFiles); 
		TextStats[] bookStats = loadBookStats(mysteryFiles);
		
		for (TextStats t: bookStats){
			//System.out.println(t.getAvgWordsPerSentence()+", "+t.getHapaxLegomena());
			findMostSimilarAuthor(authorStats,t);
		}
	}
	
	
	public static void findMostSimilarAuthor(AuthorStats[] authorStats, TextStats text) {
		double maxSimilarity = Integer.MAX_VALUE;
		String maxAuthor = "";
		for (AuthorStats a: authorStats){
			double similarity = 0;
			similarity+=Math.abs(a.getAvgWordLen()-text.getAvgWordLen())*11;
			similarity+=Math.abs(a.getAvgWordsPerSentence()-text.getAvgWordsPerSentence())*33;
			similarity+=Math.abs(a.getHapaxLegomena()-text.getHapaxLegomena())*50;
			similarity+=Math.abs(a.getTypeTokenRatio()-text.getHapaxLegomena())*.4;
			if (similarity < maxSimilarity){ //max similarity occurs for smallest abs differences
				maxSimilarity = similarity;
				maxAuthor = a.getLastName()+", "+a.getFirstName();
			}
		}
		System.out.println(maxAuthor);
	}
	
	/**
	 * Get a list of all files in the specified directory path
	 * @param path Relative file path
	 * @return 
	 * @throws FileNotFoundException
	 */
	public static File[] getFilesInDir(String path) {
		File dataDir = new File(path);
		return dataDir.listFiles();
	}
	
	
	/**
	 * 
	 * @param bookList
	 * @return
	 * @throws FileNotFoundException
	 */
	public static TextStats[] loadBookStats(File[] bookList) throws FileNotFoundException {
		TextStats[] bookStats = new TextStats[bookList.length];
		for (int i=0; i<bookList.length; i++){
			bookStats[i]=new TextStats(bookList[i]);
		}
		return bookStats;
	}
	
	
	/**
	 * Data files expected to contain 5 lines in the following order
	 *  Author name
	 *  Average Word Length
 	 *	Type-Token Ratio
 	 *	Hapax Legomana Ratio
 	 *  Average Sentence Length
	 * @param fileList A list of AuthorStat data files
	 * @return A list of AuthorStats objects
	 * @throws FileNotFoundException
	 */
	public static AuthorStats[] loadAuthorStats(File[] fileList) throws FileNotFoundException{
		AuthorStats[] authorStats = new AuthorStats[fileList.length];
		
		for (int i=0; i<fileList.length; i++){
			Scanner fIn = new Scanner(fileList[i]);
			String[] name = fIn.nextLine().split(" ");
			double awl = fIn.nextDouble();
			double ttr = fIn.nextDouble();
			double hlr = fIn.nextDouble();
			double asl = fIn.nextDouble();	
			authorStats[i]=new AuthorStats(name[1],name[0],awl,ttr,hlr,asl);
			fIn.close();
		}
		return authorStats;
	}

}
