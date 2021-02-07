DROP TABLE IF EXISTS vehicle;
DROP TABLE IF EXISTS city_company;
DROP TABLE IF EXISTS city_location;
DROP TABLE IF EXISTS city;
DROP TABLE IF EXISTS company;

CREATE TABLE city(
    id                 VARCHAR(250)   PRIMARY KEY,
    name                 VARCHAR(250)
);

CREATE TABLE company(
    id  NUMBER  primary key,
    name VARCHAR(250) not null
);

CREATE TABLE city_location(
    id UUID Primary KEY,
    city_id VARCHAR(250) not null,
    lowerLat double not null,
    leftLon double not null,
    upperLat double not null,
    rightLon double not null,
    foreign key (city_id) references city(id)
);

CREATE TABLE city_company(
    city_id VARCHAR(250),
    company_id NUMBER,
    foreign key (city_id) references city(id),
    foreign key (company_id) references company(id)
);

CREATE TABLE vehicle (
  id                 VARCHAR(250)   PRIMARY KEY,
  name               VARCHAR(250)              ,
  x                  VARCHAR(250)              ,
  y                  VARCHAR(250)              ,
  licencePlate       VARCHAR(250)              ,
  range              VARCHAR(250)              ,
  batteryLevel       VARCHAR(250)              ,
  helmets            VARCHAR(250)              ,
  model              VARCHAR(250)              ,
  resourceImageId    VARCHAR(250)              ,
  realTimeData       VARCHAR(250)              ,
  resourceType       VARCHAR(250)              ,
  companyZoneId      VARCHAR(250),
  location_id       UUID    NOT NULL,
  foreign key location_id references city_location(id),
  foreign key companyZoneId references company(id)
);
INSERT INTO CITY (id, name) VALUES ('lisboa', 'Lisboa');
INSERT INTO city_location VALUES ('lisboa',38.711046, -9.160096, 38.739429, -9.137115);
INSERT INTO company VALUES (545, 'company1');
INSERT INTO company VALUES (467, 'company2');
INSERT INTO company VALUES (473, 'company3');
INSERT INTO city_company VALUES ('lisboa',545);
INSERT INTO city_company VALUES ('lisboa',467);
INSERT INTO city_company VALUES ('lisboa',473);

