package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="network")
public class NetworkItem implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public NetworkItem(TeamMember tm1, TeamMember tm2, int bondingValue) {
		this.tm1 = tm1;
		this.tm2 = tm2;
		this.bondingValue = bondingValue;
	}
	
	public NetworkItem() {
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="team_member_first_id", referencedColumnName = "id")
	private TeamMember tm1;
	
	@Transient
	private String tm1Name;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="team_member_second_id", referencedColumnName = "id")
	private TeamMember tm2;
	
	@Transient
	private String tm2Name;
	
	@Column(name="value")
	private int bondingValue;
	

	
	public int getId() {
		return id;
	}
	
	public TeamMember getTm1(){
		return tm1;
	}
	
	public void setTm1(TeamMember tm1) {
		this.tm1 = tm1;
	}
	
	public String getTm1Name() {
		return tm1.getFirstName() + " " + tm1.getLastName();
	}

	public TeamMember getTm2(){
		return tm2;
	}
	
	public void setTm2(TeamMember tm2) {
		this.tm2 = tm2;
	}
	
	public String getTm2Name() {
		return tm2.getFirstName() + " " + tm2.getLastName();
	}

	public double getBondingValue() {
		return bondingValue;
	}

	public void setBondingValue(int bondingValue) {
		this.bondingValue = bondingValue;
	}



}
