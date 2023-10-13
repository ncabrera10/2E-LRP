#### 0. Libraries ####

# This function verifies which packages are missing. If a package is missing, is automatically installed.

foo <- function(x){
  for(i in x){
    #  Returns true if it was possible to load the package
    if(!require(i,character.only = TRUE)){
      #  If the package was not loaded, then we proceed to the installation
      install.packages(i,dependencies = TRUE)
      #  Load the package after the installation
      require( i , character.only = TRUE )
    }
  }
}

#  Load pakages:

foo(c("readr","openxlsx","sqldf","stringr","fields","mgsub"))

#### 1. Functions ####

  rename_arcs_files <- function(ini_path){
    
    # List all files in the path
    
    files_names <- list.files(path = ini_path,pattern = ".txt")
    
    # Take all the files that have the ".dat"
    
    files_names <- files_names[grepl(".dat",files_names)]
    
    # Rename the files:
    
    new_files_names <- mgsub(files_names,".dat","")
    
    file.rename(paste0(ini_path,files_names),paste0(ini_path,new_files_names))
    
    
  }
  
#### 3. USER ###
  
  ini_path <- "/Users/nicolas.cabrera-malik/Documents/Work/Thesis/2EVRP/Code/2E-LRP/2E-LRP/results/v2/"

  rename_arcs_files(ini_path)