/*Вывод данных о болезнях пользоватлей*/
SELECT country_id, city, street, building, phone_number
FROM address
         INNER JOIN contact ON address.contact_id = contact.id;

/*Удаление всех контактов с одинаковыми номерами телефонов*/
CREATE TEMPORARY TABLE contact_temp
as (
    SELECT min(id) as id
    FROM contact
    GROUP BY phone_number
);

DELETE
from contact
WHERE contact.id not in (
    SELECT id
    FROM contact_temp
);
/*Вывод первых 50% записей из таблицы*/
SELECT *
FROM contact
LIMIT((SELECT COUNT(*) FROM contact) / 2);

/*Вывод списка ФЛ c их родителями, у которых мед. статус отсутствует*/
SELECT *
FROM person_data AS person
         INNER JOIN person_data AS parent
                    ON person.parent_id = parent.id
         INNER JOIN medical_card
                    ON person.medical_card_id = medical_card.id
WHERE med_status IS NULL;

/*Представление данных о болезнях пользоватлей*/

CREATE VIEW full_contact
AS
(
SELECT country_id, city, street, building, phone_number
FROM address
         INNER JOIN contact ON address.contact_id = contact.id
    );

