/**
 * 
 */
package se.iuh.nhom21.Model;

import java.math.BigDecimal;

/**
 * @author LamNguyen
 *
 */
public class OrderDetail {
	private int masp;
	private int imadonhang;
	private int soluongct;
	private BigDecimal dongiact;
	private String tensp_sp;
	private BigDecimal congtien;
	public int getMasp() {
		return masp;
	}
	public void setMasp(int masp) {
		this.masp = masp;
	}
	public int getImadonhang() {
		return imadonhang;
	}
	public void setImadonhang(int imadonhang) {
		this.imadonhang = imadonhang;
	}
	public int getSoluongct() {
		return soluongct;
	}
	public void setSoluongct(int soluongct) {
		this.soluongct = soluongct;
	}
	public BigDecimal getDongiact() {
		return dongiact;
	}
	public void setDongiact(BigDecimal dongiact) {
		this.dongiact = dongiact;
	}
	public String getTensp_sp() {
		return tensp_sp;
	}
	public void setTensp_sp(String tensp_sp) {
		this.tensp_sp = tensp_sp;
	}
	public BigDecimal getCongtien() {
		return congtien;
	}
	public void setCongtien(BigDecimal congtien) {
		this.congtien = congtien;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((congtien == null) ? 0 : congtien.hashCode());
		result = prime * result + ((dongiact == null) ? 0 : dongiact.hashCode());
		result = prime * result + imadonhang;
		result = prime * result + masp;
		result = prime * result + soluongct;
		result = prime * result + ((tensp_sp == null) ? 0 : tensp_sp.hashCode());
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
		OrderDetail other = (OrderDetail) obj;
		if (congtien == null) {
			if (other.congtien != null)
				return false;
		} else if (!congtien.equals(other.congtien))
			return false;
		if (dongiact == null) {
			if (other.dongiact != null)
				return false;
		} else if (!dongiact.equals(other.dongiact))
			return false;
		if (imadonhang != other.imadonhang)
			return false;
		if (masp != other.masp)
			return false;
		if (soluongct != other.soluongct)
			return false;
		if (tensp_sp == null) {
			if (other.tensp_sp != null)
				return false;
		} else if (!tensp_sp.equals(other.tensp_sp))
			return false;
		return true;
	}
	/**
	 * @param masp
	 * @param imadonhang
	 * @param soluongct
	 * @param dongiact
	 * @param tensp_sp
	 * @param congtien
	 */
	public OrderDetail(int masp, int imadonhang, int soluongct, BigDecimal dongiact, String tensp_sp,
			BigDecimal congtien) {
		super();
		this.masp = masp;
		this.imadonhang = imadonhang;
		this.soluongct = soluongct;
		this.dongiact = dongiact;
		this.tensp_sp = tensp_sp;
		this.congtien = congtien;
	}
	/**
	 * 
	 */
	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
