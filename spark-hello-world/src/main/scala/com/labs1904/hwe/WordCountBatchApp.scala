package com.labs1904.hwe

import org.apache.log4j.Logger
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

case class Word(word: String, num: Int)

object WordCountBatchApp {
  lazy val logger: Logger = Logger.getLogger(this.getClass)
  val jobName = "WordCountBatchApp"

  def main(args: Array[String]): Unit = {
    logger.info(s"$jobName starting...")
    try {
      val spark = SparkSession.builder()
        .appName(jobName)
        .config("spark.sql.shuffle.partitions", "3")
        .master("local[*]")
        .getOrCreate()
      import spark.implicits._

      val sentences = spark.read.csv("src/main/resources/sentences.txt").as[String]
      sentences.printSchema
      //sentences.show()

      // TODO: implement me
      val splitWordsDf = sentences.map(row => splitSentenceIntoWords(row))
      splitWordsDf.show()
      val wordDf = splitWordsDf.map(word)

      //        val splitWords.map(word => {
//          val wordInstance = Word(word, 1)
//        })
      //val counts = ???

      //counts.foreach(wordCount=>println(wordCount))
    } catch {
      case e: Exception => logger.error(s"$jobName error in main", e)
    }
  }

  // TODO: implement this function
  // HINT: you may have done this before in Scala practice...
  def splitSentenceIntoWords(sentence: String): Array[String] = {
    val splitSentence = sentence.split(" ")
    return splitSentence
  }

}
