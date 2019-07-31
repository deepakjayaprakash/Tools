package kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * @author deepak.jayaprakash
 */
public class KafkaEventProducer {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstants.KAFKA_BROKERS);
        props.put(ProducerConfig.CLIENT_ID_CONFIG, KafkaConstants.CLIENT_ID);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        Producer producer = new KafkaProducer(props);
        ProducerRecord<String, String> rec;
        rec = new ProducerRecord<>(KafkaConstants.TOPIC_NAME, "value");
        producer.send(rec, (recordMetadata, e) -> {
            if (e != null) {
                System.out.println("Exception occured while sending data to kafka: " + e);
            } else {
                System.out.println("successfully sent event" + rec);
            }
        });
        producer.close();
    }
}
