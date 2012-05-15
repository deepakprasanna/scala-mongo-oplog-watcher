import com.mongodb._ 
import com.mongodb.casbah.Imports._ 

object MongoAnalysisDB {
  def main(args: Array[String]) = {
    //that connection
    val addresses = List(new ServerAddress("127.0.0.1" , 27018),  new ServerAddress("127.0.0.1" , 27019),  new ServerAddress( "127.0.0.1" , 27020 ))
    val mongoConn = MongoConnection(addresses) 
    val mongoDB = mongoConn("vimana-sandbox-dup") 
    val mongoColl = mongoConn("vimana-sandbox-dup")("utilization.metrics.cycledowntime") 


    //that query
    val loadEvent = MongoDBObject("period" -> "PT1H") 
    val cursor = mongoColl.find(loadEvent)
    val mtcevent = mongoColl.findOne(loadEvent)

    //that document
    println(mtcevent)
  }
}
