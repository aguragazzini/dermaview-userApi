package user

/**
 * Created by aragazzini on 10/24/15.
 */
class BadRequestException extends DermaViewException {
    def status = 400

    def BadRequestException(message, error = "bad_request", cause = []){
        super(message,error,cause)
    }

}
