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