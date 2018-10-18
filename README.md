# Performance-driven softwAre moDel Refactoring framEwork (PADRE)

## Installation instructions

### OVERVIEW
Our framework deals with UML models made of the following diagrams: a Component Diagram that describes the software components and their Interfaces/Operations; a Deployment Diagram that describes the allocation of artifacts, corresponding to components, on platform nodes; an Use Case Diagram that describes the actors and the use cases that they can execute; a number of Sequence Diagrams, one for each use case, that describe the system behavior in terms of interactions among components.  

### WEBSITE
TBD
 
### DOWNLOAD
Official Github repository: https://github.com/SEALABQualityGroup/padre
 
### INSTALLATION
 1. Download Eclipse Modelling Tool: https://www.eclipse.org/downloads/eclipse-packages/
 2. Installing the following EPSILON plugins from its Update Site (http://download.eclipse.org/epsilon/1.3/updates/):
    * core
    * development tools
    * EMF integration
    * GMF integration
    * UML integration
 3. Cloning PADRE from https://github.com/SEALABQualityGroup/padre.git
 4. Import in eclipse PADRE projects
 5. Create a running configuration for UML in:
   * EVL
     - Select an EVL file (e.g. padre/it.spe.disim.epsilon.antipattern_d-s/evl/AP-UML-MARTE.evl)
     - Give a name (e.g. BGCS)
     - Select a model from workspace (e.g. padre/it.spe.disim.epsilon.antipattern_d-s/model/uml/BGCS/BGCS.uml)
     - Select **only** this metamodels:
       - UML standar profile
       - UML
       - Ecore
   * EPL
     - Select an EPL file (e.g. padre/it.spe.disim.epsilon.antipattern_d-s/epl/AP-UML-MARTE.epl)
     - Give a name (e.g. BGCS)
     - Select a model from workspace (e.g. padre/it.spe.disim.epsilon.antipattern_d-s/model/uml/BGCS/BGCS.uml)
     - Select **only** this metamodels:
       - UML standar profile
       - UML
       - Ecore
   * EWL
     1. Add new EMF/GMF wizard (from Eclipse preferences -> epsilon -> EMF/GMF wizards)
     2. Select an EWL files from workspace (e.g. padre/it.spe.disim.epsilon.antipattern_d-s/ewl/AP-UML-MARTE.ewl)
     3. Select the UML namespace uri (http://www.eclipse.org/uml2/5.0.0/UML)
 6. enjoy :-)

### SYSTEM REQUIREMENTS
 - MacOS Sierra (10.12.06);
 - Eclipse Oxygen Modelling Tools with the following plugins in place: 
   - Epsilon 1.3, 
   - Papyrus (any)
     - Papyrus MARTE profile (dowloaded from http://download.eclipse.org/modeling/mdt/papyrus/updates/releases/neon)

### RELEASE NOTES
Latest Release: 1.0.0

### Review Description:
This release provides several major features:
 - supports several performance antipattern detection and removal
   - Blob, Pipe and Filter, Extensive Processing, Concurrent Processing Systems, Empty Semi Truck, Tower of Babel
 
### LICENSE
Eclipse Public License - v 1.0 (see http://www.eclipse.org/org/documents/epl-v10.php)
 
### DEVELOPER RESOURCES
Source Repositories: https://github.com/SEALABQualityGroup/padre.git
Clone: 
  - ssh: git@github.com:SEALABQualityGroup/padre.git
  - https: https://github.com/SEALABQualityGroup/padre.git 
 
You can use the code from these repositories to experiment, test, build, and create patches, issue pull requests.
 
### SUPPORT
We currently support:
  - email: daniele.dipompeo@graduate.univaq.it (please take care to use \[PADRE SUPPORT\] as object
  - issues on github.com
 
## Getting started guidelines
  
### EXAMPLES
We provide an example UML project that is a UML model representation of a Botanical Garden Control System (BGCS).
It is stored in padre/it.spe.disim.epsilon.antipattern_d-s/model/uml/BGCS/BGCS.uml. 
It is already filled with performance indices, and it is ready to use for a dummy execution.
 
## Additional information
Research publications:
 - Arcelli, Davide, Vittorio Cortellessa, and Daniele Di Pompeo. "Performance-driven software model refactoring." Information and Software Technology (2017).
 - Arcelli, Davide, Vittorio Cortellessa, and Daniele Di Pompeo. "Automated translation among EPSILON languages for performance-driven UML software model refactoring." Proceedings of the 1st International Workshop on Software Refactoring. ACM, 2016.
 - Arcelli, Davide, Vittorio Cortellessa, and Daniele Di Pompeo. "Towards a Unifying Approach for Performance-Driven Software Model Refactoring." GEMOC+ MPM@ MoDELS. 2015.
