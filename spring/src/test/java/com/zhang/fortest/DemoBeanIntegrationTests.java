package com.zhang.fortest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author zhangxinzheng
 * @Date 2016/5/6
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
@ActiveProfiles("dev")
public class DemoBeanIntegrationTests {
    @Autowired
    private TestBean testBean;

    @Test
    public void devBeanShouldInject(){
        String expected = "from development profile";
        String actual = testBean.getContent();
        Assert.assertEquals(expected, actual);
    }
}
