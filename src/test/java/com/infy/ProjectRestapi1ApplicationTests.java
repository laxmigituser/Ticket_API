package com.infy;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProjectRestapi1ApplicationTests {

	@Test
	void contextLoads() {
//		var regex="\b[1-9][0-9]{3}\b";
//		System.out.println(regex.matches("1234"));
//		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.nnn");
//		LocalDateTime now =		LocalDateTime.now();
//		
//		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//		System.out.println(formatter.format(now));
		int a[]= {1,2,3,4,5};
		for(int i=0;i<a.length;i++) {
			if(a[i]==5) {
				continue;
			}
			else {
				System.out.println(a[i]);
			}
		}
	}

}
