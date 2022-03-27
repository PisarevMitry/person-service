ALTER TABLE person_data
    ADD email VARCHAR;

ALTER TABLE person_data
    ADD password VARCHAR;

ALTER TABLE person_data
    ALTER COLUMN sex DROP NOT NULL;

ALTER TABLE person_data
    ALTER COLUMN contact_id DROP NOT NULL;

ALTER TABLE person_data
    ALTER COLUMN medical_card_id DROP NOT NULL;