package web.servlet.controller;



//결과페이지의 이름과 이동방법을 저장하는 클래스
public class ModelAndView {
	private String path; //jsp, 결과페이지 정보
	private boolean isRedict;//이동방식(기본값이 false이므로 기본 방식은 forword다.)
	
	public ModelAndView() {
	}
	
	public ModelAndView(String path, boolean isRedict) {//forword방식
		super();
		this.path = path;
		this.isRedict = isRedict;
	}
	
	public ModelAndView(String path) {//redict방식
		this.path =path;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isRedict() {
		return isRedict;
	}

	public void setRedict(boolean isRedict) {
		this.isRedict = isRedict;
	}
	
	
}
