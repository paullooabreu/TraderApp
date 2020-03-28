CREATE TABLE user (
	cod BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
	password VARCHAR(150) NOT NULL,
	user_type BIGINT(2)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE permission (
	cod BIGINT(20) PRIMARY KEY,
	description VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE user_permission (
	cod_user BIGINT(20) NOT NULL,
	cod_permission BIGINT(20) NOT NULL,
	PRIMARY KEY (cod_user, cod_permission),
	FOREIGN KEY (cod_user) REFERENCES user(cod),
	FOREIGN KEY (cod_permission) REFERENCES permission(cod)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;