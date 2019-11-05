import java.sql.*;

public class BankManager {
    private static Connection mysqlConnection;
    public static void openConnection() throws SQLException{
        try {
            mysqlConnection= DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_manage","root","12345678");
        }catch (SQLException e){
            System.out.println("Co loi khi ket noi co so du lieu");
            System.out.println(e.getMessage());
        }
    }
    public static void closeConnection() throws SQLException{
        if (mysqlConnection!=null && !mysqlConnection.isClosed()){
            mysqlConnection.close();
        }
    }
    public static Statement createStatement() throws SQLException{
        if (mysqlConnection==null){
            openConnection();
        }
        Statement statement=mysqlConnection.createStatement();
        return statement;
    }
    public static PreparedStatement createPreparedStatement(String sql) throws SQLException {
        if (mysqlConnection==null){
            openConnection();
        }
        PreparedStatement statement=mysqlConnection.prepareStatement(sql);
        return statement;
    }

    public static void main(String[] args) {
        try{
            openConnection();
            //doc du lieu
            Statement statement=createStatement();
            ResultSet result=statement.executeQuery("select full_name from customers");
            while (result.next()){
                System.out.println(result.getString(1));
            }
            //them du lieu
//            String sql="insert into customers value(?,?,?,?,?,?)";
//            PreparedStatement statement1=createPreparedStatement(sql);
//            statement1.setInt(1,2);
//            statement1.setString(2,"naa");
//            statement1.setString(3,"nding");
//            statement1.setString(4,"na2@gmail.com");
//            statement1.setString(5,"0932260943");
//            statement1.setInt(6,2);
//
//            int rowInserted=statement1.executeUpdate();
//            if (rowInserted>0){
//                System.out.println("them thanh cong");
//            }
           //update
//            String sql = "UPDATE customers SET full_name=? WHERE customer_number=?";
//
//            PreparedStatement statement = createPreparedStatement(sql);
//            statement.setString(1, "Viet Nga");
//            statement.setInt(2, 1);
//
//            int rowsUpdated = statement.executeUpdate();
//            if (rowsUpdated > 0) {
//                System.out.println("Cap nhat thanh cong!");
//            }
            //xoa
//            String sql = "DELETE FROM customers WHERE customer_number=?";
//
//            PreparedStatement statement = createPrepareStatement(sql);
//            statement.setInt(1, 1);
//
//            int rowsDeleted = statement.executeUpdate();
//            if (rowsDeleted > 0) {
//                System.out.println("xoa thanh cong!");
//            }

            ////////
            closeConnection();
        } catch (SQLException e) {
            System.out.println("Loi");
            System.out.println(e.getMessage());
        }finally {
        }
    }
}
