package hello.springcorebasic.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class SingletonTest {

    @Test
    void singletonBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Singletonbean.class);

        Singletonbean singletonBean1 = ac.getBean(Singletonbean.class);
        Singletonbean singletonBean2 = ac.getBean(Singletonbean.class);
        System.out.println("singletonBean1 = " + singletonBean1);
        System.out.println("singletonBean2 = " + singletonBean2);
        Assertions.assertThat(singletonBean1).isEqualTo(singletonBean2);
    }

    @Scope("singleton")
    static class Singletonbean {
        @PostConstruct
        public void init() {
            System.out.println("Singletonbean.init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("Singletonbean.destroy");
        }
    }
}
