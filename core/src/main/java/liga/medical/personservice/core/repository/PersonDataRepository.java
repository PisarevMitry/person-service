package liga.medical.personservice.core.repository;

import liga.medical.personservice.core.model.PersonDataEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PersonDataRepository {

    @Select("select * from person_data")
    List<PersonDataEntity> findAll();

    @Select("select * from person_data where id = #{personDataId}")
    PersonDataEntity findById(Long personDataId);

    @Insert("insert into person_data (id, last_name, first_name, birth_dt, age, sex, contact_id, medical_card_id) " +
            "values(#{lastName}, #{first_name}, #{birthDt}, #{age}, #{sex}, #{contact_id}, #{medical_card_id})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(PersonDataEntity personDataEntity);

    @Insert("insert into person_data (id, last_name, first_name, birth_dt, email, password)" +
            "values( #{id}, #{lastName}, #{firstName}, #{birthDt}, #{email}, #{password})")
    void insertUser(PersonDataEntity personDataEntity);

    List<PersonDataEntity> findByListId(@Param("personDataListId") List<Long> personDataListId);

    int insertAll(@Param("personDataList") List<PersonDataEntity> personDataEntityList);

    Boolean updateById(@Param("personDataEntity") PersonDataEntity personDataEntity);

    Boolean deleteById(@Param("personDataId") Long personDataId);

    @Select("SELECT * FROM person_data WHERE email = #{email}")
    PersonDataEntity findByEmail(String email);

}