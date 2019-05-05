package se.iuh.nhom21.Model;


/**
 * @author LamNguyen
 *
 */
public class Account {
	private String sdt;
	private String matkhau;
	private int quyen;
	/**
	 * @return the sdt
	 */
	public String getSdt() {
		return sdt;
	}
	/**
	 * @param sdt the sdt to set
	 */
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	/**
	 * @return the matkhau
	 */
	public String getMatkhau() {
		return matkhau;
	}
	/**
	 * @param matkhau the matkhau to set
	 */
	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}
	/**
	 * @return the quyen
	 */
	public int getQuyen() {
		return quyen;
	}
	/**
	 * @param quyen the quyen to set
	 */
	public void setQuyen(int quyen) {
		this.quyen = quyen;
	}
	/**
	 * @param sdt
	 * @param matkhau
	 * @param quyen
	 */
	public Account(String sdt, String matkhau, int quyen) {
		super();
		this.sdt = sdt;
		this.matkhau = matkhau;
		this.quyen = quyen;
	}
	/**
	 * 
	 */
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Account [sdt=" + sdt + ", matkhau=" + matkhau + ", quyen=" + quyen + "]";
	}
	
	
}
