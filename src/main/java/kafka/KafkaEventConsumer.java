package kafka;

import org.apache.kafka.clients.consumer.*;

import java.util.Arrays;
import java.util.Properties;

/**
 * @author deepak.jayaprakash
 */
public class KafkaEventConsumer {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstants.KAFKA_BROKERS);
        props.put(ConsumerConfig.CLIENT_ID_CONFIG, KafkaConstants.CLIENT_ID);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.ByteArrayDeserializer");
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, KafkaConstants.GROUP_ID_CONFIG);

        Consumer consumer = new KafkaConsumer<String, String>(props);
        consumer.subscribe(Arrays.asList(KafkaConstants.TOPIC_NAME));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(10);
            for (ConsumerRecord<String, String> record : records)
                System.out.println(record.value());
        }
    }
}
