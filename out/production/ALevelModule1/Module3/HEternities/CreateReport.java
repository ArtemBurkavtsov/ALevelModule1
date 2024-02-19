package src.Module3.HEternities;

import src.Module3.DAO.UserDAO;
import src.Module3.Service.User;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Optional;

public class CreateReport {
    private static void Report(UserDAO UserDAO) {
        Report reportBuilder = new Report();
        Optional<User> getUser = UserDAO.getById(6L);
        if (getUser.isEmpty()) {
            return;
        }
        User user = getUser.get();
        LocalDateTime startDate = LocalDateTime.of(2024, Month.JANUARY, 14, 00, 00, 00);
        LocalDateTime endDate = LocalDateTime.of(2024, Month.JANUARY, 20, 00, 00, 00);
        String operationsReport = "C:\\Users\\burka_gqys6yk\\IdeaProjects\\ALevelModule1\\src\\Module3\\ResultReport.csv";
        Report.Report(user, startDate, endDate, operationsReport);
    }
}
