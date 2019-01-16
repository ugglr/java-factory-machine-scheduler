package schedule;


public class Job {
	private String name;
	private int time;
	
	/** Creates a job with the name name which take the 
	 * int time to complete the job. */
	public Job(String name, int time) {
		this.name = name;
		this.time = time;
	}
	
	/** Returns the the processing time for this job. */
	public int getTime() {
		return this.time;
	}
	

	/** Returns a String which represents the job
	 	on the form: name (time to process). */
	public String toString() {
		return name + "(" + time + ")";
	}
	
}
