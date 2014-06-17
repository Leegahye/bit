package exam.oop3.step03;
/* [<],[>]버튼 추가 및 이벤트 처리
 * 하나의 이너 클래스가 모든 버튼의 이벤트 처리
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

public class ScoreFrame04  extends Frame {
	
	private TextField tfName = new TextField(20);
	private TextField tfKor = new TextField(5);
	private TextField tfEng = new TextField(5);
	private TextField tfMat = new TextField(5);
	
	private Button btnAdd;
	private Button btnPrevious;
	private Button btnNext;
	
	//member inner class
	class MyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//추가버튼, <버튼, >버튼
			if(e.getSource() == btnAdd ){//이벤트가 발생된 객체가 btnAdd라면
				Score score = new Score();
				score.setName(tfName.getText());
				score.setKor(Integer.parseInt(tfKor.getText()));
				score.setEng(Integer.parseInt(tfEng.getText()));
				score.setMat(Integer.parseInt(tfMat.getText()));
				
				scoreDao.insert(score);
				clearForm();
				
			} else if(e.getSource() == btnPrevious){//이벤트가 발생된 객체가 btnPrevious라면
				Score currScore = scoreDao.previousScore();
				if(currScore == null){
					System.out.println("가져올 데이터가 없습니다!");
				}else{
					setForm(currScore);
				}
			} else if(e.getSource() == btnNext ){//이벤트가 발생된 객체가 btnNext라면
				System.out.println("눌럿다!!!!! >>>>>>");
				
			}
			
		}
	}
	ScoreDao scoreDao;
	
	public ScoreFrame04() {
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
		
		MyActionListener btnListener = new MyActionListener();
		
		btnAdd = createToolbarButton("추가");
		btnAdd.addActionListener(btnListener);
		toolbar.add(btnAdd);
		
		btnPrevious = createToolbarButton("<");
		btnAdd.addActionListener(btnListener);
		toolbar.add(btnPrevious);
		
		btnNext = createToolbarButton(">");
		btnNext.addActionListener(btnListener);
		toolbar.add(btnNext);
		
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