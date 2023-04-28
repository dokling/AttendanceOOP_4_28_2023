package oopProject;

public class Books {
	
	private String title;
    private String author;
    private int copies;
    
    public Books(String title, String author, int copies){
    	this.title = title; 
    	this.author = author;
    	this.copies = copies;
    }
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    public int getCopies(){
    	return copies;
   	}
    public void available() {
    	if (copies > 0) {
    		copies--;
        }
}
}