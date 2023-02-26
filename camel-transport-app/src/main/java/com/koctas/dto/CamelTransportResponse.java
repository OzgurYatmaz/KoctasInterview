package com.koctas.dto;

public class CamelTransportResponse {

	private int tasinabilirElmaSayisi;
	private String status;

	 

	public int getTasinabilirElmaSayisi() {
		return tasinabilirElmaSayisi;
	}

	public void setTasinabilirElmaSayisi(int tasinabilirElmaSayisi) {
		this.tasinabilirElmaSayisi = tasinabilirElmaSayisi;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CamelTransportResponse [tasinabilirElmaSayisi=" + tasinabilirElmaSayisi + ", status=" + status + "]";
	}
	
	
}
