DROP TABLE IF EXISTS vehicles;

CREATE TABLE vehicles (
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
  companyZoneId      VARCHAR(250)
);
