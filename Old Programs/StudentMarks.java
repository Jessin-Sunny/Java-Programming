import java.sql.*;

public class StudentMarks {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student", "root", "password");
            Statement stmt = con.createStatement();
            String createTable = "CREATE TABLE IF NOT EXISTS StudentMarks (RollNo INT, Name VARCHAR(255), Subject1 INT, Subject2 INT, Subject3 INT)";
            stmt.executeUpdate(createTable);
            String insertData = "INSERT INTO StudentMarks VALUES (1, 'John', 90, 80, 70), (2, 'Jane', 80, 70, 60), (3, 'Jack', 70, 60, 50), (4, 'Jill', 60, 50, 40), (5, 'Jim', 50, 40, 30)";
            stmt.executeUpdate(insertData);
            String findTopper = "SELECT Name FROM StudentMarks ORDER BY (Subject1 + Subject2 + Subject3) DESC LIMIT 1";
            ResultSet rs = stmt.executeQuery(findTopper);
            rs.next();
            String topper = rs.getString("Name");
            System.out.println("The student who topped the class is " + topper);
            String findAverage = "SELECT AVG(Subject1) AS Subject1Average, AVG(Subject2) AS Subject2Average, AVG(Subject3) AS Subject3Average FROM StudentMarks";
            rs = stmt.executeQuery(findAverage);
            rs.next();
            double subject1Average = rs.getDouble("Subject1Average");
            double subject2Average = rs.getDouble("Subject2Average");
            double subject3Average = rs.getDouble("Subject3Average");
            System.out.println("The average class marks for Subject 1 is " + subject1Average);
            System.out.println("The average class marks for Subject 2 is " + subject2Average);
            System.out.println("The average class marks for Subject 3 is " + subject3Average);
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

