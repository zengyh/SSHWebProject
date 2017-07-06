CREATE TABLE t_log (  
   id  int NOT NULL PRIMARY KEY  AUTO_INCREMENT,  
   username varchar(100)  comment '用户名',  
   createdate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建日期',  
   operation varchar(1000) NOT NULL DEFAULT '' COMMENT '用户所做的操作'  
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '日志' ;




