CREATE TABLE USER_GROUP (
    USER_ID UUID NOT NULL,
    GROUP_ID UUID NOT NULL,

    CONSTRAINT FK_USER_ID
        FOREIGN KEY (USER_ID)
            REFERENCES USERS (ID),
    CONSTRAINT FK_GROUP_ID
        FOREIGN KEY (GROUP_ID)
            REFERENCES GROUPS (ID)
);

COMMENT ON TABLE USER_GROUP IS 'таблица, которая связывает USERS и GROUPS';