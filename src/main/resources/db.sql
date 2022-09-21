create table CITA
(
    IDCITA        NUMBER(10) not null
        primary key,
    DESCITA       VARCHAR2(255 char),
    ESPECIALIDAD  VARCHAR2(255 char),
    ESTADO        NUMBER(10),
    FECHAREGISTRO TIMESTAMP(6),
    ID_HOSPITAL   NUMBER(10)
        constraint FK64C5QTDNQPV2V583HTKD38CQ4
            references HOSPITAL,
    IDEUSUARIO    NUMBER(10)
        constraint FKQHTRCMKDQ2X9HSF789AC5YM18
            references USUARIO
)

INSERT INTO SYS.CITA (IDCITA, DESCITA, ESPECIALIDAD, ESTADO, FECHAREGISTRO, ID_HOSPITAL, IDEUSUARIO) VALUES (1, 'Pediatria - Tarde Vitarte', 'Pediatria', 3, TO_TIMESTAMP('2022-09-18 00:00:00.000000', 'YYYY-MM-DD HH24:MI:SS.FF6'), 1, 21);
INSERT INTO SYS.CITA (IDCITA, DESCITA, ESPECIALIDAD, ESTADO, FECHAREGISTRO, ID_HOSPITAL, IDEUSUARIO) VALUES (71, 'Cita Odontologica', 'Odontologia', 1, TO_TIMESTAMP('2022-09-16 00:00:00.000000', 'YYYY-MM-DD HH24:MI:SS.FF6'), 1, 41);
INSERT INTO SYS.CITA (IDCITA, DESCITA, ESPECIALIDAD, ESTADO, FECHAREGISTRO, ID_HOSPITAL, IDEUSUARIO) VALUES (72, 'Cita Oftalmologica', 'Oftalmologia', 1, TO_TIMESTAMP('2022-09-15 00:00:00.000000', 'YYYY-MM-DD HH24:MI:SS.FF6'), 2, 41);
INSERT INTO SYS.CITA (IDCITA, DESCITA, ESPECIALIDAD, ESTADO, FECHAREGISTRO, ID_HOSPITAL, IDEUSUARIO) VALUES (73, 'Cita Cirugia Tarde', 'Cirugia', 2, TO_TIMESTAMP('2022-09-17 00:00:00.000000', 'YYYY-MM-DD HH24:MI:SS.FF6'), 3, 41);


create table CONDICION
(
    IDCONDICION   NUMBER(10) not null
        primary key,
    DESCONDICION  VARCHAR2(255 char),
    FECHAREGISTRO TIMESTAMP(6)
)


INSERT INTO SYS.CONDICION (IDCONDICION, DESCONDICION, FECHAREGISTRO) VALUES (1, 'En funcionamiento', TO_TIMESTAMP('2022-09-18 00:11:34.000000', 'YYYY-MM-DD HH24:MI:SS.FF6'));
INSERT INTO SYS.CONDICION (IDCONDICION, DESCONDICION, FECHAREGISTRO) VALUES (2, 'Cerrado', TO_TIMESTAMP('2022-09-18 00:14:35.000000', 'YYYY-MM-DD HH24:MI:SS.FF6'));
INSERT INTO SYS.CONDICION (IDCONDICION, DESCONDICION, FECHAREGISTRO) VALUES (3, 'En limpieza', TO_TIMESTAMP('2022-09-18 00:15:03.000000', 'YYYY-MM-DD HH24:MI:SS.FF6'));


create table DISTRITO
(
    IDDISTRITO    NUMBER(10) not null
        primary key,
    DESCDISTRITO  VARCHAR2(255 char),
    FECHAREGISTRO TIMESTAMP(6),
    ID_PROVINCIA  NUMBER(10)
        constraint FK65EKCV7CLQNDJH7KEJBC7PF1U
            references PROVINCIA
)


