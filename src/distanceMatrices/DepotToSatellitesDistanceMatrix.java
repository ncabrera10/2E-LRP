package distanceMatrices;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import core.ArrayDistanceMatrix;
import util.EuclideanCalculator;

/**
 * This class implements an instance of a distance matrix, for the 2EVRPinstances
 * 
 * @author nicolas.cabrera-malik
 */
public class DepotToSatellitesDistanceMatrix extends ArrayDistanceMatrix{

	/**
	 * Constructs the distance matrix
	 * @throws IOException 
	 */
	
	public DepotToSatellitesDistanceMatrix(String path) throws IOException {
		
		super();
		
		// Read the coordinates of the nodes:
		
			//0. Creates a buffered reader:
			
			BufferedReader buff = new BufferedReader(new FileReader(path));
		
			//4.1 Initializes all the lists:
			
			ArrayList<Double> xCoors = new ArrayList<Double>();
			ArrayList<Double> yCoors = new ArrayList<Double>();
			
			if(path.contains("coord")) { //Prodhon instances
				
				//1. Reads the number of customers:
				
				String line = buff.readLine();
				int nbCustomers = Integer.parseInt(line);
				
				//2. Reads the number of satellites:
				
				line = buff.readLine();
				int nbSat = Integer.parseInt(line);
				
				//3. Skips two lines:
				
				line = buff.readLine();
				
				//4. Depot information
				
				line = buff.readLine();
				String[] attrs = line.split("	");
				xCoors.add(Double.parseDouble(attrs[0].trim()));
				yCoors.add(Double.parseDouble(attrs[1].trim()));
				
				//5. Satellites information
				
				line = buff.readLine();
				for(int i = 1 ; i < nbSat+1; i++) {
					attrs = line.split("	");
					xCoors.add(Double.parseDouble(attrs[0].trim()));
					yCoors.add(Double.parseDouble(attrs[1].trim()));
					line = buff.readLine();
				}
				
				
				//6. Customers information
				
				line = buff.readLine();
				for(int i = 1 ; i < nbCustomers+1; i++) {
					attrs = line.split("	");
					line = buff.readLine();
				}
				
			}else {
				
				// Skips the first line
				
					String line = buff.readLine();
				
				//1. Reads the number of customers:
				
					line = buff.readLine();
					String[] attrs = line.split("	");
					int nbSat = Integer.parseInt(attrs[0].trim());
					int nbCustomers = Integer.parseInt(attrs[1].trim());
				
				// Captures trucks info: (total #, capacity, cost per distance, fixcost)	
					
					line = buff.readLine();
					attrs = line.split("	");

				// Fleets fixed costs
					
					line = buff.readLine();
					attrs = line.split("	");

				//4. Depot information
					
					line = buff.readLine();
					attrs = line.split("	");
					xCoors.add(Double.parseDouble(attrs[0].trim()));
					yCoors.add(Double.parseDouble(attrs[1].trim()));
					
					
				//5. Satellites information
					
					line = buff.readLine();
					for(int i = 1 ; i < nbSat+1; i++) {
						attrs = line.split("	");
						xCoors.add(Double.parseDouble(attrs[0].trim()));
						yCoors.add(Double.parseDouble(attrs[1].trim()));
						line = buff.readLine();
					}
					
					
				//6. Customers information
					
					
					for(int i = 1 ; i < nbCustomers+1; i++) {
						
						line = buff.readLine();
					}
				
			}

			// 5. Closes the buffered reader:
					
			buff.close();
					
			
		// Number of nodes:
		
		int dimension = xCoors.size();

		// Initializes the distance matrix:
		
		double[][] distances = new double[dimension][dimension];
		
		// Fills the matrix:
		
			//Between customers:
		
			EuclideanCalculator euc = new EuclideanCalculator();
			if(path.contains("coord")) { //Prodhon instances
				
				for(int i = 0; i < dimension; i++) {
					
					for(int j = 0; j < dimension; j++) {
						
						distances[i][j] = Math.ceil(euc.calc(xCoors.get(i),yCoors.get(i),xCoors.get(j),yCoors.get(j)) * 100 * 2);
						
					}
					
				}
				
			}else {
				
				for(int i = 0; i < dimension; i++) {
					
					for(int j = 0; j < dimension; j++) {
						
						distances[i][j] = Math.ceil(euc.calc(xCoors.get(i),yCoors.get(i),xCoors.get(j),yCoors.get(j)) * 10 * 2);
						
					}
					
				}
			}
		
		// Sets the distance matrix:
		
		this.setDistances(distances);
	}
}
