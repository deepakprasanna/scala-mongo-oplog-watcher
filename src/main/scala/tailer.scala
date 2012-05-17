import com.mongodb._
import com.mongodb.casbah.Imports._

object MongoOplog {
  def main(args: Array[String]) = {
    val mongoConn = new Mongo( "127.0.0.1" , 27018 );
    val db = mongoConn.getDB("local");
    val oplog = db.getCollection("oplog.$main") 
    val cursor = oplog.find().addOption(Bytes.QUERYOPTION_NOTIMEOUT)
                             .addOption(Bytes.QUERYOPTION_TAILABLE) 
                             .addOption(Bytes.QUERYOPTION_AWAITDATA) 
    while(cursor.hasNext) {
      val doc = cursor.next
      println(doc)
    }
  }
}
