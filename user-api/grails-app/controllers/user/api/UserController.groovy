package user.api

import grails.rest.RestfulController
import org.codehaus.groovy.grails.web.json.JSONObject
import user.BadRequestException
import user.NotFoundException

import javax.servlet.http.HttpServletResponse

class UserController {

    UserService userService

    def show = {
        long userId
        if(!params.id){
            throw new BadRequestException("User id can not be empty", "empty_user_id")
        }
        try{
           userId = params.id as long
        }
        catch (Exception e){
            throw new BadRequestException("Request with invalid id", "invalid_id")
        }

        User user =  userService.searchUser(userId)

        if(!user){
            throw new NotFoundException("User not found", "user_not_found")
        }

        return  [response: [name: user.name, lastName: user.lastName,
                                  nickName:user.nickName, email: user.email],
                       status:   HttpServletResponse.SC_CREATED]
    }


    def save = {
        JSONObject userJson
        try {
            userJson = request.JSON
        }catch (Exception e){
            throw new BadRequestException("Request with not supported content", "invalid_post_body")
        }

        if(!userJson){
            throw new BadRequestException("Request null", "invalid_post_body")
        }
        else {
            User user = userService.createUser(userJson)
            return [response: [nickName:user.nickName],
                    status:   HttpServletResponse.SC_CREATED]
        }


    }


}