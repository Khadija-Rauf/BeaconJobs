package MyPack;

import java.sql.*;

public class UserDAO{
    private Connection con;
        String sql;
        public UserDAO() throws SQLException,ClassNotFoundException{
            Connection();
        }
        public void Connection() throws SQLException, ClassNotFoundException{
            Class.forName("com.mysql.jdbc.Driver"); 
            String url = "jdbc:mysql://127.0.0.1/jobs"; 
            con = DriverManager.getConnection(url, "root", "root"); 
        }
        public int addUser(UserInfo user)throws SQLException{
            int rs = 0;
            sql = "INSERT INTO users(email,username,password,phone,user_type) VALUES(?,?,?,?,?)";
            PreparedStatement pStmt = con.prepareStatement(sql);
            String email = user.getEmail();
            String username = user.getUsername();
            String password = user.getPassword();
            String phone = user.getPhone();
            String userType = user.getUserType();
            int user_type;
            if ("Admin".equals(userType)){
                user_type = 1;
            }
            else{
                user_type = 2;
            }

            pStmt.setString(1,email);
            pStmt.setString(2,username);
            pStmt.setString(3,password);
            pStmt.setString(4,phone);
            pStmt.setInt(5, user_type);
            rs = pStmt.executeUpdate();
            con.close();
        return rs;
        }
        public int authentication(String username, String password)throws SQLException{
            int ret = 0 ;
            sql = "SELECT * FROM users WHERE username=? and password=?";
            PreparedStatement pStmt = con.prepareStatement(sql);
            pStmt.setString(1, username);
            pStmt.setString(2, password);
            ResultSet rs = pStmt.executeQuery();
            if(rs.next()){
                ret = rs.getInt("user_type");
                return ret;
            }
            else{
                return -1;
            }
        }
        public UserInfo profile(String username)throws SQLException{
            UserInfo u = null;
            sql = "SELECT * FROM users WHERE username=?";
            PreparedStatement pStmt = con.prepareStatement(sql);
            pStmt.setString(1, username);
            ResultSet rs = pStmt.executeQuery();
            if(rs.next()){
                String email = rs.getString("email");
                String usern = rs.getString("username");
                String pass = rs.getString("password");
                String phone = rs.getString("phone");
                String user_type = rs.getString("user_type");
                String jobId = rs.getString("jobId");
                u =  new UserInfo();
                u.setEmail(email);
                u.setUsername(usern);
                u.setPassword(pass);
                u.setPhone(phone);
                u.setUserType(user_type);
                u.setJobId(jobId);
                return u;
                }
                else{
                    return u;
                }
        }
        public int applyJob(String username, String id)throws SQLException{
            int rs = 0;
            sql = "UPDATE users SET jobId=(SELECT id FROM jobs WHERE jobs.id=?)WHERE username=?";
            PreparedStatement pStmt = con.prepareStatement(sql);
            pStmt.setString(1, id);
            pStmt.setString(2, username);
            rs = pStmt.executeUpdate();
            con.close();
            return rs;
            }
            
}