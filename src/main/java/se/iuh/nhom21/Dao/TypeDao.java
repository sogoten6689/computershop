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

import se.iuh.nhom21.Model.Type;


/**
 * @author LamNguyen
 *
 */
@Repository
public class TypeDao {
	@Autowired
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public int save(Type type) {
		String sql ="insert into LoaiSanPham(spTenLoai,spThongTinLoai) "
				+ " values( N' "  
				+ type.getTenLoai()+" ', N' "
				+ type.getThongTinLoai()+" ')";
		System.out.println(type.toString());
		return template.update(sql);
	}	
	
	public int update(Type type) {
		String sql ="update LoaiSanPham set spTenLoai= N'"
				+ type.getTenLoai()+"',spThongTinLoai= N'"
				+ type.getThongTinLoai()+"' where spMaLoai = "
						+ type.getMaLoai();
		System.out.println(type.toString());
		return template.update(sql);
	}
	
	
	public int delete(int id) {
		String sql = "delete from LoaiSanPham where spMaLoai = "+id+" ";
		return template.update(sql);
	}
	
	public Type getTypeById(int id) {
		String sql = "select * from LoaiSanPham where spMaLoai = "+id+" ";
//		Type type = template.queryForObject(sql, new Object[] { id }, 
//				new BeanPropertyRowMapper<Type>(Type.class));
		List<Type> listtype = template.query(sql, new RowMapper<Type>() {
			
			public Type mapRow(ResultSet rs, int row ) throws SQLException{
			Type type = new Type();
			type.setMaLoai(rs.getInt(1));
			type.setTenLoai(rs.getString(2));
			type.setThongTinLoai(rs.getString(3));
			return type;
			}

		});
		Type type2 = listtype.get(0);
		return type2;
	}
	
	public List<Type> getTypes(){
		return template.query("select * from LoaiSanPham", new RowMapper<Type>() {
			
			public Type mapRow(ResultSet rs, int row ) throws SQLException{
			Type type = new Type();
			type.setMaLoai(rs.getInt(1));
			type.setTenLoai(rs.getString(2));
			type.setThongTinLoai(rs.getString(3));
			
			return type;
			}

		});
	}

}
