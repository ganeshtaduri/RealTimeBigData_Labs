import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by Mayanka on 01-Sep-16.
  */
object SparkTransformation {
  def main(args: Array[String]): Unit = {


    System.setProperty("hadoop.home.dir", "D:\\winutils");


    val sparkConf = new SparkConf().setAppName("SparkTransformation").setMaster("local[*]")

    val sc = new SparkContext(sparkConf)

    val ganesh_friends = sc.textFile("Ganesh")
    val sachin_friends = sc.textFile("Sachin")
    val common = ganesh_friends.intersection(sachin_friends).collect().foreach(println)
    println("Are Common Friends of Ganesh and Sachin")
    val union = ganesh_friends.union(sachin_friends).distinct()
    val count = union.count()
    println(s"Total number of friends of Ganesh and Sachin are $count")

    val ganesh_count = ganesh_friends.count()
    println(s"Total number of Ganesh friends are $ganesh_count")
    val sachin_first  = sachin_friends.first()
    println(s"First friend in the sachins list is $sachin_first")

    

  }

}
