package se.iuh.nhom21.Model;


/**
 * @author LamNguyen
 *
 */
public class Type {
	private int maLoai;
	private String tenLoai;
	private String thongTinLoai;
	/**
	 * @return the maLoai
	 */
	public int getMaLoai() {
		return maLoai;
	}
	/**
	 * @param maLoai the maLoai to set
	 */
	public void setMaLoai(int maLoai) {
		this.maLoai = maLoai;
	}
	/**
	 * @return the tenLoai
	 */
	public String getTenLoai() {
		return tenLoai;
	}
	/**
	 * @param tenLoai the tenLoai to set
	 */
	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}
	/**
	 * @return the thongTinLoai
	 */
	public String getThongTinLoai() {
		return thongTinLoai;
	}
	/**
	 * @param thongTinLoai the thongTinLoai to set
	 */
	public void setThongTinLoai(String thongTinLoai) {
		this.thongTinLoai = thongTinLoai;
	}
	/**
	 * @param maLoai
	 * @param tenLoai
	 * @param thongTinLoai
	 */
	public Type(int maLoai, String tenLoai, String thongTinLoai) {
		super();
		this.maLoai = maLoai;
		this.tenLoai = tenLoai;
		this.thongTinLoai = thongTinLoai;
	}
	/**
	 * 
	 */
	public Type() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Type [maLoai=" + maLoai + ", tenLoai=" + tenLoai + ", thongTinLoai=" + thongTinLoai + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maLoai;
		result = prime * result + ((tenLoai == null) ? 0 : tenLoai.hashCode());
		result = prime * result + ((thongTinLoai == null) ? 0 : thongTinLoai.hashCode());
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
		Type other = (Type) obj;
		if (maLoai != other.maLoai)
			return false;
		if (tenLoai == null) {
			if (other.tenLoai != null)
				return false;
		} else if (!tenLoai.equals(other.tenLoai))
			return false;
		if (thongTinLoai == null) {
			if (other.thongTinLoai != null)
				return false;
		} else if (!thongTinLoai.equals(other.thongTinLoai))
			return false;
		return true;
	}
	
	
}
