package gui.helpers;

public class Sorting {

	private String sorting;
	
	private String filter;
	
	public Sorting(String sorting, String filter) {
		this.sorting = sorting;
		this.filter = filter;
	}
	
	public String getSorting() {
		return sorting;
	}
	
	public String getFilter() {
		return filter;
	}
	
}
