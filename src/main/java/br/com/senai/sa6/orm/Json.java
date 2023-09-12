package br.com.senai.sa6.orm;

import java.sql.Date;
import java.util.List;

public class Json {

	private Date date;
	private List<Integer> horario;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;

}
	public List<Integer> getHorario() {
		return horario;
	}
	public void setHorario(List<Integer> horario) {
		this.horario = horario;
	}
}
