package POJOclasses;

public class UpdateUserRespPOJO 
{
	private String name;
	 private String job;
	 private String updatedAt;


	 // Getter Methods 

	 public String getName() {
	  return name;
	 }

	 public String getJob() {
	  return job;
	 }

	 public String getUpdatedAt() {
	  return updatedAt;
	 }

	 // Setter Methods 

	 public void setName(String name) {
	  this.name = name;
	 }

	 public void setJob(String job) {
	  this.job = job;
	 }

	 public void setUpdatedAt(String updatedAt) {
	  this.updatedAt = updatedAt;
	 }
}
