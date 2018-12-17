package manager;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class BookManager extends JFrame implements ActionListener{
	private JTextField tfBId;
	private String bId;
	
	private JTextField tfBName;
	private String bName;
	
	private JTextField tfBPrice;
	private int bPrice;
	
	private JTextField tfBPublCompany;
	private String bPublCompany;
	
	private JButton btnSave;
	private JButton btnRead;
	
	String id; //검색, 출력할때 id를 받을 변수
	
	BookDTO dto;
	BookFile bf = new BookFile();
	
	//생성자
	public BookManager() {
		//JFrame설정
		setTitle("도서관리 프로그램 입니다!!");
		setSize(320,400);
		getContentPane().setLayout(null);
		
		//Component를 올릴 판넬
		JPanel p1 = new JPanel();
		p1.setBounds(0, 0, 300, 360);
		p1.setLayout(null);
		getContentPane().add(p1);
		
		JLabel lbTitle = new JLabel("Book Manager Page!");
		lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitle.setFont(new Font("Sitka Display", Font.BOLD, 25));
		lbTitle.setSize(300, 80);
		p1.add(lbTitle);
		//내용 입력받는 부분
		JLabel lbBId = new JLabel("Book id");
		lbBId.setHorizontalAlignment(SwingConstants.CENTER);
		lbBId.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		lbBId.setBounds(10, 85, 80, 30);
		p1.add(lbBId);
		
		tfBId = new JTextField();
		tfBId.setBounds(95, 85, 180, 30);
		p1.add(tfBId);
		tfBId.setColumns(10);

		JLabel lbBName = new JLabel("Name");
		lbBName.setHorizontalAlignment(SwingConstants.CENTER);
		lbBName.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		lbBName.setBounds(10, 130, 80, 30);
		p1.add(lbBName);
		
		tfBName = new JTextField();
		tfBName.setBounds(95, 130, 180, 30);
		p1.add(tfBName);
		tfBName.setColumns(10);
		
		JLabel lbBPrice = new JLabel("price");
		lbBPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lbBPrice.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		lbBPrice.setBounds(10, 175, 80, 30);
		p1.add(lbBPrice);
		
		tfBPrice = new JTextField();
		tfBPrice.setBounds(95, 175, 180, 30);
		p1.add(tfBPrice);
		tfBPrice.setColumns(10);
		
		//보기 좋게 하려고 글자를 나눠서 라벨에 올렸습니다...
		JLabel lbBPublCompany0 = new JLabel("Publishing");
		lbBPublCompany0.setHorizontalAlignment(SwingConstants.CENTER);
		lbBPublCompany0.setFont(new Font("Sitka Subheading", Font.PLAIN, 12));
		lbBPublCompany0.setBounds(10, 220, 80, 20);
		p1.add(lbBPublCompany0);
		JLabel lbBPublCompany1 = new JLabel(" company");
		lbBPublCompany1.setHorizontalAlignment(SwingConstants.CENTER);
		lbBPublCompany1.setFont(new Font("Sitka Subheading", Font.PLAIN, 12));
		lbBPublCompany1.setBounds(10, 230, 80, 20);
		p1.add(lbBPublCompany1);
		
		tfBPublCompany = new JTextField();
		tfBPublCompany.setBounds(95, 220, 180, 30);
		p1.add(tfBPublCompany);
		tfBPublCompany.setColumns(10);
		//기능을 넣을 버튼
		btnSave = new JButton("Save");
		btnSave.setBounds(20, 285, 120, 50);
		p1.add(btnSave);
		btnSave.addActionListener(this);
		
		btnRead = new JButton("Read");
		btnRead.setBounds(150, 285, 120, 50);
		p1.add(btnRead);
		btnRead.addActionListener(this);
		
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnSave) {	//저장버튼을 누른경우
			bId = tfBId.getText().toUpperCase();
			bName = tfBName.getText();
			bPrice = Integer.parseInt(tfBPrice.getText());
			bPublCompany = tfBPublCompany.getText();
			
			bf.save(bId, bName, bPrice, bPublCompany);
			
			tfBId.setText("");
			tfBName.setText("");
			tfBPrice.setText("");
			tfBPublCompany.setText("");
		}
		if(e.getSource()==btnRead) {	//검색버튼을 누른경우
			id = JOptionPane.showInputDialog("찾고자 하는 Book ID를 입력해주세요.");
			dto = bf.read(id.toUpperCase());
			tfBId.setText(dto.getbId());
			tfBName.setText(dto.getbName());
			tfBPrice.setText(""+dto.getbPrice());
			tfBPublCompany.setText(dto.getbPublCompany());
		}
	}

	//메인
	public static void main(String[] args) {
		BookManager bm = new BookManager();
	}//end main()
}
