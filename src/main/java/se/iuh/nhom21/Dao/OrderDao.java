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

import se.iuh.nhom21.Model.Order;
import se.iuh.nhom21.Model.OrderDetail;


/**
 * @author LamNguyen
 *
 */
@Repository
public class OrderDao {
	@Autowired
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public int save(Order order) {
		String sql = "insert into Order(sSDT, sPtthanhtoan, sDiachiNhanhang) values('" + order.getsSDT() + "',N'"
				+ order.getsPtthanhtoan() + "',N'" + order.getsDiachiNhanhang() + "')";
		System.out.println(sql);
		return template.update(sql);
	}

	public int saveDetail(OrderDetail orderDetail) {
		String sql = "insert into Chitietdonhang(iMadonhang, Masp,sSoluongct,sDongiact) values("
				+ orderDetail.getImadonhang() + "," + orderDetail.getMasp() + "," + orderDetail.getSoluongct() + ","
				+ orderDetail.getDongiact() + ")";
		System.out.println(sql);
		return template.update(sql);
	}
	
	//Lay chi tiet don hang
		public List<OrderDetail>getAllChitietByMadonhang(int imadonhang){
			String sql="select distinct ct.iMadonhang, sTensp, sSoluongct, sDongiact, sSoluongct * sDongiact from Chitietdonhang ct join Order dh on ct.iMadonhang = dh.iMadonhang join Sanpham sp on sp.Masp = ct.Masp where ct.iMadonhang=? group by ct.iMadonhang, sTensp, sSoluongct, sDongiact";
			return template.query(sql, new Object[] {imadonhang}, new RowMapper<OrderDetail>() {

				@Override
				public OrderDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
					// TODO Auto-generated method stub
					OrderDetail ct = new OrderDetail();
					ct.setImadonhang(rs.getInt(1));
					ct.setTensp_sp(rs.getString(2));
					ct.setSoluongct(rs.getInt(3));
					ct.setDongiact(rs.getBigDecimal(4));
					ct.setCongtien(rs.getBigDecimal(5));

					return ct;
				}
				
			});
		
		}

}
