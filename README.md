# Dockerización de la Aplicación GFP

## Descripción

Este documento explica cómo se dockerizó la aplicación GFP y proporciona los pasos necesarios para ejecutar la aplicación utilizando Docker y Docker Compose.

## Dockerfile

La aplicación GFP utiliza un Dockerfile multistage para optimizar el tamaño de la imagen final. Aquí está el Dockerfile utilizado:

### Explicación del Dockerfile

#### Etapa 1: Construcción

- **Imagen base**: `maven:3.8.4-openjdk-17` se utiliza para la construcción del JAR. Esta imagen contiene Maven y JDK 17.
- **Directorio de trabajo**: `/app`.
- **Copia de `pom.xml` y dependencias**: Esto permite que las dependencias se descarguen en una capa separada.
- **Descarga de dependencias**: `RUN mvn dependency:go-offline` descarga todas las dependencias del proyecto.
- **Copia del código fuente**: `COPY src ./src`.
- **Construcción de la aplicación**: `RUN mvn clean package -DskipTests`.

#### Etapa 2: Imagen final

- **Imagen base**: `openjdk:17-jdk-slim` se utiliza para ejecutar el JAR. Esta imagen es más ligera.
- **Directorio de trabajo**: `/app`.
- **Copia del JAR**: `COPY --from=build /app/target/gfp-0.0.1-SNAPSHOT.jar /app/gfp-0.0.1-SNAPSHOT.jar`.
- **Exposición del puerto**: `EXPOSE 8080`.
- **Comando de ejecución**: `ENTRYPOINT ["java", "-jar", "gfp-0.0.1-SNAPSHOT.jar"]`.

## Docker Compose

Para facilitar la ejecución de la aplicación y la base de datos, se usa Docker Compose. Aquí está el archivo `docker-compose.yml` utilizado:

### Explicación del Docker Compose

#### Servicios

- **app**: Define el contenedor de la aplicación.
  - **image**: `evaristo00/gfp:0.0.1`.
  - **build**: Construye la imagen utilizando el Dockerfile en el contexto actual (`.`).
  - **ports**: Mapea el puerto `8080` del contenedor al puerto `8080` del host.
  - **depends_on**: Define la dependencia del servicio `db`.
  - **networks**: Conecta el servicio a la red `gfp-network`.

- **db**: Define el contenedor de la base de datos MySQL.
  - **image**: `mysql:8.0`.
  - **container_name**: Nombre del contenedor `mysql_container`.
  - **environment**: Variables de entorno para configurar MySQL.
  - **ports**: Mapea el puerto `3306` del contenedor al puerto `3306` del host.
  - **volumes**: Define un volumen para persistir los datos de MySQL.
  - **networks**: Conecta el servicio a la red `gfp-network`.

#### Volúmenes

- **db_data**: Volumen para persistir los datos de MySQL.

#### Redes

- **gfp-network**: Red compartida entre los servicios `app` y `db`.

## Pasos para ejecutar con Docker

### 1. Clonar el repositorio

Clona el repositorio de la aplicación GFP:

```sh
git clone https://github.com/tu-usuario/gfp.git
cd gfp
```

### 2. Iniciar los contenedores

Ejecuta el siguiente comando para iniciar los contenedores:
```sh
docker-compose up
```
