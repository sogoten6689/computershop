/**
 * 
 */
package se.iuh.nhom21.Model;


/**
 * @author LamNguyen
 *
 */
public class OrderDetail {
	private int masp;
	private int imadonhang;
	private int soluongct;
	private float dongiact;
	private String tensp_sp;
	private float congtien;

	
	
	@Override
	public String toString() {
		return "OrderDetail [masp=" + masp + ", imadonhang=" + imadonhang + ", soluongct=" + soluongct + ", dongiact="
				+ dongiact + ", tensp_sp=" + tensp_sp + ", congtien=" + congtien + "]";
	}
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
	public float getDongiact() {
		return dongiact;
	}
	public void setDongiact(float dongiact) {
		this.dongiact = dongiact;
	}
	public String getTensp_sp() {
		return tensp_sp;
	}
	public void setTensp_sp(String tensp_sp) {
		this.tensp_sp = tensp_sp;
	}
	public float getCongtien() {
		return congtien;
	}
	public void setCongtien(float congtien) {
		this.congtien = congtien;
	}
	/**
	 * @param masp
	 * @param imadonhang
	 * @param soluongct
	 * @param dongiact
	 * @param tensp_sp
	 * @param congtien
	 */
	public OrderDetail(int masp, int imadonhang, int soluongct, float dongiact, String tensp_sp,
			float congtien) {
		super();
		this.masp = masp;
		this.imadonhang = imadonhang;
		this.soluongct = soluongct;
		this.dongiact = dongiact;
		this.tensp_sp = tensp_sp;
		this.congtien = congtien;
	}
	/**
	 * @param dongia 
	 * @param soluong 
	 * @param mahd 
	 * @param masp2 
	 * 
	 */

	/**
	 * @param masp
	 * @param imadonhang
	 * @param soluongct
	 * @param dongiact
	 */
	public OrderDetail(int masp, int imadonhang, int soluongct, float dongiact) {
		super();
		this.masp = masp;
		this.imadonhang = imadonhang;
		this.soluongct = soluongct;
		this.dongiact = dongiact;
	}
	/**
	 * 
	 */
	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
