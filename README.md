# Projects


bin/kafka-producer-perf-test.sh --topic my-other-topic --record-size 1 --throughput 10 --producer-props bootstrap.servers=localhost:9092 key.serializer=org.apache.kafka.common.serialization.StringSerializer value.serializer=org.apache.kafka.common.serialization.StringSerializer --num-records 4
