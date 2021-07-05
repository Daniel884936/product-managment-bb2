
CREATE TABLE COUNTRY(
COUNTRY_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
	NAME VARCHAR(255) NOT NULL
);
INSERT INTO COUNTRY(NAME) VALUES
('Republica Dominicana'),
('Colombia'),
('España'),
('Venezuela'),
('Afganistán'),
('Albania'),
('Alemania'),
('Belice'),
('Bhután'),
('Brasil'),
('Chad'),
('Chequia'),
('China'),
('Cuba'),
('Dominica'),
('Eslovaquia');


CREATE TABLE SUPPLIER(
SUPPLIER_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
	NAME VARCHAR(255) NOT NULL,
	COUNTRY_ID BIGINT NOT NULL,
	FOREIGN KEY(COUNTRY_ID) REFERENCES COUNTRY(COUNTRY_ID)
	ON DELETE CASCADE
);
INSERT INTO SUPPLIER(NAME,COUNTRY_ID) VALUES('Franck', 1);


CREATE TABLE USER(
USER_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
	NAME VARCHAR(255) NOT NULL,
	SURNAMES VARCHAR(255) NOT NULL
);

INSERT INTO USER(NAME, SURNAMES) VALUES
('Daniel', 'Tejada Montero'),
('Jose', 'Turco Montero'),
('Daniel', 'Tejada Montero');


CREATE TABLE USER_LOGIN(
USER_LOGIN_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
	PASSWORD  VARCHAR(255) NOT NULL,
	ROL INT NOT NULL,
	USERNAME VARCHAR(255) NOT NULL,
	USER_ID BIGINT NOT NULL,
	FOREIGN KEY(USER_ID) REFERENCES USER(USER_ID)
	ON DELETE CASCADE
);

CREATE TABLE PRODUCT(
PRODUCT_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
	PRICE DOUBLE NOT NULL,
	CODE BIGINT NOT NULL UNIQUE,
	CREATION_DATE TIMESTAMP NOT NULL,
	DESCRIPTION  VARCHAR(255),
	NAME VARCHAR(255),
	STATE INT NOT NULL,
	USER_ID BIGINT NOT NULL ,
	FOREIGN KEY(USER_ID) REFERENCES USER(USER_ID)
	ON DELETE CASCADE
);
INSERT INTO PRODUCT(PRICE,CODE,CREATION_DATE,DESCRIPTION,NAME,STATE,USER_ID)  VALUES
(522,123,'2020-04-06','NA NA', 'AGUA', 1, 1),
(522,124,'2020-04-06','NA NA', 'FRESA', 1, 1),
(522,125,'2020-04-06','NA NA', 'REFRESCO', 1, 1);


CREATE TABLE PRODUCT_REDUCTION_PRICE (
PRODUCT_REDUCTION_PRICE_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
	REDUCED_PRICE DOUBLE NOT NULL,
	END_DATE  TIMESTAMP NOT NULL,
	START_DATE  TIMESTAMP NOT NULL,
	PRODUCT_ID BIGINT NOT NULL,
	 FOREIGN KEY(PRODUCT_ID) REFERENCES PRODUCT(PRODUCT_ID)
	ON DELETE CASCADE
);

CREATE TABLE SUPPLIER_PRODUCT (
	SUPPLIER_ID BIGINT NOT NULL,
	PRODUCT_ID BIGINT NOT NULL ,
	FOREIGN KEY(PRODUCT_ID) REFERENCES PRODUCT(PRODUCT_ID)
	ON DELETE CASCADE,
	FOREIGN KEY(SUPPLIER_ID) REFERENCES SUPPLIER(SUPPLIER_ID)
    ON DELETE CASCADE,
	PRIMARY KEY(SUPPLIER_ID,PRODUCT_ID)
);



