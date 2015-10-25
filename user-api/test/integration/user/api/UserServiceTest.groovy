package user.api

import grails.test.mixin.TestFor
import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import org.codehaus.groovy.grails.web.json.JSONObject
import org.junit.Assert
import org.junit.Test
import user.BadRequestException

/**
 * Created by aragazzini on 10/24/15.
 */
@TestMixin(GrailsUnitTestMixin)
@TestFor(UserService)
class UserServiceTest {

    @Test
    public void testCreateUser(){
        JSONObject parameters = ['name':'Agustín Nicolas', 'lastName':'Ragazzini Donghi', 'email':'agus@hotmail.com']
        mockForConstraintsTests(User)
        User user = service.createUser(parameters)
        Assert.assertNotNull(user)
        Assert.assertEquals(parameters['name'],user.getName())
        Assert.assertEquals(parameters['lastName'],user.getLastName())
        Assert.assertEquals(parameters['email'],user.getEmail())
        Assert.assertEquals("AgustínRagazzini",user.getNickName())
    }

    @Test
    public void testCreateUser_InvalidName(){
        JSONObject parameters = ['name':'', 'lastName':'Ragazzini Donghi', 'email':'agus@hotmail.com']
        mockForConstraintsTests(User)
        try {
            User user = service.createUser(parameters)
            fail("Should'n create a user with name blank")
        }catch (BadRequestException br){
            Assert.assertEquals('invalid_name',br.error)
        }
    }

    @Test
    public void testCreateUser_InvalidLastName(){
        JSONObject parameters = ['name':'Agus', 'lastName':'', 'email':'agus@hotmail.com']
        mockForConstraintsTests(User)
        try {
            User user = service.createUser(parameters)
            fail("Should'n create a user with name blank")
        }catch (BadRequestException br){
            Assert.assertEquals('invalid_lastName',br.error)
        }
    }

    @Test
    public void testCreateUser_InvalidEmail(){
        JSONObject parameters = ['name':'Agus', 'lastName':'Ragazzini Donghi', 'email':'agushotmail.com']
        mockForConstraintsTests(User)
        try {
            User user = service.createUser(parameters)
            fail("Should'n create a user with name blank")
        }catch (BadRequestException br){
            Assert.assertEquals('invalid_email',br.error)
        }
    }
}
