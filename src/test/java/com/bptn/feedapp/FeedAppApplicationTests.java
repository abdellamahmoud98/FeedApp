package com.bptn.feedapp;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.DisplayName;

import org.h2.tools.Server;
import org.springframework.boot.test.mock.mockito.MockBean;


@SpringBootTest
@ActiveProfiles("test")
class FeedAppApplicationTests {


 @DisplayName("Demo Test")
 @Test
 void contextLoads() {
 }
 @MockBean
 Server server;
}