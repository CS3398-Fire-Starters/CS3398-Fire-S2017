package com.example.derek.workouttracker20;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class UserTest
{
    private User user;

    @Before
    public void setup() throws Exception
    {
        user = new User("username", "password");
    }

    @Test
    public void testFName()
    {
        user.setFirstName("JoeDan");
        assertEquals(user.getFirstName(), "JoeDan");
    }
    @Test
    public void testLName()
    {
        user.setFirstName("Smith");
        assertEquals(user.getLastName(), "Smith");
    }
    @Test
    public void testBMI()
    {
        user.setBMI(16);
        assertEquals(user.getBMI(), 16);
    }


}
