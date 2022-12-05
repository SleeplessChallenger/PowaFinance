--
-- PostgreSQL database dump
--

-- Dumped from database version 14.6 (Homebrew)
-- Dumped by pg_dump version 14.6 (Homebrew)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: databasechangelog; Type: TABLE; Schema: public; Owner: daniilslobodenuk
--

CREATE TABLE public.databasechangelog (
    id character varying(255) NOT NULL,
    author character varying(255) NOT NULL,
    filename character varying(255) NOT NULL,
    dateexecuted timestamp without time zone NOT NULL,
    orderexecuted integer NOT NULL,
    exectype character varying(10) NOT NULL,
    md5sum character varying(35),
    description character varying(255),
    comments character varying(255),
    tag character varying(255),
    liquibase character varying(20),
    contexts character varying(255),
    labels character varying(255),
    deployment_id character varying(10)
);


ALTER TABLE public.databasechangelog OWNER TO daniilslobodenuk;

--
-- Name: databasechangeloglock; Type: TABLE; Schema: public; Owner: daniilslobodenuk
--

CREATE TABLE public.databasechangeloglock (
    id integer NOT NULL,
    locked boolean NOT NULL,
    lockgranted timestamp without time zone,
    lockedby character varying(255)
);


ALTER TABLE public.databasechangeloglock OWNER TO daniilslobodenuk;

--
-- Name: expenses; Type: TABLE; Schema: public; Owner: daniilslobodenuk
--

CREATE TABLE public.expenses (
    id uuid NOT NULL,
    amount numeric NOT NULL,
    time_created date DEFAULT CURRENT_DATE NOT NULL,
    reason text DEFAULT 'JUST EXPENSE'::text,
    user_id uuid NOT NULL
);


ALTER TABLE public.expenses OWNER TO daniilslobodenuk;

--
-- Name: TABLE expenses; Type: COMMENT; Schema: public; Owner: daniilslobodenuk
--

COMMENT ON TABLE public.expenses IS 'таблица для расходов пользователей';


--
-- Name: groups; Type: TABLE; Schema: public; Owner: daniilslobodenuk
--

CREATE TABLE public.groups (
    id uuid NOT NULL,
    group_name character varying(55)
);


ALTER TABLE public.groups OWNER TO daniilslobodenuk;

--
-- Name: TABLE groups; Type: COMMENT; Schema: public; Owner: daniilslobodenuk
--

COMMENT ON TABLE public.groups IS 'таблица для всех групп, в которых может поучаствовать пользователь';


--
-- Name: investments; Type: TABLE; Schema: public; Owner: daniilslobodenuk
--

CREATE TABLE public.investments (
    id uuid NOT NULL,
    type_of_investments text NOT NULL,
    time_of_investment date DEFAULT CURRENT_DATE NOT NULL,
    amount numeric NOT NULL,
    user_id uuid NOT NULL
);


ALTER TABLE public.investments OWNER TO daniilslobodenuk;

--
-- Name: TABLE investments; Type: COMMENT; Schema: public; Owner: daniilslobodenuk
--

COMMENT ON TABLE public.investments IS 'таблица для инвестиций пользователя';


--
-- Name: user_group; Type: TABLE; Schema: public; Owner: daniilslobodenuk
--

CREATE TABLE public.user_group (
    user_id uuid NOT NULL,
    group_id uuid NOT NULL
);


ALTER TABLE public.user_group OWNER TO daniilslobodenuk;

--
-- Name: TABLE user_group; Type: COMMENT; Schema: public; Owner: daniilslobodenuk
--

COMMENT ON TABLE public.user_group IS 'таблица, которая связывает USERS и GROUPS';


--
-- Name: users; Type: TABLE; Schema: public; Owner: daniilslobodenuk
--

CREATE TABLE public.users (
    id uuid NOT NULL,
    first_name character varying(45),
    last_name character varying(45),
    username character varying(55) NOT NULL,
    email character varying(55) NOT NULL,
    passhash character varying(256) NOT NULL
);


ALTER TABLE public.users OWNER TO daniilslobodenuk;

--
-- Name: TABLE users; Type: COMMENT; Schema: public; Owner: daniilslobodenuk
--

COMMENT ON TABLE public.users IS 'таблица для всех пользователей приложения';


--
-- Name: COLUMN users.passhash; Type: COMMENT; Schema: public; Owner: daniilslobodenuk
--

COMMENT ON COLUMN public.users.passhash IS 'колонка, где хранится hash пароля';


--
-- Data for Name: databasechangelog; Type: TABLE DATA; Schema: public; Owner: daniilslobodenuk
--

