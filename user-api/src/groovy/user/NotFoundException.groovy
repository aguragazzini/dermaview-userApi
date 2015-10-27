package user

/**
 * Created by aragazzini on 10/24/15.
 */
class NotFoundException extends DermaViewException {
    def status = 404

    def NotFoundException(message, error = "not_found", cause = []){
        super(message,error,cause)
    }
}
