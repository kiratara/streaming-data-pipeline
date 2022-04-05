# Overview

Kafka has many moving pieces, but also has a ton of helpful resources to learn available online. In this homework, your
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
   1. 'kafka_theory'
2. Complete all of the questions below by writing your answers under each question
3. Commit your changes and push to your forked repository

## Questions
#### What problem does Kafka help solve? Use a specific use case in your answer 
* Helpful resource: [Confluent Motivations and Use Cases](https://youtu.be/BsojaA1XnpM)
  * Event - what does it mean? 
    * Can simply mean data OR represents a change in state of data (a bank deposit completed, checkout button clicked by user)
    * Can also mean - event streaming processing: event/data streams are ingested and calculations performed and data is transformed/enriched to create new insights or take another action
    * Message
  * Event stream - What does it mean?
    * Sequence of events.
    * Order matters
    * Events flow through some system in a specific direction: Producers --> Consumers
    * Event Streaming (another way to say/think) 
    > Capturing data in real-time from event sources like databases, sensors, mobile devices, cloud services, and software applications in the form of streams of events, storing these event streams durably for later retrieval; manipulating, processing, and reacting to the event streams in real-time as well as retrospectively; and routing the event streams to different destination technologies as needed. Event streaming thus ensures a continuous flow and interpretation of data so that the right information is at the right place, at the right time.
  * What is the problem?
    * System design is changing from viewing "data as things" (traditional database) to "data as events". 
    * "Data as things" are stored in databases, whereas "data as events" are stored in logs (ordered sequence of the events)
    * There is continuous stream of events instead of a static summary of the events, and we want to process these events.
    * There is need for an infrastructure and platform to help achieve this. This requires more than just storage, but one that *processes* these events in real-time and also possibly stores it for a long time.
  * Example use case:
    * "Optimize in-game purchase by figuring out who is doing what right now" - analyze real-time input to determine followup response
    
#### What is Kafka?
* Helpful resource: [Kafka in 6 minutes](https://youtu.be/Ch5VhJzaoaI) 
* Kafka is:
  * Event Streaming Platform
  * Distributed
  * A system for managing the logs ("Data as events"). 
  * Horizontally scalable, fault-tolerant (replication)
  * Basically, a system that enables Event Streaming as described above under "What problem does Kafka help solve"

#### Describe each of the following with an example of how they all fit together: 
 * Topic: A grouping of Partitions handling the same type of data/event/record/message. 
   * Ordered collections of events stored in a disk and replicated.
     * Can be small or enormous
     * Can be stored for short or very long time 
     * Each item in topic represents an event happening in real world
 * Producer: Application that writes data to the brokers. 
 * Consumer: Application that consumes data from the brokers
   * Consumers are the applications that utilize the offset and read from the partitions within each broker.
   * Lightweight: can create many consumer without affecting the performance.
     * How? Kafka only maintains the latest offset read by the consumer. 
   * Consumer groups: 
     * Includes set of consumer processes that subscribe to a specific topic
     * Consumer in the same group will not read from the same partition
   * Can be parallelized 
 * Broker:  Each server (physical?) one or more Partitions
   * Can span multiple data centers or cloud regions
 * Partition: Each queue holding (related?) messages/Record
     * Record: Each event/message that has offset as its uniqueID
     * Offset: A unique sequential number assigned to each record for identification

#### Describe Kafka Producers and Consumers
* Producers: 
  * Applications that publish/write events/records to the Kafka. They are completely decoupled from consumers and never need to wait for consumers. This allows for the high scalability of Kafka.
* Consumers:
  * Applications that subscribe/read events/records from the Kafka. They are decoupled from the producers and read data from the partition.

#### How are consumers and consumer groups different in Kafka? 
* Helpful resource: [Consumers](https://youtu.be/lAdG16KaHLs)
* Helpful resource: [Confluent Consumer Overview](https://youtu.be/Z9g4jMQwog0)
* Consumer groups are made of single or multiple consumers. Specific consumer read data from specific topic. Purpose of consumer group is parallelism, multiple consumers read from different partitions (of same topic) at the same time. 
* Multiple consumers in a group cannot read from the same partition, but a single consumer can read from multiple partitions. 
* Multiple consumers, not from the same consumer group, can read from the same partition (>)

#### How are Kafka offsets different than partitions? 
* Offset is the unique number assigned (per partition) to a record. Consumers use this value by keeping track of what offset value they most recently read to identify the next record to read.
* Whereas, Partitions hold the records. Can be thought of as buckets that hold the records. A topic can be spread over different partitions.
  * Partitioning is taking a single topic log and break into multiple smaller logs. Each of these logs will then live on a separate node in Kafka cluster.
  
#### How is data assigned to a specific partition in Kafka? 
If the message/record has no key, round-robin method is used to save each message into all the partitions for that topic.
* If the message|record does have a key, the key is used to determine the destination partition where it will be stored. Messages with same key will always be in the same partition and always in order.
* Key example: customerID - All events created by a specific customer will all exist in the same partition and in order.

#### Describe immutability - Is data on a Kafka topic immutable? 
* Yes, the kafka topic is immutable. Data can only be appended to each of the partition. Each of these data/record is assigned the unique and sequential id called offset that the consumer relied on for reading and tracking. This order cannot be changed.

#### How is data replicated across brokers in kafka? If you have a replication factor of 3 and 3 brokers, explain how data is spread across brokers
* Helpful resource [Brokers and Replication factors](https://youtu.be/ZOU7PJWZU9w)
* Each partition for a topic is stored in multiple (replication factor) brokers. 
* With 3 brokers and a replication factor of 3, the expectation is that each partition will need to exist in each broker (3 instances).

#### What was the most fascinating aspect of Kafka to you while learning? 
Decoupling of Producers and Consumers. It was interesting to imagine one side doing its work without any consideration for the other. The producers are focused on filling the buckets with data without caring what happens to it. The consumers, on the other hand, read this data and do their thing on their own pace, also without caring about how fast/slow the Producers are producing this data. 
