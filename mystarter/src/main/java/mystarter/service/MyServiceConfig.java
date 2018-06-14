package mystarter.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(Myproperties.class)
public class MyServiceConfig {

    @Autowired
    private Myproperties myproperties;
    @Bean
    public MyService myService(){
        MyService service=new MyService();
        service.setMyproperties(myproperties);
        return service;
    }

}
