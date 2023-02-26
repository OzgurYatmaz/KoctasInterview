package com.koctas.dto;

public class CamelTransportRequest {

	private int elmaSayisi;
	private int mesafe;
	
	public int getElmaSayisi() {
		return elmaSayisi;
	}
	public void setElmaSayisi(int elmaSayisi) {
		this.elmaSayisi = elmaSayisi;
	}
	public int getMesafe() {
		return mesafe;
	}
	public void setMesafe(int mesafe) {
		this.mesafe = mesafe;
	}
	@Override
	public String toString() {
		return "CamelTransportRequest [elmaSayisi=" + elmaSayisi + ", mesafe=" + mesafe + "]";
	}
	
	
 
	
	
}
