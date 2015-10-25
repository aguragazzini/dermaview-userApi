package user.api

class User {

    String name
    String lastName
    String nickName
    String email

    static constraints = {
        name       blank: false, maxSize: 40, matches: "^.*[A-Za-z]+"
        lastName   blank: false, maxSize: 40, matches: "^.*[A-Za-z]+"
        email      blank: false, email: true
        nickName nullable: true
    }

    void setNickName(){
        this.nickName = name.tokenize().get(0)+lastName.tokenize().get(0).capitalize()
    }
}