INSERT INTO SYS.DISTRITO (IDDISTRITO, DESCDISTRITO, FECHAREGISTRO, ID_PROVINCIA) VALUES (1, 'Ate Vitarte', TO_TIMESTAMP('2022-09-18 00:10:22.000000', 'YYYY-MM-DD HH24:MI:SS.FF6'), 1);
INSERT INTO SYS.DISTRITO (IDDISTRITO, DESCDISTRITO, FECHAREGISTRO, ID_PROVINCIA) VALUES (2, 'Lince', TO_TIMESTAMP('2022-09-18 00:15:12.000000', 'YYYY-MM-DD HH24:MI:SS.FF6'), 1);
INSERT INTO SYS.DISTRITO (IDDISTRITO, DESCDISTRITO, FECHAREGISTRO, ID_PROVINCIA) VALUES (3, 'Barranco', TO_TIMESTAMP('2022-09-18 00:15:37.000000', 'YYYY-MM-DD HH24:MI:SS.FF6'), 1);
INSERT INTO SYS.DISTRITO (IDDISTRITO, DESCDISTRITO, FECHAREGISTRO, ID_PROVINCIA) VALUES (4, 'Breña', TO_TIMESTAMP('2022-09-21 01:51:14.000000', 'YYYY-MM-DD HH24:MI:SS.FF6'), 1);
INSERT INTO SYS.DISTRITO (IDDISTRITO, DESCDISTRITO, FECHAREGISTRO, ID_PROVINCIA) VALUES (5, 'Ica', TO_TIMESTAMP('2022-09-21 01:53:07.000000', 'YYYY-MM-DD HH24:MI:SS.FF6'), 3);


create table GERENTE
(
    IDGERENTE     NUMBER(10) not null
        primary key,
    DESCGERENTE   VARCHAR2(255 char),
    FECHAREGISTRO TIMESTAMP(6)
)

INSERT INTO SYS.GERENTE (IDGERENTE, DESCGERENTE, FECHAREGISTRO) VALUES (1, 'Juan Gomez', TO_TIMESTAMP('2022-09-18 00:10:03.000000', 'YYYY-MM-DD HH24:MI:SS.FF6'));
INSERT INTO SYS.GERENTE (IDGERENTE, DESCGERENTE, FECHAREGISTRO) VALUES (2, 'Pedro Perez', TO_TIMESTAMP('2022-09-18 00:16:21.000000', 'YYYY-MM-DD HH24:MI:SS.FF6'));
INSERT INTO SYS.GERENTE (IDGERENTE, DESCGERENTE, FECHAREGISTRO) VALUES (3, 'Luis Gonzalez', TO_TIMESTAMP('2022-09-18 00:16:34.000000', 'YYYY-MM-DD HH24:MI:SS.FF6'));
INSERT INTO SYS.GERENTE (IDGERENTE, DESCGERENTE, FECHAREGISTRO) VALUES (4, 'Christian Palma', TO_TIMESTAMP('2022-09-21 01:53:49.000000', 'YYYY-MM-DD HH24:MI:SS.FF6'));




create table HOSPITAL
(
    IDHOSPITAL    NUMBER(10) not null
        primary key,
    ANTIGUEDAD    NUMBER(10),
    AREA          FLOAT,
    FECHAREGISTRO TIMESTAMP(6),
    NOMBRE        VARCHAR2(255 char),
    IDECONDICION  NUMBER(10)
        constraint FK5DBJ6Q1BGQFK0KKA3FNJPLG2N
            references CONDICION,
    IDDISTRITO    NUMBER(10)
        constraint FKQP6UP85P1Q8X9MO2CKH52HGH8
            references DISTRITO,
    IDGERENTE     NUMBER(10)
        constraint FK29LHPY6LMQLQYPRIWPRGQOPH
            references GERENTE,
    IDSEDE        NUMBER(10)
        constraint FKH1VICIHFSABT7FGQV3T3YFJQQ
            references SEDE,
    IMAGEN        VARCHAR2(255 char),
    DETALLES      VARCHAR2(255 char)
)

