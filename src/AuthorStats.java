
public class AuthorStats {
	private String lastName;
	private String firstName;
	private double avgWordLen;
	private double typeTokenRatio;
	private double hapaxLegomena;
	private double avgWordsPerSentence;
	
	/**
	 * Construct a new author
	 * @param lastName
	 * @param firstName
	 * @param avgWordLen
	 * @param typeTokenRatio
	 * @param hapaxLegomena
	 * @param avgWordsPerSentence
	 */
	public AuthorStats(String lastName, String firstName, double avgWordLen, double typeTokenRatio,
					   double hapaxLegomena, double avgWordsPerSentence) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.avgWordLen = avgWordLen;
		this.typeTokenRatio = typeTokenRatio;
		this.hapaxLegomena = hapaxLegomena;
		this.avgWordsPerSentence = avgWordsPerSentence;
	}
	
	public AuthorStats(String lastName, String firstName){
		this(lastName, firstName, 0.0, 0.0, 0.0, 0.0);
	}
	
	public AuthorStats(){
		this("Unknown","",0,0,0,0);
	}
	
	/**
	 * @return A string representation of the author
	 */
	public String toString() {
		return "[lastName=" + lastName + ", firstName=" + firstName + ", avgWordLen=" + avgWordLen
				+ ", typeTokenRatio=" + typeTokenRatio + ", hapaxLegomena=" + hapaxLegomena + ", avgWordsPerSentence="
				+ avgWordsPerSentence + "]";
	}
	
	/**
	 * Get author last name
	 * @return Last name as a String
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Set the last name of an author
	 * @param lastName New last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Get author first name
	 * @return First name as a String
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Set the first name of an author
	 * @param firstName New first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * @return average word length statistic
	 */
	public double getAvgWordLen() {
		return avgWordLen;
	}
	
	/**
	 * 
	 * @param avgWordLen New average word length for author
	 */
	public void setAvgWordLen(double avgWordLen) {
		this.avgWordLen = avgWordLen;
	}
	
	/**
	 * 
	 * @return Type-token ratio for author
	 */
	public double getTypeTokenRatio() {
		return typeTokenRatio;
	}
	
	/**
	 * 
	 * @param typeTokenRatio New type-token ratio for author
	 */
	public void setTypeTokenRatio(double typeTokenRatio) {
		this.typeTokenRatio = typeTokenRatio;
	}
	
	/**
	 * 
	 * @return Happax-Legomena ratio for author
	 */
	public double getHapaxLegomena() {
		return hapaxLegomena;
	}
	
	/**
	 * 
	 * @param hapaxLegomena New Happax-Legomena ratio for author
	 */
	public void setHapaxLegomena(double hapaxLegomena) {
		this.hapaxLegomena = hapaxLegomena;
	}
	
	/**
	 * 
	 * @return Author's average words per sentence statistic
	 */
	public double getAvgWordsPerSentence() {
		return avgWordsPerSentence;
	}
	
	/**
	 * 
	 * @param avgWordsPerSentence New average words per sentence 
	 */
	public void setAvgWordsPerSentence(double avgWordsPerSentence) {
		this.avgWordsPerSentence = avgWordsPerSentence;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(avgWordLen);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(avgWordsPerSentence);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		temp = Double.doubleToLongBits(hapaxLegomena);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		temp = Double.doubleToLongBits(typeTokenRatio);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuthorStats other = (AuthorStats) obj;
		if (Double.doubleToLongBits(avgWordLen) != Double.doubleToLongBits(other.avgWordLen))
			return false;
		if (Double.doubleToLongBits(avgWordsPerSentence) != Double.doubleToLongBits(other.avgWordsPerSentence))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (Double.doubleToLongBits(hapaxLegomena) != Double.doubleToLongBits(other.hapaxLegomena))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (Double.doubleToLongBits(typeTokenRatio) != Double.doubleToLongBits(other.typeTokenRatio))
			return false;
		return true;
	}


}
