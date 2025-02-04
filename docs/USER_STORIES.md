# Historias de Usuario

## Introducción
Este documento describe las historias de usuario para el sistema de gestión de estudiantes y materias.

## Roles de Usuario
- **ADMIN**: Administrador del sistema.
- **TEACHER**: Profesor que dicta materias.
- **Usuario General**: Usuario que se registra e inicia sesión.

## Historias de Usuario

### Rol: ADMIN
1. Como ADMIN, quiero crear una nueva carrera para ofrecer nuevas opciones académicas.
2. Como ADMIN, quiero actualizar la información de una carrera existente para mantener los datos actualizados.
3. Como ADMIN, quiero eliminar una carrera para dejar de ofrecerla.
4. Como ADMIN, quiero ver el listado de todos los usuarios para gestionar sus permisos y roles.
5. Como ADMIN, quiero actualizar el rol de un usuario para asignarle permisos específicos (ADMIN, TEACHER).
6. Como ADMIN, quiero desactivar un usuario para revocar su acceso al sistema.

### Rol: TEACHER
1. Como TEACHER, quiero registrar un nuevo estudiante para llevar un control de los alumnos en mis materias.
2. Como TEACHER, quiero actualizar la información de un estudiante existente para corregir errores o actualizar datos.
3. Como TEACHER, quiero eliminar un estudiante para dejar de gestionarlo.
4. Como TEACHER, quiero inscribir a un estudiante en una materia para que pueda cursarla.
5. Como TEACHER, quiero actualizar el estado de una inscripción (REGULAR, UNSUCCESSFUL, APPROVED) para reflejar el progreso del estudiante.
6. Como TEACHER, quiero eliminar una inscripción para cancelar la participación de un estudiante en una materia.
7. Como TEACHER, quiero registrar una clase para llevar un control de lo que se enseña en cada sesión.
8. Como TEACHER, quiero actualizar la información de una clase existente para corregir errores o actualizar datos.
9. Como TEACHER, quiero eliminar una clase para corregir registros incorrectos.
10. Como TEACHER, quiero registrar la asistencia de un estudiante a una clase para llevar un control de su participación.
11. Como TEACHER, quiero actualizar la asistencia de un estudiante para corregir errores.
12. Como TEACHER, quiero eliminar una asistencia para corregir registros incorrectos.
13. Como TEACHER, quiero registrar una calificación para un estudiante en una materia para evaluar su desempeño.
14. Como TEACHER, quiero actualizar una calificación existente para corregir errores o ajustar la evaluación.
15. Como TEACHER, quiero eliminar una calificación para corregir registros incorrectos.
16. Como TEACHER, quiero ver el listado de estudiantes de una materia para gestionar su participación.
17. Como TEACHER, quiero ver el listado de materias que dicto para organizar mi trabajo.
18. Como TEACHER, quiero ver el listado de asistencias de un estudiante para evaluar su participación.
19. Como TEACHER, quiero ver el listado de calificaciones de un estudiante para evaluar su desempeño.
20. Como TEACHER, quiero ver el listado de inscripciones de un estudiante con su estado en cada materia para conocer su progreso.
21. Como TEACHER, quiero ver el listado de todos los estudiantes de una materia con sus asistencias para evaluar la participación general.
22. Como TEACHER, quiero ver el listado de todos los estudiantes de una materia con sus calificaciones para evaluar el desempeño general.
23. Como TEACHER, quiero ver el listado de todas las clases de una materia para revisar lo que se ha enseñado.
24. Como TEACHER, quiero ver el listado de asistencias de una clase particular para conocer la participación en esa sesión.
25. Como TEACHER, quiero ver el listado de calificaciones asignadas en una clase particular para revisar las evaluaciones de esa sesión.
26. Como TEACHER, quiero registrarme en el sistema para poder acceder a las funcionalidades.
27. Como TEACHER, quiero iniciar sesión en el sistema para acceder a mis materias y estudiantes.
28. Como TEACHER, quiero actualizar mi información personal (nombre, correo, contraseña) para mantener mis datos actualizados.
29. Como TEACHER, quiero cerrar sesión para proteger mi cuenta.

### Rol: Usuario General
1. Como usuario, quiero registrarme en el sistema para poder acceder a las funcionalidades.
2. Como usuario, quiero iniciar sesión en el sistema para poder acceder a mis datos y funcionalidades.
3. Como usuario, quiero cerrar sesión para proteger mi cuenta.

## Casos de Uso
- Listar usuarios.
- Actualizar rol de usuario.
- Desactivar usuario.
- Registrar usuario.
- Iniciar sesión
- Actualizar información de usuario.
- Cerrar sesión.
- Crear carrera.
- Actualizar carrera.
- Eliminar carrera.
- Registrar estudiante.
- Actualizar estudiante.
- Eliminar estudiante.
- Inscribir estudiante en materia.
- Actualizar estado de inscripción.
- Eliminar inscripción.
- Registrar clase.
- Actualizar clase.
- Eliminar clase.
- Registrar asistencia.
- Actualizar asistencia.
- Eliminar asistencia.
- Registrar calificación.
- Actualizar calificación.
- Eliminar calificación.
- Ver listado de estudiantes de una materia.
- Ver listado de materias que dicto.
- Ver listado de asistencias de un estudiante.
- Ver listado de calificaciones de un estudiante.
- Ver listado de inscripciones de un estudiante.
- Ver listado de estudiantes con asistencias.
- Ver listado de estudiantes con calificaciones.
- Ver listado de clases de una materia.
- Ver listado de asistencias de una clase.
- Ver listado de calificaciones de una clase.

## Priorización
- Alta: Registrar usuario, Iniciar sesión, Cerrar sesión, Crear carrera, Registrar estudiante, Inscribir estudiante en materia, Registrar clase, Registrar asistencia, Registrar calificación.
- Media: Actualizar información de usuario, Listar usuarios, Actualizar rol de usuario, Actualizar carrera, Actualizar estudiante, Actualizar estado de inscripción, Actualizar clase, Actualizar asistencia, Actualizar calificación.
- Baja: Desactivar usuario, Eliminar carrera, Eliminar estudiante, Eliminar inscripción, Eliminar clase, Eliminar asistencia, Eliminar calificación.

## Notas Adicionales
- La autenticación se implementará usando JWT (JSON Web Tokens).
- La contraseña se almacenará de manera segura usando hashing (por ejemplo, BCrypt).
- El soft delete se implementará para todas las entidades.
- Las consultas de listados son críticas para la gestión diaria de los docentes.