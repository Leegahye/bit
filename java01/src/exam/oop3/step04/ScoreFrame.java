package exam.oop3.step04;
/* [<],[>]버튼 추가 및 이벤트 처리
 * - Frame 클래스가 ActionListener역할을 겸한다.
 * - OOP입장에서는 바람직하지 않다 => Low coupling, High cohesion(하나의 클래스는 하나의 역할을 수행한다)
 * 
 * ActionListener 규칙
 *  - 버튼을 클릭 이벤트를 처리하는 규칙
 *  - TextField의 엔터키 이벤트를 처리하는 규칙
 *  
 * 버튼에 Action 이름을 설정한 후 이벤트 처리시에 사용한다.
 * 
 */
import java.awt.Button;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ScoreFrame  extends Frame implements ActionListener{
	
	private TextField tfName = new TextField(20);
	private TextField tfKor = new TextField(5);
	private TextField tfEng = new TextField(5);
	private TextField tfMat = new TextField(5);
	
		public void actionPerformed(ActionEvent e) {
			//추가버튼, <버튼, >버튼
			if(e.getActionCommand().equals("scoreAdd")){//이벤트가 발생된 객체가 btnAdd라면
				Score score = new Score();
				score.setName(tfName.getText());
				score.setKor(Integer.parseInt(tfKor.getText()));
				score.setEng(Integer.parseInt(tfEng.getText()));
				score.setMat(Integer.parseInt(tfMat.getText()));
				
				scoreDao.insert(score);
				clearForm();
				
			} else if(e.getActionCommand().equals("scorePrevious")){//이벤트가 발생된 객체가 btnPrevious라면
				Score currScore = scoreDao.previousScore();
				if(currScore == null){
					System.out.println("가져올 데이터가 없습니다!");
				}else{
					setForm(currScore);
				}
			} else if(e.getActionCommand().equals("scoreNext")){//이벤트가 발생된 객체가 btnNext라면
				System.out.println("눌럿다!!!!! >>>>>>");
				
			}
		}
	ScoreDao scoreDao;
	
	public ScoreFrame() {
		this.setTitle("비트 성적관리 시스템");
		this.setSize(400, 300);
		
		this.addWindowListener(new WindowAdapter() {
		  public void windowClosing(WindowEvent e) {
			  System.exit(0);
		  }
		});
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		this.add( createRowPanel("이름", tfName) );
		this.add( createRowPanel("국어", tfKor) );
		this.add( createRowPanel("영어", tfEng) );
		this.add( createRowPanel("수학", tfMat) );
		
		Panel toolbar = new Panel(new FlowLayout(FlowLayout.LEFT));
		
		Button btn = createToolbarButton("추가");
		btn.setActionCommand("scoreAdd"); //버튼에 액션 이름 설정
		btn.addActionListener(this);
		toolbar.add(btn);
		
		btn = createToolbarButton("<");
		btn.setActionCommand("scorePrevious"); //버튼에 액션 이름 설정
		btn.addActionListener(this);
		toolbar.add(btn);
		
		btn = createToolbarButton(">");
		btn.setActionCommand("scoreNext"); //버튼에 액션 이름 설정
		btn.addActionListener(this);
		toolbar.add(btn);
		
		this.add(toolbar);
	}
	
	private Button createToolbarButton(String title){
		Button btn = new Button(title);
		btn.setPreferredSize(new Dimension(80,30));
		return btn;
	}
	private Panel createRowPanel(String title, Component comp){/*TextField뿐만아니라 Component의 자식을 모두 받을 수 있다*/ 
		// Panel의 기본 레이아웃 매니저 => FlowLayout(FlowLayout.CENTER)
		Panel panel = new Panel(new FlowLayout(FlowLayout.LEFT)); 
		panel.setPreferredSize(new Dimension(300, 25));
		
		Label label = new Label(title);
		label.setPreferredSize(new Dimension(50, 25));
		panel.add(label);
		
		panel.add(comp);
		
		return panel;
	}
	public void setScoreDao(ScoreDao scoreDao) {
		this.scoreDao = scoreDao;
	}
	
	private void clearForm() {
		tfName.setText("");
		tfKor.setText("");
		tfEng.setText("");
		tfMat.setText("");
	}
	private void setForm(Score score){
		tfName.setText(score.getName());
		tfKor.setText(Integer.toString(score.getKor()));
		tfEng.setText(Integer.toString(score.getEng()));
		tfMat.setText(Integer.toString(score.getMat()));
	}
}