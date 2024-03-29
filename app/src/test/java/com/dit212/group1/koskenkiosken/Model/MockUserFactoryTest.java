package com.dit212.group1.koskenkiosken.Model;

import com.dit212.group1.koskenkiosken.Model.User.IAccount;
import com.dit212.group1.koskenkiosken.Model.User.UserFactory;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 *
 * @author Albin Otterhäll <gusalbiot@student.gu.se>
 * Uses: IAccount, UserFactory.
 */

public class MockUserFactoryTest {
    private IAccount mockUser;

    @Before
    public void setUp() throws Exception {
        mockUser = UserFactory.createMockUser();
    }

    @Test
    public void defaultNameIsCorrect() {
        String mockUserName = mockUser.getName();
        assertThat(mockUserName, equalTo("FirstUser"));
    }

    @Test
    public void defaultAmountOfCredits() {
        int mockUserCredits = mockUser.getCredits();
        assertThat(mockUserCredits, equalTo(10));
    }
}