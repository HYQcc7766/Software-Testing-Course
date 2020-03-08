package com.hyq;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)

public class VerificationTest {
    private double input;
    private boolean expected;
    private Verification ver = null;

    public VerificationTest(double input, boolean expected){
        this.input = input;
        this.expected = expected;
    }

    @Before
    public void setUp() throws Exception {
        ver = new Verification();
    }

@Parameterized.Parameters
public static Collection<Object[]> getData(){

    return Arrays.asList(new Object[][]{
            {61, true},
            {95, false},
            {0, true},
            {-1, false},
            {-242.5, false},
            {1, true},
            {4, false},
            {93, true},
            {11, true},
            {70, true},
            {80.1, false},
            {1111.1, false},
            {23.0002, false},
            {3, true},
            {16, true},
    });
}

    @Test
    public void verify() {
        assertEquals(this.expected,ver.verify(input));
    }
}