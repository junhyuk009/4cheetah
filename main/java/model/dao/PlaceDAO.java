package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.dto.PlaceDTO;

public class PlaceDAO {
	private static final String INSERT ="INSERT INTO PLACE (ID, NAME, ADDRESS, LAT, LNG) VALUES (?, ?, ?, ?, ?)";
	private static final String SELECT_ONE ="SELECT ID, NAME, ADDRESS, LAT, LNG FROM PLACE WHERE ID = ?";
	private static final String SELECT_ALL ="SELECT ID, NAME, ADDRESS, LAT, LNG FROM PLACE ORDER BY ID DESC";


	private Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Teemo","1234");
	}


	public boolean insert(PlaceDTO dto) {
		try (Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(INSERT)) {
			pstmt.setInt(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getAddress());
			pstmt.setDouble(4, dto.getLat());
			pstmt.setDouble(5, dto.getLng());


			return pstmt.executeUpdate() == 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}


	public PlaceDTO selectOne(int id) {
		try (Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_ONE)) {


			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();


			if (rs.next()) {
				PlaceDTO dto = new PlaceDTO();
				dto.setId(rs.getInt("ID"));
				dto.setName(rs.getString("NAME"));
				dto.setAddress(rs.getString("ADDRESS"));
				dto.setLat(rs.getDouble("LAT"));
				dto.setLng(rs.getDouble("LNG"));
				return dto;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	public List<PlaceDTO> selectAll() {
		List<PlaceDTO> list = new ArrayList<>();


		try (Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL);
				ResultSet rs = pstmt.executeQuery()) {


			while (rs.next()) {
				PlaceDTO dto = new PlaceDTO();
				dto.setId(rs.getInt("ID"));
				dto.setName(rs.getString("NAME"));
				dto.setAddress(rs.getString("ADDRESS"));
				dto.setLat(rs.getDouble("LAT"));
				dto.setLng(rs.getDouble("LNG"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
