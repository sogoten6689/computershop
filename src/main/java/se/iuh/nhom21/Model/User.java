package se.iuh.nhom21.Model;

import java.util.Date;

/**
 * @author LamNguyen
 *
 */
public class User {
	private int ma;
	private String ten;
	private String sdt;
	private String diachi;
	private String email;
	private String gioitinh;
	private Date ngaysinh;
	/**
	 * @return the ma
	 */
	public int getMa() {
		return ma;
	}
	/**
	 * @param ma the ma to set
	 */
	public void setMa(int ma) {
		this.ma = ma;
	}
	/**
	 * @return the ten
	 */
	public String getTen() {
		return ten;
	}
	/**
	 * @param ten the ten to set
	 */
	public void setTen(String ten) {
		this.ten = ten;
	}
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
	 * @return the diachi
	 */
	public String getDiachi() {
		return diachi;
	}
	/**
	 * @param diachi the diachi to set
	 */
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the gioitinh
	 */
	public String getGioitinh() {
		return gioitinh;
	}
	/**
	 * @param gioitinh the gioitinh to set
	 */
	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}
	/**
	 * @return the ngaysinh
	 */
	public Date getNgaysinh() {
		return ngaysinh;
	}
	/**
	 * @param ngaysinh the ngaysinh to set
	 */
	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public User(int ma, String ten, String sdt, String diachi, String email, String gioitinh, Date ngaysinh) {
		super();
		this.ma = ma;
		this.ten = ten;
		this.sdt = sdt;
		this.diachi = diachi;
		this.email = email;
		this.gioitinh = gioitinh;
		this.ngaysinh = ngaysinh;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((diachi == null) ? 0 : diachi.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((gioitinh == null) ? 0 : gioitinh.hashCode());
		result = prime * result + ma;
		result = prime * result + ((ngaysinh == null) ? 0 : ngaysinh.hashCode());
		result = prime * result + ((sdt == null) ? 0 : sdt.hashCode());
		result = prime * result + ((ten == null) ? 0 : ten.hashCode());
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
		User other = (User) obj;
		if (diachi == null) {
			if (other.diachi != null)
				return false;
		} else if (!diachi.equals(other.diachi))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (gioitinh == null) {
			if (other.gioitinh != null)
				return false;
		} else if (!gioitinh.equals(other.gioitinh))
			return false;
		if (ma != other.ma)
			return false;
		if (ngaysinh == null) {
			if (other.ngaysinh != null)
				return false;
		} else if (!ngaysinh.equals(other.ngaysinh))
			return false;
		if (sdt == null) {
			if (other.sdt != null)
				return false;
		} else if (!sdt.equals(other.sdt))
			return false;
		if (ten == null) {
			if (other.ten != null)
				return false;
		} else if (!ten.equals(other.ten))
			return false;
		return true;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [ma=" + ma + ", ten=" + ten + ", sdt=" + sdt + ", diachi=" + diachi + ", email=" + email
				+ ", gioitinh=" + gioitinh + ", ngaysinh=" + ngaysinh + "]";
	}
	
	
	

}
