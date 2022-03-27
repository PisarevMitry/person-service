package liga.medical.personservice.core.repository;

import liga.medical.personservice.core.model.ContactEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ContactRepository {

    @Select("select * from contact")
    List<ContactEntity> findAll();

    @Select("select * from contact where id = #{contactId}")
    ContactEntity findById(Long contactId);

    @Insert("insert into contact (phone_number, email, profile_link)" +
            "values(#{phoneNumber}, #{email}, #{profileLink})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(ContactEntity contactEntity);

    List<ContactEntity> findByListId(@Param("contactListId") List<Long> contactListId);

    int insertAll(@Param("contactList") List<ContactEntity> contactEntityList);

    Boolean updateById(@Param("contactEntity") ContactEntity contactEntity);

    Boolean deleteById(@Param("contactId") Long contactId);
}