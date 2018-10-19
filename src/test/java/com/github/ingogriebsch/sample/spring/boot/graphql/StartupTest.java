package com.github.ingogriebsch.sample.spring.boot.graphql;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.github.ingogriebsch.sample.spring.boot.graphql.repository.ContinentRepository;

@RunWith(MockitoJUnitRunner.class)
public class StartupTest {

    @Mock
    private ContinentRepository continentRepository;

    @InjectMocks
    private Startup startup;

    @Test(expected = NullPointerException.class)
    public void run_should_throw_exception_if_called_with_null() throws Exception {
        startup.run((String[]) null);
    }

}
