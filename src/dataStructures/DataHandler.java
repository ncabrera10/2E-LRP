package dataStructures;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class stores the main parameters of the current instance, as the number of satellites, customers..
 * 
 * @author nicolas.cabrera-malik
 *
 */
public class DataHandler {
	
	/**
	 * Dimension (total number of nodes)
	 */
	
	private int dim;
	
	/**
	 * Number of satellites
	 */
	
	private int nbSat;
	
	/**
	 * Number of customers
	 */
	
	private int nbCustomers;
	
	/**
	 * Capacity of first-echelon vehicles
	 */
	
	private int Q1;
	
	/**
	 * Capacity of second-echelon vehicles
	 */
	
	private int Q2;
	
	/**
	 * Fleet of first-echelon vehicles
	 */
	
	private int fleet1;
	
	/**
	 * Fleet of second-echelon vehicles
	 */
	
	private int fleet2;
	
	/**
	 * Fixed cost of first-echelon vehicles
	 */
	
	private int fixed_cost1;
	
	/**
	 * Fixed cost of second-echelon vehicles
	 */
	
	private int fixed_cost2;
	
	
	
	/**
	 * Max SE vehicle per satellite
	 */
	private int ms;
	
	/**
	 * Largest demand
	 */
	
	private double largest_demand;
	
	/**
	 * Demands
	 */
	private ArrayList<Double> demands;
	
	/**
	 * Demands
	 */
	private ArrayList<Double> handling_costs;
	
	/**
	 * Satellites capacities
	 */
	private ArrayList<Double> satellites_capacities;
	
	/**
	 * Satellites opening costs
	 */
	private ArrayList<Double> satellites_opening;
	
	
	// METHODS:
	
	
	/**
	 * This method creates a new DataHandler.
	 * 
	 * @param path: path to the instance.dat file
	 * @throws IOException
	 */
	public DataHandler(String path) throws IOException{
		
		// Read the coordinates of the nodes:
		
			//0. Creates a buffered reader:
			
			BufferedReader buff = new BufferedReader(new FileReader(path));
		
			if(path.contains("coord")) { //Prodhon instances
				
				//1. Reads the number of customers:
				
				String line = buff.readLine();
				nbCustomers = Integer.parseInt(line);
				
				//2. Reads the number of satellites:
				
				line = buff.readLine();
				nbSat = Integer.parseInt(line);
				
				//3. Skips two lines:
				
				line = buff.readLine();
				
				//4. Depot information
				
				line = buff.readLine();
				
				//5. Satellites information
				
				line = buff.readLine();
				for(int i = 1 ; i < nbSat+1; i++) {
					
					line = buff.readLine();
				}
				
				
				//6. Customers information
				
				line = buff.readLine();
				for(int i = 1 ; i < nbCustomers+1; i++) {
					
					line = buff.readLine();
				}
				

			// Captures trucks info: (total #, capacity, cost per distance, fixcost)	
				
				line = buff.readLine();
				Q2 = Integer.parseInt(line);
				fleet2 = nbCustomers;
				
				line = buff.readLine();
				Q1 = Integer.parseInt(line);
				fleet1 = nbCustomers;
				
				line = buff.readLine();
				
			// Satellites capacities:
				
				satellites_capacities = new ArrayList<Double>();
				handling_costs = new ArrayList<Double>();
				handling_costs.add(0.0);
				line = buff.readLine();
				for(int i = 1 ; i < nbSat+1; i++) {
					satellites_capacities.add(Double.parseDouble(line));
					handling_costs.add(0.0);
					line = buff.readLine();
				}
			
			// Customers demands
				
				demands = new ArrayList<Double>();
				line = buff.readLine();
				for(int i = 1 ; i < nbCustomers+1; i++) {
					demands.add(Double.parseDouble(line.trim()));
					line = buff.readLine();
				}
			
			// Satellites opening costs
				
				satellites_opening = new ArrayList<Double>();
				line = buff.readLine();
				for(int i = 1 ; i < nbSat+1; i++) {
					satellites_opening.add(Double.parseDouble(line));
					line = buff.readLine();
				}
				
			// Fleets fixed costs
				
				line = buff.readLine();
				fixed_cost2 = Integer.parseInt(line);
				
				line = buff.readLine();
				fixed_cost1 = Integer.parseInt(line);
				
				
			}else { //Nguyen instances
				
				// Skips the first line
				
					String line = buff.readLine();
				
				//1. Reads the number of customers:
				
					line = buff.readLine();
					String[] attrs = line.split("	");
					nbSat = Integer.parseInt(attrs[0].trim());
					nbCustomers = Integer.parseInt(attrs[1].trim());
				
				// Captures trucks info: (total #, capacity, cost per distance, fixcost)	
					
					line = buff.readLine();
					attrs = line.split("	");
					Q1 = Integer.parseInt(attrs[0].trim());
					Q2 = Integer.parseInt(attrs[1].trim());
					fleet1 = nbCustomers;
					fleet2 = nbCustomers;
					
				// Fleets fixed costs
					
					line = buff.readLine();
					attrs = line.split("	");
					fixed_cost1 = Integer.parseInt(attrs[0].trim());
					fixed_cost2 = Integer.parseInt(attrs[1].trim());
					
				//4. Depot information
					
					line = buff.readLine();
					
				//5. Satellites information
					
					satellites_capacities = new ArrayList<Double>();
					satellites_opening = new ArrayList<Double>();
					handling_costs = new ArrayList<Double>();
					handling_costs.add(0.0);
					line = buff.readLine();
					for(int i = 1 ; i < nbSat+1; i++) {
						
						attrs = line.split("	");
						
						satellites_capacities.add(Double.parseDouble(attrs[2].trim()));
						satellites_opening.add(Double.parseDouble(attrs[3].trim()));
						handling_costs.add(0.0);
						line = buff.readLine();
					}
					
					
				//6. Customers information
					
					demands = new ArrayList<Double>();
					for(int i = 1 ; i < nbCustomers+1; i++) {
						attrs = line.split("	");
						demands.add(Double.parseDouble(attrs[2].trim()));
						line = buff.readLine();
					}
			
				

			}	
					
			// 5. Closes the buffered reader:
					
			buff.close();
	}

