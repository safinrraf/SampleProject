CREATE TABLE adex_db.hourly_stats (
  id int(11) unsigned NOT NULL AUTO_INCREMENT,
  customer_id int(11) unsigned NOT NULL,
  time timestamp NOT NULL,
  request_count bigint(20) unsigned NOT NULL DEFAULT '0',
  invalid_count bigint(20) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (id),
  UNIQUE KEY unique_customer_time (customer_id,time),
  KEY customer_idx (customer_id)
);