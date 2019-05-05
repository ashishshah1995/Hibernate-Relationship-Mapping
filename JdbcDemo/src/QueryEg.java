import java.sql.*;

public class QueryEg {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		//Connection ct = null;

		try (
				Connection ct=DBUtil.getConnection();){
			System.out.println("Connected");
			Statement stmt=ct.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rst=stmt.executeQuery("select * from states");
			while(rst.next())
			System.out.println(rst.getString(1)+"\t"+rst.getString(2));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}/*
		 * finally {if(ct!=null) { ct.close();} }
		 */
		
	}

}
