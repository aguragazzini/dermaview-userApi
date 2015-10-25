package user.api

import grails.converters.JSON
import grails.rest.RestfulController
import org.codehaus.groovy.grails.web.json.JSONObject
import user.BadRequestException

import javax.servlet.http.HttpServletResponse

class UsersController extends RestfulController {

    UserService userService

    def save () {

        JSONObject userJson
        try {
            userJson = request.JSON
        }catch (Exception e){
            throw new BadRequestException("Request with not supported content", "invalid_post_body")
        }

        if(userJson){
            throw new BadRequestException("Request null", "invalid_post_body")
        }
        else {
            User user = userService.createUser(userJson)
        }

        return [response: HttpServletResponse.SC_CREATED]

    }


}