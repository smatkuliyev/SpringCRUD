package springbootCrud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "kisiler")

// @Data --> ipmort lombok, --> cons+/getter/setter/toString olustu
// @NoArgsConstructor --> ipmort lombok, --> parametresiz constructor

public class Kisi {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 		//id otomotik gelsin
	private Integer id;
	
	private String ad;
	
	private String soyad;
	
	private int yas;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public int getYas() {
		return yas;
	}

	public void setYas(int yas) {
		this.yas = yas;
	}
	
	

}