INSERT INTO SYS.HOSPITAL (IDHOSPITAL, ANTIGUEDAD, AREA, FECHAREGISTRO, NOMBRE, IDECONDICION, IDDISTRITO, IDGERENTE, IDSEDE, IMAGEN, DETALLES) VALUES (1, 10, 420, TO_TIMESTAMP('2022-09-18 00:00:00.000000', 'YYYY-MM-DD HH24:MI:SS.FF6'), 'Hospital  de Lima Este', 1, 1, 1, 1, 'hospital1.jpeg', 'Somos un Hospital de referencia nacional, que brinda atención altamente especializada a la salud en                        general y diversas especialidades; siempre con la mejor calidad y seguridad para la población en general');
INSERT INTO SYS.HOSPITAL (IDHOSPITAL, ANTIGUEDAD, AREA, FECHAREGISTRO, NOMBRE, IDECONDICION, IDDISTRITO, IDGERENTE, IDSEDE, IMAGEN, DETALLES) VALUES (2, 5, 200, TO_TIMESTAMP('2022-09-18 00:00:00.000000', 'YYYY-MM-DD HH24:MI:SS.FF6'), 'Centro de Salud Barranco', 2, 3, 3, 2, 'no-image.jpeg', 'Hospital situada en la ciudad de barranco, con diversas especialidades y abierto las 24 horas del dia.');
INSERT INTO SYS.HOSPITAL (IDHOSPITAL, ANTIGUEDAD, AREA, FECHAREGISTRO, NOMBRE, IDECONDICION, IDDISTRITO, IDGERENTE, IDSEDE, IMAGEN, DETALLES) VALUES (3, 2, 500, TO_TIMESTAMP('2022-09-18 00:19:45.000000', 'YYYY-MM-DD HH24:MI:SS.FF6'), 'Hospital Sede Lince', 3, 2, 2, 3, 'no-image.jpeg', 'Hospital de lima centro que presta sus funcionalidaddes durantes las 24 horas del día.');
INSERT INTO SYS.HOSPITAL (IDHOSPITAL, ANTIGUEDAD, AREA, FECHAREGISTRO, NOMBRE, IDECONDICION, IDDISTRITO, IDGERENTE, IDSEDE, IMAGEN, DETALLES) VALUES (62, 50, 4000, TO_TIMESTAMP('2022-03-08 00:00:00.000000', 'YYYY-MM-DD HH24:MI:SS.FF6'), 'Hospital Lima Centro', 2, 2, 3, 1, 'no-image.jpeg', 'Es un centro hospitalario público peruano, situado en Lima y administrado por el Ministerio de Salud del Perú, encargado de la atención especializada, prevención y disminución de riesgos relacionados con la salud.');
INSERT INTO SYS.HOSPITAL (IDHOSPITAL, ANTIGUEDAD, AREA, FECHAREGISTRO, NOMBRE, IDECONDICION, IDDISTRITO, IDGERENTE, IDSEDE, IMAGEN, DETALLES) VALUES (79, 23, 5400, TO_TIMESTAMP('2022-09-13 00:00:00.000000', 'YYYY-MM-DD HH24:MI:SS.FF6'), 'Hospital Breña', 3, 4, 2, 1, 'no-image.jpeg', 'Hospital en pleno funcionamiento');
INSERT INTO SYS.HOSPITAL (IDHOSPITAL, ANTIGUEDAD, AREA, FECHAREGISTRO, NOMBRE, IDECONDICION, IDDISTRITO, IDGERENTE, IDSEDE, IMAGEN, DETALLES) VALUES (67, 20, 100, TO_TIMESTAMP('2022-09-05 00:00:00.000000', 'YYYY-MM-DD HH24:MI:SS.FF6'), 'Hospital Ica', 2, 5, 4, 4, 'no-image.jpeg', 'Hospital de la ciudad de Ica');



create table PERFIL
(
    IDPERFIL NUMBER(10) not null
        primary key,
    PERFIL   VARCHAR2(255 char)
)

INSERT INTO SYS.PERFIL (IDPERFIL, PERFIL) VALUES (1, 'ADMINISTRADOR');
INSERT INTO SYS.PERFIL (IDPERFIL, PERFIL) VALUES (2, 'USUARIO');


create table PROVINCIA
(
    IDPROVINCIA   NUMBER(10) not null
        primary key,
    DESCPROVINCIA VARCHAR2(255 char),
    FECHAREGISTRO TIMESTAMP(6)
)

INSERT INTO SYS.PROVINCIA (IDPROVINCIA, DESCPROVINCIA, FECHAREGISTRO) VALUES (1, 'Lima', TO_TIMESTAMP('2022-09-18 00:09:07.000000', 'YYYY-MM-DD HH24:MI:SS.FF6'));
INSERT INTO SYS.PROVINCIA (IDPROVINCIA, DESCPROVINCIA, FECHAREGISTRO) VALUES (2, 'Callao', TO_TIMESTAMP('2022-09-18 00:17:29.000000', 'YYYY-MM-DD HH24:MI:SS.FF6'));
INSERT INTO SYS.PROVINCIA (IDPROVINCIA, DESCPROVINCIA, FECHAREGISTRO) VALUES (3, 'Ica', TO_TIMESTAMP('2022-09-21 01:52:28.000000', 'YYYY-MM-DD HH24:MI:SS.FF6'));


