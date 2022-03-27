package liga.medical.personservice.core;

import liga.medical.personservice.core.model.PersonDataEntity;
import liga.medical.personservice.core.model.UserRole;
import liga.medical.personservice.core.service.impl.PersonDataServiceImpl;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Component
public class Init {

    private final PersonDataServiceImpl personDataService;

    public Init(PersonDataServiceImpl personDataService) {this.personDataService = personDataService;}

    @PostConstruct
    public void init() {

        UserRole admin = UserRole.ADMIN;
        UserRole user = UserRole.USER;

        Set<UserRole> allAccess = new HashSet<>();
        Set<UserRole> userAccess = new HashSet<>();

        allAccess.add(admin);
        allAccess.add(user);

        userAccess.add(user);

        PersonDataEntity user1 = new PersonDataEntity("Pisarev", "Dmitrii", LocalDate.of(2003, 1, 1), "d.pisarev" + ".03@mail.ru", "1234");
        PersonDataEntity user2 = new PersonDataEntity("Pisarev1", "Dmitrii", LocalDate.of(2003, 1, 1), "d1.pisarev" + ".03@mail.ru", "12");
        PersonDataEntity user3 = new PersonDataEntity("Pisarev2", "Dmitrii", LocalDate.of(2003, 1, 1), "d2.pisarev" + ".03@mail.ru", "13");
        PersonDataEntity user4 = new PersonDataEntity("Pisarev3", "Dmitrii", LocalDate.of(2003, 1, 1), "d3.pisarev" + ".03@mail.ru", "14");
        PersonDataEntity user5 = new PersonDataEntity("Pisarev4", "Dmitrii", LocalDate.of(2003, 1, 1), "d4.pisarev" + ".03@mail.ru", "15");

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
}
