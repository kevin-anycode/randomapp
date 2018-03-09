package app;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.JTableHeader;

public class ExpertListJFrame {
	private JFrame frame = new JFrame("专家列表"); 
	private JPanel showPanel;
	//private JTextArea jTextArea;
	private JTable jTable;
	public ExpertListJFrame(List<String> nameList, List<String> phoneList, List<String> typeList) {
		showPanel = (JPanel)frame.getContentPane();	
		/*jTextArea=new JTextArea();  
		jTextArea.setLineWrap(true);  
		for(int i=0; i<nameList.size(); i++){
			jTextArea.append(nameList.get(i) + "\t" + phoneList.get(i) + "\t" + typeList.get(i) + "\n");
		}*/
		Object[][] rowData = new Object[nameList.size()][3];
		String[] columnNames={"姓名","电话","类型"};
		for(int i=0; i<nameList.size(); i++){
			rowData[i][0] = "  " + nameList.get(i);
			rowData[i][1] = phoneList.get(i);
			rowData[i][2] = typeList.get(i);
		}
		jTable = new JTable(rowData,columnNames);
		jTable.setRowHeight(30);
		jTable.setFont(new Font("Courier",Font.BOLD,12));
		jTable.setForeground(Color.BLUE);
		JScrollPane js=new JScrollPane(jTable);  
		showPanel.add(js);
		
		frame.setSize(350, 550);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	public static void main(String[] args){
		List<String> list = new ArrayList<String>();
		new ExpertListJFrame(list,list,list);
	}
	
}
