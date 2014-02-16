examples-ch02-getting_started
=============================
The "Hello World" of [Apache Storm topologies](https://github.com/apache/incubator-storm)



How to Run it
=============
You can run the storm tolology with this command:
_mvn exec:java -Dexec.mainClass="TopologyMain" -Dexec.args="src/main/resources/words.txt"

you will see the output being generated that produces a count for each word seen in the input file.By default only one node will be used for the word counter, but it can be configured as below:

_mvn exec:java -Dexec.mainClass="TopologyMain" -Dexec.args="src/main/resources/words.txt 2"
