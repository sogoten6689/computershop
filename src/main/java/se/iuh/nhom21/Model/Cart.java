/**
 * 
 */
package se.iuh.nhom21.Model;

import java.math.BigDecimal;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.lang.NonNull;

/**
 * @author LamNguyen
 *
 */
public class Cart {
	private int masp;
	private String tensp;
	@NonNull
	@NumberFormat
	private int soluong;
	private float dDongia;
	public int getMasp() {
		return masp;
	}
	public void setMasp(int masp) {
		this.masp = masp;
	}
	public String getTensp() {
		return tensp;
	}
	public void setTensp(String tensp) {
		this.tensp = tensp;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public float getdDongia() {
		return dDongia;
	}
	public void setdDongia(float dDongia) {
		this.dDongia = dDongia;
	}
	/**
	 * @param masp
	 * @param tensp
	 * @param soluong
	 * @param dDongia
	 */
	public Cart(int masp, String tensp, int soluong, float dDongia) {
		super();
		this.masp = masp;
		this.tensp = tensp;
		this.soluong = soluong;
		this.dDongia = dDongia;
	}
	/**
	 * 
	 */
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(dDongia);
		result = prime * result + masp;
		result = prime * result + soluong;
		result = prime * result + ((tensp == null) ? 0 : tensp.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		if (Float.floatToIntBits(dDongia) != Float.floatToIntBits(other.dDongia))
			return false;
		if (masp != other.masp)
			return false;
		if (soluong != other.soluong)
			return false;
		if (tensp == null) {
			if (other.tensp != null)
				return false;
		} else if (!tensp.equals(other.tensp))
			return false;
		return true;
	}
	/**
	 * 
	 */
	public Cart(Product product) {
		super();
		this.masp = product.getMasp();
		this.tensp = product.getTensp();
		this.soluong = 1;
		this.dDongia = product.getDongia();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
