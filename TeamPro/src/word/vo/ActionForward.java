package word.vo;

public class ActionForward {
	private String resUrl;
	private boolean isRedirect;
	public ActionForward(String resUrl, boolean isRedirect) {
		super();
		this.resUrl = resUrl;
		this.isRedirect = isRedirect;
	}
	public String getResUrl() {
		return resUrl;
	}
	public void setResUrl(String resUrl) {
		this.resUrl = resUrl;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
	
}
