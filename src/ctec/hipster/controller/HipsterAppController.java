package ctec.hipster.controller;

import ctec.hipster.model.Hipster;
import ctec.hipster.view.HipsterFrame;

public class HipsterAppController
{
	private HipsterFrame baseFrame;
	private Hipster myHipster;
	
	public HipsterAppController()
	{
		myHipster = new Hipster("Avery", 17);
		createAlbumArray();
		baseFrame = new HipsterFrame(this);
		
		
	}
	
	public Hipster getMyHipster()
	{
		return myHipster;
	}
	
	private void createAlbumArray()
	{
		String [] tempHipster = myHipster.getHipsterAlbums();
		tempHipster[0] = "Death Cab for Cutie: Plans";
		tempHipster[1] = "City and Colour: Bring Me Your Love";
		tempHipster[2] = "Radical Face: Ghost";
		tempHipster[3] = "Modest Mouse: Good News for People Who Love Bad News";
		myHipster.setHipsterAlbums(tempHipster);
	}
	
	public void start()
	{
		
	}
}
