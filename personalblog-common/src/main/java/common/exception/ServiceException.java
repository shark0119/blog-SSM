package common.exception;

/**
 * <hr/>
 * 
 * @author wanison
 * @version 1.0 2017年4月12日
 * @class com.iyuego.exception.CustomException
 */
public class ServiceException extends RuntimeException {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 异常编码
     */
    private String code;
    
    
	public ServiceException() {
		super();
	}

	public ServiceException(String message) {
		super(message);
	}

	/**
     * 构造函数
     * @param code 异常编码
     * @param message 异常消息
     */
    public ServiceException(String code, String message) {
        super(message);
        this.code = code;
    }
    
	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
