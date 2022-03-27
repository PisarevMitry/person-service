DELETE FROM person_data;
DELETE FROM address;
DELETE FROM illness;
DELETE FROM medical_card;
DELETE FROM contact;

DROP SEQUENCE person_data_seq;
DROP SEQUENCE address_seq;
DROP SEQUENCE illness_seq;
DROP SEQUENCE medical_card_seq;
DROP SEQUENCE contact_seq;

