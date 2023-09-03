INSERT INTO ARTICLE (article_id, title, content, parent_id)
VALUES (1, 'title', 'content', NULL);

INSERT INTO ARTICLE (article_id, title, content, parent_id)
VALUES (2, 'child', 'content', 1);

INSERT INTO ARTICLE (article_id, title, content, parent_id)
VALUES (3, 'child child', 'content', 2);
