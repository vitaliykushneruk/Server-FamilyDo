package com.kushneruk.vitaliy.serverfamilydo;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;


@ActiveProfiles("test")
@SpringBootTest(classes = ServerFamilyDoApplication.class)
public class TestContextConfiguration {

}
