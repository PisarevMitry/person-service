ALTER TABLE person_data
    DROP COLUMN email;

ALTER TABLE person_data
    DROP COLUMN password;

ALTER TABLE person_data
    ALTER COLUMN sex SET NOT NULL;

ALTER TABLE person_data
    ALTER COLUMN contact_id SET NOT NULL;

ALTER TABLE person_data
    ALTER COLUMN medical_card_id SET NOT NULL;

DELETE
FROM person_data
WHERE id = 1001;

DELETE
FROM person_data
WHERE id = 1002;
DELETE
FROM person_data
WHERE id = 1003;
DELETE
FROM person_data
WHERE id = 1004;
DELETE
FROM person_data
WHERE id = 1005;