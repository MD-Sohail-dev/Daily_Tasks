package org.example;

import java.sql.*;
import java.util.Scanner;

public class Main {
    // Database credentials
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Scanner sc = new Scanner(System.in)) {

            System.out.println("Connected to MySQL database!");

            while (true) {
                System.out.println("\n===== MENU =====");
                System.out.println("1. Insert User");
                System.out.println("2. View All Users");
                System.out.println("3. Update User");
                System.out.println("4. Delete User");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter email: ");
                        String email = sc.nextLine();
                        insertUser(conn, name, email);
                        break;

                    case 2:
                        readUsers(conn);
                        break;

                    case 3:
                        System.out.print("Enter user ID to update: ");
                        int uid = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter new name: ");
                        String newName = sc.nextLine();
                        System.out.print("Enter new email: ");
                        String newEmail = sc.nextLine();
                        updateUser(conn, uid, newName, newEmail);
                        break;

                    case 4:
                        System.out.print("Enter user ID to delete: ");
                        int delId = sc.nextInt();
                        deleteUser(conn, delId);
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // INSERT
    private static void insertUser(Connection conn, String name, String email) throws SQLException {
        String sql = "INSERT INTO users (name, email) VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            int rows = pstmt.executeUpdate();
            System.out.println("Inserted " + rows + " user(s).");
        }
    }

    // READ
    private static void readUsers(Connection conn) throws SQLException {
        String sql = "SELECT * FROM users";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\nUsers in DB:");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("email"));
            }
        }
    }

    // UPDATE
    private static void updateUser(Connection conn, int id, String newName, String newEmail) throws SQLException {
        String sql = "UPDATE users SET name = ?, email = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newName);
            pstmt.setString(2, newEmail);
            pstmt.setInt(3, id);
            int rows = pstmt.executeUpdate();
            System.out.println("Updated " + rows + " user(s).");
        }
    }

    // DELETE
    private static void deleteUser(Connection conn, int id) throws SQLException {
        String sql = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rows = pstmt.executeUpdate();
            System.out.println("Deleted " + rows + " user(s).");
        }
    }
}
