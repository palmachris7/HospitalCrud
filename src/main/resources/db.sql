CREATE TABLE sys.condicion (
    idcondicion   NUMBER(10) NOT NULL,
    descondicion  VARCHAR2(255 CHAR),
    fecharegistro TIMESTAMP
)
PCTFREE 10 PCTUSED 40 TABLESPACE system LOGGING
    STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT
    )
NO INMEMORY;

ALTER TABLE sys.condicion
    ADD CONSTRAINT condicion_pk PRIMARY KEY ( idcondicion )
        USING INDEX PCTFREE 10 INITRANS 2 TABLESPACE system
LOGGING
    STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT
    );

CREATE TABLE sys.distrito (
    iddistrito    NUMBER(10) NOT NULL,
    descdistrito  VARCHAR2(255 CHAR),
    fecharegistro TIMESTAMP,
    id_provincia  NUMBER(10)
)
PCTFREE 10 PCTUSED 40 TABLESPACE system LOGGING
    STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT
    )
NO INMEMORY;

ALTER TABLE sys.distrito
    ADD CONSTRAINT distrito_pk PRIMARY KEY ( iddistrito )
        USING INDEX PCTFREE 10 INITRANS 2 TABLESPACE system
LOGGING
    STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT
    );

CREATE TABLE sys.gerente (
    idgerente     NUMBER(10) NOT NULL,
    descgerente   VARCHAR2(255 CHAR),
    fecharegistro TIMESTAMP
)
PCTFREE 10 PCTUSED 40 TABLESPACE system LOGGING
    STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT
    )
NO INMEMORY;

ALTER TABLE sys.gerente
    ADD CONSTRAINT gerente_pk PRIMARY KEY ( idgerente )
        USING INDEX PCTFREE 10 INITRANS 2 TABLESPACE system
LOGGING
    STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT
    );

CREATE TABLE sys.hospital (
    idhospital    NUMBER(10) NOT NULL,
    antiguedad    NUMBER(10),
    area          FLOAT(126),
    fecharegistro TIMESTAMP,
    nombre        VARCHAR2(255 CHAR),
    idecondicion  NUMBER(10),
    iddistrito    NUMBER(10),
    idgerente     NUMBER(10),
    idsede        NUMBER(10)
)
PCTFREE 10 PCTUSED 40 TABLESPACE system LOGGING
    STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT
    )
NO INMEMORY;

ALTER TABLE sys.hospital
    ADD CONSTRAINT hospital_pk PRIMARY KEY ( idhospital )
        USING INDEX PCTFREE 10 INITRANS 2 TABLESPACE system
LOGGING
    STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT
    );

CREATE TABLE sys.perfil (
    idperfil NUMBER(10) NOT NULL,
    perfil   VARCHAR2(255 CHAR)
)
PCTFREE 10 PCTUSED 40 TABLESPACE system LOGGING
    STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT
    )
NO INMEMORY;

ALTER TABLE sys.perfil
    ADD CONSTRAINT perfil_pk PRIMARY KEY ( idperfil )
        USING INDEX PCTFREE 10 INITRANS 2 TABLESPACE system
LOGGING
    STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT
    );

CREATE TABLE sys.provincia (
    idprovincia   NUMBER(10) NOT NULL,
    descprovincia VARCHAR2(255 CHAR),
    fecharegistro TIMESTAMP
)
PCTFREE 10 PCTUSED 40 TABLESPACE system LOGGING
    STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT
    )
NO INMEMORY;

ALTER TABLE sys.provincia
    ADD CONSTRAINT provincia_pk PRIMARY KEY ( idprovincia )
        USING INDEX PCTFREE 10 INITRANS 2 TABLESPACE system
LOGGING
    STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT
    );

CREATE TABLE sys.sede (
    idsede        NUMBER(10) NOT NULL,
    descsede      VARCHAR2(255 CHAR),
    fecharegistro TIMESTAMP
)
PCTFREE 10 PCTUSED 40 TABLESPACE system LOGGING
    STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT
    )
NO INMEMORY;

ALTER TABLE sys.sede
    ADD CONSTRAINT sede_pk PRIMARY KEY ( idsede )
        USING INDEX PCTFREE 10 INITRANS 2 TABLESPACE system
LOGGING
    STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT
    );

CREATE TABLE sys.usuario (
    idusuario NUMBER(10) NOT NULL,
    estatus   NUMBER(10),
    password  VARCHAR2(255 CHAR),
    username  VARCHAR2(255 CHAR)
)
PCTFREE 10 PCTUSED 40 TABLESPACE system LOGGING
    STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT
    )
NO INMEMORY;

ALTER TABLE sys.usuario
    ADD CONSTRAINT usuario_pk PRIMARY KEY ( idusuario )
        USING INDEX PCTFREE 10 INITRANS 2 TABLESPACE system
LOGGING
    STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT
    );

CREATE TABLE sys.usuario_perfil (
    idusuario NUMBER(10) NOT NULL,
    idperfil  NUMBER(10) NOT NULL
)
PCTFREE 10 PCTUSED 40 TABLESPACE system LOGGING
    STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT
    )
NO INMEMORY;

ALTER TABLE sys.hospital
    ADD CONSTRAINT fk29lhpy6lmqlqypriwprgqoph FOREIGN KEY ( idgerente )
        REFERENCES sys.gerente ( idgerente )
    NOT DEFERRABLE;

ALTER TABLE sys.usuario_perfil
    ADD CONSTRAINT fk4kvnrqpuur4gacpbv0ym67wey FOREIGN KEY ( idperfil )
        REFERENCES sys.perfil ( idperfil )
    NOT DEFERRABLE;

ALTER TABLE sys.hospital
    ADD CONSTRAINT fk5dbj6q1bgqfk0kka3fnjplg2n FOREIGN KEY ( idecondicion )
        REFERENCES sys.condicion ( idcondicion )
    NOT DEFERRABLE;

ALTER TABLE sys.distrito
    ADD CONSTRAINT fk65ekcv7clqndjh7kejbc7pf1u FOREIGN KEY ( id_provincia )
        REFERENCES sys.provincia ( idprovincia )
    NOT DEFERRABLE;

ALTER TABLE sys.usuario_perfil
    ADD CONSTRAINT fkfhd0amil8cpdgy5e3s3cn22pb FOREIGN KEY ( idusuario )
        REFERENCES sys.usuario ( idusuario )
    NOT DEFERRABLE;

ALTER TABLE sys.hospital
    ADD CONSTRAINT fkh1vicihfsabt7fgqv3t3yfjqq FOREIGN KEY ( idsede )
        REFERENCES sys.sede ( idsede )
    NOT DEFERRABLE;

ALTER TABLE sys.hospital
    ADD CONSTRAINT fkqp6up85p1q8x9mo2ckh52hgh8 FOREIGN KEY ( iddistrito )
        REFERENCES sys.distrito ( iddistrito )
    NOT DEFERRABLE;