package POJOclasses;

public class ListUsersPOJO {

     private float page;
	 private float per_page;
	 private float total;
	 private float total_pages;
	 
	 public float getPage() {	  return page;	 }
	 public void setPage(int a) {		 }
	 
	 public float getPer_page() {	  return per_page;	 }
	 public void setPer_page(int a) {		 }
	 
	 public float getTotal() {	  return total;	 }
	 public void setTotal(int a) {		 }
	 
	 public float getTotal_pages() {	  return total_pages;	 }
	 public void setTotal_pages(int a) {		 }
	 
	 public support getSupport() {	  return null;	 }
	 public void setSupport(support a) {		 }
	 
	private GetUserPOJO[] users;
	public GetUserPOJO[] getData() {return users;}
	public void setData(GetUserPOJO[] us) {users = us;}
	
	

}
