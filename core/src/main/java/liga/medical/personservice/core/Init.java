package liga.medical.personservice.core;

import liga.medical.personservice.core.model.PersonDataEntity;
import liga.medical.personservice.core.model.UserRole;
import liga.medical.personservice.core.service.impl.PersonDataServiceImpl;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Component
public class Init {

    private final PersonDataServiceImpl personDataService;

    public Init(PersonDataServiceImpl personDataService) {this.personDataService = personDataService;}

    @PostConstruct
    public void init() {

        UserRole admin = UserRole.ROLE_ADMIN;
        UserRole user = UserRole.ROLE_USER;

        Set<UserRole> allAccess = new HashSet<>();
        Set<UserRole> userAccess = new HashSet<>();

        allAccess.add(admin);
        allAccess.add(user);

        userAccess.add(user);

        personDataService.deleteById(1001L);
        personDataService.deleteById(1002L);
        personDataService.deleteById(1003L);
        personDataService.deleteById(1004L);
        personDataService.deleteById(1005L);

        PersonDataEntity user1 = new PersonDataEntity(1001L, "Pisarev", "Dmitrii", LocalDate.of(2003, 1, 1), "d.pisarev" + ".03@mail.ru", "1234");
        PersonDataEntity user2 = new PersonDataEntity(1002L, "Pisarev1", "Dmitrii", LocalDate.of(2003, 1, 1), "d1.pisarev" + ".03@mail.ru", "12");
        PersonDataEntity user3 = new PersonDataEntity(1003L, "Pisarev2", "Dmitrii", LocalDate.of(2003, 1, 1), "d2.pisarev" + ".03@mail.ru", "13");
        PersonDataEntity user4 = new PersonDataEntity(1004L, "Pisarev3", "Dmitrii", LocalDate.of(2003, 1, 1), "d3.pisarev" + ".03@mail.ru", "14");
        PersonDataEntity user5 = new PersonDataEntity(1005L, "Pisarev4", "Dmitrii", LocalDate.of(2003, 1, 1), "d4.pisarev" + ".03@mail.ru", "15");

        user1.setRoles(allAccess);
        user2.setRoles(userAccess);
        user3.setRoles(userAccess);
        user4.setRoles(userAccess);
        user5.setRoles(userAccess);
        personDataService.insertUser(user1);
        personDataService.insertUser(user2);
        personDataService.insertUser(user3);
        personDataService.insertUser(user4);
        personDataService.insertUser(user5);
    }

    @PreDestroy
    void destroy() {
        personDataService.deleteById(1001L);
        personDataService.deleteById(1002L);
        personDataService.deleteById(1003L);
        personDataService.deleteById(1004L);
        personDataService.deleteById(1005L);
    }
}
