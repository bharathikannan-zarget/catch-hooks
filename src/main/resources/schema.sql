create database if not exists catch_hooks;

CREATE TABLE if not exists `requests` (
                            `id` bigint NOT NULL AUTO_INCREMENT,
                            `url` varchar(255) NOT NULL,
                            `request_method` enum('GET','PUT','POST','PATCH','DELETE','OPTIONS','HEAD') DEFAULT NULL,
                            `headers` json DEFAULT NULL,
                            `query_string` text,
                            `form_values` json DEFAULT NULL,
                            `raw_content` text,
                            `created_at` datetime DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

create index url_idx on requests (url);