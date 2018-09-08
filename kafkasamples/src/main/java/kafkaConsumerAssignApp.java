import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class KafkaConsumerAssignApp {

    public static void main (String [] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers" , "localhost:9092, localhost:9093");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> myConsumer = new KafkaConsumer<String, String>(props);
        List<TopicPartition> partitionList = new ArrayList<TopicPartition>();

        TopicPartition partition = new TopicPartition("my-topic", 0);

        TopicPartition myOtherPartition = new TopicPartition("my-other-topic", 2);
        partitionList.add(partition);
        partitionList.add(myOtherPartition);


        myConsumer.assign(partitionList);

        try{
            while(true) {
                ConsumerRecords<String, String> myConsumerRecords = myConsumer.poll(10);
                for (ConsumerRecord<String, String> record: myConsumerRecords) {
                    System.out.println(String.format("Topic: %s , Partition : %s, Offset: %s, Key: %s, Value: %s", record.topic(),
                            record.partition(), record.offset(), record.key(), record.value()));
                }
            }

        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            myConsumer.close();
        }
    }
}
