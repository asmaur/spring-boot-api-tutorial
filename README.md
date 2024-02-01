# Web API with Spring Boot, H2, JPA and Hibernate
This is a sample CRUD API with spring, it is a part of course I have on my
YouTube channel <https://youtube.com/@wanubit>.
More about me or Wanubit company on <https://wanubit.com>

## Requirements

The list of tools required to build and run the project:

* Open JDK 17
* Apache Maven 3.8

## Steps to Setup

**1. Clone the application**

```bash
git@github.com:asmaur/spring-boot-api-tutorial.git
```

## Building

In order to build project use:

```bash
mvn clean package
```

Alternatively, you can run the app without packaging it using -

```bash
mvn spring-boot:run
```

The app will start running at <http://localhost:8080>

## Configuration

Configuration can be updated in `application.yaml` or using environment variables.


In `tutorialapp/src/main/java/com.wanubit.tutorialapp`:

* `TutorialAppApplication` - Spring Boot application entry point, bean definition,
* `domain/*` - entity classes for Category and Tutorial,
* `dto/*` - DTO classes for Category and Tutorial,
* `mapper/*` - mapping functions between entities and DTO,
* `repository/*` - repository interface and declarations,
* `service/*` - services declarations,
* `impl/*` - services implementations,
* `controller/*` - controllers declarations and implementations,

## Explore Rest APIs

The app defines following CRUD APIs.
### Categories Endpoints
* `GET /api/categories` get all categories.

* `GET /api/categories?name=name` get all categories by name.

* `POST /api/categories` create new category.

* `GET /api/categories/{id}` get category by id.

* `PUT /api/categories/{id}` update category.

* `DELETE /api/categories/{id}` delete category.

### Tutorials Endpoints
* `GET /api/tutorials` get all tutorials.

* `GET /api/tutorials?title=title` get all tutorials by title.

* `POST /api/tutorials` create new tutorial.

* `GET /api/tutorials/{id}` get tutorial by id.

* `PUT /api/tutorials/{id}` update tutorial.

* `DELETE /api/tutorials/{id}` delete tutorial.

You can find the tutorial for this application on my YouTube channel <https://youtube.com/@wanubit> -