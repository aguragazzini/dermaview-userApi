package user.api

/**
 * Created by aragazzini on 10/26/15.
 */
class UserBuilder {

    String name
    String lastName
    String nickName
    String email

    public UserBuilder(){
        name = "Agustin"
        lastName = "Ragazzini"
        email = "agusragazzini@hotmail.com"
    }

    public User build(){
        User user = new User()
        user.name = this.name
        user.lastName  = this.lastName
        user.email = this.email
        user.nickName = this.nickName
        return user
    }

    public User buildAndSave(){
        User user = this.build()
        user.save(flush: true)
        return user
    }
}
