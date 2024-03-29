===========================================================================================================================================================================
 Readme for the MSH Java code for 2E-LRP
 Version: 1.0
===========================================================================================================================================================================

 Author:       Nicolás Cabrera (nicolas.cabrera-malik@hec.ca)
               Logistics and Operations Management department
               HEC Montreal       

===========================================================================================================================================================================

This file contains important information about the Java code for the 2ELRP.

To visualize all our solutions or new ones you can use this website: https://nicolascabrera.shinyapps.io/2EVRP/

===========================================================================================================================================================================

The file 2E-VRP contains all the source code for executing the Multi-space sampling heuristic (MSH) for solving the two-echelon location routing problem (2LVRP). 

The main class is called "Main". In this class the user can select the instance (line 44) and the configuration file (line 48).

The configuration file is an xml file that should be saved in the "config" folder. 
 
We include a sample configuration file (default.xml).


===========================================================================================================================================================================
Default instance
===========================================================================================================================================================================

The default instance is 25-5MN. The objective function of the best-known solution for this instance is 80370.


===========================================================================================================================================================================
References
===========================================================================================================================================================================

-Mendoza, J. E., & Villegas, J. G. (2013). A multi-space sampling heuristic for the vehicle routing problem with stochastic demands. Optimization Letters, 7, 1503-1516.

-Cabrera, N., Cordeau, J. F., & Mendoza, J. E. (2022). The doubly open park-and-loop routing problem. Computers & Operations Research, 143, 105761.


===========================================================================================================================================================================
Usage & License
===========================================================================================================================================================================

If you use this code please send a line to nicolas.cabrera-malik@hec.ca describing us your application.