	// Getters / setters:
	
	
	/**
	 * @return the dim
	 */
	public int getDim() {
		return dim;
	}


	/**
	 * @param dim the dim to set
	 */
	public void setDim(int dim) {
		this.dim = dim;
	}


	/**
	 * @return the nbSat
	 */
	public int getNbSat() {
		return nbSat;
	}


	/**
	 * @param nbSat the nbSat to set
	 */
	public void setNbSat(int nbSat) {
		this.nbSat = nbSat;
	}


	/**
	 * @return the nbCustomers
	 */
	public int getNbCustomers() {
		return nbCustomers;
	}


	/**
	 * @param nbCustomers the nbCustomers to set
	 */
	public void setNbCustomers(int nbCustomers) {
		this.nbCustomers = nbCustomers;
	}


	/**
	 * @return the q1
	 */
	public int getQ1() {
		return Q1;
	}


	/**
	 * @param q1 the q1 to set
	 */
	public void setQ1(int q1) {
		Q1 = q1;
	}


	/**
	 * @return the q2
	 */
	public int getQ2() {
		return Q2;
	}


	/**
	 * @param q2 the q2 to set
	 */
	public void setQ2(int q2) {
		Q2 = q2;
	}


	/**
	 * @return the fleet1
	 */
	public int getFleet1() {
		return fleet1;
	}


	/**
	 * @param fleet1 the fleet1 to set
	 */
	public void setFleet1(int fleet1) {
		this.fleet1 = fleet1;
	}


	/**
	 * @return the fleet2
	 */
	public int getFleet2() {
		return fleet2;
	}


	/**
	 * @param fleet2 the fleet2 to set
	 */
	public void setFleet2(int fleet2) {
		this.fleet2 = fleet2;
	}


	/**
	 * @return the ms
	 */
	public int getMs() {
		return ms;
	}


	/**
	 * @param ms the ms to set
	 */
	public void setMs(int ms) {
		this.ms = ms;
	}

	/**
	 * @return the demands
	 */
	public ArrayList<Double> getDemands() {
		return demands;
	}

	/**
	 * @param demands the demands to set
	 */
	public void setDemands(ArrayList<Double> demands) {
		this.demands = demands;
	}

	/**
	 * @return the handling_costs
	 */
	public ArrayList<Double> getHandling_costs() {
		return handling_costs;
	}

	/**
	 * @param handling_costs the handling_costs to set
	 */
	public void setHandling_costs(ArrayList<Double> handling_costs) {
		this.handling_costs = handling_costs;
	}

	/**
	 * @return the largest_demand
	 */
	public double getLargest_demand() {
		return largest_demand;
	}

	/**
	 * @param largest_demand the largest_demand to set
	 */
	public void setLargest_demand(double largest_demand) {
		this.largest_demand = largest_demand;
	}

	/**
	 * @return the fixed_cost1
	 */
	public int getFixed_cost1() {
		return fixed_cost1;
	}

	/**
	 * @param fixed_cost1 the fixed_cost1 to set
	 */
	public void setFixed_cost1(int fixed_cost1) {
		this.fixed_cost1 = fixed_cost1;
	}

	/**
	 * @return the fixed_cost2
	 */
	public int getFixed_cost2() {
		return fixed_cost2;
	}

	/**
	 * @param fixed_cost2 the fixed_cost2 to set
	 */
	public void setFixed_cost2(int fixed_cost2) {
		this.fixed_cost2 = fixed_cost2;
	}

	/**
	 * @return the satellites_capacities
	 */
	public ArrayList<Double> getSatellites_capacities() {
		return satellites_capacities;
	}

	/**
	 * @param satellites_capacities the satellites_capacities to set
	 */
	public void setSatellites_capacities(ArrayList<Double> satellites_capacities) {
		this.satellites_capacities = satellites_capacities;
	}

	/**
	 * @return the satellites_opening
	 */
	public ArrayList<Double> getSatellites_opening() {
		return satellites_opening;
	}

	/**
	 * @param satellites_opening the satellites_opening to set
	 */
	public void setSatellites_opening(ArrayList<Double> satellites_opening) {
		this.satellites_opening = satellites_opening;
	}
	
	
	
	
}
