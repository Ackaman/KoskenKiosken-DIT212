package com.dit212.group1.koskenkiosken.Model;

import com.dit212.group1.koskenkiosken.Model.User.IAccount;
import com.dit212.group1.koskenkiosken.Model.User.UserFactory;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

/**
 * Primary author: Albin Otterhäll <gusalbiot@student.gu.se>
 */

public class UserFactoryTest {
    private IAccount user;

    @Before
    public void setUp() throws Exception {
        user = UserFactory.create("John Doe", 100);
    }

    @Test
    public void checkName() {
        assertThat(user.getName(), equalTo("John Doe"));
    }

    @Test
    public void checkCredits() {
        assertThat(user.getCredits(), equalTo(100));
    }
}