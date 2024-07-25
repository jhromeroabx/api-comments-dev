
CREATE SCHEMA rl_api_comments;


CREATE TABLE rl_api_comments.rl_comments (
    id_comment SERIAL PRIMARY KEY,
    comment VARCHAR(255) NOT NULL,
    comment_by VARCHAR(255) NOT NULL,
    id_product INT NOT NULL
);