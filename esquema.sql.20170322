
    alter table UsuarioRol
        drop
        foreign key FK4CA33E1C7F566F0;

    alter table UsuarioRol
        drop
        foreign key FK4CA33E1BC6DE0AE;

    drop table if exists Estados;

    drop table if exists Hoteles;

    drop table if exists Lugares;

    drop table if exists Pais;

    drop table if exists Recomendaciones;

    drop table if exists Roles;

    drop table if exists UsuarioRol;

    drop table if exists Usuarios;

    drop table if exists ciudades;

    create table Estados (
        id bigint not null,
        Nombre varchar(255) not null unique,
        Descripcion varchar(255),
        primary key (id)
    ) Engine=InnoDB;

    create table Hoteles (
        id bigint not null,
        Nombre varchar(255) not null unique,
        Descripcion varchar(255),
        Precio varchar(255),
        Horario varchar(255),
        Estado varchar(255),
        Imagen varchar(255),
        Pais varchar(255),
        Direccion varchar(255),
        primary key (id)
    ) Engine=InnoDB;

    create table Lugares (
        id bigint not null,
        Nombre varchar(255) not null unique,
        Descripcion varchar(255),
        Poblacion bigint,
        Coordenadas varchar(255),
        Estado varchar(255),
        Imagen varchar(255),
        Pais varchar(255),
        Moneda varchar(255),
        primary key (id)
    ) Engine=InnoDB;

    create table Pais (
        id bigint not null,
        Nombre varchar(255) not null unique,
        Descripcion varchar(255),
        primary key (id)
    ) Engine=InnoDB;

    create table Recomendaciones (
        id bigint not null,
        Nombre varchar(255) not null,
        Estado varchar(255),
        Usuario varchar(255),
        Fecha varchar(255),
        Comentario varchar(255),
        Calificacion bigint,
        primary key (id)
    ) Engine=InnoDB;

    create table Roles (
        idRol bigint not null,
        nombre varchar(255) not null unique,
        descripcion varchar(255),
        primary key (idRol)
    ) Engine=InnoDB;

    create table UsuarioRol (
        idUsuario bigint not null,
        idRol bigint not null
    ) Engine=InnoDB;

    create table Usuarios (
        idUsuario bigint not null,
        nombrePrefijo varchar(255),
        nombreNombre varchar(255),
        nombreApellidoPaterno varchar(255),
        nombreApellidoMaterno varchar(255),
        nombrePosfijo varchar(255),
        nombreIniciales varchar(255),
        nombreUsuario varchar(255) not null unique,
        claveAcceso varchar(255) not null,
        primary key (idUsuario)
    ) Engine=InnoDB;

    create table ciudades (
        idciudad bigint not null,
        nombre varchar(255) not null unique,
        descripcion varchar(255),
        primary key (idciudad)
    ) Engine=InnoDB;

    alter table UsuarioRol
        add index FK4CA33E1C7F566F0 (idRol),
        add constraint FK4CA33E1C7F566F0
        foreign key (idRol)
        references Roles (idRol);

    alter table UsuarioRol
        add index FK4CA33E1BC6DE0AE (idUsuario),
        add constraint FK4CA33E1BC6DE0AE
        foreign key (idUsuario)
        references Usuarios (idUsuario);
