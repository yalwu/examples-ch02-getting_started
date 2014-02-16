Examples-ch02-getting_started
=============================
The "Hello World" of [Apache Storm topologies](https://github.com/apache/incubator-storm) uses the well-known word counter example to demonstrate the concept of spouts, bolts and configuring storm clusters.



How to Run it
=============
You can run the storm tolology with this command:

*mvn exec:java -Dexec.mainClass="TopologyMain" -Dexec.args="src/main/resources/words.txt"*

You will see the output being generated that produces a count for each word seen in the input file. By default only one node will be used for the word counter, but it can be configured as below:

*mvn exec:java -Dexec.mainClass="TopologyMain" -Dexec.args="src/main/resources/words.txt 2"*
