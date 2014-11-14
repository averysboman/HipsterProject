package ctec.hipster.view;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

import ctec.hipster.controller.HipsterAppController;

public class HipsterPanel extends JPanel
{
	private HipsterAppController baseController;
	private JComboBox albumBox;
	private JLabel albumLabel;
	private JLabel hipsterImage;
	private SpringLayout baseLayout;
	
	public HipsterPanel(HipsterAppController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		albumLabel = new JLabel("Album Information");
		
		
		albumBox = new JComboBox();
		hipsterImage = new JLabel("Me as a hipster.");
		
		
		
		setupComboBox();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupComboBox()
	{
		albumBox.setModel(new DefaultComboBoxModel(baseController.getMyHipster().getHipsterAlbums()));
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setSize(1000, 400);
		this.setBackground(Color.ORANGE);
		this.add(albumBox);
		this.add(albumLabel);
		this.add(hipsterImage);
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, hipsterImage, 3, SpringLayout.NORTH, albumBox);
		baseLayout.putConstraint(SpringLayout.WEST, hipsterImage, 54, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, hipsterImage, -583, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, albumBox, -70, SpringLayout.NORTH, albumLabel);
		baseLayout.putConstraint(SpringLayout.WEST, albumLabel, 0, SpringLayout.WEST, albumBox);
		baseLayout.putConstraint(SpringLayout.EAST, albumBox, -205, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, albumLabel, 306, SpringLayout.NORTH, this);
	}
	
	private void setupListeners()
	{
		albumBox.addItemListener(new ItemListener()
		{
			@Override
			public void itemStateChanged(ItemEvent itemSelected)
			{
				if(albumBox.getSelectedIndex() == 0)
				{
					albumLabel.setText("This album is so underground not even God knows about it.");
				}
				else
				{
					albumLabel.setText("Not very hipster at all, actually.");
				}
			}
		});
	}

}
