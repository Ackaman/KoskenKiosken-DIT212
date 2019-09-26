package com.dit212.group1.koskenkiosken.Model;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

/**
 * Author: Albin Otterhäll <gusalbiot@student.gu.se>
 */

public class UserFactoryTest {
    private IUser user;

    @Before
    public void setUp() throws Exception {
        user = UserFactory.create("John Doe", 100);
    }

    @Test
    public void checkName() {
        assertThat(user.getUserName(), equalTo("John Doe"));
    }

    @Test
    public void checkCredits() {
        assertThat(user.getCredits(), equalTo(100));
    }
}