# Projects

To Create new topic

bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic jsa-test

To publish messages using Kafka producer

bin/kafka-console-producer.sh --broker-list localhost:9092 --topic jsa-test

To read messages using Kafka Consumer

bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic jsa-test --from-beginning

To List the topic available in the Cluster

bin/kafka-topics.sh --list --zookeeper localhost:2181

bin/kafka-producer-perf-test.sh --topic my-other-topic --record-size 1 --throughput 10 --producer-props bootstrap.servers=localhost:9092 key.serializer=org.apache.kafka.common.serialization.StringSerializer value.serializer=org.apache.kafka.common.serialization.StringSerializer --num-records 4
