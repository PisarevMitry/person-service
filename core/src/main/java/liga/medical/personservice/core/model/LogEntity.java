package liga.medical.personservice.core.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LogEntity {

    private Long id;

    private LocalDateTime createDttm;

    private String methodName;

    private String className;

    private String userName;

    public LogEntity(LocalDateTime createDttm, String methodName, String className, String userName) {
        this.createDttm = createDttm;
        this.methodName = methodName;
        this.className = className;
        this.userName = userName;
    }
}