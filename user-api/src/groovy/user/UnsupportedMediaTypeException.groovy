package user

/**
 * Created by aragazzini on 10/24/15.
 */
class UnsupportedMediaTypeException extends DermaViewException {
    def status = 415

    def UnsupportedMediaTypeException(message, error = "server_error", cause = []){
        super(message,error,cause)
    }
}
