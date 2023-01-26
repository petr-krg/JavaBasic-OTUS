-- Новый скрипт в Postgre - [localhost].
-- Дата: 2 дек. 2022 г.
-- Время: 18:42:39

CREATE TABLE public.answers (
    id SERIAL PRIMARY KEY,
    answer varchar(512) NOT NULL ,
	CONSTRAINT answers_un UNIQUE (id)    
);

ALTER TABLE public.answers OWNER TO uquiz;

CREATE TABLE public.questions (
    id SERIAL PRIMARY KEY,
    question varchar(512) UNIQUE,
    correct int,
	CONSTRAINT questions_un UNIQUE (id)
);

ALTER TABLE public.questions OWNER TO uquiz;

CREATE TABLE public.QuestionsToAnswer (
	id_question int, 
	id_answer int 
);

ALTER TABLE public.QuestionsToAnswer OWNER TO uquiz;

-- Пример запроса для выборки
WITH RECURSIVE que AS (
	SELECT q.id, 0 AS ParentID, q.question AS TextQuiz, q.correct AS Correct FROM public.questions q
	UNION ALL
	SELECT q2.id_answer, q2.id_question AS ParentID, a.answer AS TextQuiz, 0 AS Correct  FROM public.questionstoanswer q2
	INNER JOIN public.answers a ON a.id = q2.id_answer 
)
SELECT * FROM que
