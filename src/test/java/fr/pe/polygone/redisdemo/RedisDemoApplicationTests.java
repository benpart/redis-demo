package fr.pe.polygone.redisdemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class RedisDemoApplicationTests {

    @Autowired
    private RedisDemoApplication redisDemoApplication;


	@Test
	void contextLoads() {
        assertThat( redisDemoApplication ).isNotNull();
    }

}
