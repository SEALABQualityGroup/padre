## Framework
The framework architecture is illustrated in Figure \ref{fig:framework}, which basically shows the main actors that it involves, together with its workflow.

![The PADRE framework](/assets/images/framework.png)

The framework is centered on three performance antipatterns detection and solution engines that provide different interactive support to the designer, and that are respectively based on EPL, EVL, and EWL. The designer selects the engine to use in order to perform refactoring sessions starting from an initial software model, i.e. *M<sub>0</sub>*, which conforms to UML+MARTE metamodel and is given as input to the selected engine. During a refactoring session, a number of new refactored models, i.e., *M<sub>1</sub>,..,M<sub>n-1</sub>*, can be created until a software model that satisfies performance requirements is obtained, i.e. *M<sub>n</sub>*.

PADRE deals with UML models made of the following diagrams: a Component Diagram that describes the software components and their Interfaces/Operations; a Deployment Diagram that describes the allocation of artifacts, corresponding to components, on platform nodes; a Use Case Diagram that describes the actors and scenarios; a number of Sequence Diagrams, one for each use case, that describe the system behavior.  

A performance expert has to build the basic knowledge *K<sub>UML+MARTE</sub>*, which is the UML+MARTE representation of performance antipatterns detection rules and refactoring actions that can be applied to remove them. Such knowledge is then used to produce detection and refactoring code in one of the considered *EPSILON* languages.

### Involved european project
PADRE is part of the [MegaM@Rt2 European Project](https://megamart2-ecsel.eu/) toolset. 

 
## Getting started 

 1. Download [Eclipse Modelling Tool](https://www.eclipse.org/downloads/eclipse-packages/)
 2. Install the EPSILON framework from its [Update Site](https://download.eclipse.org/epsilon/updates/):
 3. Clone PADRE from its [github repository](https://github.com/SEALABQualityGroup/padre)
 4. Import PADRE-PerfDetection projects
       * Clone the Padre example [repository](https://github.com/SEALABQualityGroup/padre-examaple)
       * Run the given running configuration "AP-UML-MARTE.launch" within the example project for the BGCS UML example model
 5. Enjoy the tool:-)

## Publication

If you are using PADRE or you have though PADRE is related to your research, please consider to cite it as follows:

  * our Information and Software Technology paper

```
@article{DBLP:journals/infsof/ArcelliCP18,
  author    = {Davide Arcelli and
               Vittorio Cortellessa and
               Daniele Di Pompeo},
  title     = {Performance-driven software model refactoring},
  journal   = {Inf. Softw. Technol.},
  volume    = {95},
  pages     = {366--397},
  year      = {2018},
  url       = {https://doi.org/10.1016/j.infsof.2017.09.006},
  doi       = {10.1016/j.infsof.2017.09.006},
  timestamp = {Thu, 20 Feb 2020 13:20:31 +0100},
  biburl    = {https://dblp.org/rec/journals/infsof/ArcelliCP18.bib},
  bibsource = {dblp computer science bibliography, https://dblp.org}
}
```
[download the bib from dblp](https://dblp.uni-trier.de/rec/bib1/journals/infsof/ArcelliCP18.bib), [pdf](https://doi.org/10.1016/j.infsof.2017.09.006), or the [preprint version](http://danieledipompeo.github.io/files/2018-JIST-Performance-driven-software-model-refactoring.pdf) 

  * or our SANER 2019 demo paper

```
@inproceedings{DBLP:conf/wcre/ArcelliCP19,
  author    = {Davide Arcelli and
               Vittorio Cortellessa and
               Daniele Di Pompeo},
  editor    = {Xinyu Wang and
               David Lo and
               Emad Shihab},
  title     = {Automating Performance Antipattern Detection and Software Refactoring
               in {UML} Models},
  booktitle = {26th {IEEE} International Conference on Software Analysis, Evolution
               and Reengineering, {SANER} 2019, Hangzhou, China, February 24-27,
               2019},
  pages     = {639--643},
  publisher = {{IEEE}},
  year      = {2019},
  url       = {https://doi.org/10.1109/SANER.2019.8667967},
  doi       = {10.1109/SANER.2019.8667967},
  timestamp = {Wed, 16 Oct 2019 14:14:53 +0200},
  biburl    = {https://dblp.org/rec/conf/wcre/ArcelliCP19.bib},
  bibsource = {dblp computer science bibliography, https://dblp.org}
}
```

[download the bib form dblp](https://dblp.uni-trier.de/rec/bibtex/conf/wcre/ArcelliCP19)
