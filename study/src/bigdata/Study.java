package bigdata;

public class Study {
	public String id;		//아이디를 기준으로 검색받아야 해서 public
	String subject;
	String content;
	public int cost;		//수정이 들어가는 부분이라 public
	int maxPeople;
	
	//기본 생성자 메서드
	public Study() {		
	}

	//자동으로 입력받는 생성자 메서드
	public Study(String id, String subject, String content, int cost, int maxPeople) {
		this.id = id;
		this.subject = subject;
		this.content = content;
		this.cost = cost;
		this.maxPeople = maxPeople;
	}
	
	//클래스 내의 모든 속성값들을 출력할 수 있는 메서드
	@Override
	public String toString() {
		return "Study [id=" + id + ", subject=" + subject + ", content=" + content + ", cost=" + cost + ", maxPeople="
				+ maxPeople + "]";
	}//end toString
}//end Class
