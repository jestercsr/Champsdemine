import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChampsDeMines extends JFrame implements ActionListener{
		int compteur;
		int [][]boite = new int[10][10];
		int valCliques =0;
		int valBombes =0;
		JLabel cliques  = new JLabel("Nombres Boite cliquées : "+valCliques);
		JLabel bombes  = new JLabel("Nombres bombe explosées : "+valBombes);
		
		
		ChampsDeMines(){
			super("Champs De Mines");
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.setSize(700,700);
			this.setLocationRelativeTo(null);
			this.setLayout(new BorderLayout());
			JPanel score = new JPanel();
			score.add(cliques);
			score.add(bombes);
			this.add(score,BorderLayout.NORTH);
			JPanel zone = new JPanel();
			zone.setLayout(new GridLayout(10,10));
			for(int i=0;i<100;i++) {
				Boite boite = new Boite(""+i);
				zone.add(boite);
				boite.addActionListener(this);
			}
			this.add(zone);
			/*for(int i=0;i<10;i++)
				for(int j=0;j<10;j++)
					ChampsDeMines(boite[i][j].addActionListener(this));*/
		}
		public static void main(String args[])
		{
			ChampsDeMines terrain = new ChampsDeMines();
			terrain.setVisible(true);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			Boite b = (Boite) e.getSource();
			if(b.getbombe() == true) {
				System.out.println("bombe");
				valBombes++;
				b.setOuvert(true);
				ImageIcon boum = new ImageIcon("Boum.jpg");
				b.setIcon(boum);
			}
			else {
				System.out.println("pas de bombe");
				b.setCouleur(Color.WHITE);
				b.setText(" ");
				valCliques++;
				
			}
			if(valCliques+valBombes==20)
			{
				JFrame jf = new JFrame("Champs De Mines");
				jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				jf.setSize(560, 220);
				JPanel p = new JPanel();
				p.setLayout(new BorderLayout());
				p.add(new JLabel ("Vous avez gagne"),BorderLayout.CENTER);
				jf.setVisible(true);

			}
			
		}
}


