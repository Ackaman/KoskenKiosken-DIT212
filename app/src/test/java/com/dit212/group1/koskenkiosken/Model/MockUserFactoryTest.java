package com.dit212.group1.koskenkiosken.Model;

import com.dit212.group1.koskenkiosken.Model.IUser;
import com.dit212.group1.koskenkiosken.Model.UserFactory;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MockUserFactoryTest {
    private IUser mockUser;

    @Before
    public void setUp() throws Exception {
        mockUser = UserFactory.createMock();
    }

    @Test
    public void defaultNameIsCorrect() {
        String mockUserName = mockUser.getUserName();
        assertThat(mockUserName, equalTo("FirstUser"));
    }

    @Test
    public void defaultAmountOfCredits() {
        int mockUserCredits = mockUser.getCredits();
        assertThat(mockUserCredits, equalTo(10));
    }
}