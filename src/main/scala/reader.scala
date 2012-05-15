import com.mongodb.casbah.Imports._ 

object MongoAnalysisDB {
  def main(args: Array[String]) = {
    //that connection
    val mongoConn = MongoConnection("127.0.0.1", 27018) 
    val mongoDB = mongoConn("vimana-analysis") 
    val mongoColl = mongoConn("vimana-analysis")("mtcevents") 

    //that query
    val loadEvent = MongoDBObject("jsonClass" -> "Load") 
    val cursor = mongoColl.find(loadEvent)
    val mtcevent = mongoColl.findOne(loadEvent)

    //that document
    println(mtcevent)
  }
}
