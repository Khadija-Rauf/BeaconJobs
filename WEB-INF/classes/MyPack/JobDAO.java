package MyPack;

import java.sql.*;
import java.util.ArrayList;

public class JobDAO{
        private Connection con;
        String sql;
        public JobDAO() throws SQLException,ClassNotFoundException{
            Connection();
        }
        public void Connection() throws SQLException, ClassNotFoundException{
            Class.forName("com.mysql.jdbc.Driver"); 
            String url = "jdbc:mysql://127.0.0.1/jobs"; 
            con = DriverManager.getConnection(url, "root", "root"); 
        }
        public int addJob(JobInfo job) throws SQLException{
            int rs = 0 ;
            sql = "INSERT INTO jobs(id,title,salary,type,description) VALUES(?,?,?,?,?)";
            PreparedStatement pStmt = con.prepareStatement(sql);

            String id = job.getId();
            String title = job.getTitle();
            Integer salary = job.getSalary();
            String type = job.getType();
            String decription = job.getDescription();

            pStmt.setString(1,id);
            pStmt.setString(2,title);
            pStmt.setInt(3,salary);
            pStmt.setString(4,type);
            pStmt.setString(5,decription);
            rs = pStmt.executeUpdate();
            return rs;
        }

        public int updateJob(JobInfo job)throws SQLException{
            int rs = 0;
            sql = "UPDATE jobs SET title=?, salary=?, type=?, description=? WHERE id=?";
            PreparedStatement pStmt = con.prepareStatement(sql);

            String id = job.getId();
            String title = job.getTitle();
            Integer salary = job.getSalary();
            String type = job.getType();
            String description = job.getDescription();

            pStmt.setString(1, title);
            pStmt.setInt(2, salary);
            pStmt.setString(3, type);
            pStmt.setString(4,description);
            pStmt.setString(5, id);
            rs = pStmt.executeUpdate();
            con.close();
            return rs;
        }

        public int delete(String id) throws SQLException{
            int rs = 0;
            sql = "DELETE FROM jobs WHERE id=?";
            PreparedStatement pStmt = con.prepareStatement(sql);
            pStmt.setString(1, id);
            rs = pStmt.executeUpdate();
            con.close();
            return rs;
        }

        public ArrayList<JobInfo> searchJob(String jobTitle)throws SQLException{
            ArrayList <JobInfo> jobList = new ArrayList<JobInfo>();
            sql = "SELECT * FROM jobs WHERE title=?";
            PreparedStatement pSmt = con.prepareStatement(sql);
            pSmt.setString(1, jobTitle);
            ResultSet rs = pSmt.executeQuery();
            while(rs.next()){
                String id = rs.getString("id");
                String title = rs.getString("title");
                Integer salary = rs.getInt("salary");
                String type = rs.getString("type");
                String description = rs.getString("description");
                
                JobInfo jobs = new JobInfo();
                jobs.setId(id);
                jobs.setTitle(title);
                jobs.setSalary(salary);
                jobs.setType(type);
                jobs.setDescription(description);
                jobList.add(jobs);
            }                
        return jobList;
        }

        public ArrayList<JobInfo> retrieveJobs()throws SQLException{
            ArrayList <JobInfo> jobList = new ArrayList<JobInfo>();
            sql = "SELECT * FROM jobs";
            PreparedStatement pSmt = con.prepareStatement(sql);
            ResultSet rs = pSmt.executeQuery();
            while(rs.next()){
                String id = rs.getString("id");
                String title = rs.getString("title");
                Integer salary = rs.getInt("salary");
                String type = rs.getString("type");
                String description = rs.getString("description");
                
                JobInfo jobs = new JobInfo();
                jobs.setId(id);
                jobs.setTitle(title);
                jobs.setSalary(salary);
                jobs.setType(type);
                jobs.setDescription(description);
                jobList.add(jobs);
            }
            return jobList;
        }
        public ArrayList<JobInfo> searchAppJob(String jobId)throws SQLException{
            ArrayList <JobInfo> jobList = new ArrayList<JobInfo>();
            sql = "SELECT * FROM jobs WHERE id=?";
            PreparedStatement pSmt = con.prepareStatement(sql);
            pSmt.setString(1, jobId);
            ResultSet rs = pSmt.executeQuery();
            while(rs.next()){
                String id = rs.getString("id");
                String title = rs.getString("title");
                Integer salary = rs.getInt("salary");
                String type = rs.getString("type");
                String description = rs.getString("description");
                
                JobInfo jobs = new JobInfo();
                jobs.setId(id);
                jobs.setTitle(title);
                jobs.setSalary(salary);
                jobs.setType(type);
                jobs.setDescription(description);

                jobList.add(jobs);
            }
        return jobList;
        }
}