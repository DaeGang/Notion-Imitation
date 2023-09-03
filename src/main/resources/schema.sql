DROP TABLE IF EXISTS ARTICLE;

CREATE TABLE ARTICLE (
     article_id BIGINT NOT NULL,
     title VARCHAR(255) NOT NULL,
     content TEXT NOT NULL,
     parent_id BIGINT,
     PRIMARY KEY (article_id),
     FOREIGN KEY (parent_id) REFERENCES ARTICLE (article_id)
);
