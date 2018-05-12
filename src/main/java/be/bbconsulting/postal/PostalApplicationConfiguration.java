package be.bbconsulting.postal;

import be.bbconsulting.postal.events.EventChannel;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.schema.avro.AvroSchemaMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.util.MimeType;

@Configuration
@EnableBinding(EventChannel.class)
public class PostalApplicationConfiguration {

    @Bean
    public MessageConverter eventMessageConverter() {
        AvroSchemaMessageConverter avroSchemaMessageConverter = new AvroSchemaMessageConverter(MimeType.valueOf("avro/bytes"));
        avroSchemaMessageConverter.setSchemaLocation(new ClassPathResource("avro/Event.avsc"));
        return avroSchemaMessageConverter;
    }
}


