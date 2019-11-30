
DROP TABLE IF EXISTS t_lob;
CREATE TABLE t_lob (
    id                  serial                  not null,
    clob                text                    not null, -- 相当于 Clob
	blob                bytea                   not null, -- 相当于 Blob
    CONSTRAINT pk_t_lob PRIMARY KEY (id)
);
