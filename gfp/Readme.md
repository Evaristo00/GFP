# GFP - Gestión de Finanzas Personales

## Descripción

Debido a la inflación y la situación general del país, proponemos una aplicación que organice el día a día, mes a mes y el estado financiero anual del cliente.

## Endpoints

### Authentication

- **POST /auth/register**: Crea un nuevo usuario.
  - Request Body: `SingUpRequestDTO`
  - Response: `JwtAuthenticationResponse`

- **POST /auth/login**: Inicia sesión con un usuario existente.
  - Request Body: `SingInRequestDTO`
  - Response: `JwtAuthenticationResponse`

### Categorias

- **GET /api/categorias/{id}**: Obtiene una categoría por ID.
  - Response: `Categoria`

- **GET /api/categorias**: Obtiene todas las categorías.
  - Response: `List<Categoria>`

- **POST /api/categorias**: Crea una nueva categoría.
  - Request Body: `CategoriaRequestDto`
  - Response: `CategoriaResponseDto`

- **DELETE /api/categorias/{id}**: Elimina una categoría por ID.

### Gastos

- **GET /api/gastos**: Obtiene todos los gastos del usuario autenticado.
  - Response: `List<Gasto>`

- **GET /api/gastos/categoria/{categoriaId}**: Obtiene los gastos por categoría para el usuario autenticado.
  - Response: `List<Gasto>`

- **POST /api/gastos**: Crea un nuevo gasto.
  - Request Body: `GastosRequestDto`
  - Response: `GastosResponseDto`

- **DELETE /api/gastos/{id}**: Elimina un gasto por ID para el usuario autenticado.

### Presupuestos

- **GET /api/presupuestos/{id}**: Obtiene un presupuesto por ID para el usuario autenticado.
  - Response: `Presupuesto`

- **GET /api/presupuestos/usuario/{usuarioId}**: Obtiene todos los presupuestos por ID de usuario.
  - Response: `List<Presupuesto>`

- **POST /api/presupuestos**: Crea un nuevo presupuesto.
  - Request Body: `PresupuestoRequestDto`
  - Response: `PresupuestoResponseDto`

- **DELETE /api/presupuestos/{id}**: Elimina un presupuesto por ID para el usuario autenticado.

### Usuarios

- **GET /api/usuarios/{id}**: Obtiene un usuario por ID.
  - Response: `Usuario`

- **DELETE /api/usuarios/{id}**: Elimina un usuario por ID.

## Autenticación JWT

Esta aplicación usa JSON Web Tokens (JWT) para la autenticación. Al registrarte o iniciar sesión, recibirás un token JWT que deberás incluir en las cabeceras de tus solicitudes para acceder a los endpoints protegidos.

### Ejemplo de cabecera de autorización

```http
Authorization: Bearer <token_jwt>
