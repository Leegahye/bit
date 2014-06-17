package exam.oop3.step03;
/* 성적 등록 폼 만들기
 * - Panel 사용 
 *   > 여러 개의 UI 컴포넌트를 묶을 때 사용하는 윈도우 
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

public class ScoreFrame03  extends Frame {
	
	private TextField tfName = new TextField(20);
	private TextField tfKor = new TextField(5);
	private TextField tfEng = new TextField(5);
	private TextField tfMat = new TextField(5);
	
	ScoreDao scoreDao;
	
	public ScoreFrame03() {
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
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Score score = new Score();
				score.setName(tfName.getText());
				score.setKor(Integer.parseInt(tfKor.getText()));
				score.setEng(Integer.parseInt(tfEng.getText()));
				score.setMat(Integer.parseInt(tfMat.getText()));
				
				scoreDao.insert(score);
				clearForm();
			}
			//성적 입력 폼 초기화
			private void clearForm() {
				tfName.setText("");
				tfKor.setText("");
				tfEng.setText("");
				tfMat.setText("");
			}
			
		});
		
		toolbar.add(btn);
		btn = createToolbarButton("<");
		btn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Score currScore = scoreDao.previousScore();
				if(currScore == null){
					System.out.println("가져올 데이터가 없습니다!");
				}else{
					setForm(currScore);
				}
			}
			private void setForm(Score score){
				tfName.setText(score.getName());
				tfKor.setText(Integer.toString(score.getKor()));
				tfEng.setText(Integer.toString(score.getEng()));
				tfMat.setText(Integer.toString(score.getMat()));
			}
		});
		toolbar.add(btn);
		
		btn = createToolbarButton(">");
		btn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println("눌럿다!!!!! >>>>>>");
			}
		});
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
}