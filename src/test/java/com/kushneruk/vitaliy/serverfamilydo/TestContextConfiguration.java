package com.kushneruk.vitaliy.serverfamilydo;

import com.kushneruk.vitaliy.serverfamilydo.config.DatabaseConfig.DatabaseTestConfig;
import com.kushneruk.vitaliy.serverfamilydo.infrastructure.property.Profiles;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ActiveProfiles(Profiles.TEST)
@SpringBootTest(classes ={DatabaseTestConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public abstract class TestContextConfiguration {

}