COPY public.databasechangelog (id, author, filename, dateexecuted, orderexecuted, exectype, md5sum, description, comments, tag, liquibase, contexts, labels, deployment_id) FROM stdin;
raw	includeAll	db/changelog/changeset/create-users-table.sql	2022-12-06 01:46:24.326341	1	EXECUTED	8:6572c748277aa48535b31940b00b129e	sql		\N	3.8.9	\N	\N	0280384306
raw	includeAll	db/changelog/changeset/create-groups-table.sql	2022-12-06 01:46:24.818849	2	EXECUTED	8:9464809aae43ceb927dcb1f26bfeb2f3	sql		\N	3.8.9	\N	\N	0280384306
raw	includeAll	db/changelog/changeset/create-expenses-table.sql	2022-12-06 01:46:24.843784	3	EXECUTED	8:167e191ab2a058267d461573b558f603	sql		\N	3.8.9	\N	\N	0280384306
raw	includeAll	db/changelog/changeset/create-investments-table.sql	2022-12-06 01:46:24.850286	4	EXECUTED	8:e861229293cdc7db3a0aa829a47661e9	sql		\N	3.8.9	\N	\N	0280384306
raw	includeAll	db/changelog/changeset/create-relation-users-groups.sql	2022-12-06 01:46:24.856445	5	EXECUTED	8:a35199e13284469686662f20160720e6	sql		\N	3.8.9	\N	\N	0280384306
\.


--
-- Data for Name: databasechangeloglock; Type: TABLE DATA; Schema: public; Owner: daniilslobodenuk
--

COPY public.databasechangeloglock (id, locked, lockgranted, lockedby) FROM stdin;
1	f	\N	\N
\.


--
-- Data for Name: expenses; Type: TABLE DATA; Schema: public; Owner: daniilslobodenuk
--

COPY public.expenses (id, amount, time_created, reason, user_id) FROM stdin;
\.


--
-- Data for Name: groups; Type: TABLE DATA; Schema: public; Owner: daniilslobodenuk
--

COPY public.groups (id, group_name) FROM stdin;
\.


--
-- Data for Name: investments; Type: TABLE DATA; Schema: public; Owner: daniilslobodenuk
--

COPY public.investments (id, type_of_investments, time_of_investment, amount, user_id) FROM stdin;
\.


--
-- Data for Name: user_group; Type: TABLE DATA; Schema: public; Owner: daniilslobodenuk
--

COPY public.user_group (user_id, group_id) FROM stdin;
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: daniilslobodenuk
--

COPY public.users (id, first_name, last_name, username, email, passhash) FROM stdin;
\.


--
-- Name: databasechangeloglock databasechangeloglock_pkey; Type: CONSTRAINT; Schema: public; Owner: daniilslobodenuk
--

ALTER TABLE ONLY public.databasechangeloglock
    ADD CONSTRAINT databasechangeloglock_pkey PRIMARY KEY (id);


--
-- Name: expenses expenses_pkey; Type: CONSTRAINT; Schema: public; Owner: daniilslobodenuk
--

ALTER TABLE ONLY public.expenses
    ADD CONSTRAINT expenses_pkey PRIMARY KEY (id);


--
-- Name: groups groups_pkey; Type: CONSTRAINT; Schema: public; Owner: daniilslobodenuk
--

ALTER TABLE ONLY public.groups
    ADD CONSTRAINT groups_pkey PRIMARY KEY (id);


--
-- Name: users users_email_key; Type: CONSTRAINT; Schema: public; Owner: daniilslobodenuk
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_email_key UNIQUE (email);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: daniilslobodenuk
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- Name: users users_username_key; Type: CONSTRAINT; Schema: public; Owner: daniilslobodenuk
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_username_key UNIQUE (username);


--
-- Name: idx_username; Type: INDEX; Schema: public; Owner: daniilslobodenuk
--

CREATE INDEX idx_username ON public.users USING btree (username);


--
-- Name: user_group fk_group_id; Type: FK CONSTRAINT; Schema: public; Owner: daniilslobodenuk
--

ALTER TABLE ONLY public.user_group
    ADD CONSTRAINT fk_group_id FOREIGN KEY (group_id) REFERENCES public.groups(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: expenses fk_user; Type: FK CONSTRAINT; Schema: public; Owner: daniilslobodenuk
--

ALTER TABLE ONLY public.expenses
    ADD CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- Name: investments fk_user; Type: FK CONSTRAINT; Schema: public; Owner: daniilslobodenuk
--

ALTER TABLE ONLY public.investments
    ADD CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- Name: user_group fk_user_id; Type: FK CONSTRAINT; Schema: public; Owner: daniilslobodenuk
--

ALTER TABLE ONLY public.user_group
    ADD CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES public.users(id) ON UPDATE CASCADE;


--
-- PostgreSQL database dump complete
--

