package user.api

import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.json.JSONObject
import user.BadRequestException

@Transactional
class UserService {

    @Transactional
    public User createUser(JSONObject userRequest) {
        User user = new User(userRequest)

        if(user.validate()){
            user.setNickName()
            user.save(flush: true)
        }
        else {
            def causeMessage = user.errors.getFieldError().field
            log.debug("El request es invalido ${causeMessage}")
            throw new BadRequestException("Invalid $causeMessage",'invalid_'+causeMessage,causeMessage)
        }
        return user
    }

    @Transactional
    public User searchUser(long id){
        User user = User.get(id)
        return user
    }
}
