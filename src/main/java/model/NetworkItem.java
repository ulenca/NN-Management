package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="network")
public class NetworkItem implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="team_member_first_id")
	private int tm1;
	
	@Column(name="team_member_second_id")
	private int tm2;
	
	@Column(name="value")
	private int bondingValue;
	
	public NetworkItem(int id,int tm1, int tm2, int bondingValue) {
		this.id=id;
		this.setTm1(tm1);
		this.setTm2(tm2);
		this.setBondingValue(bondingValue);
	}
	
	//hibernate requires default constructor
	public NetworkItem() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getTm1() {
		return tm1;
	}

	public void setTm1(int tm1) {
		this.tm1 = tm1;
	}

	public int getTm2() {
		return tm2;
	}

	public void setTm2(int tm2) {
		this.tm2 = tm2;
	}

	public double getBondingValue() {
		return bondingValue;
	}

	public void setBondingValue(int bondingValue) {
		this.bondingValue = bondingValue;
	}
	
	

}
