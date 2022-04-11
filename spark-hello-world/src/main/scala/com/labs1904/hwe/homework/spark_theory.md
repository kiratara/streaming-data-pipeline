# Overview

Similar to the work you did for Kafka, this is your crash course into Spark through different questions. In this homework, your
challenge is to write answers that make sense to you, and most importantly, **in your own words!**
Two of the best skills you can get from this class are to find answers to your questions using any means possible, and to
reword confusing descriptions in a way that makes sense to you. 

### Tips
* You don't need to write novels, just write enough that you feel like you've fully answered the question
* Use the helpful resources that we post next to the questions as a starting point, but carve your own path by searching on Google, YouTube, books in a library, etc to get answers!
* We're here if you need us. Reach out anytime if you want to ask deeper questions about a topic 
* This file is a markdown file. We don't expect you to do any fancy markdown, but you're welcome to format however you like
* Spark By Examples is a great resources to start with - [Spark By Examples](https://sparkbyexamples.com/)

### Your Challenge
1. Create a new branch for your answers 
2. Complete all of the questions below by writing your answers under each question
3. Commit your changes and push to your forked repository

## Questions
#### What problem does Spark help solve? Use a specific use case in your answer 
* Helpful resource: [Apache Spark Use Cases](https://www.toptal.com/spark/introduction-to-apache-spark)
* [Overivew of Apache Spark](https://www.youtube.com/watch?v=znBa13Earms&t=42s)
* Spark helps anaylze and process large datasets, and does it fast.
* It also can do so for real-time streaming data in addition to batch data.
* Use case: Analyzing user interaction to provide a more targeted feedback/recommendation to users in a e-commerece site.
* 

#### What is Apache Spark?
* Helpful resource: [Spark Overview](https://www.youtube.com/watch?v=ymtq8yjmD9I) 
* Data processing engine. Distributed, fast, and fault tolerant. 

#### What is distributed data processing? How does it relate to Apache Spark?  
[Apache Spark for Beginners](https://medium.com/@aristo_alex/apache-spark-for-beginners-d3b3791e259e)
* Distributed -> data residing in multiple nodes. All the nodes execute a task, analyze data, parallel to each other.
* Apache Spark is also distributed, cluster computing framework.
* Apache Spark can do distributed data processing.

#### On the physical side of a spark cluster, you have a driver and executors. Define each and give an example of how they work together to process data
* Driver 
  * process where the main() method runs
  * Executes user code
  * Create Spark Session/ Spark context
    * Spark session/context is responsible for creating Dataset, DataFrame, RDD, execute SQL, perform Transformation & Action, etc.
* Executor:
  * resides in worker node 
  * responsible for running individual tasks and return results to the driver
  * 

#### Define each and explain how they are different from each other 
* RDD (Resilient Distributed Dataset)
  * collection of objects (user-made).
  * Distributed
  * Contains Dataset
  * Structured and unstructured data formats are accepted.
* DataFrame
  * Collection of unmodified distributed data
  * data is organized into columns named as a table in the relational database
  * enables developers to impose a structure on distributed data collection
  * Structured and semi-structured data formats are accepted
* DataSet
  * Extension of dataFrame
  * Combination of RDD and DataFrame

#### What is a spark transformation?
[Spark By Examples-Transformations](https://sparkbyexamples.com/apache-spark-rdd/spark-rdd-transformations/)
* Spark Transformation
  * Type of operation that can be performed in Spark on RDD. These types of operation "transform" the RDD and return a new RDD.
  * New RDD becasue they are immutable.
  * Example operations/functions: filter(), map, union
* Another type of operation is Action. Unlike, transformation, it returns a value isntead of a new RDD. 
  * Example: count(), first()
#### What is a spark action? How do actions differ from transformations? 
* Spark Action:
  * A type of Spark operation performed on RDD.
  * It returns some value.
  * Transformation, returns a new RDD
  * Example: count(), first

#### What is a partition in spark? Why would you ever need to repartition? 
[Spark Partitioning](https://sparkbyexamples.com/spark/spark-repartition-vs-coalesce/)
* Partitioning is a way where Spark divides data (RDD) into partitions for parallel processing
* Repartitioning - increasing or decreasing the partition.
* Why repartition -> Transformed data? 


#### What was the most fascinating aspect of Spark to you while learning? 
