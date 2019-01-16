package schedule;

import java.util.LinkedList;

public class Machine {
	private int nbr;
	private LinkedList<Job> jobs; 
	private Job currentJob;
	private int totTime;
	
	/** Creates a machine with the number nbr. */
	public Machine(int nbr) {
		this.nbr = nbr;
	}

	/** Returns the machines number. */
	public int getNbr() {
		return this.nbr;
	}	


	/** assigns the machine a job */
	public void assignJob(Job j) {
		jobs = new LinkedList<Job>();
		if(currentJob == null) {
			currentJob = j;
			totTime = j.getTime();
		} else {
			totTime += j.getTime();
			jobs.addLast(j);
		}		
	}
	
	/** Removes all jobs from the machine. */
	public void clearJobs() {
		jobs.clear();		
	}
	
	/** Removes and returns the next job the machine shall process. 
	 	Returns null if the machine does not have any jobs. */
	public Job getNextJob() {
		if(currentJob == null) {
			return null;
		} else {
			Job tmp = jobs.peekFirst();
			currentJob = tmp;
			totTime -= tmp.getTime();
			return jobs.poll();
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
