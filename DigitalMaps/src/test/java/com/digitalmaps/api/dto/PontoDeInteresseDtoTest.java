package com.digitalmaps.api.dto;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.MatcherAssert.assertThat;


import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanConstructor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;


import com.digitalmaps.api.dtos.PontoDeInteresseDto;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class PontoDeInteresseDtoTest {

	@Test
    public void testMainMethods(){
        assertThat(PontoDeInteresseDto.class, 
        		allOf(hasValidBeanConstructor(), hasValidGettersAndSetters()));
    }
}
