/**
 * 
 */
package se.iuh.nhom21.Model;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author LamNguyen
 *
 */
public class Product {
	private int masp;
	private String tensp;
	private float dongia;
	private String anhsp;
	private String mota;
	private int maloai;
	private String trangthai;
	
	private MultipartFile file;
	
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
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
	public float getDongia() {
		return dongia;
	}
	public void setDongia(float dongia) {
		this.dongia = dongia;
	}
	public String getAnhsp() {
		return anhsp;
	}
	public void setAnhsp(String anhsp) {
		this.anhsp = anhsp;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	public int getMaloai() {
		return maloai;
	}
	public void setMaloai(int maloai) {
		this.maloai = maloai;
	}
	public String getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}
	/**
	 * @param masp
	 * @param tensp
	 * @param dongia
	 * @param anhsp
	 * @param mota
	 * @param maloai
	 * @param trangthai
	 */
	public Product(int masp, String tensp, float dongia, String anhsp, String mota, int maloai, String trangthai) {
		super();
		this.masp = masp;
		this.tensp = tensp;
		this.dongia = dongia;
		this.anhsp = anhsp;
		this.mota = mota;
		this.maloai = maloai;
		this.trangthai = trangthai;
	}
	/**
	 * 
	 */
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Product [masp=" + masp + ", tensp=" + tensp + ", dongia=" + dongia + ", anhsp=" + anhsp + ", mota="
				+ mota + ", maloai=" + maloai + ", trangthai=" + trangthai + "]";
	}
	
}
