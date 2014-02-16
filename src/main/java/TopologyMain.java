import spouts.WordReader;
import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.tuple.Fields;
import bolts.WordCounter;
import bolts.WordNormalizer;


public class TopologyMain {
	public static void main(String[] args) throws InterruptedException {
         
        
	 //Configuration
                Config conf = new Config();
                conf.put("wordsFile", args[0]);
                conf.setDebug(false);

	 //How many "nodes" in cluster to parallelize work
		int numNodes=1;
		if (args.length > 1) {
   			try {
				numNodes= Integer.parseInt(args[1]);
	  		 }
			 catch (NumberFormatException e) {
        			System.err.println("Number of nodes " + " must be an integer");
       				System.exit(1);
   			 }
		}

	//Topology definition
		TopologyBuilder builder = new TopologyBuilder();
		builder.setSpout("word-reader",new WordReader());
		builder.setBolt("word-normalizer", new WordNormalizer())
			.shuffleGrouping("word-reader");
		builder.setBolt("word-counter", new WordCounter(),numNodes)
			.fieldsGrouping("word-normalizer", new Fields("word"));
		
        //Topology run
		conf.put(Config.TOPOLOGY_MAX_SPOUT_PENDING, 1);
		LocalCluster cluster = new LocalCluster();
		cluster.submitTopology("Getting-Started-Toplogie", conf, builder.createTopology());
		Thread.sleep(1000);
		cluster.shutdown();
	}
}
