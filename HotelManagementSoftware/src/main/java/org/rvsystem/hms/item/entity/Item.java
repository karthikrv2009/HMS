package org.rvsystem.hms.item.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.rvsystem.hms.employe.entity.Employe;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="ITEM")
public class Item {

	@Id
	@SequenceGenerator(name = "ITEM_ID", sequenceName = "ITEM_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ITEM_ID")
	@Column(name = "ITEM_ID", unique = true, nullable = false)
	private int itemid;
	
	@Column(name="ITEM_NAME")
	private String itemname;
	
	@Column(name="ITEM_DESCRIPTION")
	private String itemdescription;
	
	@Column(name="PRICE")
	private double price;

	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY,mappedBy="item")
	private Set<ItemImage> itemimage;

	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY,mappedBy="item")
	private Set<ItemTransaction> itemtransaction;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="EMPLOYE_ID",nullable=false)
	private Employe employe;

	public int getItemid() {
		return itemid;
	}

	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getItemdescription() {
		return itemdescription;
	}

	public void setItemdescription(String itemdescription) {
		this.itemdescription = itemdescription;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Set<ItemImage> getItemimage() {
		return itemimage;
	}

	public void setItemimage(Set<ItemImage> itemimage) {
		this.itemimage = itemimage;
	}

	public Set<ItemTransaction> getItemtransaction() {
		return itemtransaction;
	}

	public void setItemtransaction(Set<ItemTransaction> itemtransaction) {
		this.itemtransaction = itemtransaction;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	@Override
	public String toString() {
		return "Item [itemid=" + itemid + ", itemname=" + itemname
				+ ", itemdescription=" + itemdescription + ", price=" + price
				+ ", itemimage=" + itemimage + ", itemtransaction="
				+ itemtransaction + ", employe=" + employe + "]";
	}
	

}
