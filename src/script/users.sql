CREATE TABLE users (
  id int(11) NOT NULL auto_increment,
  username varchar(100) default NULL,
  password varchar(100) default NULL,
  version int(11) default NULL,
  PRIMARY KEY  (id)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8