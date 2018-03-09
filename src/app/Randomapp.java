package app;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField; 

import util.ReadExecl;

public class Randomapp implements ActionListener{

	private JFrame frame = new JFrame("ר�ҳ�ȡ");
	private JPanel imagePanel;
	private JPanel showPanel;
	private JPanel okPanel;
	private JPanel zjkPanel;
	private JLabel zjkJba = new JLabel("ר�ҿ�:");
	private JComboBox zjJcb=null;
	private JLabel nameJba = new JLabel("��     ��:");
	private JTextField nameTf = new JTextField();
	private JLabel phoneJba = new JLabel("��     ��:");
	private JTextField phoneTf = new JTextField();
	private JLabel typeJba = new JLabel("��     ��:");
	private JTextField typeTf = new JTextField();
	private JLabel dwJba = new JLabel("��     λ:");
	private JTextField dwTf = new JTextField();
	private ImageIcon background;
	private JLabel jlb = new JLabel();
	private JButton jba = new JButton("��ʼ");
	private JButton jbb = new JButton("ֹͣ");
	private JButton jbc = new JButton("���¿�ʼ");
	private JButton jbZjList = new JButton("�鿴");
	private static boolean flag = true;
	private JLabel okJba = new JLabel("��ѡר��:");
	private JTextArea jTextArea;
	private StringBuffer okZj=new StringBuffer();
	private JDialog jDialog;
	private JRadioButton jrb = new  JRadioButton();
	private List<String> mustNameList = new ArrayList<String>();
	private List<String> mustPhoneList = new ArrayList<String>();
	private List<String> mustTypeList = new ArrayList<String>();
	private List<String> mustDwList = new ArrayList<String>();
	private int mustNum = 0;
	public Randomapp() {
		//double width = Toolkit.getDefaultToolkit().getScreenSize().width; //�õ���ǰ��Ļ�ֱ��ʵĸ� 
		//double height = Toolkit.getDefaultToolkit().getScreenSize().height;//�õ���ǰ��Ļ�ֱ��ʵĿ�
		URL url = getClass().getResource("bg.jpg");
		background = new ImageIcon(url);// ����ͼƬ
		JLabel label = new JLabel(background);// �ѱ���ͼƬ��ʾ��һ����ǩ����
		// �ѱ�ǩ�Ĵ�Сλ������ΪͼƬ�պ�����������
		label.setBounds(0, 0, background.getIconWidth(), background
				.getIconHeight());
		// �����ݴ���ת��ΪJPanel���������÷���setOpaque()��ʹ���ݴ���͸��
		imagePanel = (JPanel) frame.getContentPane();
		imagePanel.setOpaque(false);
		// ���ݴ���Ĭ�ϵĲ��ֹ�����ΪBorderLayout
		imagePanel.setLayout(null);
		//imagePanel.setLayout(null);
		
		zjkPanel = new JPanel();
		zjkPanel.setBorder(BorderFactory.createLineBorder(Color.red));//
		zjkPanel.setBounds(300,140,450,50);
		zjkPanel.setBackground(Color.WHITE);
		zjkPanel.setLayout(null);
		
		zjkJba.setFont(new Font("�����п�",Font.PLAIN,20));
		zjkJba.setBounds(10,10,200,30);
		zjkPanel.add(zjkJba);

		zjJcb = new JComboBox(new ReadExecl().getAllExcelSheetName());
		zjJcb.setFont(new Font("Courier",Font.BOLD,18));
		zjJcb.setBounds(100,10,200,25);
		zjkPanel.add(zjJcb);
		
		jbZjList.setBounds(320,10,80,26);
		zjkPanel.add(jbZjList);
		jbZjList.addActionListener(this);
		
		showPanel = new JPanel();
		showPanel.setBorder(BorderFactory.createLineBorder(Color.red));//
		showPanel.setBounds(300,200,450,150);
		showPanel.setBackground(Color.WHITE);
		showPanel.setLayout(null);
		//jla.setFont(new Font("Courier",Font.BOLD,22));
		//jla.setHorizontalAlignment(JLabel.CENTER);
		//jla.setVerticalAlignment(JLabel.CENTER); 		
		jlb.setFont(new Font("Courier",Font.BOLD,22));
		jlb.setSize(400, 30);
		showPanel.add(jlb);
		
		nameJba.setFont(new Font("�����п�",Font.PLAIN,20));
		nameJba.setBounds(10,10,200,30);
		showPanel.add(nameJba);
		
		nameTf.setFont(new Font("Courier",Font.BOLD,15));
		nameTf.setForeground(Color.BLUE);
		nameTf.setBounds(100,10,300,25);
		//nameTf.setEnabled(false);//��ֹ�༭
		showPanel.add(nameTf);
		
		phoneJba.setFont(new Font("�����п�",Font.PLAIN,20));
		phoneJba.setBounds(10,40,200,30);
		showPanel.add(phoneJba);
		
		phoneTf.setFont(new Font("Courier",Font.BOLD,15));
		phoneTf.setForeground(Color.BLUE);
		phoneTf.setBounds(100,40,300,25);
		//phoneTf.setEnabled(false);
		showPanel.add(phoneTf);
		
		typeJba.setFont(new Font("�����п�",Font.PLAIN,20));
		typeJba.setBounds(10,70,200,30);
		showPanel.add(typeJba);
		
		typeTf.setFont(new Font("Courier",Font.BOLD,15));
		typeTf.setForeground(Color.BLUE);
		typeTf.setBounds(100,70,300,25);
		//typeTf.setEnabled(false);
		showPanel.add(typeTf);
		
		dwJba.setFont(new Font("�����п�",Font.PLAIN,20));
		dwJba.setBounds(10,100,200,30);
		showPanel.add(dwJba);
		
		dwTf.setFont(new Font("Courier",Font.BOLD,15));
		dwTf.setForeground(Color.BLUE);
		dwTf.setBounds(100,100,300,25);
		//dwTf.setEnabled(false);
		showPanel.add(dwTf);
		
		
		okPanel = new JPanel();
		okPanel.setBorder(BorderFactory.createLineBorder(Color.red));//
		okPanel.setBounds(300,360,450,150);
		okPanel.setBackground(Color.WHITE);
		okPanel.setLayout(null);
		
		okJba.setFont(new Font("�����п�",Font.PLAIN,20));
		okJba.setBounds(0,0,200,30);
		okPanel.add(okJba);
		
		
		
		jTextArea=new JTextArea();  
		jTextArea.setLineWrap(true);
		jTextArea.setFont(new Font("Courier",Font.BOLD,15));
		jTextArea.setForeground(Color.RED);
		JScrollPane js=new JScrollPane(jTextArea);  
		js.setBounds(100,10,330,135);
		okPanel.add(js);
		
		imagePanel.add(zjkPanel);
		imagePanel.add(showPanel);
		imagePanel.add(okPanel);
 		//jla.setBounds(500,300,100,30);
 		
 		jba.setBounds(360,550,80,26);
 		jbb.setBounds(490,550,80,26);
 		jbc.setBounds(620,550,100,26);
 		if(flag){
 			jbb.setEnabled(false);
 		}else{
 			jbb.setEnabled(true);
 		}
 		jba.addActionListener(this);
 		jbb.addActionListener(this);
 		jbc.addActionListener(this);
 		zjJcb.addItemListener(new ItemListener() {
			
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				mustNum = 0;
				nameTf.setText("");
				phoneTf.setText("");
				typeTf.setText("");
				dwTf.setText("");
				jTextArea.setText("");
				
			}
		});
 		imagePanel.add(jba);
 		imagePanel.add(jbb);
 		imagePanel.add(jbc);
 		
