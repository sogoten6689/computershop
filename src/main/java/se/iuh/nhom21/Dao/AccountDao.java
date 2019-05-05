/**
 * 
 */
package se.iuh.nhom21.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import se.iuh.nhom21.Model.Account;
import se.iuh.nhom21.Model.Type;


/**
 * @author LamNguyen
 *
 */
@Repository
public class AccountDao {
	@Autowired
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public int save(Account account) {
		String sql ="insert into TaiKhoan(sSDT,sMatkhau,iMaquyen) "
				+ " values( '"+account.getSdt()+"','"+account.getMatkhau()+"',2)";
		System.out.println(account.toString());
		return template.update(sql);
	}	
	
	public int delete(int id) {
		String sql = "delete from TaiKhoan where id = "+id+" ";
		return template.update(sql);
	}
	
	public List<Account> getAccounts(){
		return template.query("select * from TaiKhoan", new RowMapper<Account>() {
			public Account mapRow(ResultSet rs, int row ) throws SQLException{
			Account Account = new Account();
			Account.setSdt(rs.getString(1));
			Account.setMatkhau(rs.getString(2));
			Account.setQuyen(rs.getInt(3));
				return Account;
			}
		});
	}

}
