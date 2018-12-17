package manager;

public class BookDTO {
	private String bId;
	private String bName;
	private int bPrice;
	private String bPublCompany;

	public String getbId() {
		return bId;
	}

	public void setbId(String bId) {
		this.bId = bId;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public int getbPrice() {
		return bPrice;
	}

	public void setbPrice(int bPrice) {
		this.bPrice = bPrice;
	}

	public String getbPublCompany() {
		return bPublCompany;
	}

	public void setbPublCompany(String bPublCompany) {
		this.bPublCompany = bPublCompany;
	}

	@Override
	public String toString() {
		return "BookDTO [bId=" + bId + ", bName=" + bName + ", bPrice=" 
				+ bPrice + ", bPublCompany=" + bPublCompany	+ "]";
	}

}
