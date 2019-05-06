/**
 * 
 */
package se.iuh.nhom21.Model;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author LamNguyen
 *
 */
public class Order {
	private int imadonhang;
	private String sSDT;
	private Timestamp dtNgaydathang;
	private String sPtthanhtoan;
	private String sDiachiNhanhang;
	private int makh;
	private BigDecimal tongtien;
	private int countSL;

	public int getMakh() {
		return makh;
	}
	public void setMakh(int makh) {
		this.makh = makh;
	}
	public BigDecimal getTongtien() {
		return tongtien;
	}
	public void setTongtien(BigDecimal tongtien) {
		this.tongtien = tongtien;
	}
	public int getCountSL() {
		return countSL;
	}
	public void setCountSL(int countSL) {
		this.countSL = countSL;
	}
	public int getImadonhang() {
		return imadonhang;
	}
	public void setImadonhang(int imadonhang) {
		this.imadonhang = imadonhang;
	}
	public String getsSDT() {
		return sSDT;
	}
	public void setsSDT(String sSDT) {
		this.sSDT = sSDT;
	}
	
	public Timestamp getDtNgaydathang() {
		return dtNgaydathang;
	}
	
	public void setDtNgaydathang(Timestamp timestamp) {
		this.dtNgaydathang = timestamp;
	}
	public String getsPtthanhtoan() {
		return sPtthanhtoan;
	}
	public void setsPtthanhtoan(String sPtthanhtoan) {
		this.sPtthanhtoan = sPtthanhtoan;
	}
	public String getsDiachiNhanhang() {
		return sDiachiNhanhang;
	}
	public void setsDiachiNhanhang(String sDiachiNhanhang) {
		this.sDiachiNhanhang = sDiachiNhanhang;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + imadonhang;
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
		Order other = (Order) obj;
		if (imadonhang != other.imadonhang)
			return false;
		return true;
	}
	/**
	 * @param imadonhang
	 * @param sSDT
	 * @param dtNgaydathang
	 * @param sPtthanhtoan
	 * @param sDiachiNhanhang
	 * @param makh
	 * @param tongtien
	 * @param countSL
	 */
	public Order(int imadonhang, String sSDT, Timestamp dtNgaydathang, String sPtthanhtoan, String sDiachiNhanhang,
			int makh, BigDecimal tongtien, int countSL) {
		super();
		this.imadonhang = imadonhang;
		this.sSDT = sSDT;
		this.dtNgaydathang = dtNgaydathang;
		this.sPtthanhtoan = sPtthanhtoan;
		this.sDiachiNhanhang = sDiachiNhanhang;
		this.makh = makh;
		this.tongtien = tongtien;
		this.countSL = countSL;
	}
	/**
	 * 
	 */
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
