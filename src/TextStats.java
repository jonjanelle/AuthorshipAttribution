import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class TextStats {
	private String text;
	private String[] sentences;
	private HashMap<String,Integer> wordCounts;
	private int totalWords;
	private double avgWordLen;
	private double typeTokenRatio;
	private double hapaxLegomena;
	private double avgWordsPerSentence;
	
	/**
	* Construct text statistics from file 
	* @param textFile
	* @throws FileNotFoundException
	*/
	public TextStats(File textFile) throws FileNotFoundException
	{
		super();
		Scanner fIn = new Scanner(textFile);
		String newText = new String();
		while (fIn.hasNextLine()){
			newText+=fIn.nextLine();
		}
		this.text = newText;
		this.wordCounts=new HashMap<String,Integer>();
		fIn.close();
		this.setupStats();
	}
	
	/**
	 * Construct text statistics from String
	 * @param text Text to analyze
	 */
	public TextStats(String text){
		super();
		this.text = text;
		this.setupStats();
	}
	
	/**
	 * Call helper functions to calculate and set
	 * statistics for this text
	 */
	private void setupStats()
	{
		this.makeSentenceArray();
		this.makeWordsMap();
		this.calcHappaxLegoMena();
		this.avgWordsPerSentence=(double)totalWords/sentences.length;
		this.typeTokenRatio=(double)wordCounts.size()/totalWords;
	}
	
	/**
	 * Calculate the Happax Legomena ratio using the 
	 * word counts map.
	 */
	private void calcHappaxLegoMena() 
	{
		int onceOnly=0;
		for (String key:wordCounts.keySet()){
			if (wordCounts.get(key)==1){
				onceOnly+=1;
			}
		}
		this.hapaxLegomena=(double)onceOnly/this.totalWords;
	}
	
	/**
	 * Split text into an array of sentences. 
	 * The end of a sentence is assumed to be marked by '.', '!', or '?'
	 */
	private void makeSentenceArray() 
	{
		this.sentences=this.text.split("[.!?]");
	}
	
	/**
	 * Build word map, set average words per sentence,
	 * and calculate average word length
	 * Letter case is ignored.
	 */
	private void makeWordsMap()
	{
		int wordCount = 0;
		int letterCount = 0;
		for (String s:this.sentences){
			for (String w:s.split(" ")) {
				w = w.replaceAll("[1-9,()'\":;_-]", " ");
				w = w.trim().toLowerCase();
				if (w.length()>0){
					if (wordCounts.containsKey(w)){
						wordCounts.put(w,wordCounts.get(w)+1);
					} else {
						wordCounts.put(w, 1);
					}
					wordCount+=1;
					letterCount+=w.length();
				}
			}
		}
		this.totalWords=wordCount;
		this.avgWordLen=(double)letterCount/wordCount;
	}
	
	/**
	 * Print the first n sentences of the text
	 * @param n The number of sentences to print.
	 */
	public void printNSentences(int n){
		if (sentences == null || n > sentences.length){ return; }
		for (int i=0; i < n; i++){
			System.out.println(sentences[i]);
		}
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String[] getSentences() {
		return sentences;
	}

	public void setSentences(String[] sentences) {
		this.sentences = sentences;
	}

	public HashMap<String, Integer> getWordCounts() {
		return wordCounts;
	}

	public void setWordCounts(HashMap<String, Integer> wordCounts) {
		this.wordCounts = wordCounts;
	}

	public int getTotalWords() {
		return totalWords;
	}

	public void setTotalWords(int totalWords) {
		this.totalWords = totalWords;
	}

	public double getAvgWordLen() {
		return avgWordLen;
	}

	public void setAvgWordLen(double avgWordLen) {
		this.avgWordLen = avgWordLen;
	}

	public double getTypeTokenRatio() {
		return typeTokenRatio;
	}

	public void setTypeTokenRatio(double typeTokenRatio) {
		this.typeTokenRatio = typeTokenRatio;
	}

	public double getHapaxLegomena() {
		return hapaxLegomena;
	}

	public void setHapaxLegomena(double hapaxLegomena) {
		this.hapaxLegomena = hapaxLegomena;
	}

	public double getAvgWordsPerSentence() {
		return avgWordsPerSentence;
	}

	public void setAvgWordsPerSentence(double avgWordsPerSentence) {
		this.avgWordsPerSentence = avgWordsPerSentence;
	}

	@Override
	public String toString() {
		return "TextStats [text=" + text + ", sentences=" + Arrays.toString(sentences) + ", wordCounts=" + wordCounts
				+ ", totalWords=" + totalWords + ", avgWordLen=" + avgWordLen + ", typeTokenRatio=" + typeTokenRatio
				+ ", hapaxLegomena=" + hapaxLegomena + ", avgWordsPerSentence=" + avgWordsPerSentence + "]";
	}
	
	
}
