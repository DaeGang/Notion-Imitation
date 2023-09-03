package com.wanted.teamassignment1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DatabaseConnectionTest {
        // MySQL Connector 의 클래스. DB 연결 드라이버 정의
        private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
        // DB 경로
        private static final String URL = "jdbc:mysql://localhost:3306/wanted_team_assignment?serverTimezone=Asia/Seoul";
        private static final String USER = "bfly";
        private static final String PASSWORD = "20203085";



        @Test
        public void testConnection() {
            // DBMS에게 DB 연결 드라이버의 위치를 알려주기 위한 메소드
            assertDoesNotThrow(() -> {
                Class.forName(DRIVER);
            });
            assertDoesNotThrow(() -> {
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println(connection);
            });

        }
}