 		jrb.setBounds(1000,635,20,20);
 		jrb.setOpaque(false);
 		imagePanel.add(jrb);

		//frame.getLayeredPane().setLayout(null);
		// �ѱ���ͼƬ��ӵ��ֲ㴰�����ײ���Ϊ����
		frame.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setSize((int)width,(int)height);//����ȫ����ʾ
		frame.setSize(background.getIconWidth(), 680);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==jbc){
			jTextArea.setText("");
			return;
		}
		ReadExecl readExecl = new ReadExecl();
		String sheetName = (String)zjJcb.getSelectedItem();
		//System.out.println(sheetName);
		boolean isMust = jrb.isSelected();
		List<String[]> list = readExecl.readExcel(sheetName,0,6);
		String[] num =  list.get(0);//���
		String[] names =  list.get(1);//����
		String[] sex =  list.get(2);//�Ա�
		String[] dws =  list.get(3);//��λ
		String[] zjlx =  list.get(4);//ר������
		String[] phone =  list.get(5);//�绰
		String[] mustFlag =  list.get(6);//��ѡ��־
		int length = list.get(0).length;
		final List<String> nameList = new ArrayList<String>();
		final List<String> phoneList = new ArrayList<String>();
		final List<String> typeList = new ArrayList<String>();
		final List<String> dwList = new ArrayList<String>();
		for(int i=0; i<length; i++){
			nameList.add(names[i]);
			phoneList.add(phone[i]);
			typeList.add(zjlx[i]);
			dwList.add(dws[i]);
		}
		if(e.getSource()==jbZjList){
			List<String> zjList = new ArrayList<String>();
			new ExpertListJFrame(nameList,phoneList,typeList);
		}
		else if(e.getSource()==jba){
			mustNameList.clear();
			mustPhoneList.clear();
			mustTypeList.clear();
			mustDwList.clear();
			for(int i=0; i<length; i++){
				if("1".equals(mustFlag[i])){
					mustNameList.add(names[i]);
					mustPhoneList.add(phone[i]);
					mustTypeList.add(zjlx[i]);
					mustDwList.add(dws[i]);
				}
			}
			flag = true;
			jbb.setEnabled(true);
			new Thread(){	
				int i=0;
				public void run(){
					while(Randomapp.flag){
						//Random r = new Random(); 
						//double a = Math.random()*(nameList.size()-1); 
						//a = Math.ceil(a); 
						//int randomNum = new Double(a).intValue();
						nameTf.setText(nameList.get(i));
						phoneTf.setText(phoneList.get(i));
						typeTf.setText(typeList.get(i));
						dwTf.setText(dwList.get(i));
						//System.out.println(i+"===" + nameList.get(i));
						i++;
						if(i>nameList.size()-1){
							i=0;
						}
						try {
							this.sleep(60);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}				
			}.start();
		}
		else if(e.getSource()==jbb){
			//jDialog.setLocationRelativeTo(null);

			flag = false;
			jbb.setEnabled(false);
			String selectedString = jTextArea.getText();
			String[] selectedNameStrings = selectedString.split(";");
			for(int j=0; j<selectedNameStrings.length;j++){
				String str1 = selectedNameStrings[j].trim();
				String str2 = nameTf.getText().trim();
				if(str1.equals(str2)){
					JLabel showInfo = new JLabel("ר�ң�" + str2 + " �Ѿ���ȡ����������ʼ��������ȡ");
					nameJba.setFont(new Font("Courier",Font.BOLD,16));
					nameJba.setBounds(20,10,200,30);
					jDialog = new JDialog(frame,"��ʾ");
					jDialog.add(showInfo);
					jDialog.setSize(400, 150);
					jDialog.setLocationRelativeTo(null);
					jDialog.setVisible(true);
					return;
				}
			}
			String name = nameTf.getText();
			String pbone = phoneTf.getText();
			String type = typeTf.getText();
			/*if(jTextArea.getText()==null || "".equals(jTextArea.getText())){
				jTextArea.append(name + "\t" + pbone + "\t" + type + ";");
			}else{
				jTextArea.append("\n" + name + "\t" + pbone + "\t" + type + ";");
			}*/
			if(jrb.isSelected() && mustNum<mustNameList.size()){
				if(jTextArea.getText()==null || "".equals(jTextArea.getText())){
					nameTf.setText(mustNameList.get(mustNum));
					phoneTf.setText(mustPhoneList.get(mustNum));
					typeTf.setText(mustTypeList.get(mustNum));
					dwTf.setText(mustDwList.get(mustNum));
					jTextArea.append(mustNameList.get(mustNum) + ";");
				}else{
					nameTf.setText(mustNameList.get(mustNum));
					phoneTf.setText(mustPhoneList.get(mustNum));
					typeTf.setText(mustTypeList.get(mustNum));
					dwTf.setText(mustDwList.get(mustNum));
					jTextArea.append("\n" + mustNameList.get(mustNum) + ";");
				}
				mustNum ++;
			}else{
				if(jTextArea.getText()==null || "".equals(jTextArea.getText())){
					jTextArea.append(name + ";");
				}else{
					jTextArea.append("\n" + name + ";");
				}
			}
		}
	}
    public static void main(String arguments []){ 
		new Randomapp();
    }
}
