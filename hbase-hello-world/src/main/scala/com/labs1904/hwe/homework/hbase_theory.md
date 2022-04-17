# Overview

By now you've seen some different Big Data frameworks such as Kafka and Spark. Now we'll be focusing in on HBase. In this homework, your
challenge is to write answers that make sense to you, and most importantly, **in your own words!**
Two of the best skills you can get from this class are to find answers to your questions using any means possible, and to
reword confusing descriptions in a way that makes sense to you. 

### Tips
* You don't need to write novels, just write enough that you feel like you've fully answered the question
* Use the helpful resources that we post next to the questions as a starting point, but carve your own path by searching on Google, YouTube, books in a library, etc to get answers!
* We're here if you need us. Reach out anytime if you want to ask deeper questions about a topic 
* This file is a markdown file. We don't expect you to do any fancy markdown, but you're welcome to format however you like


### Your Challenge
1. Create a new branch for your answers 
2. Complete all of the questions below by writing your answers under each question
3. Commit your changes and push to your forked repository

## Questions
#### What is a NoSQL database? 
* non-relational databases, distributed. Do not have a strict structure
* Key-value
* document - semi-structured, store in document format, JSON: couchDB, mongoDB
* columnar - similar to relational database, has rows and columns, BUT each row can have different format for its column
* graph - organize data as nodes
* Does not have query language but has API


#### In your own words, what is Apache HBase? 
* Non-relational database 
* built on top of HDFS
* Comprises set of standard tables with rows and columns, similar to traditional databases.
* Each table has primary key and is needed to access the table
* can serve as the input and output for MapReduce jobs
* suitable for real-time rather than batch analytics


#### What are some strengths and limitations of HBase? 
* [HBase By Examples](https://sparkbyexamples.com/apache-hbase-tutorial/)
* Difficult for querying
* Cannot do join on the HBase tables
* CPU and Memory intensive since it utlizies in-memory operations
* Compound key is not possible
* Single point of failure - HMaster, takes long time for the replica to replace if the original goes down

#### Explain the following concepts: 
* Rowkey
  * Each row is referenced by a unique key - similar to Primary key in relational database.
  * rows are sorted by this rowkey
* Column Qualifier
  * Within a column family
  * Actual column names 
* Column Family
  * Logical and physical grouping of columns
  * For each row, you do  not define a column, but instead define a column family which then can have columns

  
#### What are the differences between Get and Put commands in HBase? 
* [HBase commands](https://www.tutorialspoint.com/hbase/hbase_create_data.htm)
* Get
  * Read data from a table
* Put
  * Used for inserting rows into a table
  * put a cell 'value' at a specific table, row or column


#### What is the HBase Scan command for? 
* [HBase Scan](https://www.tutorialspoint.com/hbase/hbase_scan.htm)
* used to view the data
* If run in Hbase shell it will display the inserted values with column and row names

#### What was the most interesting aspect of HBase when went through all the questions? 
 