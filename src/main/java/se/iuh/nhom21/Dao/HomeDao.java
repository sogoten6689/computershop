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
public class HomeDao {
	@Autowired
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public int register(Account account) {
		AccountDao accountDao = new AccountDao();
		UserDao userDao = new UserDao();
		if(userDao.saveAddAcc(account.getSdt())==1) {
			return accountDao.save(account);
		}
			return -5;
	}	
	public Account login(String sdt,String matkhau) {
		String sql = "select * from TaiKhoan where sSDT = '"+sdt+"' and sMatkhau='"+matkhau+"'";
		List<Account> list = template.query(sql, new RowMapper<Account>() {
			
			public Account mapRow(ResultSet rs, int row ) throws SQLException{
			Account account  = new Account();
			account.setSdt(rs.getString(1));
			account.setMatkhau(rs.getString(2));
			account.setQuyen(rs.getInt(3));
			return account;
			}

		});
		if(list.size()>0) {
			Account accountResult = list.get(0);
				return accountResult;
		}
		return null;
	}

}
