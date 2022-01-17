import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*; 

public class Main implements ActionListener, ChangeListener {

	static int speed;

	static OS141 os;

	static JFrame frame;
	static JPanel panel;

	JLabel title, sLabel;

	JLabel u1, u2, u3, u4, d1, d2, p1, p2, p3;
	static JLabel i1, i2, i3, i4, wr1, wr2, pr1, pr2, pr3;

	JButton start;
	JSlider slider;

	public Main(){
		frame = new JFrame("OS141");
    	panel = new JPanel();
		speed = 1;
    	frame.getContentPane();
		
		//name
    	title = new JLabel("Noopur Siroya (nsiroya, #28421984)");
		title.setFont(new Font("Calibri", Font.BOLD, 15));
    	Dimension sizeL = title.getPreferredSize();
    	title.setBounds(10, 10, sizeL.width, sizeL.height);
    	panel.add(title);

		//start button
		start = new JButton("Start");
		start.setFont(new Font("Calibri", Font.BOLD, 15));
    	start.setBounds(10, 35, 100, 50);
    	panel.setLayout(null);
		start.addActionListener(this);
		panel.add(start);

		//speed slider
		slider = new JSlider(1, 10, speed);
		slider.setFont(new Font("Calibri", Font.BOLD, 20));
		slider.setPaintTrack(true); 
        slider.setPaintTicks(true); 
        slider.setPaintLabels(true);
		slider.setMajorTickSpacing(1);
		slider.setMinorTickSpacing(0);
		slider.setBounds(10, 100, 500, 50);
		slider.addChangeListener(this);
		panel.add(slider);

		sLabel = new JLabel("Value of Slider is = " + speed);
		sLabel.setFont(new Font("Calibri", Font.BOLD, 15));
		Dimension sizesL = sLabel.getPreferredSize();
    	sLabel.setBounds(10, 160, 300, sizesL.height);
    	panel.add(sLabel);

		//users
		u1 = new JLabel("USER 1");
		u1.setFont(new Font("Calibri", Font.BOLD, 20));
    	Dimension sizeU1 = u1.getPreferredSize();
    	u1.setBounds(10, 250, sizeU1.width, sizeU1.height);
    	panel.add(u1);

		u2 = new JLabel("USER 2");
		u2.setFont(new Font("Calibri", Font.BOLD, 20));
    	Dimension sizeU2 = u2.getPreferredSize();
    	u2.setBounds(10, 350, sizeU2.width, sizeU2.height);
    	panel.add(u2);

		u3 = new JLabel("USER 3");
		u3.setFont(new Font("Calibri", Font.BOLD, 20));
    	Dimension sizeU3 = u3.getPreferredSize();
    	u3.setBounds(10, 450, sizeU3.width, sizeU3.height);
    	panel.add(u3);

		u4 = new JLabel("USER 4");
		u4.setFont(new Font("Calibri", Font.BOLD, 20));
    	Dimension sizeU4 = u4.getPreferredSize();
    	u4.setBounds(10, 550, sizeU4.width, sizeU4.height);
    	panel.add(u4);

		//disks
		d1 = new JLabel("DISK 1");
		d1.setFont(new Font("Calibri", Font.BOLD, 20));
    	Dimension sizeD1 = d1.getPreferredSize();
    	d1.setBounds(325, 250, sizeD1.width, sizeD1.height);
    	panel.add(d1);

		d2 = new JLabel("DISK 2");
		d2.setFont(new Font("Calibri", Font.BOLD, 20));
    	Dimension sizeD2 = d2.getPreferredSize();
    	d2.setBounds(325, 350, sizeD2.width, sizeD2.height);
    	panel.add(d2);

		//printers
		p1 = new JLabel("PRINTER 1");
		p1.setFont(new Font("Calibri", Font.BOLD, 20));
    	Dimension sizeP1 = p1.getPreferredSize();
    	p1.setBounds(650, 250, sizeP1.width, sizeP1.height);
    	panel.add(p1);

		p2 = new JLabel("PRINTER 2");
		p2.setFont(new Font("Calibri", Font.BOLD, 20));
    	Dimension sizeP2 = p2.getPreferredSize();
    	p2.setBounds(650, 350, sizeP2.width, sizeP2.height);
    	panel.add(p2);

		p3 = new JLabel("PRINTER 3");
		p3.setFont(new Font("Calibri", Font.BOLD, 20));
    	Dimension sizeP3 = p3.getPreferredSize();
    	p3.setBounds(650, 450, sizeP3.width, sizeP3.height);
    	panel.add(p3);

		//users inputs
		i1 = new JLabel("Start");
		i1.setFont(new Font("Calibri", Font.BOLD, 15));
		Dimension sizeI1 = i1.getPreferredSize();
		i1.setBounds(10, 300, 300, sizeI1.height);
		panel.add(i1);

		i2 = new JLabel("Start");
		i2.setFont(new Font("Calibri", Font.BOLD, 15));
		Dimension sizeI2 = i2.getPreferredSize();
		i2.setBounds(10, 400, 300, sizeI2.height);
		panel.add(i2);

		i3 = new JLabel("Start");
		i3.setFont(new Font("Calibri", Font.BOLD, 15));
		Dimension sizeI3 = i3.getPreferredSize();
		i3.setBounds(10, 500, 300, sizeI3.height);
		panel.add(i3);

		i4 = new JLabel("Start");
		i4.setFont(new Font("Calibri", Font.BOLD, 15));
		Dimension sizeI4 = i4.getPreferredSize();
		i4.setBounds(10, 600, 300, sizeI4.height);
		panel.add(i4);

		//disks read/write
		wr1 = new JLabel("Ready");
		wr1.setFont(new Font("Calibri", Font.BOLD, 15));
		Dimension sizewr1 = wr1.getPreferredSize();
		wr1.setBounds(325, 300, 300, sizewr1.height);
		panel.add(wr1);

		wr2 = new JLabel("Ready");
		wr2.setFont(new Font("Calibri", Font.BOLD, 15));
		Dimension sizewr2 = wr2.getPreferredSize();
		wr2.setBounds(325, 400, 300, sizewr2.height);
		panel.add(wr2);

		//printers printing
		pr1 = new JLabel("Ready");
		pr1.setFont(new Font("Calibri", Font.BOLD, 15));
		Dimension sizePr1 = pr1.getPreferredSize();
		pr1.setBounds(650, 300, 300, sizePr1.height);
		panel.add(pr1);

		pr2 = new JLabel("Ready");
		pr2.setFont(new Font("Calibri", Font.BOLD, 15));
		Dimension sizePr2 = pr2.getPreferredSize();
		pr2.setBounds(650, 400, 300, sizePr2.height);
		panel.add(pr2);

		pr3 = new JLabel("Ready");
		pr3.setFont(new Font("Calibri", Font.BOLD, 15));
		Dimension sizePr3 = pr3.getPreferredSize();
		pr3.setBounds(650, 500, 300, sizePr3.height);
		panel.add(pr3);

		//run gui
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    	frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		panel.setLayout(null);
    	frame.add(panel);
    	frame.setSize(1000, 750);
    	frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e){  
		Thread t1 = new Thread() {
		@Override
			public void run() {
				for(int i = 0; i < os.NUM_USERS; i++){
					os.users[i].run();
					try {
						sleep(200*speed);
					} catch (InterruptedException ex) {}
				} 
			}
		};
		t1.start();
	}

	public void stateChanged(ChangeEvent e) {
		Thread t = new Thread() {
			@Override
			public void run() {
				if(!slider.getValueIsAdjusting()){
					speed = (int)slider.getValue();
					sLabel.setText("Value of Slider is = " + speed);
				}
				try {
					sleep(200*speed);
				} catch (InterruptedException ex) {}
			}
		};
		t.start();
	}

	public static void main(String args[]){
		os = new OS141(args);
        new Main();
	}
}