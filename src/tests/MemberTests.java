package tests;

import model.Member;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class MemberTests {
    private Member makeMember() {
        Member mock = new Member();
        mock.setMemberID(1);
        mock.setUserName("user");
        mock.setPassword("pass");
        mock.setFirstName("John");
        mock.setLastName("Smith");
        mock.setEmailAddress("Email");
        return mock;
    }

    @Test
    public void testGetMemberID() {
        Member mock = makeMember();
        assertEquals(1, mock.getMemberID());
    }

    @Test
    public void testGetUserName() {
        Member mock = makeMember();
        assertEquals("user", mock.getUserName());
    }

    @Test
    public void testGetPassword() {
        Member mock = makeMember();
        assertEquals("user", mock.getUserName());
    }

    @Test
    public void testGetFirstName() {
        Member mock = makeMember();
        assertEquals("John", mock.getFirstName());
    }

    @Test
    public void testGetLastName() {
        Member mock = makeMember();
        assertEquals("Smith", mock.getLastName());
    }

    @Test
    public void testGetEmailAddress() {
        Member mock = makeMember();
        assertEquals("Email", mock.getEmailAddress());
    }
}
