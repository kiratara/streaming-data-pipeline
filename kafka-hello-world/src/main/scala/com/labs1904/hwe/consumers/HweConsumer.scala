package com.labs1904.hwe.consumers

import com.labs1904.hwe.consumers.SimpleConsumer.EnrichedUser
import com.labs1904.hwe.producers.SimpleProducer
import com.labs1904.hwe.util.Util
import com.labs1904.hwe.util.Util.{getScramAuthString, numberToWordMap}
import net.liftweb.json.DefaultFormats
import org.apache.kafka.clients.consumer.{ConsumerConfig, ConsumerRecord, ConsumerRecords, KafkaConsumer}
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}
import org.apache.kafka.common.serialization.StringDeserializer

import java.time.Duration
import java.util.{Arrays, Properties, UUID}

//case class RawUser(id: Int, fullName: String, email:String )
//case class EnrichedUser(id: Int, fullName: String, email:String, numberAsWord: String, hweDeveloper: String )

object HweConsumer {
  val BootstrapServer : String = "b-2-public.hwe-kafka-cluster.l384po.c8.kafka.us-west-2.amazonaws.com:9196,b-1-public.hwe-kafka-cluster.l384po.c8.kafka.us-west-2.amazonaws.com:9196,b-3-public.hwe-kafka-cluster.l384po.c8.kafka.us-west-2.amazonaws.com:9196"
  val consumerTopic: String = "question-1"
  val producerTopic: String = "question-1-output"
  val username: String = "hwe"
  val password: String = "1904labs"
  //Use this for Windows
//  val trustStore: String = "src\\main\\resources\\kafka.client.truststore.jks"
  //Use this for Mac
  val trustStore: String = "src/main/resources/kafka.client.truststore.jks"

  implicit val formats: DefaultFormats.type = DefaultFormats

  def main(args: Array[String]): Unit = {

    // Create the KafkaConsumer
    val consumerProperties = SimpleConsumer.getProperties(BootstrapServer)
    val consumer: KafkaConsumer[String, String] = new KafkaConsumer[String, String](consumerProperties)

    // Create the KafkaProducer
    val producerProperties = SimpleProducer.getProperties(BootstrapServer)
    val producer = new KafkaProducer[String, String](producerProperties)


    // Subscribe to the topic
    consumer.subscribe(Arrays.asList(consumerTopic))

    while ( {
      true
    }) {
      // poll for new data
      val duration: Duration = Duration.ofMillis(100)
      val records: ConsumerRecords[String, String] = consumer.poll(duration)

      records.forEach((record: ConsumerRecord[String, String]) => {
        // Retrieve the message from each record
        val message = record.value()
        println(s"Message Received: $message")
        // TODO: Add business logic here!
        val splitMessage = message.split(',')

        println(s"Message Received: $message")
        val userId = splitMessage(0).toInt
        val idAsWord = numberToWordMap(userId)
        val newUser = EnrichedUser(userId, splitMessage(1), splitMessage(2), idAsWord, "BR")
        val csvString = newUser.id + "," + newUser.fullName.replace(",", "") + "," + newUser.email.replace(",", "") + "," + newUser.numberAsWord.replace(",", "") + "," + newUser.hweDeveloper.replace(",", "")
        println(csvString)
        val newRecord = new ProducerRecord[String, String](producerTopic, csvString)
        producer.send(newRecord)
        println("sent new record to")
        //        new ProducerRecord[String, String](producerTopic, userId, csvString)
        //      }).foreach(toSendRecord => {
        //
        //        // send records to topic
        //        producer.send(toSendRecord, new Callback() {
        //          override def onCompletion(recordMetadata: RecordMetadata, e: Exception): Unit = {
        //            if (e == null) {
        //              println(
        //                s"""
        //                   |Sent Record: ${record.value()}
        //                   |Topic: ${recordMetadata.topic()}
        //                   |Partition: ${recordMetadata.partition()}
        //                   |Offset: ${recordMetadata.offset()}
        //                   |Timestamp: ${recordMetadata.timestamp()}
        //          """.stripMargin)
        //            } else println("Error while producing", e)
        //          }
        //        })
        //      })
    })
    }
    producer.close()

  }
}