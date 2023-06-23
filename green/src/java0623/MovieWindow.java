package java0623;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import java.util.List; //����Ʈ ������ ����. 
//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

//�� : ������ �� ��ü�� �Է�, �׸��� �����ִ� ����� ��Ÿ����. 
//�����͸� ������� ����ڵ��� �� �� �ִ� ȭ���̴�.
//1. ȭ�鿡�� �߻��� �̺�Ʈ�� �Է� �����͵��� ��Ʈ�ѷ��� �����Ѵ�.
//����ڿ��� �������� ȭ���� ����� �κ��̶� ��������

public class MovieWindow extends JFrame implements ActionListener {

	// �� ȭ�鿡 ��µǴ� ��� �޽���
	String resultMsg = null;
	// �� ������� �Է��� �޴� �ؽ�Ʈ �ʵ� 30���ڱ���
	JTextField tMovieTitle = new JTextField(30);
	// �� �ۼ��� ����� �����ϱ� ���� ������ �ϴ� ��ư
	JButton btnTitleInsert = new JButton("��ȭ���� �߰�");
	// �� ������ ���Ͽ� ���� ����Ǵ� ��ư
	JButton btnSave = new JButton("��ȭ���� ���� ����");
	// �� List ��Ʈ���� ���� �����͸� ������ �� ���δ�.
	// List ���۳�Ʈ��, �ؽ�Ʈ �׸��� ��ũ�� ����Ʈ�� ����ڿ� ���ؼ� ǥ���Ѵ�.
	// �� ������ �����͵��� ������� �����ϴ� ��.
	List movieList = new List();
	// ��Ʈ�ѷ� ��ü�� �����Ѵ�.
	MovieController controller = new MovieController();
	// �� ������ JFrame�� ��ư����
	JButton btnExit = new JButton("����");

	// JFrame ������
	public MovieWindow() {
		setTitle("��ȭ���� ���� ȭ��");
		// super("��ȭ���� ���� ȭ��");

		// JTextArea ���� ����
		// ������ ��ũ�� �Ѵ�.
		movieList.setBackground(Color.pink);

		// �ĳ� ��ü ����
		Panel p = new Panel();
		p.add(new Label("��ȭ���� �Է�"));
		p.add(tMovieTitle);
		p.add(btnTitleInsert);
		p.add(btnSave);

		// ���� p�� �߰��� ��ü���� ��ܿ�
		add(BorderLayout.NORTH, p);
		// ��ȭ���� �Է� ���� ������ �߰���
		add(BorderLayout.CENTER, movieList);
		// ���� ��ư�� �� �Ʒ���
		add(BorderLayout.SOUTH, btnExit);
		// setBounds : ���� ��ġ�� ũ�⸦ �����Ѵ�.
		setBounds(0, 0, 800, 600);
		setVisible(true);
		// Listener�� �����Ѵ�.
		movieList.addActionListener(this);
		btnTitleInsert.addActionListener(this);
		btnSave.addActionListener(this);
		btnExit.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		String mTitle = e.getActionCommand();
		// ���࿡ ��ȭ���� �߰� ��ư�� ������
		if (e.getSource() == btnTitleInsert) {
			// System.out.println("��ȭ���� �߰��ϱ�");
			// �ؽ�Ʈ�ʵ忡 �Է��� ��ȭ������ ������ �´�.
			mTitle = tMovieTitle.getText().trim();
			// �� ����Ʈ�� ��ȭ������ �߰��ϴ� �޼ҵ�
			controller.addTitle(mTitle, movieList);
			// ��ư�� Ŭ���ϸ� �ؽ�Ʈ �Է�â�� ���� ��������
			tMovieTitle.setText("");
			// �˾�â�� �ߴ� ����
			resultMsg = "��ȭ ������ �߰��߽��ϴ�.";

		} else if (e.getSource() == btnSave) {
//System.out.println("���� ����");
//�� ����Ʈ�� �ִ� ��ȭ������� ���Ͽ� �����ϴ� �޼ҵ� 
			controller.saveTitles(movieList);
//�˾�â�� �ߴ� ����
			resultMsg = "��ȭ������ ���Ͽ� �����߽��ϴ�.";

		} // ���� ��ư Ŭ���� JFrame ȭ���� ����ȴ�.
		else if (e.getSource() == btnExit) {
			System.exit(0);

		} else {
//�� ����Ʈ ������ ���� Ŭ���� ������ �����.
			controller.delTitle(mTitle, movieList);
			resultMsg = "��ȭ������ �����߽��ϴ�.";
		}
		// ���̾�α� ó�� ����� �����ش�.
		// JOptionPane.showMessageDialog(parentComponent, message, title, messageType);
		JOptionPane.showMessageDialog(this, resultMsg, "�޽��� �ڽ�", JOptionPane.INFORMATION_MESSAGE);
		if (e.getSource() == btnExit)
			System.exit(1);
	}
	public static void main(String[] args) {
		new MovieWindow();
	}
}
