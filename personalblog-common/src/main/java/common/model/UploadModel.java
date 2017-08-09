
package common.model;

public class UploadModel {

	public static final int Status_Success = 200;
	public static final int Status_Error   = 300;

	private int             status;

	private String          absoluteFilePath;    // 绝对路径
	private String          relativeFilePath;    // 相对路径

	private String          zoomOneAbsoluteFilePath; // 第一次缩放后的绝对路径
	private String          zoomOneRelativeFilePath; // 第一次缩放后的相对路径
	
	private String          zoomTwoAbsoluteFilePath; // 第二次缩放后的绝对路径
	private String          zoomTwoRelativeFilePath; // 第二次缩放后的相对路径

	public UploadModel() {
		status = Status_Error;
	}

	/**
	 * 绝对路径,相对路径
	 */
	public UploadModel(String absoluteFilePath, String relativeFilePath) {
		status = Status_Success;
		this.absoluteFilePath = absoluteFilePath;
		this.relativeFilePath = relativeFilePath;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getAbsoluteFilePath() {
		return absoluteFilePath;
	}

	public void setAbsoluteFilePath(String absoluteFilePath) {
		this.absoluteFilePath = absoluteFilePath;
	}

	public String getRelativeFilePath() {
		return relativeFilePath;
	}

	public void setRelativeFilePath(String relativeFilePath) {
		this.relativeFilePath = relativeFilePath;
	}

	public String getZoomOneAbsoluteFilePath() {
		return zoomOneAbsoluteFilePath;
	}

	public void setZoomOneAbsoluteFilePath(String zoomOneAbsoluteFilePath) {
		this.zoomOneAbsoluteFilePath = zoomOneAbsoluteFilePath;
	}

	public String getZoomOneRelativeFilePath() {
		return zoomOneRelativeFilePath;
	}

	public void setZoomOneRelativeFilePath(String zoomOneRelativeFilePath) {
		this.zoomOneRelativeFilePath = zoomOneRelativeFilePath;
	}

	public String getZoomTwoAbsoluteFilePath() {
		return zoomTwoAbsoluteFilePath;
	}

	public void setZoomTwoAbsoluteFilePath(String zoomTwoAbsoluteFilePath) {
		this.zoomTwoAbsoluteFilePath = zoomTwoAbsoluteFilePath;
	}

	public String getZoomTwoRelativeFilePath() {
		return zoomTwoRelativeFilePath;
	}

	public void setZoomTwoRelativeFilePath(String zoomTwoRelativeFilePath) {
		this.zoomTwoRelativeFilePath = zoomTwoRelativeFilePath;
	}

	

}
