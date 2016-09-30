package hello.form;

import java.util.List;


public class FormBean {

	public FormBean(){}


	/**
	 * 基本的にAjax通信時、この配列に値を格納する
	 */
	private List<String> strList;


	/**
	 * 値を返却するときは、このリストに格納する。
	 */
	private List<List<String>> rtnList;


	/**
	 * 画面遷移の判断で使用する。	※消去予定
	 */
	private Boolean valid;


	public List<String> getStrList() {
		return strList;
	}
	public void setStrList(List<String> strList) {
		this.strList = strList;
	}
	public Boolean isValid() {
		return valid;
	}
	public void setValid(Boolean boolean1) {
		this.valid = boolean1;
	}
	public List<List<String>> getRtnList() {
		return rtnList;
	}
	public void setRtnList(List<List<String>> rtnList) {
		this.rtnList = rtnList;
	}

}

