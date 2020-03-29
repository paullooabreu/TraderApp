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

CREATE TABLE day_trade (
	cod BIGINT(8) PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50),
	description VARCHAR(500),	
	date_day DATETIME NOT NULL,
	daily_profit DECIMAL(8,2),
	cod_user BIGINT(8),
	FOREIGN KEY (cod_user) REFERENCES user(cod)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE trade (
	cod BIGINT(8) PRIMARY KEY AUTO_INCREMENT,
	cod_day_trade BIGINT(8),
	date_trade DATETIME NOT NULL,
	type_trade VARCHAR(20) NOT NULL,
	contract_amount BIGINT(3),
	contract_price DECIMAL(4,2),
	price_trade BIGINT(7),
	price_final_trade BIGINT(7),
	result_type_trade VARCHAR(20),
	trade_profit DECIMAL(8,2),
	description VARCHAR(500),
	FOREIGN KEY (cod_day_trade) REFERENCES day_trade(cod)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;