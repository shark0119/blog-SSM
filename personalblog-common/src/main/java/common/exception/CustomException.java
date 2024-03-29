package common.exception;

/**
 * <hr/>
 * 
 * @author wanison
 * @version 1.0 2017年4月12日
 * @class com.iyuego.exception.CustomException
 */
public class CustomException extends RuntimeException {

	private static final long serialVersionUID = 4461665310754411773L;

	public CustomException() {
		super();
	}

	public CustomException(String message) {
		super(message);
	}

	public CustomException(String message, Throwable cause) {
		super(message, cause);
	}

	public CustomException(Throwable cause) {
		super(cause);
	}
}
