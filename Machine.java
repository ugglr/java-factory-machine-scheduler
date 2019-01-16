package schedule;

import java.util.LinkedList;

public class Machine {
	private int nbr;
	private LinkedList<Job> jobs; 
	private int totTime;
	
	/** Creates a machine with the number nbr. */
	public Machine(int nbr) {
		this.nbr = nbr;
		jobs = new LinkedList<Job>();
		totTime = 0;
	}

	/** Returns the machines number. */
	public int getNbr() {
		return this.nbr;
	}	


	/** assigns the machine a job */
	public void assignJob(Job j) {
		jobs.add(j);
		totTime += j.getTime();
	}
	
	/** Removes all jobs from the machine. */
	public void clearJobs() {
		jobs.clear();
		totTime = 0;
	}
	
	/** Removes and returns the next job the machine shall process. 
	 	Returns null if the machine does not have any jobs. */
	public Job getNextJob() {
		if(jobs.isEmpty()) {
			return null;
		} else {
			totTime -= jobs.getFirst().getTime();
			return jobs.getFirst();
		}
	}
	
	/** Returns the total time for the machines jobs. */
	public int getTotalTime() {
		return totTime;
	}
	
	/** Returns a String which contains the machine number and the 
	 * scheduled jobs within [] with comma signs in between.*/
	public String toString() {
		return Integer.toString(nbr) + jobs.toString();
	}
	
}
