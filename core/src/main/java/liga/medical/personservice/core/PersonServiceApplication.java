package liga.medical.personservice.core;

//import org.apache.ibatis.type.MappedTypes;
//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Service application.
 */
@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
//if use mapper classes
//@MapperScan("package")
//@MappedTypes({Entity1.class,  Entity2.class})
@ComponentScan("liga.medical.personservice")
public class PersonServiceApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(PersonServiceApplication.class);
    }
}
