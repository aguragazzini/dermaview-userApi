package user

/**
 * Created by aragazzini on 10/24/15.
 */
class DermaViewException extends RuntimeException {
    def status = 500
    def error
    def internalCause = []

    def DermaViewException(String message, error, cause){
        super(message.toString(), (cause in Throwable) ? cause : null)
        this.error = error
        this.internalCause = cause
    }

    def DermaViewException(message){
        super(message)
    }

    def DermaViewException(){
        super("internal_error")
    }
}
