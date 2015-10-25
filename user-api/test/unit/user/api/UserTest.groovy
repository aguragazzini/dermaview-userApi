package user.api

import grails.test.*
import org.junit.After
import org.junit.Before
import org.junit.Test

class UserTest extends GrailsUnitTestCase {

    User user

    @Before
    public void setUp() {
        super.setUp()
        mockForConstraintsTests(User)
        user = new User(name: 'agustin', lastName: 'Ragazzini', email: 'agus@gmail.com')
    }

    @After
    public void tearDown(){
        user = null
    }

    @Test
    void testBlankName() {
        user = new User(name: '')
        assertFalse user.validate()
    }

    @Test
    void testBlankLastName() {
        user = new User(lastName: '')
        assertFalse user.validate()
    }

    @Test
    void testBlankEmail() {
        user = new User(email: '')
        assertFalse user.validate()
    }

    @Test
    void testInvalidEmail() {
        user.email = 'test'
        assertFalse user.validate()
        assertEquals 'Not a valid email.', 'email', user.errors['email']
    }

    @Test
    void testValidEmail(){
        mockForConstraintsTests(User,[user])
        assertTrue user.validate()
    }

    @Test
    void testValidUser(){
        assertTrue user.validate()
    }

    @Test
    void testSetNickName(){
        user.setNickName()
        assertEquals("agustinRagazzini", user.nickName)
    }

    @Test
    void testInvalidMatchesName(){
        user.name = "·csa,123"
        assertFalse user.validate()
        assertEquals 'matches', user.errors['name']
    }

    @Test
    void testInvalidMatchesLastName(){
        user.lastName = "·12Ragazzini,123"
        assertFalse user.validate()
        assertEquals 'matches', user.errors['lastName']
    }
}
