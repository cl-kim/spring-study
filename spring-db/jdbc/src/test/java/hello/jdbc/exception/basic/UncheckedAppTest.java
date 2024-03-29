package hello.jdbc.exception.basic;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

@Slf4j
public class UncheckedAppTest {

    @Test
    void unchecked() {
        Controller controller = new Controller();
        Assertions.assertThatThrownBy(() -> controller.request())
                .isInstanceOf(Exception.class);
    }

    @Test
    void printEx() {
        Controller controller = new Controller();
        try {
            controller.request();
        } catch (Exception e) {
            log.info("ex", e);
        }
    }

    static class Controller {
        Service service = new Service();

        public void request() {
            service.logic();
        }

    }

    static class Service {
        Repository repository = new Repository();
        NetworkClient networkClient = new NetworkClient();

        public void logic() {
            repository.call();
            networkClient.call();
        }
    }

    static class NetworkClient {
        public void call() {
            throw new RuntimeConnectException("연결 실패");
        }
    }

    static class Repository {
        public void call() {
            try {
                runSQL();
            } catch (SQLException e) {
                throw new RuntimeSqlException(e);
            }
        }

        // 이러면 안된다!
        // 예외를 전환할 때는 기존 예외를 꼭 포함해야한다.
        public void callV2() {
            try {
                runSQL();
            } catch (SQLException e) {
                throw new RuntimeSqlException();
            }
        }

        public void runSQL() throws SQLException {
            throw new SQLException("ex");
        }
    }

    static class RuntimeSqlException extends RuntimeException {

        public RuntimeSqlException() {
        }

        public RuntimeSqlException(Throwable cause) {
            super(cause);
        }
    }

    static class RuntimeConnectException extends RuntimeException {
        public RuntimeConnectException(String message) {
            super(message);
        }
    }
}
