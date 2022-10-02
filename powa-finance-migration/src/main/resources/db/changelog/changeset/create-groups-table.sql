CREATE TABLE GROUPS (
    ID UUID NOT NULL,
    GROUP_NAME VARCHAR(55),
    PRIMARY KEY(ID)
);

COMMENT ON TABLE GROUPS IS 'таблица для всех групп, в которых может поучаствовать пользователь';