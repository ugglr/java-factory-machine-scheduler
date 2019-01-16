package schedule;

import java.util.ArrayList;

public class Scheduler {
	private Machine[] machines;
	
	/** Creates a scheduler for the machines 
	 * in the array machines. */
	public Scheduler(Machine[] machines) {
		this.machines = machines;
	}
	
	/** Distributes the jobs in the list jobs to the machines. 
	 	jobs are sorted by decreasing processing times. */
	public void makeSchedule(ArrayList<Job> jobs) {
		for(int i = 0; i < machines.length; i++) {
			machines[i].clearJobs();
		}
		for(Job j: jobs) {
			Machine m = machineWithLeastToDo();
			m.assignJob(j);
		}
	}
	
	// Returns the machine with the least to do
	private Machine machineWithLeastToDo() {
		int min = Integer.MAX_VALUE;
		int minPos = -1;
		for(int i = 0; i < machines.length; i++) {
			int totalTime = machines[i].getTotalTime();
			if(totalTime < min) {
				min = totalTime;
				minPos = i;
			}
		}
		return machines[minPos];
	}

	/** Skriver ut maskinernas scheman. */
	public void printSchedule() {
		for(int i = 0; i < machines.length; i++) {
			System.out.println(machines[i]);
		}
	}
}
