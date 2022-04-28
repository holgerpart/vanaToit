-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-04-27 08:21:52.398

-- tables
-- Table: authorized_user
CREATE TABLE authorized_user
(
    id      serial NOT NULL,
    user_id int    NOT NULL,
    shop_id int    NOT NULL,
    CONSTRAINT authorized_user_pk PRIMARY KEY (id)
);

-- Table: book_food
CREATE TABLE book_food
(
    id           serial NOT NULL,
    user_id      int    NOT NULL,
    shop_food_id int    NOT NULL,
    quantity     int    NOT NULL,
    status_id    int    NOT NULL,
    CONSTRAINT book_food_pk PRIMARY KEY (id)
);

-- Table: city
CREATE TABLE city
(
    id   serial       NOT NULL,
    name varchar(255) NOT NULL,
    CONSTRAINT city_pk PRIMARY KEY (id)
);

-- Table: contact
CREATE TABLE contact
(
    id         serial      NOT NULL,
    first_name varchar(50) NOT NULL,
    last_name  varchar(50) NOT NULL,
    CONSTRAINT contact_pk PRIMARY KEY (id)
);

-- Table: food
CREATE TABLE food
(
    id      serial      NOT NULL,
    name    varchar(50) NOT NULL,
    type_id int         NOT NULL,
    CONSTRAINT food_pk PRIMARY KEY (id)
);

-- Table: profile
CREATE TABLE profile
(
    id         serial        NOT NULL,
    aadress    varchar(255)  NOT NULL,
    tel_number varchar(255)  NOT NULL,
    longitude  decimal(7, 5) NULL,
    latitude   decimal(7, 5) NULL,
    city_id    int           NOT NULL,
    CONSTRAINT profile_pk PRIMARY KEY (id)
);

-- Table: role
CREATE TABLE role
(
    id   serial      NOT NULL,
    role varchar(50) NOT NULL,
    CONSTRAINT role_pk PRIMARY KEY (id)
);

-- Table: shop
CREATE TABLE shop
(
    id         serial      NOT NULL,
    name       varchar(50) NOT NULL,
    profile_id int         NOT NULL,
    CONSTRAINT shop_pk PRIMARY KEY (id)
);

-- Table: shop_food
CREATE TABLE shop_food
(
    id              serial        NOT NULL,
    shop_id         int           NOT NULL,
    food_id         int           NOT NULL,
    quantity        int           NOT NULL,
    unit_id         int           NOT NULL,
    is_available    boolean       NOT NULL,
    date_time       timestamp     NOT NULL,
    expiration_date date          NULL,
    comments        varchar(1000) NULL,
    CONSTRAINT shop_food_pk PRIMARY KEY (id)
);

-- Table: shop_food_log
CREATE TABLE shop_food_log
(
    id        serial    NOT NULL,
    shop_id   int       NOT NULL,
    food_id   int       NOT NULL,
    quantity  int       NOT NULL,
    unit_id   int       NOT NULL,
    date_time timestamp NOT NULL,
    CONSTRAINT shop_food_log_pk PRIMARY KEY (id)
);

-- Table: status
CREATE TABLE status
(
    id          serial      NOT NULL,
    description varchar(50) NOT NULL,
    CONSTRAINT status_pk PRIMARY KEY (id)
);

-- Table: type
CREATE TABLE type
(
    id   serial      NOT NULL,
    name varchar(50) NOT NULL,
    CONSTRAINT type_pk PRIMARY KEY (id)
);

-- Table: unit
CREATE TABLE unit
(
    id   serial       NOT NULL,
    name varchar(255) NOT NULL,
    CONSTRAINT unit_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE "user"
(
    id         serial      NOT NULL,
    name       varchar(50) NOT NULL,
    password   varchar(50) NOT NULL,
    contact_id int         NOT NULL,
    CONSTRAINT user_pk PRIMARY KEY (id)
);

-- Table: user_role
CREATE TABLE user_role
(
    id      serial NOT NULL,
    user_id int    NOT NULL,
    role_id int    NOT NULL,
    CONSTRAINT user_role_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: authorized_user_shop (table: authorized_user)
ALTER TABLE authorized_user
    ADD CONSTRAINT authorized_user_shop
        FOREIGN KEY (shop_id)
            REFERENCES shop (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: authorized_user_user (table: authorized_user)
ALTER TABLE authorized_user
    ADD CONSTRAINT authorized_user_user
        FOREIGN KEY (user_id)
            REFERENCES "user" (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: book_food_shop_food (table: book_food)
ALTER TABLE book_food
    ADD CONSTRAINT book_food_shop_food
        FOREIGN KEY (shop_food_id)
            REFERENCES shop_food (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: book_food_status (table: book_food)
ALTER TABLE book_food
    ADD CONSTRAINT book_food_status
        FOREIGN KEY (status_id)
            REFERENCES status (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: book_food_user (table: book_food)
ALTER TABLE book_food
    ADD CONSTRAINT book_food_user
        FOREIGN KEY (user_id)
            REFERENCES "user" (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: food_type (table: food)
ALTER TABLE food
    ADD CONSTRAINT food_type
        FOREIGN KEY (type_id)
            REFERENCES type (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: profile_city (table: profile)
ALTER TABLE profile
    ADD CONSTRAINT profile_city
        FOREIGN KEY (city_id)
            REFERENCES city (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: shop_food_log_food (table: shop_food_log)
ALTER TABLE shop_food_log
    ADD CONSTRAINT shop_food_log_food
        FOREIGN KEY (food_id)
            REFERENCES food (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: shop_food_log_shop (table: shop_food_log)
ALTER TABLE shop_food_log
    ADD CONSTRAINT shop_food_log_shop
        FOREIGN KEY (shop_id)
            REFERENCES shop (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: shop_food_log_unit (table: shop_food_log)
ALTER TABLE shop_food_log
    ADD CONSTRAINT shop_food_log_unit
        FOREIGN KEY (unit_id)
            REFERENCES unit (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: shop_goods_food (table: shop_food)
ALTER TABLE shop_food
    ADD CONSTRAINT shop_goods_food
        FOREIGN KEY (food_id)
            REFERENCES food (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: shop_goods_shop (table: shop_food)
ALTER TABLE shop_food
    ADD CONSTRAINT shop_goods_shop
        FOREIGN KEY (shop_id)
            REFERENCES shop (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: shop_goods_unit (table: shop_food)
ALTER TABLE shop_food
    ADD CONSTRAINT shop_goods_unit
        FOREIGN KEY (unit_id)
            REFERENCES unit (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: shop_profile (table: shop)
ALTER TABLE shop
    ADD CONSTRAINT shop_profile
        FOREIGN KEY (profile_id)
            REFERENCES profile (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: user_contact (table: user)
ALTER TABLE "user"
    ADD CONSTRAINT user_contact
        FOREIGN KEY (contact_id)
            REFERENCES contact (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: user_role_role (table: user_role)
ALTER TABLE user_role
    ADD CONSTRAINT user_role_role
        FOREIGN KEY (role_id)
            REFERENCES role (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: user_role_user (table: user_role)
ALTER TABLE user_role
    ADD CONSTRAINT user_role_user
        FOREIGN KEY (user_id)
            REFERENCES "user" (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- End of file.

