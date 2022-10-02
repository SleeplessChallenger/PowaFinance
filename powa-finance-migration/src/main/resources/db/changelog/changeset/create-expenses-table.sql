CREATE TABLE EXPENSES (
    ID UUID NOT NULL,
    AMOUNT NUMERIC NOT NULL,
    TIME_CREATED DATE NOT NULL DEFAULT CURRENT_DATE,
    REASON TEXT NOT NULL DEFAULT 'JUST EXPENSE',
    USER_ID UUID NOT NULL,
    PRIMARY KEY(ID),
    CONSTRAINT FK_USER
        FOREIGN KEY (USER_ID)
            REFERENCES USERS (ID)
);

COMMENT ON TABLE EXPENSES IS 'таблица для расходов пользователей';