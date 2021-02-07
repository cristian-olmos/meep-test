# Meep Talent Test

Proyecto de evaluación para Senior Developer

## EJECUCION
### PREREQUISITOS

### RUN
El proyecto dispone de una archivo Makefile para facilitar la ejecución de instrucciones. Será necesario tener instalados docker y docker-compose Para levantar toda la infraestructura:
- `make` - muestra la ayuda
- `make test` ejecución de test
- `make dist` - empaquetado del servicio
- `make run` - ejecuta docker-compose con las imagenes necesarias
- `make up` - ejecuta los pasos dist y run

## USO
El servicio no dispone de un api, actualmente solo publica eventos de dominio en un mongoDB. Se pueden consultar los eventos que van ocurriendo accediento a
- [mongo-express](http://localhost:8081/)
- `user` - root
- `password` - example

Y en la database test_db aparecerán dos nuevas colecciones:
- `domainEvent` - Listado de eventos que va generando el servicio
- `vehicles` - Listado de vehiculos actualmente en db

## AUTHOR
[Cristian Olmos](https://www.linkedin.com/in/cristian-olmos-arrabal-b8868b2b/) ([cristianolmosarrabal@gmail.com](mailto:cristianolmosarrabal@gmail.com))