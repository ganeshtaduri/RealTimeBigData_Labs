

import org.apache.spark.{SparkConf, SparkContext}

/**
 * Created by Mayanka on 09-Sep-15.
 */
object SparkWordCount {

  def main(args: Array[String]) {

    System.setProperty("hadoop.home.dir", "D:\\winutils");

    val sparkConf = new SparkConf().setAppName("SparkWordCount").setMaster("local[*]")

    val sc = new SparkContext(sparkConf)

    val input = sc.textFile("input")
    val lineLengths = input.count()
    val output = input.sortBy(x=>x)
    output.foreach(println)
    println()
    println(s"The total number of lines are: $lineLengths")



    // val output=wc.reduceByKey(_+_)

    /*output_sorted.saveAsTextFile("output")

    val o=input.collect()


    output.saveAsTextFile("output")
     val o = output.collect()
     var s:String="Lines:\n"
     o.foreach{case(line)=>{

       s+=line+"\n"

     }}*/


  }
}




