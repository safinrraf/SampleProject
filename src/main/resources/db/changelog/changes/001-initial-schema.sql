CREATE TABLE adex_db.customer (
  id int(11) unsigned NOT NULL AUTO_INCREMENT,
  name varchar(255) NOT NULL,
  active tinyint(1) unsigned NOT NULL DEFAULT '1',
  PRIMARY KEY (id)
);