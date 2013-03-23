package com.mehdie19.lig;

import java.util.ArrayList;


public class data {
	private static ArrayList<String> TeamName = new ArrayList<String>();//we add all team to a arrayList
	private static ArrayList<String> GameNo = new ArrayList<String>();//we add all GameNo to a arrayList
	private static ArrayList<String> PlayWin = new ArrayList<String>();//we add all PlayWin to a arrayList
	private static ArrayList<String> PlayEqual = new ArrayList<String>();//we add all PlayEqual to a arrayList
	private static ArrayList<String> PlayFaild = new ArrayList<String>();
	private static ArrayList<String> Emtiaz = new ArrayList<String>();
	
	/***************************************************
	 * all set_method append a member to dynamical_array
	 * all get_method return dynamical_array
	 ***************************************************/
	
	public final static ArrayList<String> getTeamName() {
		return TeamName;
	}
	public final static void setTeamName(String Teamame) {
		TeamName.add(Teamame);
	}
	
	public final static ArrayList<String> getGameNo() {
		return GameNo;
	}
	public final static void setGameNo(String GamNo) {
		GameNo.add(GamNo);
	}
	
	public final static ArrayList<String> getPlayWin() {
		return PlayWin;
	}
	public final static void setPlayWin(String PlaWin) {
		PlayWin.add(PlaWin);
	}
	
	public final static ArrayList<String> getPlayEqual() {
		return PlayEqual;
	}
	public final static void setPlayEqual(String PlaEqual) {
		PlayEqual.add(PlaEqual);
	}
	
	public final static ArrayList<String> getPlayFaild() {
		return PlayFaild;
	}
	public final static void setPlayFaild(String PlaFaild) {
		PlayFaild.add(PlaFaild);
	}
	
	public final static ArrayList<String> getEmtiaz() {
		return Emtiaz;
	}
	public final static void setEmtiaz(String Emtia) {
		Emtiaz.add(Emtia);
	}	
}