/**
 * 
 */
package se.iuh.nhom21.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import se.iuh.nhom21.Model.User;


/**
 * @author LamNguyen
 *
 */
@Repository
public class UserDao {
	@Autowired
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	// tao khach hang truoc khi tao tai khoan
	public int saveAddAcc(String sdt) {
		int kq=-5;
		try {
			String sql ="insert into KhachHang (sSDT) values('"+sdt+"' )";
			 kq=template.update(sql);
		}
		catch(Exception exception) {
			System.err.println(exception);
		}
		return kq;
	}	
	
	// cap nhat khachang sau khi dang ki
	public int update(User user) {
		String sql ="update KhachHang set tenkh= N'"
				+ user.getTen()+"',sDiachi=N'"
				+user.getDiachi()+"',sEmail=N'"+user.getEmail()+"',Gioitinh=N'"
				+user.getGioitinh()+"' where iMakh = "+ user.getMa();
		System.out.println(user.toString());
		return template.update(sql);
	}
	
	public int delete(int id) {
		String sql = "delete from KhachHang where id = "+id+" ";
		return template.update(sql);
	}
	
	public List<User> getUsers(){
		return template.query("select * from KhachHang", new RowMapper<User>() {
			public User mapRow(ResultSet rs, int row ) throws SQLException{
			User user = new User();
			user.setMa(rs.getInt(1));
			user.setTen(rs.getString(2));
			user.setSdt(rs.getString(3));
			user.setDiachi(rs.getString(4));
			user.setEmail(rs.getString(5));
			user.setGioitinh(rs.getString(6));
//			user.setGioitinh(rs.getString());
			user.setNgaysinh(new Date());
			
			return user;
			}

		});
	}
	
	public User getTypeBySdt(String sdt) {
		String sql = "select * from KhachHang where sSDT = "+sdt+" ";
		List<User> list = template.query(sql, new RowMapper<User>() {
			public User mapRow(ResultSet rs, int row ) throws SQLException{
				User user = new User();
				user.setMa(rs.getInt(1));
				user.setTen(rs.getString(2));
				user.setSdt(rs.getString(3));
				user.setDiachi(rs.getString(4));
				user.setEmail(rs.getString(5));
				user.setGioitinh(rs.getString(6));
//				user.setGioitinh(rs.getString());
				user.setNgaysinh(new Date());
				
				return user;
			}

		});
		User userResult = list.get(0);
		return userResult;
	}

}
