package com.ryangrillo.util;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class DateUtilTest {
	
	@Test
	public void test_random_today_or_yesterday() {
		assertNotNull(DateUtil.randomTodayOrYesterday());
	}
	
	@Test
	public void test_get_yeserday_or_today( ) {
		assertNotNull(DateUtil.getYesterday(new Date()));
	}

}