create table SEDE
(
    IDSEDE        NUMBER(10) not null
        primary key,
    DESCSEDE      VARCHAR2(255 char),
    FECHAREGISTRO TIMESTAMP(6)
)

INSERT INTO SYS.SEDE (IDSEDE, DESCSEDE, FECHAREGISTRO) VALUES (1, 'Lima-I', TO_TIMESTAMP('2022-09-18 00:05:33.000000', 'YYYY-MM-DD HH24:MI:SS.FF6'));
INSERT INTO SYS.SEDE (IDSEDE, DESCSEDE, FECHAREGISTRO) VALUES (2, 'Lima-II', TO_TIMESTAMP('2022-09-18 00:17:49.000000', 'YYYY-MM-DD HH24:MI:SS.FF6'));
INSERT INTO SYS.SEDE (IDSEDE, DESCSEDE, FECHAREGISTRO) VALUES (3, 'Sub-Sede I', TO_TIMESTAMP('2022-09-18 00:18:10.000000', 'YYYY-MM-DD HH24:MI:SS.FF6'));
INSERT INTO SYS.SEDE (IDSEDE, DESCSEDE, FECHAREGISTRO) VALUES (4, 'Ica-I', TO_TIMESTAMP('2022-09-21 01:57:46.000000', 'YYYY-MM-DD HH24:MI:SS.FF6'));


create table USUARIO
(
    IDUSUARIO NUMBER(10) not null
        primary key,
    ESTATUS   NUMBER(10),
    PASSWORD  VARCHAR2(255 char),
    USERNAME  VARCHAR2(255 char)
)

INSERT INTO SYS.USUARIO (IDUSUARIO, ESTATUS, PASSWORD, USERNAME, EMAIL, NOMBRE, FECHAREGISTRO) VALUES (21, 1, '$2a$10$2t0V50GlNCr3rqmTtVZo/O9Z61u0YNjpvavaB42AZSIPU4Zx58Q62', 'user', 'palmachristopher7@hotmail.com', 'Christopher Palma', TO_TIMESTAMP('2022-09-19 22:39:11.000000', 'YYYY-MM-DD HH24:MI:SS.FF6'));
INSERT INTO SYS.USUARIO (IDUSUARIO, ESTATUS, PASSWORD, USERNAME, EMAIL, NOMBRE, FECHAREGISTRO) VALUES (41, 1, '$2a$10$15Ba7W031vm/Iwq3J.As4ObsYusXkj6PLEKKwRg4S9BZK7I/JouJ2', 'admin', 'palmachristopher7@gmail.com', 'Arnie Talaverano', TO_TIMESTAMP('2022-09-18 22:39:13.000000', 'YYYY-MM-DD HH24:MI:SS.FF6'));
INSERT INTO SYS.USUARIO (IDUSUARIO, ESTATUS, PASSWORD, USERNAME, EMAIL, NOMBRE, FECHAREGISTRO) VALUES (78, 1, '$2a$10$Fo4.UQX2vr0FWr6zklSvCu31RHAie1KH2/CJ8vl9SYwflW1Hyt.TS', 'prueba', 'prueba@hotmail.com', 'prueba', TO_TIMESTAMP('2022-09-21 00:33:09.893000', 'YYYY-MM-DD HH24:MI:SS.FF6'));


create table USUARIO_PERFIL
(
    IDUSUARIO NUMBER(10) not null
        constraint FKFHD0AMIL8CPDGY5E3S3CN22PB
            references USUARIO,
    IDPERFIL  NUMBER(10) not null
        constraint FK4KVNRQPUUR4GACPBV0YM67WEY
            references PERFIL
)


INSERT INTO SYS.USUARIO_PERFIL (IDUSUARIO, IDPERFIL) VALUES (21, 2);
INSERT INTO SYS.USUARIO_PERFIL (IDUSUARIO, IDPERFIL) VALUES (41, 1);
INSERT INTO SYS.USUARIO_PERFIL (IDUSUARIO, IDPERFIL) VALUES (78, 2);




